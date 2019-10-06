package me.junrup.projects.index.adPlan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanObject {
    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newAdPlanObject) {
        if (newAdPlanObject.getPlanId() != null) {
            this.planId = newAdPlanObject.getPlanId();
        }
        if (newAdPlanObject.getUserId() != null) {
            this.userId = newAdPlanObject.getUserId();
        }
        if (newAdPlanObject.getPlanStatus() != null) {
            this.planStatus = newAdPlanObject.getPlanStatus();
        }
        if (newAdPlanObject.getStartDate() != null) {
            this.startDate = newAdPlanObject.getStartDate();
        }
        if (newAdPlanObject.getEndDate() != null) {
            this.endDate = newAdPlanObject.getEndDate();
        }

    }
}
