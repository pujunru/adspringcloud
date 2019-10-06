package me.junrup.projects.constant;

public enum CreativityMaterialType {
    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private Integer type;
    private String decs;

    CreativityMaterialType(Integer type, String decs) {
        this.type = type;
        this.decs = decs;
    }

}
