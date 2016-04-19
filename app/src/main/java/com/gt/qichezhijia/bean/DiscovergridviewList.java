package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/25.
 */
public class DiscovergridviewList {

    /**
     * id : 40829
     * productid : 0
     * title : 奇瑞 瑞虎5 2016款 1.5T 手动家悦版
     * shorttitle : 瑞虎5 2016款 1.5T 手动家悦版
     * logo : http://car3.autoimg.cn/cardfs/product/g12/M09/A5/69/tp_autohomecar__wKgH01YZ5XKAWhI2AAGAevY1eGQ140.jpg
     * price : 10.69万
     * fctprice : 10.69万
     * adinfo : 下单需在线支付订金2000元！卖爆了！双11返场活动，购车送5000元大礼包（1000元购车券，3M车膜、行车记录仪、高级蓝牙音箱），享受国家购置税减免一半约4500元，数量有限，售完为止。
     * murl : http://m.mall.autohome.com.cn/detail/40829-110100-0.html?isapp=1#pvareaid=110002
     * carlable : 爆款
     * state : 现货充足
     * brandid : 26
     * seriesid : 3195
     * specid : 23999
     * count : 0
     */

    private int id;
    private int productid;
    private String title;
    private String shorttitle;
    private String logo;
    private String price;
    private String fctprice;
    private String adinfo;
    private String murl;
    private String carlable;
    private String state;
    private int brandid;
    private int seriesid;
    private int specid;
    private int count;

    @Override
    public String toString() {
        return "DiscovergridviewList{" +
                "id=" + id +
                ", productid=" + productid +
                ", title='" + title + '\'' +
                ", shorttitle='" + shorttitle + '\'' +
                ", logo='" + logo + '\'' +
                ", price='" + price + '\'' +
                ", fctprice='" + fctprice + '\'' +
                ", adinfo='" + adinfo + '\'' +
                ", murl='" + murl + '\'' +
                ", carlable='" + carlable + '\'' +
                ", state='" + state + '\'' +
                ", brandid=" + brandid +
                ", seriesid=" + seriesid +
                ", specid=" + specid +
                ", count=" + count +
                '}';
    }

    public DiscovergridviewList(int id, int productid, String title,
                                String shorttitle, String logo, String price,
                                String fctprice, String adinfo, String murl,
                                String carlable, String state, int brandid,
                                int seriesid, int specid, int count) {
        this.id = id;
        this.productid = productid;
        this.title = title;
        this.shorttitle = shorttitle;
        this.logo = logo;
        this.price = price;
        this.fctprice = fctprice;
        this.adinfo = adinfo;
        this.murl = murl;
        this.carlable = carlable;
        this.state = state;
        this.brandid = brandid;
        this.seriesid = seriesid;
        this.specid = specid;
        this.count = count;
    }

    public DiscovergridviewList() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShorttitle(String shorttitle) {
        this.shorttitle = shorttitle;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFctprice(String fctprice) {
        this.fctprice = fctprice;
    }

    public void setAdinfo(String adinfo) {
        this.adinfo = adinfo;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public void setCarlable(String carlable) {
        this.carlable = carlable;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
    }

    public void setSpecid(int specid) {
        this.specid = specid;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public int getProductid() {
        return productid;
    }

    public String getTitle() {
        return title;
    }

    public String getShorttitle() {
        return shorttitle;
    }

    public String getLogo() {
        return logo;
    }

    public String getPrice() {
        return price;
    }

    public String getFctprice() {
        return fctprice;
    }

    public String getAdinfo() {
        return adinfo;
    }

    public String getMurl() {
        return murl;
    }

    public String getCarlable() {
        return carlable;
    }

    public String getState() {
        return state;
    }

    public int getBrandid() {
        return brandid;
    }

    public int getSeriesid() {
        return seriesid;
    }

    public int getSpecid() {
        return specid;
    }

    public int getCount() {
        return count;
    }
}
