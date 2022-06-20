package com.gerniks.app.browsers_setup;

import com.gerniks.app.utility.GenericFunctions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class RunDriver extends DriverSetup {
    @BeforeClass
    public void startDriver() {
        System.out.println("This is a status code "+GenericFunctions.getStatusCode(url));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
