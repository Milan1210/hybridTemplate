package com.gerniks.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SetDriver extends RequiredData{
    public WebDriver driver;
    public SetDriver() {
        System.setProperty("webdriver."+browserDriver+".driver", fullWebDriverPath);
    }

    public void chromeManager(){
        if (runLocal) {
            if (localDriver) {
                System.setProperty("webdriver."+browserDriver+".driver", fullWebDriverPath);

            } else {
                WebDriverManager.chromedriver().setup();
            }
            driver = new ChromeDriver();
        } else {
            if (grid){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(gridPlatform);
//                chromeOptions.setBrowserVersion("101.0");
                chromeOptions.getBrowserName();
                try {
                    driver = new RemoteWebDriver(new URL(gridURL),chromeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else {
                ChromeOptions chrome = new ChromeOptions();
                chrome.addArguments("--headless");
            }
        }


    }

        public void fireFoxManager() {
            if (runLocal) {
                if (localDriver) {
                    System.setProperty("webdriver."+browserDriver+".driver", fullWebDriverPath);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                }
                driver = new FirefoxDriver();
            } else {
                if (grid) {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPlatformName(gridPlatform);
                    try {
                        driver = new RemoteWebDriver(new URL(gridURL),firefoxOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    FirefoxOptions firefox = new FirefoxOptions();
                    firefox.addArguments("--headless");
                }
            }
        }

    public void edgeManager() {
        if (runLocal) {
            if (localDriver) {
                System.setProperty("webdriver."+browserDriver+".driver", fullWebDriverPath);
            } else {
                WebDriverManager.edgedriver().setup();
            }
            driver = new EdgeDriver();
        } else {
            if (grid) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.setPlatformName(gridPlatform);
                try {
                    driver = new RemoteWebDriver(new URL(gridURL),edgeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                EdgeOptions edge = new EdgeOptions();
                edge.addArguments("--headless");
            }
        }
    }

    public void safariManager() {
        if (runLocal) {
            if (localDriver) {
                WebDriverManager.safaridriver().setup();
            } else {
                System.setProperty("webriver.safari.driver", fullWebDriverPath);
            }
        } else {
            if (grid) {
                System.out.println("THis is gird");
            } else {
//                SafariOptions safari = new SafariOptions();
//                safari.add;
            }
        }
    }
}
