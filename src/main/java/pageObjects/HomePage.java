package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "[data-key='url']")
    WebElement requestType;

    @FindBy(css = "[data-key='response-code']")
    WebElement statusCode;

    @FindBy(css = "li[data-id='users-single-not-found']")
    WebElement requestNotFoundRequest;

    @FindBy(css = "span[class='url']")
    WebElement actualRequest;

    @FindBy(css = "span[class^='response-code']")
    WebElement actualResponse;

//    @FindBy(xpath = "//span[contains(text(),'404')]")
    @FindBy(css = "[data-key='response-code']")
    WebElement statusCodeNotFound;

    @FindBy(xpath = "//button[contains(text(),'Support ReqRes')]")
    WebElement supportPageNavigationButton;

    @FindBys(@FindBy(css = "[data-key='endpoint']"))
    private List<WebElement> allEndpoints;

    public List<WebElement> getAllEndpoints() {
        LOGGER.info("Endpoints " + allEndpoints.toString());
        return allEndpoints;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isRequestTypeAvailable() {
        return requestType.isDisplayed();
    }

    public boolean isStatusCodeAvailable() {
        return statusCode.isDisplayed();
    }

    public void clicksOnRequestNotFound(String requestName) {
        LOGGER.debug("Request Name Expected " + requestName);
        LOGGER.debug("Request Name Actual Found " + requestNotFoundRequest.getText());
        if (requestName.contains("SINGLE USER NOT FOUND"))
            requestNotFoundRequest.click();
        else
            Assert.assertNotSame(requestName, requestNotFoundRequest.getText());
    }

    public void requestValidation(String expectedRequest) {
        LOGGER.debug("Expected Request : " + expectedRequest);
        LOGGER.debug("Actual Request : " + actualRequest.getText());
        Assert.assertEquals("Requests doesn't match ", expectedRequest, actualRequest.getText());
    }

    public void responseValidation(String expectedResponse) {
        LOGGER.debug("Expected Response : " + expectedResponse);
        LOGGER.debug("Actual Response : " + statusCodeNotFound.getText());
        System.out.println("Status code received "+statusCodeNotFound.getText());
        Assert.assertTrue("Response not Present ", statusCodeNotFound.isDisplayed());
    }

    public void clicksSupportPageNavigationButton() {
        Assert.assertTrue("Support Page Navigation Button Not Present !", supportPageNavigationButton.isDisplayed());
        LOGGER.debug("Clicking on SupportPage Navigation Button");
        supportPageNavigationButton.click();
    }
}
