package me.junrup.projects.service.impl;

import me.junrup.projects.constant.Constants;
import me.junrup.projects.dao.AdPlanRepository;
import me.junrup.projects.dao.AdUnitRepository;
import me.junrup.projects.dao.CreativityRepository;
import me.junrup.projects.dao.CreativityUnitRepository;
import me.junrup.projects.dao.unit_limitation.AdUnitInterestRepository;
import me.junrup.projects.dao.unit_limitation.AdUnitKeywordRepository;
import me.junrup.projects.dao.unit_limitation.AdUnitLocationRepository;
import me.junrup.projects.entity.AdPlan;
import me.junrup.projects.entity.AdUnit;
import me.junrup.projects.entity.CreativityUnit;
import me.junrup.projects.entity.unit_limitation.AdUnitInterest;
import me.junrup.projects.entity.unit_limitation.AdUnitKeyword;
import me.junrup.projects.entity.unit_limitation.AdUnitLocation;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.service.IAdUnitService;
import me.junrup.projects.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdPlanRepository planRepository;
    private final AdUnitRepository unitRepository;
    private final CreativityRepository creativityRepository;
    private final AdUnitKeywordRepository unitKeywordRepository;
    private final AdUnitInterestRepository unitInterestRepository;
    private final AdUnitLocationRepository unitLocationRepository;
    private final CreativityUnitRepository creativityUnitRepository;

    @Autowired
    public AdUnitServiceImpl(AdPlanRepository planRepository, AdUnitRepository unitRepository, CreativityRepository creativityRepository, AdUnitKeywordRepository unitKeywordRepository, AdUnitInterestRepository unitInterestRepository, AdUnitLocationRepository unitLocationRepository, CreativityUnitRepository creativityUnitRepository) {
        this.planRepository = planRepository;
        this.unitRepository = unitRepository;
        this.creativityRepository = creativityRepository;
        this.unitKeywordRepository = unitKeywordRepository;
        this.unitInterestRepository = unitInterestRepository;
        this.unitLocationRepository = unitLocationRepository;
        this.creativityUnitRepository = creativityUnitRepository;
    }

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException{
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdUnit oldAdUnit = unitRepository.findByPlanIdAndUnitName(
                request.getPlanId(), request.getUnitName()
        );
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_Unit_ERROR);
        }

        AdUnit newAdUnit = unitRepository.save(
                new AdUnit(request.getPlanId(), request.getUnitName(),
                        request.getPositionType(), request.getBudget())
        );

        return new AdUnitResponse(newAdUnit.getId(), newAdUnit.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        List<Long> unitIds = request.getUnitKeywords().stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<Long> ids = Collections.emptyList();

        List<AdUnitKeyword> unitKeywords = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {

            request.getUnitKeywords().forEach(i -> unitKeywords.add(
                    new AdUnitKeyword(i.getUnitId(), i.getKeyword())
            ));
            ids = unitKeywordRepository.saveAll(unitKeywords).stream()
                    .map(AdUnitKeyword::getId)
                    .collect(Collectors.toList());
        }

        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitInterestResponse createUnitInterest(AdUnitInterestRequest request) throws AdException {
        List<Long> unitIds = request.getUnitInterests().stream()
                .map(AdUnitInterestRequest.UnitInterest::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<AdUnitInterest> unitIts = new ArrayList<>();
        request.getUnitInterests().forEach(i -> unitIts.add(
                new AdUnitInterest(i.getUnitId(), i.getItTag())
        ));
        List<Long> ids = unitInterestRepository.saveAll(unitIts).stream()
                .map(AdUnitInterest::getId)
                .collect(Collectors.toList());

        return new AdUnitInterestResponse(ids);
    }

    @Override
    public AdUnitLocationResponse createUnitLocation(AdUnitLocationRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream()
                .map(AdUnitLocationRequest.UnitDistrict::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<AdUnitLocation> unitDistricts = new ArrayList<>();
        request.getUnitDistricts().forEach(d -> unitDistricts.add(
                new AdUnitLocation(d.getUnitId(), d.getProvince(),
                        d.getCity())
        ));
        List<Long> ids = unitLocationRepository.saveAll(unitDistricts)
                .stream().map(AdUnitLocation::getId)
                .collect(Collectors.toList());

        return new AdUnitLocationResponse(ids);
    }

    @Override
    public CreativityUnitResponse createCreativityUnit(CreativityUnitRequest request) throws AdException {
        List<Long> unitIds = request.getUnitItems().stream()
                .map(CreativityUnitRequest.CreativityUnitItem::getUnitId)
                .collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream()
                .map(CreativityUnitRequest.CreativityUnitItem::getCreativityId)
                .collect(Collectors.toList());

        if (!(isRelatedUnitExist(unitIds) && isRelatedUnitExist(creativeIds))) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<CreativityUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems().forEach(i -> creativeUnits.add(
                new CreativityUnit(i.getCreativityId(), i.getUnitId())
        ));

        List<Long> ids = creativityUnitRepository.saveAll(creativeUnits)
                .stream()
                .map(CreativityUnit::getId)
                .collect(Collectors.toList());

        return new CreativityUnitResponse(ids);
    }

    private boolean isRelatedUnitExist(List<Long> unitIds) {

        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }

        return unitRepository.findAllById(unitIds).size() ==
                new HashSet<>(unitIds).size();
    }

    private boolean isRelatedCreativityExist(List<Long> creativityIds) {

        if (CollectionUtils.isEmpty(creativityIds)) {
            return false;
        }

        return creativityRepository.findAllById(creativityIds).size() ==
                new HashSet<>(creativityIds).size();
    }
}
