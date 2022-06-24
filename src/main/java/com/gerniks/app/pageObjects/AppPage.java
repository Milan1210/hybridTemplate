package com.gerniks.app.pageObjects;

import com.gerniks.app.utility.Helpers;
import com.gerniks.app.utility.RedirectionLinks;
import com.gerniks.app.utility.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppPage extends WebElementUtils {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(id = "s22")
    WebElement btntest;

    @FindBy(id = "submit-button")
    WebElement scr;

    @FindBy(css = "img#angular")
    WebElement drag;

    @FindBy(css = "div>#droparea")
    WebElement drop;

    @FindBy(xpath = "//*[@id=\"draggable\"]/p")
    WebElement dragJquery;

    @FindBy(id = "droppable")
    WebElement dropJquery;


    public AppPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterEmailAndPassowrd(){
//        slowType(email,"milan1210@live.com",200);
//        slowType(password,"1234556",200);
        type(email,"milan1210@live.com");
        type(password,"1234556");
        click(loginBtn);
        sleep(5000);
    }

    public void testClick(){
        hybridWait(btntest,10);
        click(btntest);
    }

    public void switchToNewTab(){
        Helpers h = new Helpers();
        h.switchToNewTab(driver,"https://youtube.com");
//        h.switchToNewWindow(driver,"https://youtube.com");
    }

    public void navigateToAlertPage(){
        RedirectionLinks redirectionLinks = new RedirectionLinks();
        driver.navigate().to("https://youtube.com");
        driver.navigate().to(redirectionLinks.redirectURL("Alerts.html"));
    }

    public void selectTab(int index){
        Helpers h = new Helpers();
        h.selectSpecificTab(driver,index);
        sleep(3000);
    }

    public void switchToNewWin(){
        Helpers h = new Helpers();
        h.switchToNewWindow(driver,"https://youtube.com");
//        h.switchToNewWindow(driver,"https://youtube.com");
    }

    public void selectWin(int index){
        Helpers h = new Helpers();
        h.selectSpecificTab(driver,index);
        sleep(3000);
    }

    public void captureElem(){
        scroll(scr);
        captureElement(scr);
        sleep(10);
    }

    public void dragAndDropTest(){
//        new Helpers().switchToIFrame(driver,2);
        waitForVisibility(drag);
        waitForVisibility(drop);
        dragAndDrop(drag,drop);
        sleep(5000);
    }
}
