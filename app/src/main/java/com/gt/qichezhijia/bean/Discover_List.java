package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/24.
 */
public class Discover_List {

    /**
     * id : 1545
     * title : 20151124
     * shorttitle : 沃尔沃
     * url : http://m.mall.autohome.com.cn/detail/63523-0-0.html?pvareaid=104735
     * imgurl : http://x.autoimg.cn/app/image/banner/201511240903488112486.jpg
     * urlscheme :
     * type : 2
     * appicon :
     * siteindex : 0
     */

    private String id;
    private String title;
    private String shorttitle;
    private String url;
    private String imgurl;
    private String urlscheme;
    private String type;
    private String appicon;
    private String siteindex;

    public Discover_List() {
    }

    @Override
    public String toString() {
        return "Discover_List{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shorttitle='" + shorttitle + '\'' +
                ", url='" + url + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", urlscheme='" + urlscheme + '\'' +
                ", type=" + type +
                ", appicon='" + appicon + '\'' +
                ", siteindex=" + siteindex +
                '}';
    }

    public Discover_List(String id, String title, String shorttitle, String url,
                         String imgurl, String urlscheme, String type, String appicon,
                         String siteindex) {
        this.id = id;
        this.title = title;
        this.shorttitle = shorttitle;
        this.url = url;
        this.imgurl = imgurl;
        this.urlscheme = urlscheme;
        this.type = type;
        this.appicon = appicon;
        this.siteindex = siteindex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShorttitle(String shorttitle) {
        this.shorttitle = shorttitle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setUrlscheme(String urlscheme) {
        this.urlscheme = urlscheme;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAppicon(String appicon) {
        this.appicon = appicon;
    }

    public void setSiteindex(String siteindex) {
        this.siteindex = siteindex;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShorttitle() {
        return shorttitle;
    }

    public String getUrl() {
        return url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getUrlscheme() {
        return urlscheme;
    }

    public String getType() {
        return type;
    }

    public String getAppicon() {
        return appicon;
    }

    public String getSiteindex() {
        return siteindex;
    }
}
