package cn.giteasy.blog.repository;

import cn.giteasy.blog.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Vote Repository 接口
 *
 */
public interface VoteRepository extends JpaRepository<Vote, Long>{
 
}
