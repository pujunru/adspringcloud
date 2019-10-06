package me.junrup.projects.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.service.IAdUnitService;
import me.junrup.projects.vo.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdUnitOPController {
    private final IAdUnitService adUnitService;

    public AdUnitOPController(IAdUnitService adUnitService) {
        this.adUnitService = adUnitService;
    }

    @PostMapping("/create/adUnit")
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createUnit(request);
    }

    @PostMapping("/create/unitKeyword")
    public AdUnitKeywordResponse createUnitKeyword(@RequestBody AdUnitKeywordRequest request) throws AdException {
        log.info("ad-sponsor: createUnitKeyword -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitKeyword(request);
    }

    @PostMapping("/create/unitInterest")
    public AdUnitInterestResponse createUnitInterest(@RequestBody AdUnitInterestRequest request) throws AdException {
        log.info("ad-sponsor: createUnitInterest -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitInterest(request);
    }

    @PostMapping("/create/unitLocation")
    public AdUnitLocationResponse createUnitLocation(@RequestBody AdUnitLocationRequest request) throws AdException {
        log.info("ad-sponsor: createUnitLocation -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitLocation(request);
    }

    @PostMapping("/create/creativityUnit")
    public CreativityUnitResponse createCreativityUnit(@RequestBody CreativityUnitRequest request) throws AdException {
        log.info("ad-sponsor: createCreativityUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createCreativityUnit(request);
    }
}

