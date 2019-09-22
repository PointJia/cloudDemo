package com.dian.common.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONUtil {

    public static JSONObject strToJson(String content){
        return JSONObject.parseObject(content);
    }


    public static void main(String[] args) {
        String s = "{\"access_token\":\"23_joqCS1ZVd1Mok7c-zoe5Fct-JkgJDCN-hapLVJWUaDOxvBRLW8UovXXwm96fFYaGq_6nMePh9RhYVvf912nN0s_4mRNnUcWv9pYjVGZrpxZpfC3TbnlPovZtTWXet9-rkDEJCldF4W_hAlavQWQjAAAWCW\",\"expires_in\":7200}";
        JSONObject jsonObject = strToJson(s);
        String access_token = jsonObject.getString("access_token");
        logger.info("access_token : {}" , access_token);

    }

    private static Logger logger = LoggerFactory.getLogger(JSONUtil.class);


}
