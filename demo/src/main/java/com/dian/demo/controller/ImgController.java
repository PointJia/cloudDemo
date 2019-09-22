package com.dian.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dian.demo.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "/img")
public class ImgController {

    private String localPath = "D:/DOWNLOAD/server/httpd-2.4.39-o102s-x64-vc14/Apache24/htdocs/img/";
    private String url_temp = "http://localhost/img/";

    private Logger logger = LoggerFactory.getLogger(ImgController.class);

    @RequestMapping(value = "/upload")
    public String upload(String ckCsrfToken, MultipartFile upload){
        logger.info("{}",ckCsrfToken);
        String name = getTime() + "_" + upload.getOriginalFilename();
        JSONObject jsonObject = new JSONObject();
        try {
            FileUtil.writeFile(localPath+name,upload.getBytes());
            jsonObject.put("uploaded",1);
            jsonObject.put("url",url_temp+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }



    private String getTime(){
        Date date = new Date();
        return String.valueOf(date.getTime());
    }



}
