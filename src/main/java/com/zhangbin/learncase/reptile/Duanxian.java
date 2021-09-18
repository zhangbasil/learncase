package com.zhangbin.learncase.reptile;

import org.jsoup.nodes.Document;

/**
 * @author <a href="mailto:hbsy_zhb@163.com">zhangbin</a>
 */
public class Duanxian {

    public static void main(String[] args) {

        Document document = DocumentUtils.getDocument("http://www.iwencai.com/unifiedwap/result?w=9%E6%9C%883%E6%97%A5%E4%B8%80%E9%98%B3%E7%A9%BF%E4%B8%89%E7%BA%BF%EF%BC%9B%E6%B6%A8%E5%B9%85%E5%A4%A7%E4%BA%8E4%25%EF%BC%9B%E9%9D%9E%E5%88%9B%E4%B8%9A%E6%9D%BF%E5%92%8Cst%E5%92%8C%E7%A7%91%E5%88%9B%E6%9D%BF&querytype=&issugs");


        System.out.println("document = " + document);
    }
}
