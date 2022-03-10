package com.deeps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTxt(WebElement element, String value) {
        element.sendKeys(value);
    }

    public String getTxt(WebElement element) {
        return element.getText();
    }


}

