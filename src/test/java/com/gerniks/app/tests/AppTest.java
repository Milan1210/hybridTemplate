package com.gerniks.app.tests;


import com.gerniks.app.BaseClass;
import com.gerniks.app.pageObjects.AppPage;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseClass {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        AppPage a = new AppPage(driver);
//        a.enterEmailAndPassowrd();
//        a.captureElem();
        a.switchToNewWin();
        a.switchToNewWin();
        a.switchToNewWin();
        a.switchToNewWin();
        a.selectWin(0);
        a.selectWin(99);
    }

    @Test
    public void test() {
        String pattern = "MM-dd-yyyy HH:mm:ss";
        Date date = new Date();
        DateFormat format = new SimpleDateFormat(pattern);
        String currentDate = format.format(date);
        System.out.println("THis is the date: " + currentDate);
    }
}
