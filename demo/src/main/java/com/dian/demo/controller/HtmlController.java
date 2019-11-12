package com.dian.demo.controller;

import com.dian.demo.util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/html")
public class HtmlController {

    private String localPath = "D:/DOWNLOAD/server/httpd-2.4.39-o102s-x64-vc14/Apache24/htdocs/html/";
    private String url_temp = "http://localhost/html/";

    @RequestMapping(value = "/save")
    public String saveHtml(String content){
        String html = initHtml(content);
        try {
            FileUtil.writeFile(localPath+"1.html",html.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    private String initHtml(String content){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<title>Title</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(content);
        sb.append("<script type=\"text/javascript\" src=\"/ckeditor/ckeditor.js\"></script>");
        sb.append("</body></html>");
        return sb.toString();
    }


}
