package com.gerniks.app.tests;


import com.gerniks.app.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseClass
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(passwprd);
    }
}
