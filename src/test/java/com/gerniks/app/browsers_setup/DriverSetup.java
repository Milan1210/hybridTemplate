package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import org.openqa.selenium.WebDriver;

public class DriverSetup extends RequiredData {
    public WebDriver driver;

    DriverSetup(){
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
}
