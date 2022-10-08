package com.gerniks.app.browsers_setup;

import com.gerniks.app.utility.GenericFunctions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;


public class RunDriver extends DriverSetup {

    public Logger logger = Logger.getLogger("RunDriver");

    @BeforeClass
    public void startDriver() {
        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");
        System.out.println("This is a status code "+GenericFunctions.getStatusCode(url));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterMethod
    public void tearDown(ITestResult result)  //this method will take a
    // screenshot of page where test has failed
    {

        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
        // Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

        // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

        // Copy method  specific location here it will save all screenshot in our project home directory and
        // result.getName() will return name of test case so that screenshot name will be same
                try{
                    FileHandler.copy(source, new File("./screenshots/"+result.getName()+".png"));
                    System.out.println("Screenshot taken");
                }catch (Exception e){
                    System.out.println("File isn't handled");
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        // close application
        driver.close();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
