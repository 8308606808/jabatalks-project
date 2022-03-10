package com.jabatalks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class LoginPage extends BasePage {
    WebDriver driver;
    @FindBy(id = "name")
    private WebElement txtFullName;

    @FindBy(id = "orgName")
    private WebElement txtOrgName;

    @FindBy(id = "singUpEmail")
    private WebElement txtEmail;

    @FindBy(id = "login-button")
    private WebElement termsCondition;

    @FindBy(xpath = "//div[@class='form-group custom-form-group']")
    private WebElement getStartedBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-custom']//span")
    private WebElement emailTxt;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterFullName(String userName) {
        enterTxt(txtFullName, userName);

    }

    public void enterOrgName(String orgName) {
        enterTxt(txtOrgName, orgName);
    }

    public void enterEmail(String email) {
        enterTxt(txtEmail, email);
    }

    public void clickTermsCondition() {
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@class='ui-checkbox']//span")));
        element.click();
    }

    public void clickGetStartedBtn() {
        getStartedBtn.click();
    }

    public String actualWelcomeText() {
        String welcomeTxt = getTxt(emailTxt);
        return welcomeTxt;
    }

    public List<String> getLanguagesList() {
        driver.findElement(By.xpath("//section/descendant::span[@ng-hide='$select.isEmpty()']/span[text()='English']")).click();
        List<WebElement> ddlEle = driver.findElements(By.xpath("//li/descendant::div[@ng-bind-html='language']"));
        List<String> ddlList = new ArrayList<>();
        for (WebElement e : ddlEle) {
            ddlList.add(e.getText());
        }
        return ddlList;
    }
}

