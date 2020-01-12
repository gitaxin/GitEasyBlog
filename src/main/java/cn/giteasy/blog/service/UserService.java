package cn.giteasy.blog.service;

import cn.giteasy.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * 用户服务接口
 * Created by Axin in 2019/12/27 21:25
 */
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    void removeUser(Long id);


    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);



    /**
     * 根据用户名进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);


    /**
     * 根据名称列表查询
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);


}
