package me.junrup.projects.vo;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitInterestRequest {

    private List<UnitInterest> unitInterests;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitInterest {
        private Long unitId;
        private String itTag;
    }
}
