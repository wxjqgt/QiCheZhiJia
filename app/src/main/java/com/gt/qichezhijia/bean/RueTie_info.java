package com.gt.qichezhijia.bean;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class RueTie_info {
   /* [
    {
        "topicid": 47310477,
            "title": "找老公就得照着ES300h感觉找-（照片已更新，四百楼继续爆照）",
            "lastreplydate": "2015-11-24 13:26:49",
            "postusername": "你的执着",
            "replycounts": 333,
            "ispictopic": 1,
            "bbsid": 403,
            "bbsname": "雷克萨斯ES论坛",
            "postdate": "2015-11-23 13:56:49"
    },*/
    private String title;
    private String bbsname;
    private String postdate;
    private String replycounts;
    private String topicid;

    public RueTie_info(String bbsname, String title, String postdate, String replycounts,String topicid) {
        this.bbsname = bbsname;
        this.title = title;
        this.postdate = postdate;
        this.replycounts = replycounts;
        this.topicid=topicid;
    }

    public RueTie_info() {

    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
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

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getReplycounts() {
        return replycounts;
    }

    public void setReplycounts(String replycounts) {
        this.replycounts = replycounts;
    }

    @Override
    public String toString() {
        return "RueTie_info{" +
                "title='" + title + '\'' +
                ", bbsname='" + bbsname + '\'' +
                ", postdate='" + postdate + '\'' +
                ", replycounts='" + replycounts + '\'' +
                '}';
    }
}
