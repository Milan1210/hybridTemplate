package com.gerniks.app;

import java.util.Scanner;

public class RequiredData {

    //Driver config
     String os = "win";
     String browserDriver = "firefox";
     boolean runLocal = true;
     boolean localDriver = false;
     boolean grid = true;
     String extension = "driver";

    public String propertyFileName = "file";
    public static String url = "https://youtube.com";
    public String sourcePath = System.getProperty("user.dir");
    public String fullWebDriverPath;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bw = sc.nextLine();
    }
    public RequiredData(){
        if (os.equals("win")){
            extension+=".exe";
        }
        if (browserDriver.equals("firefox")){
            browserDriver="gecko";
        }

        fullWebDriverPath=sourcePath+"\\browsers\\"+os+"\\"+browserDriver+extension;
    }

}
