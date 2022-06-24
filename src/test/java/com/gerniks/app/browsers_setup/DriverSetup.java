package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import com.gerniks.app.listeners.Listener;
import com.gerniks.app.utility.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

public class DriverSetup extends RequiredData {
    public WebDriver driverOrigin;
    WebDriverListener listener;
    public WebDriver driver; // That is driver with listener

    DriverSetup(){
        this.validateStatusCode();
        this.setUp();
    }

    public void setUp(){
        DriverStrategy chooseDriver = new ChooseDriver().chooseDriver(browserDriver);
        if (runLocal){
            if (localDriver){
                if (headless){
                    driverOrigin = chooseDriver.setHeadLess();
                }else {
                    driverOrigin = chooseDriver.setLocalDriver();
                }
            } else {
                driverOrigin = chooseDriver.setDriverManager();
            }
            driver = setUpListener();
        }

        if (grid){
            driverOrigin = chooseDriver.setGrid();
            driver = setUpListener();
        }

    }

    public void validateStatusCode() {
        int statusCode = GenericFunctions.getStatusCode(url);

        //Assert.assertTrue(statusCode<399,"Status code of the page isn't as expected, the current status code is "+ statusCode);

        if (statusCode>399){
            //Assert.assertTrue(false,"Status code doesn't belong to success status code, the current status code is "+GenericFunctions.getStatusCode(url)+"|");
            throw new  AssertionError("Status code of the visited site doesn't belong to success status codes the current status code is "+statusCode+ " but expecte is between 200 and 399");
        }
    }

    public WebDriver setUpListener(){
        WebDriverListener listener = new Listener();
        return new EventFiringDecorator(listener).decorate(driverOrigin);
    }
}
