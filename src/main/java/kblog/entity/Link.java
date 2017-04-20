package kblog.entity;

/**
 * Created by kason_zhang on 4/20/2017.
 */
public class Link {
    private Integer id;
    private String linkname;
    private String linkurl;
    private Integer orderNum;//连接排序的序号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", linkname='" + linkname + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }
}
