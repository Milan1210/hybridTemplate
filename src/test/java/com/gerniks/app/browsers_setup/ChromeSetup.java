package com.gerniks.app.browsers_setup;

import com.gerniks.app.RequiredData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeSetup extends RequiredData implements DriverStrategy{

    public WebDriver setLocalDriver() {
        System.setProperty("webdriver.chrome.driver",fullWebDriverPath);
        return new ChromeDriver();
    }

    public WebDriver setDriverManager() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver setGrid() {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName(gridPlatform);
        try {
            driver = new RemoteWebDriver(new URL(gridURL),options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public WebDriver setHeadLess() {
        System.setProperty("webdriver.chrome.driver",fullWebDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return new ChromeDriver(options);
    }
}
