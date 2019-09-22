package com.dian.oamanager.util.wechart;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RefundUtil {

    static Logger logger = LoggerFactory.getLogger(RefundUtil.class);

    public static void main(String[] args) throws IOException {
        logger.info("-------START--------");
        refund();
        logger.info("-------OVER--------");
    }

    public static void refund() throws IOException {
        String url_ = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        String s = initContent();
        logger.info("退款报文 : {}" , s);
        URL url = new URL(url_);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("Accept", "application/xml"); // 设置接收数据的格式
        conn.setRequestProperty("Content-Type", "application/xml"); // 设置发送数据的格式
        conn.setRequestProperty("Accept-Charset", "utf-8");
        conn.setRequestProperty("contentType", "utf-8");
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(1000);
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);


        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(s.getBytes());
        // flush输出流的缓冲
        outputStream.flush();

        int code = conn.getResponseCode();
        // 定义BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String result = "";
        String line;
        while ((line = in.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            result += line;
        }
        logger.debug("退款返回报文=====>"+result);

    }



    public static String initContent(){
        Map<String,String> params = new HashMap<String,String>();
        params.put("appid","appID");
        params.put("mch_id","1318360201");
        params.put("nonce_str","6cefdb308e1e2e8aabd48cf79e546a02");
        params.put("out_trade_no","order");
        params.put("out_refund_no","order_call_back");
        params.put("total_fee","1");
        params.put("refund_fee","1");
        StringBuilder sbParams = new StringBuilder();
        for (Map.Entry entry : params.entrySet()){
            sbParams.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        String s = Md5Util.md5(sbParams.substring(0, sbParams.length() - 1));
        params.put("sign",s.toUpperCase());

        return "<xml>\n" +
                "   <appid>"+params.get("appid")+"</appid>\n" +
                "   <mch_id>"+params.get("mch_id")+"</mch_id>\n" +
                "   <nonce_str>"+params.get("nonce_str")+"</nonce_str> \n" +
                "   <sign>"+params.get("sign")+"</sign>\n" +
                "   <out_refund_no>"+params.get("out_refund_no")+"</out_refund_no>\n" +
                "   <out_trade_no>"+params.get("out_trade_no")+"</out_trade_no>\n" +
                "   <refund_fee>"+params.get("refund_fee")+"</refund_fee>\n" +
                "   <total_fee>"+params.get("appid")+"</total_fee>\n" +
                "</xml>";
    }


}
