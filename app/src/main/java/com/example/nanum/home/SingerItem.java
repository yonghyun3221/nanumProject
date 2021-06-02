package com.example.nanum.home;


public class SingerItem {
    String name;
    String mobile;
    int resId;
    String keyword;

    // Generate > Constructor
    public SingerItem(String name, String mobile, int resId, String keyword) {
        this.name = name;
        this.mobile = mobile;
        this.resId = resId;
        this.keyword = keyword;
    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    // Generate > toString() : 아이템을 문자열로 출력

    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}