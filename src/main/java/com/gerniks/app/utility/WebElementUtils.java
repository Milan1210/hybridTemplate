package com.gerniks.app.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebElementUtils {
    public WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public WebElementUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void mouseHover(WebElement element){
        waitForVisibility(element);
        actions.moveToElement(element).perform();
    }

    public void doubleClick(WebElement element){
        waitForVisibility(element);
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element){
        waitForVisibility(element);
        actions.contextClick(element).perform();
    }

    public void clickAndHold(WebElement element){
        waitForVisibility(element);
        actions.clickAndHold(element).perform();
    }

    public void releaseClick(WebElement element){
        waitForVisibility(element);
        actions.release(element).perform();
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

    public void waitForVisibility(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
//            hybridWait(element,10);
            e.printStackTrace();
        }
    }

    public void type(WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void slowType(WebElement element, String text, int milisec){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.isDisplayed();
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

    public void dragAndDrop(WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public void acceptAlert(boolean Accept){
        wait.until(ExpectedConditions.alertIsPresent());
        if (Accept){
        driver.switchTo().alert().accept();
        }else {driver.switchTo().alert().dismiss();}
    }

    public void uploadFile(WebElement element, String file){  //put content root of the file e.g screenshots/image22.png
        waitForVisibility(element);
        String rootPath = System.getProperty("user.dir");
        element.sendKeys(rootPath+"\\"+file);
    }

    public void verifyAllLinksInThePage(){
        ManageLinks manageLinks = new ManageLinks();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("a"))));
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link:links) {
            String url = link.getAttribute("href");
            manageLinks.verifyLinkConnection(url);
        }
    }

    public void verifyLink(WebElement linkElement){
        ManageLinks manageLinks = new ManageLinks();
        String url = linkElement.getAttribute("href");
    }
}
