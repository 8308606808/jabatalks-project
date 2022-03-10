package com.deeps.testscript;

import com.deeps.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterFullName("Deepika");
        loginPage.enterOrgName("EncureIT");
        loginPage.enterEmail("deepstesting12@gmail.com");
        loginPage.clickTermsCondition();
        loginPage.clickGetStartedBtn();

        List<String> expectedLanguages = new ArrayList();
        expectedLanguages.add("English");
        expectedLanguages.add("Dutch");

        String expectedWelcomeText = "A welcome email has been sent. Please check your email.";

        Assert.assertEquals(loginPage.actualWelcomeText(), expectedWelcomeText);
        Assert.assertEquals(loginPage.getLanguagesList(), expectedLanguages);

    }
}
