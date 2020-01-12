package cn.giteasy.blog.service;

import cn.giteasy.blog.entity.Authority;

/**
 *
 * Authority 服务接口
 * Created by Axin in 2019/12/28 22:08
 */
public interface AuthorityService  {

    /**
     * 根据ID查询Authority
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);
}
