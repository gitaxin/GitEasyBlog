package cn.giteasy.blog.service.impl;

import cn.giteasy.blog.entity.Comment;
import cn.giteasy.blog.repository.CommentRepository;
import cn.giteasy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论 服务层
 * Created by Axin in 2019/12/29 17:03
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment getCommentById(Long id) {
        return this.commentRepository.findById(id).get();
    }

    @Override
    public void removeComment(Long id) {
        this.commentRepository.deleteById(id);


    }
}
