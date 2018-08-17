package com.zhangbin.learncase.httprequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhangbin
 * @Type HttpRequestTest
 * @Desc
 * @date 2018-07-10
 * @Version V1.0
 */
public class HttpRequestTest {
    private String fosunReqestUrl = "http://dev.zhangfeibiao.iego.cn:10062/ms-youle/openapi/weiyi/acceptAccessToken";

    @Test
    void postRequestTest() throws Exception {

        String params = "{\t\n" +
                "\t\"appkey\":\"weiyi\",\n" +
                "\t\"timestamp\":\"1531193418471\",\n" +
                "\t\"version\" : \"1.0\",\n" +
                "\t\"sign\":\"606ebd053ad603f37af396ff2ab28bc7c77c1ec3\",\n" +
                "\t\"accessToken\" : \"!TErhLXPYRO1j2z3jZJ16U7lu0nHTUoNlD6hpb1LSyHnvS-0v9gFR2QNKvjKoVkPYGuZHMRHEqOgjmQk4k99naXqhu-QMTaw0dcordQaWnDnmvkXcMYj5VfW-6dH5viSiJiU7GsZ_Ed-fICZWD0cKA9NncWXPIxLDsfg28lJ3tyI1LLtYwhs-7-ZhIR4Hzfz4K2\"\n" +
                "}";

        Map<String, Object> map = new HashMap<>();
        map.put("accessToken", "!TErhLXPYRO1j2z3jZJ16U7lu0nHTUoNlD6hpb1LSyHnvS-0v9gFR2QNKvjKoVkPYGuZHMRHEqOgjmQk4k99naXqhu-QMTaw0dcordQaWnDnmvkXcMYj5VfW-6dH5viSiJiU7GsZ_Ed-fICZWD0cKA9NncWXPIxLDsfg28lJ3tyI1LLtYwhs-7-ZhIR4Hzfz4K2");
        map.put("appKey", "weiyi");
        map.put("timestamp", new Date().getTime() + "");
        map.put("version", "1.0");
//        map.add("sign", FosunUtils.sign(map));
        map.put("sign", "606ebd053ad603f37af396ff2ab28bc7c77c1ec3");

        String s = doPost(fosunReqestUrl, params);
        System.out.println("s = " + s);
    }

    /**
     * post请求(用于key-value格式的参数)
     * 
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params) {

        BufferedReader in = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            // 设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

                // System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            request.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) { // 请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();

                return sb.toString();
            } else { //
                System.out.println("状态码：" + code);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }



    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Test
    void test() {

        String params = "{\t\n" +
                "\t\"appkey\":\"weiyi\",\n" +
                "\t\"timestamp\":\"1531193418471\",\n" +
                "\t\"version\" : \"1.0\",\n" +
                "\t\"sign\":\"606ebd053ad603f37af396ff2ab28bc7c77c1ec3\",\n" +
                "\t\"accessToken\" : \"!TErhLXPYRO1j2z3jZJ16U7lu0nHTUoNlD6hpb1LSyHnvS-0v9gFR2QNKvjKoVkPYGuZHMRHEqOgjmQk4k99naXqhu-QMTaw0dcordQaWnDnmvkXcMYj5VfW-6dH5viSiJiU7GsZ_Ed-fICZWD0cKA9NncWXPIxLDsfg28lJ3tyI1LLtYwhs-7-ZhIR4Hzfz4K2\"\n" +
                "}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        org.springframework.http.HttpEntity httpEntity = new org.springframework.http.HttpEntity(params, headers);

//        ResponseEntity<String> response = restTemplate.postForEntity(fosunReqestUrl, httpEntity, String.class);

        String s = restTemplate.postForObject(fosunReqestUrl, httpEntity, String.class);
        System.out.println("s = " + s);
//        boolean equals = response.getStatusCode().equals(org.springframework.http.HttpStatus.OK);
//        if (equals) {
//            String body = response.getBody();
//            System.out.println("body = " + body);
//        }

    }


}
