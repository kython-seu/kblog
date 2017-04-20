package kblog.entity;

import java.util.Date;

/**
 * Created by kason_zhang on 4/20/2017.
 */
public class Comment {
    private Integer id;
    private String userIp;
    private String nickName;
    private String content;
    private Date commentTime;
    private Integer state;//0:待审核，1 审核通过， 2 未通过
    private Blog blog; //关联的博客

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userIp='" + userIp + '\'' +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                ", state=" + state +
                ", blog=" + blog +
                '}';
    }
}
