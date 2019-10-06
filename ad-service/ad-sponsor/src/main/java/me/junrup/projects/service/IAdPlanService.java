package me.junrup.projects.service;

import me.junrup.projects.entity.AdPlan;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.vo.AdPlanGetRequest;
import me.junrup.projects.vo.AdPlanRequest;
import me.junrup.projects.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
