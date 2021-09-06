package com.zhangbin.learncase.reptile;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.zhangbin.learncase.excel.util.ExcelExportUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * @author zhangbin
 * @Type ReptileLearn
 * @Desc
 * @date 2018-08-03
 * @Version V1.0
 */
public class ReptileLearn {

    private static final String URL = "http://top100.imicams.ac.cn/province";

    static List<Information> ALL = new ArrayList<>();



    public static void main(String[] args) throws Exception {

//        List<Province> provinces = listProvince();
//        System.out.println("provinces.size() = " + provinces.size());
//        listTest(provinces);
//        oneTest(provinces);


        chaogu();

    }


    public static void oneTest(List<Province> provinces) throws Exception {

        provinces.stream().parallel().forEach(province -> {
            List<Information> information = listInfomation(province, 1, new ArrayList<>());
            province.setInformations(information);
            Map<String, String> map = new HashMap<>();
            map.put("title", province.getName() + "地区排名");
            map.put("sheetName", province.getName());
            map.put("sheetSize", 1000 + "");

            Workbook workbook = ExcelExportUtil.exportExcel07(Information.class, information, map);
            File file = new File("D:/" + province.getName() + ".xls");
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        });

//        for (int i = 0; i < provinces.size(); i++) {
//            Province province = provinces.get(i);
//            List<Information> information = listInfomation(province, 1, new ArrayList<>());
//            province.setInformations(information);
//            Map<String, String> map = new HashMap<>();
//            map.put("title", province.getName() + "地区排名");
//            map.put("sheetName", province.getName());
//            map.put("sheetSize", 1000 + "");
//
//            Workbook workbook = ExcelExportUtil.exportExcel07(Information.class, information, map);
//            File file = new File("D:/" + province.getName() + ".xls");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            workbook.write(outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//        }

    }




    public static void listTest(List<Province> provinces) throws Exception {
        long start = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        map.put("title", "地区排名");

        for (int i = 0; i < provinces.size(); i++) {
            Province province = provinces.get(i);

            all(province, 1);
//            System.out.println("province ======================> " + province);
//                List<Information> information = listInfomation(province, 1, new ArrayList<>());
//                province.setInformations(information);
//                map.put("sheetName", province.getName());
//                map.put("sheetSize", "5000");


        }



        Workbook workbook = ExcelExportUtil.exportExcel07(Information.class, ALL);

        File file = new File("D:/all.xls");
        FileOutputStream outputStream = new FileOutputStream(file);

        // workbook = ExcelExportUtil.exportExcel07(Information.class, informations);

        // map.put("sheetName", "上海地区");

        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

        System.out.println("System.currentTimeMillis()-start = " + (System.currentTimeMillis() - start));

//        provinces.forEach(province -> {
//
//            listInfomation(province.getId(), 1);
//
//        });
    }


    private static List<Information> listInfomation(Province province, Integer page, List<Information> informations) {

        String requestUrl = URL + "?" + "province=" + province.getId() +
                "&" + "year=2017" +
                "#" + "page=" + page +
                "&" + "value=" + "NaN";
        Document document = DocumentUtils.getDocument(requestUrl);
        Elements trs = document.select("table.index_table > tbody > tr");
//        String temp = "";

        for (Element tr : trs) {
            Information information = new Information();
            information.setProvinceName(province.getName());
            Elements tds = tr.children();
            int size = tds.size();
            for (int i = 0; i < tds.size(); i++) {
                if (size == 3) {
//                    String text = tds.get(0).text();
                    information.setCourse(tds.get(0).text());
                    information.setOrder(tds.get(1).text());
                    information.setHospitalName(tds.get(2).text());

                } else if (size == 2) {
//                    information.setCourse(temp);
                    information.setOrder(tds.get(0).text());
                    information.setHospitalName(tds.get(1).text());
                }
            }
            if (!"学科".equals(information.getCourse()) && !StringUtils.isEmpty(information.getOrder())) {
                informations.add(information);
            }

        }


        if (page < 5) {
            System.out.println(" ======================page======================= " + page);
            listInfomation(province, (page + 1), informations);
        }

        return informations;

    }




