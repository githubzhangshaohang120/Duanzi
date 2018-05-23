package com.example.week1duanzi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MyDataBean {
    @Id
    private Long id;
    @Property
    private String commentNum;
    @Property
    private String content;
    @Property
    private String createTime;
    @Property
    private String imgUrls;
    @Property
    private int jid;
    @Property
    private String praiseNum;
    @Property
    private String shareNum;
    @Property
    private int uid;
    @Property
    private String age;
    @Property
    private String fans;
    @Property
    private boolean follow;
    @Property
    private String icon;
    @Property
    private String nickname;
    @Generated(hash = 1891157934)
    public MyDataBean(Long id, String commentNum, String content, String createTime,
            String imgUrls, int jid, String praiseNum, String shareNum, int uid,
            String age, String fans, boolean follow, String icon, String nickname) {
        this.id = id;
        this.commentNum = commentNum;
        this.content = content;
        this.createTime = createTime;
        this.imgUrls = imgUrls;
        this.jid = jid;
        this.praiseNum = praiseNum;
        this.shareNum = shareNum;
        this.uid = uid;
        this.age = age;
        this.fans = fans;
        this.follow = follow;
        this.icon = icon;
        this.nickname = nickname;
    }
    @Generated(hash = 650128772)
    public MyDataBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCommentNum() {
        return this.commentNum;
    }
    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getImgUrls() {
        return this.imgUrls;
    }
    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }
    public int getJid() {
        return this.jid;
    }
    public void setJid(int jid) {
        this.jid = jid;
    }
    public String getPraiseNum() {
        return this.praiseNum;
    }
    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }
    public String getShareNum() {
        return this.shareNum;
    }
    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }
    public int getUid() {
        return this.uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getFans() {
        return this.fans;
    }
    public void setFans(String fans) {
        this.fans = fans;
    }
    public boolean getFollow() {
        return this.follow;
    }
    public void setFollow(boolean follow) {
        this.follow = follow;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
