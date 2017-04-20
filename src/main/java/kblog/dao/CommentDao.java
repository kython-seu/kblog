package kblog.dao;

import kblog.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by kason_zhang on 4/20/2017.
 */
//评论dao接口
public interface CommentDao {

    // 获取评论信息
    public List<Comment> getCommentData(Map<String, Object> map);

    // 添加评论
    public int addComment(Comment comment);

    // 获取总记录数
    public Long getTotal(Map<String, Object> map);

    // 修改评论信息
    public Integer update(Comment comment);

    // 删除评论信息
    public Integer deleteComment(Integer id);

    // 根据博客id删除评论信息，用于删除某篇博客前，先删掉该博客的评论，因为有外键
    public Integer deleteCommentByBlogId(Integer blogId);
}