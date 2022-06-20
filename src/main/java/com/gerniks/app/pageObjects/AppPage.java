package com.gerniks.app.pageObjects;

import com.gerniks.app.utility.Helpers;
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

    public AppPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterEmailAndPassowrd(){
        slowType(email,"milan1210@live.com",200);
        slowType(password,"1234556",200);
        click(loginBtn);
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
}
