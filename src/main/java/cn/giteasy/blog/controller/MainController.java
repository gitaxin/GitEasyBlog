package cn.giteasy.blog.controller;

import cn.giteasy.blog.entity.Authority;
import cn.giteasy.blog.entity.User;
import cn.giteasy.blog.service.AuthorityService;
import cn.giteasy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * 主页控制器
 * Created by Axin in 2019/12/26 22:23
 */

@Controller
public class MainController {

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;//博主

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;


    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }



    @GetMapping("/index")
    public String index(){
        return "redirect:/blogs";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败，用户名或密码错误！");
        //登录失败后，还是会返回登录页面，但是会携带错误信息
        return "login";
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }


    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        user.setEncodePassword(user.getPassword()); // 加密密码

        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
