package com.demo.modules.sys;

public enum TypeEnum {

    RESOURCE("资源", 0),
    VIDEO("在线视频", 1),
    work("作业", 2),
    TEST("测试", 3);


    private String desc;
    private Integer code;

    TypeEnum(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
