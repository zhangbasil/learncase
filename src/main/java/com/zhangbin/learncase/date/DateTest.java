package com.zhangbin.learncase.date;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangbin
 * @Type DateTest
 * @Desc
 * @date 2018-04-19
 * @Version V1.0
 */
public class DateTest {

    @Test
    void test() {
        Date date = new Date();
        System.out.println("date0 = " + date);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 60);
        System.out.println("date1 = " + calendar.getTime());

    }

    private boolean inCurrentMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(date);
        int targetYear = calendar.get(Calendar.YEAR);
        int targetMonth = calendar.get(Calendar.MONTH) + 1;
        return (currentYear == targetYear && currentMonth == targetMonth);
    }


    @Test
    void addSeconds() {
        Date date = new Date();
        System.out.println("date1 = " + date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, -10);
        System.out.println("date2 = " + c.getTime());


        String str = "18910647692";
        String loginId = "112";
        String s = StringUtils.rightPad(str, 6, "*");
        System.out.println("s = " + s);


        loginId = loginId.substring(0,2) + "*" + loginId.substring(loginId.length() - 2, loginId.length());

        System.out.println("loginId = " + loginId);
    }

    @Test
    void stringOperate() {
        String str = String.format("%06d", 12L);
        System.out.println("左加0 start:"+str+":end");
    }


}
