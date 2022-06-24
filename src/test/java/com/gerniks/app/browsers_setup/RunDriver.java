package com.gerniks.app.browsers_setup;

import com.gerniks.app.listeners.Listener;
import com.gerniks.app.utility.GenericFunctions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class RunDriver extends DriverSetup {

    public Logger logger = Logger.getLogger("RunDriver");

    @BeforeClass
    public void startDriver() {
        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");
        System.out.println("This is a status code "+GenericFunctions.getStatusCode(url));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
