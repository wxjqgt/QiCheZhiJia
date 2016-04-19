package com.gt.qichezhijia.bean;


/**
 * Created by Administrator on 2015/11/24.
 */
public class Result {
    /*
    * "list": [
            {
                "id": 1545,
                "title": "20151124",
                "shorttitle": "沃尔沃",
                "url": "http://m.mall.autohome.com.cn/detail/63523-0-0.html?pvareaid=104735",
                "imgurl": "http://x.autoimg.cn/app/image/banner/201511240903488112486.jpg",
                "urlscheme": "",
                "type": 2,
                "appicon": "",
                "siteindex": 0
            },
    * */
    private Discover_List[] list;

    public Result() {
    }

    public Result(Discover_List[] list) {
        this.list = list;
    }

    public Discover_List[] getList() {
        return list;
    }

    public void setList(Discover_List[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Result{" +
                "list=" + list +
                '}';
    }
}
