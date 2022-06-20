package com.gerniks.app.browsers_setup;

import org.openqa.selenium.WebDriver;

public interface DriverStrategy {
    WebDriver setLocalDriver();
    WebDriver setDriverManager();
    WebDriver setGrid();
    WebDriver setHeadLess();
}
