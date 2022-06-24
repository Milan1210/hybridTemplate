package com.gerniks.app.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("********Test Started: " +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("********Test is successful: " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("********Test is failed: " +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("********Test skipped: " +result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("********Test Completed: " +context.getName());
    }
}
