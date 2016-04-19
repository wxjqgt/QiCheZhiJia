package com.gt.qichezhijia.bean_recomend;

/**
 * Created by Administrator on 2015/11/25.
 */
public class kuaibao {
    private int id;
    private String title;
    private String reviewcount;
    private String bgimage;
    private String typename;
    private String createtime;

    public kuaibao() {
    }

    public kuaibao(String title, String reviewcount, String bgimage, String typename, String createtime) {
        this.title = title;
        this.reviewcount = reviewcount;
        this.bgimage = bgimage;
        this.typename = typename;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(String reviewcount) {
        this.reviewcount = reviewcount;
    }

    public String getBgimage() {
        return bgimage;
    }

    public void setBgimage(String bgimage) {
        this.bgimage = bgimage;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "kuaibao{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reviewcount='" + reviewcount + '\'' +
                ", bgimage='" + bgimage + '\'' +
                ", typename='" + typename + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