    private static void all(Province province, Integer page) {

        String requestUrl = URL + "?" + "province=" + province.getId() +
                "&" + "year=2017" +
                "#" + "page=" + page +
                "&" + "value=" + "NaN";
        Document document = DocumentUtils.getDocument(requestUrl);
        Elements trs = document.select("table.index_table > tbody > tr");
//        String temp = "";

        for (Element tr : trs) {
            Information information = new Information();
            information.setProvinceName(province.getName());
            Elements tds = tr.children();
            int size = tds.size();
            for (int i = 0; i < tds.size(); i++) {
                if (size == 3) {
//                    String text = tds.get(0).text();
                    information.setCourse(tds.get(0).text());
                    information.setOrder(tds.get(1).text());
                    information.setHospitalName(tds.get(2).text());

                } else if (size == 2) {
//                    information.setCourse(temp);
                    information.setOrder(tds.get(0).text());
                    information.setHospitalName(tds.get(1).text());
                }
            }
            if (!"学科".equals(information.getCourse()) && !StringUtils.isEmpty(information.getOrder())) {
                ALL.add(information);
            }

        }
        if (page < 5) {
            System.out.println(" ======================page======================= " + page);
            all(province, (page + 1));
        }


    }

    public static boolean hasNext(String url) {
        Document document = DocumentUtils.getDocument(url);
        Elements as = document.select("div.yahoo2 > span");
        for (Element a : as) {
            String text = a.text();
            if ("下一页".equals(text)) {
                return true;
            }
        }
        return false;
    }

    private static List<Province> listProvince() {

        Document document = DocumentUtils.getDocument(URL + "?province=1&year=2017#page=1&value=NaN");

        Elements lis = document.select("ul.nav_left > li");

        List<Province> provinces = new ArrayList<>();

        for (Element li : lis) {
            String text = li.text();
            Attributes attributes = li.attributes();
            attributes.asList().forEach(attribute -> {
                if ("onclick".equals(attribute.getKey())) {
                    String value = attribute.getValue();
                    String[] split = value.split("'");
                    String number = split[1];
                    provinces.add(new Province(number, text));
                }
            });
        }

        // provinces.forEach(province -> {
        // System.out.println("province.getId()+ \"\" + province.getName() = " +
        // province.getId() + " " + province.getName());
        // });

        return provinces;

    }



    private static void chaogu() {
        String url = "http://blog.sina.com.cn/s/blog_486e105c01000cih.html";

        Document document = DocumentUtils.getDocument(url);

        System.out.println("document = " + document);
    }




    private static void exportExcel(List<Information> informations, Province province, Workbook workbook) {

        FileOutputStream outputStream = null;
        try {
            File file = new File("D:/test.xls");
            outputStream = new FileOutputStream(file);

            long start = System.currentTimeMillis();
//            workbook = ExcelExportUtil.exportExcel07(Information.class, informations);
            Map<String, String> map = new HashMap<>();
            map.put("title", province.getName() + "地区排名");
//            map.put("sheetName", "上海地区");
            workbook = ExcelExportUtil.exportExcel07(Information.class, informations, map, workbook);
            // workbook =
            // ExcelExportUtil.exportExcel(Person.class,list,ExcelFileType.XLS,null,null,true);
            // list = getData();
            // workbook =
            // ExcelExportUtil.exportExcel(UserPlus.class,list,ExcelFileType.XLSX,map,workbook,true);
            long end = System.currentTimeMillis();

            System.out.println("耗时：" + (end - start) + "毫秒");
            System.out.println("****************************");
            workbook.write(outputStream);

            if (SXSSFWorkbook.class.equals(workbook.getClass())) {
                SXSSFWorkbook wb = (SXSSFWorkbook) workbook;
                wb.dispose();
            }
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
