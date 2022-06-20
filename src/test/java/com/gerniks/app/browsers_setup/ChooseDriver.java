package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;

public class ChooseDriver {
    public DriverStrategy chooseDriver(String browserDriver){
        switch (browserDriver){
            case "chrome":
                return new ChromeSetup();
            case "gecko":  // that is firefox
                return new FirefoxSetup();
            case "edge":
                return new EdgeSetup();
            default:
                return null;
        }
    }
}
