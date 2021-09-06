package com.zhangbin.learncase.reptile;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hbsy_zhb@163.com">zhangbin</a>
 */
public class ChanLun {


    private static void createHtml(Document document, Elements elements) {



    }


    public static void main(String[] args) throws Exception {
        List<String> pages = new ArrayList<>();
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_1.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_2.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_3.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_4.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_5.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_6.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_7.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_8.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_9.html");
        pages.add("http://blog.sina.com.cn/s/articlelist_1215172700_10_10.html");
        for (String page : pages) {
            Document document = DocumentUtils.getDocument(page);
            Elements elements = document.select("a");
            for (Element element : elements) {
                String text = element.text();
                if (!StringUtils.isEmpty(text) && text.contains("教你炒股票")) {
                    String href = element.attr("href");
                    Document detail = DocumentUtils.getDocument(href);
                    String html = detail.outerHtml();
                    html = "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>" + html.split("<head>")[1];

                    FileOutputStream fileOutputStream = new FileOutputStream(text.replace("教你炒股票","缠论") + ".html");
                    fileOutputStream.write(html.getBytes());
                    fileOutputStream.close();
                }
            }
        }
    }


}
