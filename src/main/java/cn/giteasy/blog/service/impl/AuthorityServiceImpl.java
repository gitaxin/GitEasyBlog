package cn.giteasy.blog.service.impl;

import cn.giteasy.blog.entity.Authority;
import cn.giteasy.blog.repository.AuthorityRepository;
import cn.giteasy.blog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Authority 服务接口实现
 * Created by Axin in 2019/12/28 22:09
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public Authority getAuthorityById(Long id) {
        return this.authorityRepository.findById(id).get();
    }
}
