package kblog.entity;

/**
 * Created by kason_zhang on 4/19/2017.
 */

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 博客实体，对应的数据库表
 * CREATE TABLE `t_blog` (
 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客类型',
 `title` VARCHAR(200) NOT NULL COMMENT '博客题目',
 `summary` VARCHAR(400) DEFAULT NULL COMMENT '博客摘要',
 `releaseDate` DATETIME DEFAULT NULL COMMENT '发布日期',
 `clickHit` INT(11) DEFAULT NULL COMMENT '评论次数',
 `replyHit` INT(11) DEFAULT NULL COMMENT '回复次数',
 `content` TEXT COMMENT '博客内容',
 `keyWord` VARCHAR(200) DEFAULT NULL COMMENT '关键字',
 `type_id` INT(11) DEFAULT NULL COMMENT '外键关联博客类别',
 PRIMARY KEY (`id`),
 KEY `type_id` (`type_id`),
 CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
 */
public class Blog {
    private Integer id;
    private String title;
    private String summary;
    private Date releaseDate;
    private Integer clickHit;
    private Integer replyHit;
    private String content;
    private String keyWord; //关键字，用空格隔开

    //变通
    private String contentNoTag; //不带标签的博客内容，用于Lucene索引中
    private BlogType blogType; //博客类型，对应外键
    private Integer blogCount; //博客数量，非博客实际属性，用于根据发布日期归档查询
    private String releaseDateStr; //发布日期的字符串，只取年月

    private List<String> imageList = new LinkedList<String>();//博客里存的图片，主要用于展示缩略图

    public Blog() {
    }

    public Blog(String title, String summary, Date releaseDate, Integer clickHit, Integer replyHit, String content, String keyWord, BlogType blogType) {
        this.title = title;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.clickHit = clickHit;
        this.replyHit = replyHit;
        this.content = content;
        this.keyWord = keyWord;
        this.blogType = blogType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getContentNoTag() {
        return contentNoTag;
    }

    public void setContentNoTag(String contentNoTag) {
        this.contentNoTag = contentNoTag;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseDate=" + releaseDate +
                ", clickHit=" + clickHit +
                ", replyHit=" + replyHit +
                ", content='" + content + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", contentNoTag='" + contentNoTag + '\'' +
                ", blogType=" + blogType +
                ", blogCount=" + blogCount +
                ", releaseDateStr='" + releaseDateStr + '\'' +
                ", imageList=" + imageList +
                '}';
    }
}
