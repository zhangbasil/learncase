package com.zhangbin.learncase.xxxx;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @Type SignUtil
 * @Desc 签名工具类
 * @Date 2015年10月28日
 * @Version V1.0
 */
public class SignUtil {
	/**
	 * 根据map的key的ASCII码进行排序，以keyvalue的拼接，然后再首位添加appsecret字符换，在末尾添加appsecret的值，再进行md5，最后转大写
	 *
	 * @param map       非空的请求头参数和非空的请求参数
	 * @param appSecret 账号的秘钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String createSign(Map<String, Object> map, String appSecret)
		throws NoSuchAlgorithmException {
		String[] keys = map.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		StringBuffer sb = new StringBuffer("appsecret");
		for (String key : keys) {
			Object value = map.get(key);
			if (value != null && !value.equals("")) {
				sb.append(key).append(value);
			}
		}
		sb.append(appSecret);
		return MD5Utils.encryptMD5(sb.toString());
	}

	/**
	 * 根据map的key的ASCII码进行排序，以keyvalue的拼接，然后再首位添加appsecret字符换，在末尾添加appsecret的值
	 * 进行md5，再转大写
	 *
	 * @param headerMap  请求头参数
	 * @param requestMap 请求参数
	 * @param appSecret  秘钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String createSign(Map<String, Object> headerMap, Map<String, Object> requestMap, String appSecret)
		throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		map.putAll(headerMap);
		map.putAll(requestMap);
		return createSign(map, appSecret);
	}
}
