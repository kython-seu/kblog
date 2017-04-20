package kblog.dao;

import kblog.entity.Blogger;

/**
 * 博主DAO
 * Created by kason_zhang on 4/20/2017.
 */
public interface BloggerDao {

    //通过用户名查询博主
    public Blogger getByUsername(String username);

    //获取博主信息
    public Blogger getBloggerData();

    // 更新博主个人信息
    public Integer updateBlogger(Blogger blogger);
}
