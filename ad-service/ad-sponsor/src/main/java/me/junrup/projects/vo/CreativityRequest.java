package me.junrup.projects.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.junrup.projects.constant.CommonStatus;
import me.junrup.projects.entity.Creativity;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativityRequest {
    private String name;
    private Integer type;
    private Integer materialType;
    private Integer height;
    private Integer width;
    private Long size;
    private Integer duration;
    private Long userId;
    private String url;

    public Creativity convertToEntity() {
        Creativity creativity = new Creativity();
        creativity.setName(name);
        creativity.setType(type);
        creativity.setMaterialType(materialType);
        creativity.setHeight(height);
        creativity.setWidth(width);
        creativity.setSize(size);
        creativity.setDuration(duration);
        creativity.setUserId(userId);
        creativity.setUrl(url);
        creativity.setAuditStatus(CommonStatus.VALID.getStatus());
        creativity.setCreateTime(new Date());
        creativity.setUpdateTime(creativity.getCreateTime());

        return creativity;
    }


}
