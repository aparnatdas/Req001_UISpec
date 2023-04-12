package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.SupportPage;
import utils.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class HomeSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeSteps.class);

    Context context;
    HomePage homePage;
    SupportPage supportPage;

    public HomeSteps(Context context) {
        this.context = context;
        homePage = context.getHomePage();
        supportPage = context.getSupportPage();
    }

    @Given("User navigates to the Home Page")
    public void userNavigatesToHomePage() {
        context.openBaseURL();
        LOGGER.info("User is on Login Page");
    }

    @Given("User reaches the HomePage")
    public void userReachesTheHomePage() {
        String homePageTitle = homePage.getPageTitle();
        LOGGER.info("Page Title = " + homePageTitle);
        Assert.assertEquals("Unable to load Home Page", homePageTitle, "Reqres - A hosted REST-API ready to respond to your AJAX requests");
    }


    @When("User verifies different request types")
    public void userChecksDifferentRequestTypes() {
        LOGGER.info("Checking for different Request Types");
        Assert.assertTrue("Request Type not Found !!", homePage.isRequestTypeAvailable());
    }

    @And("User verifies different endpoints")
    public void userChecksDifferentEndpoints() {
        LOGGER.info("Checking for different Endpoints");
        List<WebElement> endpoints = homePage.getAllEndpoints();
        Assert.assertEquals("All endpoints not listed", 15, endpoints.size());
    }

    @Then("User checks the status code and closes the browser")
    public void userChecksTheStatusCodeAndClosesTheBrowser() {
        LOGGER.info("Checking for Status Code");
        Assert.assertTrue("Status Code not Found !!", homePage.isStatusCodeAvailable());
        context.tearDown();
    }

    @When("User selects {string}")
    public void userSelectsRequest(String requestName) {
        LOGGER.info("Selecting the request");
        homePage.clicksOnRequestNotFound(requestName);
    }

    @Then("The request should be {string}")
    public void validatingTheRequest(String requestExpected) {
        LOGGER.info("Validating the request");
        homePage.requestValidation(requestExpected);
    }

    @Then("The response should be {string}")
    public void validatingTheResponse(String responseExpected) {
        LOGGER.info("Validating the response");
        homePage.responseValidation(responseExpected);
    }

    //Its better to add this in After Hooks
    @And("User closes the browser")
    public void userClosesTheBrowser() {
        LOGGER.info("Closing the browser");
        context.tearDown();
    }

    @When("User clicks on Support Page Navigation Button")
    public void userClicksOnSupportPageNavigationButton() {
        LOGGER.info("Clicking on Support Page Navigation Button");
        homePage.clicksSupportPageNavigationButton();
    }
}
