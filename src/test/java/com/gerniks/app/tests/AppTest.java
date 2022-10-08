package com.gerniks.app.tests;


import com.gerniks.app.BaseClass;
import com.gerniks.app.browsers_setup.RunDriver;
import com.gerniks.app.listeners.Listener;
import com.gerniks.app.listeners.TestNgListener;
import com.gerniks.app.pageObjects.AppPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */

public class AppTest extends RunDriver {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Listener listener = new Listener();
        AppPage a = new AppPage(setUpListener());
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

    @Test
    public void test1() {
        setUpListener().get("https://www.softwaretestingmaterial.com/webdriver-event-listeners/");
    }
}
