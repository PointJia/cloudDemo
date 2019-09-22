package com.dian.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    public static String get(String url, Map<String,String> params){
        String param = initParams(params);
        try {
            logger.info("url : {}",url+param);
            URL urlTemp = new URL(url+param);
            URLConnection urlConnection = urlTemp.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            StringBuilder result = new StringBuilder();
            while ((length=inputStream.read(bytes))>0){
                result.append(new String(bytes,0,length));
            }
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String initParams(Map<String,String> params){
        if (CollectionUtils.isEmpty(params))
            return "";
        StringBuilder param = new StringBuilder("?");
        for (Map.Entry entry : params.entrySet()){
            Object key = entry.getKey();
            Object value = entry.getValue();
            param.append(key + "=" + value + "&");
        }
        return param.substring(0,param.length()-1);
    }

    public static void main(String[] args) {

    }

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);


}
