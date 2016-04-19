package com.gt.qichezhijia.Adapter;

/**
 * Created by Administrator on 2015/11/25.
 */
public class IconsInfo {

    /**
     * id : 13
     * title : 汽车音频
     * type : 2
     * iconurl : http://x.autoimg.cn/app/image/banner/201509252006224849892.jpg
     * url :
     * showbubble : 0
     * createtime : 2015/11/13 14:55:06
     * pvname : 电台来源-发现
     * pvkey : v470_radio_radio_playFrom
     * scheme :
     * packagename :
     */

    private int id;
    private String title;
    private int type;
    private String iconurl;
    private String url;
    private int showbubble;
    private String createtime;
    private String pvname;
    private String pvkey;
    private String scheme;
    private String packagename;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShowbubble(int showbubble) {
        this.showbubble = showbubble;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setPvname(String pvname) {
        this.pvname = pvname;
    }

    public void setPvkey(String pvkey) {
        this.pvkey = pvkey;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public String getIconurl() {
        return iconurl;
    }

    public String getUrl() {
        return url;
    }

    public int getShowbubble() {
        return showbubble;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getPvname() {
        return pvname;
    }

    public String getPvkey() {
        return pvkey;
    }

    public String getScheme() {
        return scheme;
    }

    public String getPackagename() {
        return packagename;
    }

    public IconsInfo() {
    }

    public IconsInfo(int id, String title, int type, String iconurl, String url, int showbubble, String createtime, String pvname, String pvkey, String scheme, String packagename) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.iconurl = iconurl;
        this.url = url;
        this.showbubble = showbubble;
        this.createtime = createtime;
        this.pvname = pvname;
        this.pvkey = pvkey;
        this.scheme = scheme;
        this.packagename = packagename;
    }

    @Override
    public String toString() {
        return "IconsInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", iconurl='" + iconurl + '\'' +
                ", url='" + url + '\'' +
                ", showbubble=" + showbubble +
                ", createtime='" + createtime + '\'' +
                ", pvname='" + pvname + '\'' +
                ", pvkey='" + pvkey + '\'' +
                ", scheme='" + scheme + '\'' +
                ", packagename='" + packagename + '\'' +
                '}';
    }
}
