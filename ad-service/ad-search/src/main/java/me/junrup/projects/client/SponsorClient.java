package me.junrup.projects.client;

import me.junrup.projects.client.vo.AdPlan;
import me.junrup.projects.client.vo.AdPlanGetRequest;
import me.junrup.projects.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.GET)
    CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request
            );
}
