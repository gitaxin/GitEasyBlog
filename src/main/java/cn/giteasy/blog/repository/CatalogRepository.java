package cn.giteasy.blog.repository;

import java.util.List;

import cn.giteasy.blog.entity.Catalog;
import cn.giteasy.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Catalog 仓库.
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long>{
	
	/**
	 * 根据用户查询
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);
	
	/**
	 * 根据用户查询
	 * @param user
	 * @param name
	 * @return
	 */
	List<Catalog> findByUserAndName(User user, String name);
}
