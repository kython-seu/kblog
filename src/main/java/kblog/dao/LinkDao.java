package kblog.dao;

import kblog.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * Created by kason_zhang on 4/20/2017.
 */
//友情链接dao接口
public interface LinkDao {

    // 获取友情链接
    public List<Link> getLinkData();

    // 分页获取友情链接
    public List<Link> listLinkData(Map<String, Object> map);

    // 获取总记录数
    public Long getTotal(Map<String, Object> map);

    // 添加友情链接
    public Integer addLink(Link link);

    // 更新友情链接
    public Integer updateLink(Link link);

    // 删除友情链接
    public Integer deleteLink(Integer id);
}
