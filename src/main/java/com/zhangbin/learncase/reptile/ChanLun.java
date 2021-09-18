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
 *
 * 1.中信重工  跳空（突破压力位）高开涨停  回到涨停实体的地点买入
 * 2.云煤能源   涨停后高开低走收盘破5日线 涨停K线破一半 第三天高开下杀到10日线附近涨停K线吃掉三分之二 第四天大涨
 *
 *
 */
public class ChanLun {




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
                if (!StringUtils.isEmpty(text) && text.contains("缠论")) {
                    String href = element.attr("href");
                    Document detail = DocumentUtils.getDocument(href);
                    String html = detail.outerHtml();
                    html = "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>" + html.split("<head>")[1];

                    FileOutputStream fileOutputStream = new FileOutputStream(text.replace("缠论","缠论") + ".html");
                    fileOutputStream.write(html.getBytes());
                    fileOutputStream.close();
                }
            }
        }
    }


}
