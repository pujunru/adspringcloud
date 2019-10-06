package me.junrup.projects.client;

import me.junrup.projects.client.vo.AdPlan;
import me.junrup.projects.client.vo.AdPlanGetRequest;
import me.junrup.projects.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "Service Sponsor not available.");
    }
}
