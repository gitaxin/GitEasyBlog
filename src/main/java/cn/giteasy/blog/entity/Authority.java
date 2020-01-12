package cn.giteasy.blog.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Axin in 2019/12/28 21:47
 */
@Entity
public class Authority implements GrantedAuthority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长策略
    private Long id;

    @Column(nullable = false)//映射为字段，值不能为空
    private String name;


    /**
     * 覆盖父类方法，相当于 getName
     * @return
     */
    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


}
