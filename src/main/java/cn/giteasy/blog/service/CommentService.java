package cn.giteasy.blog.service;

import cn.giteasy.blog.entity.Comment;

/**
 * Created by Axin in 2019/12/29 17:02
 */
public interface CommentService {

    /**
     * 根据id获取 Comment
     * @param id
     * @return
     */
    Comment getCommentById(Long id);
    /**
     * 删除评论
     * @param id
     * @return
     */
    void removeComment(Long id);

}
