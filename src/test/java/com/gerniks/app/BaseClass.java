package com.gerniks.app;

import com.gerniks.app.utility.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass extends SetDriver{
//    public WebDriver driver;
    public String email;
    public String passwprd;

    @BeforeClass
    public void runDriver(){
        RequiredData rd = new RequiredData();
        switch (rd.browserDriver){
            case "chrome":
            System.out.println("Browser "+rd.browserDriver);
                chromeManager();
//                driver = new ChromeDriver();
                break;
            case "gecko":
                fireFoxManager();
//                driver = new FirefoxDriver();
                break;
            case "edge":
                edgeManager();
//                driver = new EdgeDriver();
                break;
        }

        GenericFunctions g = new GenericFunctions();
        String url = g.fileRead("file","url");
        email = g.fileRead("file","email");
        passwprd = g.fileRead("file","password");
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
