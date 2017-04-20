package kblog.entity;

/**
 * Created by kason_zhang on 4/19/2017.
 */

/**
 * 博客类型，对应
 * CREATE TABLE `t_blogtype` (
 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
 `typeName` VARCHAR(30) DEFAULT NULL COMMENT '博客类别',
 `orderNum` INT(11) DEFAULT NULL COMMENT '博客排序',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
 */
public class BlogType {
    private Integer id;
    private String typeName;
    private String orderNum;

    //变通
    private Integer blogCount; //统计不同类型的博客数量的

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    public Integer getBlogCount() {
        return blogCount;
    }
    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", blogCount=" + blogCount +
                '}';
    }
}
