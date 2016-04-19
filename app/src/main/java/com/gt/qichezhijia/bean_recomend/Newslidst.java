package com.gt.qichezhijia.bean_recomend;

/**
 * Created by Administrator on 2015/11/24.
 */
public class Newslidst {
    private int id;
    private String title;
    private String time;
    private String smallpic;

    public Newslidst() {
    }

    public Newslidst(int id, String title, String time, String smallpic) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.smallpic = smallpic;
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

    @Override
    public String toString() {
        return "Newslidst{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", smallpic='" + smallpic + '\'' +
                '}';
    }
}
