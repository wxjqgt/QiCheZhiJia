package com.gt.qichezhijia.bean_recomend;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Adv {
    private String imgpath;

    public Adv() {
    }

    public Adv(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "Adv{" +
                "imgpath='" + imgpath + '\'' +
                '}';
    }
}
