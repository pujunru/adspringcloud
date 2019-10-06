package me.junrup.projects.constant;

import lombok.Getter;

@Getter
public enum CommonStatus {
    VALID (1, "Valid Status"),
    INVALID (2, "Invalid Status" );

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
