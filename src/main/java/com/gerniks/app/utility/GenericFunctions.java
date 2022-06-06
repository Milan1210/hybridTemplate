package com.gerniks.app.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GenericFunctions {

    public String fileRead(String fileName, String variable){
        try (InputStream input = new FileInputStream("testData/"+fileName+".properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("This is parameter "+prop.getProperty(variable));

            return prop.getProperty(variable);
        } catch (IOException ex) {
            ex.printStackTrace();
            return "There isn't variable";
        }

    }
}
