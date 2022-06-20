package com.gerniks.app.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WebElementUtils {
    public WebDriver driver;
    WebDriverWait wait;

    public WebElementUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void hybridWait(WebElement element, int sec){
        for (int i = 0; i<sec ; i ++){
            try {
                    element.isDisplayed();
                    break;
            } catch (NoSuchElementException e) {
                    sleep(1000);
                e.getMessage();
            }
        }
    }

    public void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollTo(int position){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy('0','"+position+"');");
    }

    public void type(WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void slowType(WebElement element, String text, int milisec){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        for (int i = 0; i<text.length(); i++) {
        char letter = text.charAt(i);
            element.sendKeys(String.valueOf(letter));
            sleep(milisec);
        }
    }

    public void sleep(int milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void captureElement(WebElement element){
        Helpers helpers = new Helpers();
        String fileName = helpers.getDateAndTime()+".png";
        File file = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/"+fileName);
//        File dest = new File("screenshots/logos1.png");
        try {
            FileUtils.copyFile(file,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
