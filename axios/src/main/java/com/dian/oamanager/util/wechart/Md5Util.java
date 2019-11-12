package com.dian.oamanager.util.wechart;

import java.security.MessageDigest;

/**
 * Md5工具类
 * @author zclever <304078606@qq.com>
 *
 */
public class Md5Util {

	public static String md5(String str) {
		StringBuffer hexString = new StringBuffer();
		if (str == null)
			str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes("utf-8"));
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (Exception e) {
			return null;
		}
		return hexString.toString();
	}

	public static void main(String[] args) {
		System.out.println(Md5Util.md5("appid=wxf52e42ed403fe957&body=JSAPItest&mch_id=1318360201&nonce_str=Q0T91NUSU8NUNQHG4QJYNQO2D3OF75AL&notify_url=http://weixintest.newchinalife.com/fe/page/wxpay/payBack.jsp&openid=oNmeHuH3Hyc5uf02GyPOPxs_dYHo&out_trade_no=1415659990&spbill_create_ip=192.168.168.241&total_fee=1&trade_type=JSAPI&key=newstrengthcomcn20160304weixingo"));
		System.out.println(Md5Util.md5("appid=wxf52e42ed403fe957&body=JSAPI支付测试&mch_id=1318360201&nonce_str=Q0T91NUSU8NUNQHG4QJYNQO2D3OF75AL&notify_url=http://weixintest.newchinalife.com/fe/page/wxpay/payBack.jsp&openid=oNmeHuH3Hyc5uf02GyPOPxs_dYHo&out_trade_no=1415659990&spbill_create_ip=192.168.168.241&total_fee=1&trade_type=JSAPI&key=newstrengthcomcn20160304weixingo"));
	}
}
