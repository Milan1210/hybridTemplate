package com.gerniks.app;

import java.util.Scanner;

public class RequiredData {

    //Driver config
     public String os = "win";
     public String browserDriver = "chrome";
     public boolean runLocal = false;
     public boolean headless = true;
     public boolean localDriver = false;  //FALSE value means that it will run driver through WebDriverManager

    public boolean grid = false;
    public String gridPlatform = "Linux";
    public String gridURL = "http://localhost:4444";

    public String extension = "driver";

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
