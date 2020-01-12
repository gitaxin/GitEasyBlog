package cn.giteasy.blog.repository;

import cn.giteasy.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Comment Repository
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
