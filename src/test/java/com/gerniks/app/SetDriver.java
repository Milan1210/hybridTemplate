package com.gerniks.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SetDriver extends RequiredData{

    public void chromeManager(){
        if (runLocal) {
            if (localDriver) {
                System.setProperty("webdriver.chrome.driver", fullWebDriverPath);
            } else {
                WebDriverManager.chromedriver().setup();
            }
        } else {
            if (grid){
                System.out.println("THis is gird");
            }else {
                ChromeOptions chrome = new ChromeOptions();
                chrome.addArguments("--headless");
            }
        }


    }

        public void fireFoxManager() {
            if (runLocal) {
                if (localDriver) {
                    System.setProperty("webdriver.gecko.driver", fullWebDriverPath);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                }
            } else {
                if (grid) {
                    System.out.println("THis is gird");
                } else {
                    FirefoxOptions firefox = new FirefoxOptions();
                    firefox.addArguments("--headless");
                }
            }
        }

    public void edgeManager() {
        if (runLocal) {
            if (localDriver) {
                System.setProperty("wedbriver.edge.driver", fullWebDriverPath);
            } else {
                WebDriverManager.edgedriver().setup();
            }
        } else {
            if (grid) {
                System.out.println("THis is gird");
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
