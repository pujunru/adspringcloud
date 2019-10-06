package me.junrup.projects.service.impl;

import me.junrup.projects.dao.CreativityRepository;
import me.junrup.projects.entity.Creativity;
import me.junrup.projects.service.ICreativityService;
import me.junrup.projects.vo.CreativityRequest;
import me.junrup.projects.vo.CreativityResponse;
import org.springframework.stereotype.Service;

@Service
public class CreativityServiceImpl implements ICreativityService {

    private final CreativityRepository creativityRepository;

    public CreativityServiceImpl(CreativityRepository creativityRepository) {
        this.creativityRepository = creativityRepository;
    }

    @Override
    public CreativityResponse createCreativity(CreativityRequest request) {
        Creativity creativity = creativityRepository.save(
                request.convertToEntity()
        );

        return new CreativityResponse(creativity.getId(), creativity.getName());
    }
}
