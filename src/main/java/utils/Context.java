package utils;

import org.openqa.selenium.WebDriver;
import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.SupportPage;

public class Context extends BaseClass {

    private HomePage homePage;
    private SupportPage supportPage;

    public Context() {
        setup();
    }

    public WebDriver getDriver() {
        return driver;
    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public SupportPage getSupportPage() {
        if (supportPage == null) {
            supportPage = new SupportPage(driver);
        }
        return supportPage;
    }
}