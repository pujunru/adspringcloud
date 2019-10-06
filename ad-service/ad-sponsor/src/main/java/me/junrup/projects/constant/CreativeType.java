package me.junrup.projects.constant;

public enum CreativeType {
    IMAGE(1, "Image"),
    VIDEO(2, "Video"),
    TEXT(3, "Text");

    private Integer type;
    private String desc;

    CreativeType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
