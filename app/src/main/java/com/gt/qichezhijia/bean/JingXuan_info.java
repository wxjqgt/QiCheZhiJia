package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class JingXuan_info {
/*    {
        "topicid": 46958526,
            "title": "必去景点全攻略 萌妹子香港自由行",
            "lastreplydate": "36分钟前",
            "postusername": "Miss丶Lee",
            "replycounts": 625,
            "isclosed": 0,
            "bigpic": "",
            "smallpic": "http://club2.autoimg.cn/album/g15/M09/EA/A8/userphotos/2015/11/20/18/240180_wKjByFZO-4uAEAS6AAE17uC-dwU183.jpg",
            "topictype": "精",
            "views": 313472,
            "postmemberid": 0,
            "imgurl": "",
            "bbsid": 100002,
            "bbstype": "a",
            "bbsname": "美人“记”302季"
    },*/
    private String title;
    private String bbsname;
    private String replycounts;
    private String smallpic;
    private String topicid;

    public JingXuan_info(String title, String bbsname, String replycounts, String smallpic,String topicid) {
        this.title = title;
        this.bbsname = bbsname;
        this.replycounts = replycounts;
        this.smallpic = smallpic;
        this.topicid=topicid;
    }

    @Override
    public String toString() {
        return "JingXuan_info{" +
                "title='" + title + '\'' +
                ", bbsname='" + bbsname + '\'' +
                ", replycounts='" + replycounts + '\'' +
                ", smallpic='" + smallpic + '\'' +
                ", topicid='" + topicid + '\'' +
                '}';
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public JingXuan_info() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBbsname() {
        return bbsname;
    }

    public void setBbsname(String bbsname) {
        this.bbsname = bbsname;
    }

    public String getReplycounts() {
        return replycounts;
    }

    public void setReplycounts(String replycounts) {
        this.replycounts = replycounts;
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }
}
