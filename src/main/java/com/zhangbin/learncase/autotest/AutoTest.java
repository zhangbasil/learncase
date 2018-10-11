package com.zhangbin.learncase.autotest;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author zhangbin
 * @Type AutoTest
 * @Desc 自动化测试
 * @date 2018-05-20
 * @Version V1.0
 */
public class AutoTest {
    private static ChromeDriver driver;

    private void init() {
        System.setProperty("webdriver.chrome.driver",
                "F:/other/zhangbin/learncase/src/main/java/com/zhangbin/learncase/autotest/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void test() throws InterruptedException {

        init();
        driver.get("http://n.xxxx-test.com/member/bigmember/page");

        Thread.sleep(2000);

        driver.findElementByXPath("//*[@id=\"bigmember-content\"]/div[1]/div/div/div/div[3]/a").click();



        Thread.sleep(2000);

        driver.findElementByXPath("//*[@id=\"bigmember-content\"]/div[1]/input").click();


        Thread.sleep(2000);

        // 快速登录
//        driver.findElementById("loginId").sendKeys("18910647692");
//        driver.findElementById("imgcaptcha").sendKeys("1234");
//        driver.findElementByXPath("//*[@id=\"code\"]").sendKeys("111111");
//        driver.findElementByXPath("//*[@id=\"J_TelAccountFirst\"]/form/div[4]/a").click();
//        driver.findElementByXPath("//*[@id=\"J_TelAccountSecond\"]/form/a").click();


        // 密码登录

        driver.findElementByXPath("//*[@id=\"J_TelAccountFirst\"]/form/div[5]/a").click();

        Thread.sleep(2000);
        driver.findElementByXPath("//*[@id=\"username\"]").sendKeys("18910647692");
        driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("091818");
        driver.findElementByXPath("//*[@id=\"captcha\"]").sendKeys("1234");

        driver.findElementByXPath("//*[@id=\"J_AccountLogin\"]/form/div[5]/a").click();


//        driver.quit();
    }



    @Test
    void helperTest() {
        init();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("F:/other/zhangbin/learncase/src/main/java/com/zhangbin/learncase/autotest/auto1.txt"));
            String content;
            while ((content = reader.readLine()) != null) {
                if (StringUtils.startsWith(content, "#")) {
                    continue;
                }
                String[] split = content.split("( )+");

                processCommand(split);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(reader)) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    void processCommand(String[] strings) {

        String command = strings[0];

        switch (command) {
            case "url":
                driver.get(strings[1]);
                sleep(1);
                break;
            case "txt":
                sendTextValue(strings[1], strings[2]);
                sleep(1);
                break;
            case "click":
                sendButtonClick(strings[1]);
                sleep(1);
                break;
            default:
                break;

        }

    }

    private void sendTextValue(String path, String value) {
        driver.findElementByXPath(path).sendKeys(value);
    }

    private void sendButtonClick(String path) {
        driver.findElementByXPath(path).click();
    }

    private void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
