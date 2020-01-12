package cn.giteasy.blog.controller;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


/**
 * 用户主页控制
 */

@Controller
@RequestMapping("/image")
public class ImageController {


    /**
     * 七牛云存储配置
     */
    @Value("${qiniu.access.key}")
    private String accessKey;
    @Value("${qiniu.secret.key}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${image.url.prefix}")
    private String imageUrlPrefix;


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value="file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        String suffix = contentType.split("/")[1];
        String url = uploadToQiniu(inputStream, suffix);
        return url;
    }


    /**
     * 上传图片到七牛云
     * @param inputStream
     * @param suffix
     * @return
     */
    private String uploadToQiniu(InputStream inputStream,String suffix){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        StringBuilder key = new StringBuilder();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String random = UUID.randomUUID().toString();
        key.append("blog/").append(random).append(".").append(suffix);

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(inputStream,key.toString(),upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            StringBuilder url = new StringBuilder(imageUrlPrefix);
            url.append("/").append(putRet.key);
            return url.toString();
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

        return null;
    }


}
