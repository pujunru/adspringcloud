package me.junrup.projects.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativityUnitRequest {
    private List<CreativityUnitItem> unitItems;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreativityUnitItem {
        private Long creativityId;
        private Long unitId;
    }

}
