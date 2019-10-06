package me.junrup.projects.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.service.ICreativityService;
import me.junrup.projects.vo.CreativityRequest;
import me.junrup.projects.vo.CreativityResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreativityOPController {

    private final ICreativityService creativityService;

    public CreativityOPController(ICreativityService creativityService) {
        this.creativityService = creativityService;
    }

    public CreativityResponse createCreativity(@RequestBody CreativityRequest request) throws AdException {
        log.info("ad-sponsor: createCreativity -> {}", JSON.toJSONString(request));
        return creativityService.createCreativity(request);
    }
}
