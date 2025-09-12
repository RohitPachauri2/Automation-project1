package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    public Properties pro;
    public ConfigDataProvider() {
    	provider();
    }

    public void provider() {
        File src = new File("C:\\Users\\PC\\eclipse-workspace\\newproject\\Configurations\\Config.properties");
        try {
            FileInputStream input = new FileInputStream(src);
            pro = new Properties();
            pro.load(input);
        } catch (Exception e) {
            System.out.println("No file found "+e.getMessage());
        }
    }

    public String geturl() {
        return pro.getProperty("testurl");
    }

    public String getbrowser() {
        return pro.getProperty("browser");
    }
}
