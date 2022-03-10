package com.jabatalks.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    private final String CONFIG_PATH = "//src//test//resources//config.properties";
    public Properties props = null;

    public static Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void init() {
        WebDriverManager.chromedriver().setup();
        props = loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        log.info("Browser opened");
        driver.get(props.getProperty("url"));
        log.info("Application is opened");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        log.info("Browser closed");
    }

    public Properties loadProperties() {
        String path = System.getProperty("user.dir");
        log.info("Config File Path: " + path + CONFIG_PATH);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path + CONFIG_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
