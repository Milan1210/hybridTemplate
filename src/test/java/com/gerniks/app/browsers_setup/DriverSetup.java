package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import com.gerniks.app.utility.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DriverSetup extends RequiredData {
    public WebDriver driver;

    DriverSetup(){
        this.validateStatusCode();
        this.setUp();
    }

    public void setUp(){
        DriverStrategy chooseDriver = new ChooseDriver().chooseDriver(browserDriver);
        if (runLocal){
            if (localDriver){
                if (headless){
                    driver = chooseDriver.setHeadLess();
                }else {driver = chooseDriver.setLocalDriver();}
            } else {
                driver = chooseDriver.setDriverManager();
            }
        }

        if (grid){
            chooseDriver.setGrid();
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
}
