## GitEasy博客系统
*** 
### 功能
 - 用户管理
 - 安全设置
 - 博客管理 
 - 评论管理
 - 点赞管理
 - 分类管理
 - 标签管理
 - 搜索
### 涉及技术
- 前端
    - Bootstrap
    - Thymeleaf
    - jQuery
    - HTML5
    - JavaScript
    - CSS
    - ...
- 后端
    - Spring
    - Spring Boot
    - Spring MVC
    - Spring Data
    - Spring Security
    - Hibernate
    - ...  
- 存储
    - MySQL
    - H2
    - 七牛云
    - ...
- 其他
    - ElasticSearch-6.1.1
    - Maven
    - ...
### 修改配置
修改配置文件 application.properties

~~~
#项目中引入了h2,会自动使用这个内存数据库，可以不用设置数据源，开发阶段常用
#如果设置了数据源则使用数据源设置的数据库
#如果配置为true，可以通过网页访问h2的控制台：http://localhost:8080/h2-console,本项目默认配置为true
spring.h2.console.enabled=true
~~~
将mysql数据源配置为你自己的数据源
~~~ 
spring.datasource.url=jdbc:mysql://localhost/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8
spring.datasource.username= your username
spring.datasource.password= your password
~~~
项目每次启动都会根据POJO类重建数据表，开发阶段一般为打开，生产环境需注释掉
~~~
#spring.jpa.hibernate.ddl-auto=create-drop
~~~
如果打开了配置spring.jpa.hibernate.ddl-auto=create-drop，则每次重启都会加载data.sql数据到数据库
~~~
spring.datasource.data =  classpath:data.sql
~~~
ES数据源配置
~~~
spring.data.elasticsearch.cluster-nodes= your url
~~~
配置七牛云存储。七牛云使用请参考七牛云官方文档 https://developer.qiniu.com/kodo/sdk/1239/java
~~~
qiniu.access.key = your access key
qiniu.secret.key = your secret key
qiniu.bucket = your bucket
#修改为你的自定义域名，需要配置域名解析
image.url.prefix = http://static.giteasy.cn 
~~~
### Mysql数据库初始化

新建blog数据库并导入blog.sql
> blog.sql文件在项目根目录下

### ElasticSearch初始化
本项目采用elasticsearch-6.1.1，其他版本未测试
1. 启动elasticsearch
2. 使用head插件创建索引,索引名称为'blog'（其他方式请自行百度）
![](http://static.giteasy.cn/mackdown/20200112175017.png)
3. 创建mapping
> mapping.json在项目根目录下

创建mapping url : http://localhost:9200/blog/_mapping/blog

![](http://static.giteasy.cn/mackdown/20200112175443.png)

### 运行项目
运行cn.giteasy.blog.Application类中main方法启动项目

访问url:http://localhost:8080

预置管理员账号：admin|123456

预置博主账号：xin|123456

![](http://static.giteasy.cn/mackdown/20200112184142.png)

### 异常
如果报以下异常，请修改es中tags字段和username字段的fielddata为true
~~~
java.lang.IllegalArgumentException: Fielddata is disabled on text fields by default. Set fielddata=true on [tags] in order to load fielddata in memory 
                                    by uninverting the inverted index. Note that this can however use significant memory. Alternatively use a keyword field instead.
~~~

执行的url为：
http://localhost:9200/blog/_mapping/blog/

执行的json为：

```
{
  "blog": {
    "properties": {
      "tags": {
        "type": "text",
        "fielddata": true
      }
    }
  }
}
```

```
 {
   "blog": {
     "properties": {
       "username": {
         "type": "text",
         "fielddata": true
       }
     }
   }
 }
```

![](http://static.giteasy.cn/mackdown/20200112181131.png)

更多内容请关注：
阿信技术频道

![](http://static.giteasy.cn/qrcode.jpg)
