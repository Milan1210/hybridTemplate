package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxSetup extends RequiredData implements DriverStrategy{

    public WebDriver setLocalDriver() {
        System.setProperty("webdriver.gecko.driver",fullWebDriverPath);
        return new FirefoxDriver();
    }

    public WebDriver setDriverManager() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public WebDriver setGrid() {
        WebDriver driver = null;
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(gridPlatform);
        try {
            driver = new RemoteWebDriver(new URL(gridURL),options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public WebDriver setHeadLess() {
        System.setProperty("webdriver.gecko.driver",fullWebDriverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return new FirefoxDriver(options);
    }
}
