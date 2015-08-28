package com.tarvel.business.admin.user.enums;

/**
 * Created by Yuan on 2015/7/14 0014.
 */
public enum CardType {
    SFZ("身份证"),
    JZ("驾照"),
    LNZ("老年证"),
    JGZ("军官证");

    CardType(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
