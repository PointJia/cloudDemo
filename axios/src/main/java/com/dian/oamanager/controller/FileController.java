package com.dian.oamanager.controller;

import com.dian.oamanager.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request){
        logger.info("开始上传……");

        MultipartHttpServletRequest servletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = servletRequest.getFileMap();
        for (Map.Entry entry : fileMap.entrySet()) {
            logger.info("name : {}",entry.getKey());
            MultipartFile multipartFile = (MultipartFile) entry.getValue();
            try {
                FileUtil.writeFile(multipartFile.getInputStream(),path+"/12_"+multipartFile.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "{'result':'OK'}";
    }


    @RequestMapping(value = "/uploadII")
    public String uploadII(@RequestParam("uploadFile") MultipartFile uploadFile){
        logger.info("upload : {}",uploadFile);
        try {
            InputStream inputStream = uploadFile.getInputStream();
            String originalFilename = uploadFile.getOriginalFilename();
            logger.info("file : {}",originalFilename);
            FileUtil.writeFile(inputStream,path+"/"+originalFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{'result':'OK'}";
    }

    private String path = "G:/test";



    private Logger logger = LoggerFactory.getLogger(FileController.class);

}
