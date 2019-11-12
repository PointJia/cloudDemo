package com.dian.oamanager.util;

import com.alibaba.fastjson.JSONObject;
import com.dian.common.util.HttpUtil;
import com.dian.common.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WXUtil {

    /**
     * 获取accessToken
     * @return
     */
    public static String getAccessToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String,String> params = new HashMap<>();
        params.put("grant_type","client_credential");
        params.put("appid","wxc1e6f7dd7a8e1731");
        params.put("secret","0d93327baba4e4088c926f4cacf9c0c8");

        String s = HttpUtil.get(url, params);
        logger.info("result : {}" , s);
        JSONObject json = JSONUtil.strToJson(s);
        if (json == null){
            return null;
        }
        return json.getString("access_token");
    }

    public static List<String> getUsers(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get";
        Map<String,String> params = new HashMap<>();
        params.put("access_token","25_sVd-HmT6O11gu2t7UPb3NlSjBPsGlmS8YJPrceQzpOanFYqoqApti24hgm7MrgOZ_fFcyUs4j0p0jVQpsiygJD4GU0iXy6rowa5YhZwwW44qgum1KtEiyQWdWvrQMoVzrGO_LTi8ETCL87ykWSAcAAAJFN");
        params.put("next_openid","NEXT_OPENID");

        String s = HttpUtil.get(url, params);
        JSONObject jsonObject = JSONUtil.strToJson(s);
        logger.info("result : {}",jsonObject);
        return null;
    }

    //25_sVd-HmT6O11gu2t7UPb3NlSjBPsGlmS8YJPrceQzpOanFYqoqApti24hgm7MrgOZ_fFcyUs4j0p0jVQpsiygJD4GU0iXy6rowa5YhZwwW44qgum1KtEiyQWdWvrQMoVzrGO_LTi8ETCL87ykWSAcAAAJFN
    public static void main(String[] args) {
//        String accessToken = getAccessToken();
//        logger.info("access_token : {}",accessToken);
        List<String> users = getUsers();
        logger.info("result : {}",users);
    }


    private static Logger logger = LoggerFactory.getLogger(WXUtil.class);

}
