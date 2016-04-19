package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/25.
 */
public class ViewPagerInfo {
    /*
    *  "groupid": 1,
                "list"
    * */
    private String groupid;
    private String list;

    public ViewPagerInfo() {
    }

    public ViewPagerInfo(String groupid, String list) {
        this.groupid = groupid;
        this.list = list;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ViewPagerInfo{" +
                "groupid='" + groupid + '\'' +
                ", list='" + list + '\'' +
                '}';
    }
}
