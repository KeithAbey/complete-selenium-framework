package com.pastbook;

import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver getDriver() throws IOException {
        //Loading Properties in the File
        properties = new Properties();
        String userdir = System.getProperty("user.dir");
        String propFilePath = "/src/test/java/com/pastbook/global.properties";
        FileInputStream fileInputStream = new FileInputStream(userdir+propFilePath);
        properties.load(fileInputStream);

        String chrome = properties.getProperty("chromepath");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chrome);

        //Setting Up Chrome Driver
        String chromePath = properties.getProperty("chromedriver");
        //String chromePath = properties.getProperty("/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver",userdir+chromePath);
        driver = new ChromeDriver(options);



        driver.get(properties.getProperty("url"));
        return driver;
    }
    public static String getImagePath(String file){
        return System.getProperty("user.dir")+"\\images\\"+file;
    }

    public void quitDriver(){
        driver.quit();
    }
    
    public void initPercy(WebDriver driver, String pageName,Integer[] resolution){
        Percy percy = new Percy(driver);
        if (resolution != null){
            List<Integer> arr = Arrays.asList(resolution);
            percy.snapshot(pageName, arr);
        }else{
            percy.snapshot(pageName);
        }

    }
}
