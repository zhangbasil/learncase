package com.zhangbin.learncase.reptile;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author <a href="mailto:hbsy_zhb@163.com">zhangbin</a>
 */
public class DocumentUtils {


    public static Document getDocument(String url) {
        Document document = null;
        try {
            // 创建模拟浏览器，参数可以指定不同类型的浏览器
            WebClient webClient = new WebClient();

            // 启用JS解释器，默认为true
            webClient.getOptions().setJavaScriptEnabled(true);

            // 禁用css支持
            webClient.getOptions().setCssEnabled(false);

            // js运行错误时，是否抛出异常
            webClient.getOptions().setThrowExceptionOnScriptError(false);

            // 设置超时
            webClient.getOptions().setTimeout(20000);

            // page 就是你获取到的html，你可以进一步的解析数据
            HtmlPage page = webClient.getPage(url);

            document = Jsoup.parse(page.asXml());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
