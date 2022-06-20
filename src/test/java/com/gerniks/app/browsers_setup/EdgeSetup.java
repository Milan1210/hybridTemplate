package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeSetup extends RequiredData implements DriverStrategy{

    public WebDriver setLocalDriver() {
        System.setProperty("webdriver.edge.driver",fullWebDriverPath);
        return new EdgeDriver();
    }

    public WebDriver setDriverManager() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public WebDriver setGrid() {
        WebDriver driver = null;
        EdgeOptions options = new EdgeOptions();
        options.setPlatformName(gridPlatform);
        try {
            driver = new RemoteWebDriver(new URL(gridURL),options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public WebDriver setHeadLess() {
        System.setProperty("webdriver.edge.driver",fullWebDriverPath);
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(true);
        return new EdgeDriver(options);
    }
}
