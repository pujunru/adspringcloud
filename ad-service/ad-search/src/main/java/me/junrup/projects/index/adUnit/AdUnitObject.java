package me.junrup.projects.index.adUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitObject {
    private Long unitId;
    private Long planId;
    private Integer unitStatus;
    private Integer positionType;

    public void update(AdUnitObject newObject) {
        if (null != newObject.getUnitId()) {
            unitId = newObject.getUnitId();
        }
        if (null != newObject.getPlanId()) {
            planId = newObject.getPlanId();
        }
        if (null != newObject.getPositionType()) {
            positionType = newObject.getPositionType();
        }
        if (null != newObject.getUnitStatus()) {
            unitStatus = newObject.getUnitStatus();
        }
    }
}
