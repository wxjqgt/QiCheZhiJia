package com.gt.qichezhijia.bean_recomend;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Xinwen {
    private int id;
    private String title;
    private String time;
    private String smallpic;
    private String replycount;

    public Xinwen() {
    }

    public Xinwen(int id, String title, String time, String smallpic, String replycount) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.smallpic = smallpic;
        this.replycount = replycount;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }

    public String getReplycount() {
        return replycount;
    }

    public void setReplycount(String replycount) {
        this.replycount = replycount;
    }

    @Override
    public String toString() {
        return "Xinwen{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", smallpic='" + smallpic + '\'' +
                ", replycount='" + replycount + '\'' +
                '}';
    }
}
