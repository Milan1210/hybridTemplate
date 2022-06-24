package com.gerniks.app.utility;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Helpers {

    public String getDateAndTime(){
//        String pattern = "MM-dd-yyyy";
        String pattern = "dd-MM-yyyy__HH-mm-ss";
        Date date = new Date();
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public String getRandomString(){
        String pattern = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        int size = pattern.length();
        StringBuilder randomString = new StringBuilder();
        for (int i =0; i<7;i++){
            randomString.append(pattern.charAt(new Random().nextInt(size)));
        }
        return randomString.toString();
    }

    public void switchToNewTab(WebDriver driver,String url){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
    }

    public void selectSpecificTab(WebDriver driver,int index){ // index 0 means first tab, while 99 means last tab
        String firstTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        Iterator<String> it = allTabs.iterator();
        LinkedList<String> tabs = new LinkedList<>();

        while (it.hasNext()){
            tabs.add(it.next());
        }

        if (index == 99){
            driver.switchTo().window(tabs.getLast());
        }else {
            driver.switchTo().window(tabs.get(index));
        }
    }

    public void switchToNewWindow(WebDriver driver,String url){
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(url);
    }

    public void selectSpecificWinb(WebDriver driver,int index){ // index 0 means first tab, while 99 means last tab
        String firstTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        Iterator<String> it = allTabs.iterator();
        LinkedList<String> tabs = new LinkedList<>();

        while (it.hasNext()){
            tabs.add(it.next());
        }

        if (index == 99){
            driver.switchTo().window(tabs.getLast());
        }else {
            driver.switchTo().window(tabs.get(index));
        }
    }

    public void switchToIFrame(WebDriver driver,int index){
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("This is sum of iframe "+size);
        driver.switchTo().frame(index);
    }

    public void switchToIFrame(WebDriver driver,String iFrame){
        driver.switchTo().frame(iFrame);
    }
}
