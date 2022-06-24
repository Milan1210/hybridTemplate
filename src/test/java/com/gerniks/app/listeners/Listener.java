package com.gerniks.app.listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;
import java.net.URL;

public class Listener implements WebDriverListener {

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Starting WebDriver");
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("WebDriver is started successfully and url is "+url);
    }

    @Override
    public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args) {
        System.out.println("TImeout is called");
    }

    @Override
    public void afterAccept(Alert alert) {
        System.out.println("Alert is accepted");
    }

    @Override
    public void beforeGetWindowHandles(WebDriver driver) {
        System.out.println("Managing multiple windwos");
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        navigation.to(url);
        System.out.println("Navigate to the URL "+url);
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        navigation.refresh();
        System.out.println("Refresh the page");
    }

    @Override
    public void beforeFindElement(WebDriver driver, By xpath) {
        System.out.println("--------- Tring to find element >>>>> "+xpath);
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {
        System.out.println("Checking is element {{{ "+element.getAccessibleName()+" }}} displated");
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Try clicking on the element {{{ "+element.getAccessibleName()+" }}}");

    }

//    @Override
//    public void afterClick(WebElement element) {
//        System.out.println("Click is preformend on the element }}}"+element.getAccessibleName()+" }}}");
//    }

    @Override
    public void beforeClear(WebElement element) {
        System.out.println("Cleaning text field {{{ "+element.getAccessibleName()+" }}}");
    }

    @Override
    public void afterClear(WebElement element) {
        System.out.println("Text field {{{ "+element.getAccessibleName()+" }}} has been cleaned");
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Try typing into text field {{{ "+element.getAccessibleName()+" }}}");
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend)
    {
        System.out.println("Typing is done into the text field {{{ "+element.getAccessibleName()+" }}}");
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        System.out.println("Quite WebDriver");
    }
}
