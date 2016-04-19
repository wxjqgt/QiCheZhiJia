package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Discover_gridview {
    /*"iconurl": "http://x.autoimg.cn/app/image/apriceicon.png",
            "title": "一口价购车",
            "carsurl": "http://m.mall.autohome.com.cn/list/2-0-0-0-0-0-0-0-0-1.html?isapp=1",
            "list": [
            */
    private String iconurl;
    private String title;
    private String carsurl;
    private String list;


    public Discover_gridview() {
    }

    public Discover_gridview(String iconurl, String title, String carsurl, String list) {
        this.iconurl = iconurl;
        this.title = title;
        this.carsurl = carsurl;
        this.list = list;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCarsurl() {
        return carsurl;
    }

    public void setCarsurl(String carsurl) {
        this.carsurl = carsurl;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Discover_gridview{" +
                "iconurl='" + iconurl + '\'' +
                ", title='" + title + '\'' +
                ", carsurl='" + carsurl + '\'' +
                ", list=" + list +
                '}';
    }
}
