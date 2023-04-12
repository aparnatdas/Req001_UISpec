package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.HomePage;
import pageObjects.SupportPage;
import utils.Context;

public class SupportSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupportSteps.class);

    Context context;
    HomePage homePage;
    SupportPage supportPage;

    public SupportSteps(Context context) {
        this.context = context;
        supportPage = context.getSupportPage();
        homePage = context.getHomePage();
    }

    @Given("User clicks on Support ReqRes Option")
    public void userClicksOnSupportReqResButton() {
        LOGGER.info("Clicking on Support ReqRes Button");
        supportPage.clicksSupportOption();
    }

    @When("User reaches Support Page and check for options")
    public void userReachesSupportPageAndCheckForOptions() {
        supportPage.getPageTitle();
        LOGGER.info("Support Page : " + supportPage.getPageTitle());
    }

    @Then("User should be navigated to Support Page")
    public void userShouldBeNavigatedToSupportPage() {
        LOGGER.info("SupportPage Title = " + supportPage.getPageTitle());
    }

    @Then("One Time and Monthly options should be available")
    public void isOneTimeAndMontlyOptionsAvailable() {
        LOGGER.info("Checking if OneTime and Monthly Support options are available");
        Assert.assertTrue("One Time Payment Option is not available !", supportPage.isOneTimePaymentOptionDisplayed());
        Assert.assertTrue("Montly Support Option is not available !", supportPage.isMonthlySupportOptionDisplayed());
        LOGGER.info("Both options are available");
    }

    @Then("User checks for Upgrade Options")
    public void upgradeOptionShouldBeAvailable() {
        LOGGER.info("Checking for Upgrade Option");
        Assert.assertTrue("Upgrade Options are not available !", supportPage.isUpgradeOptionDisplayed());
        LOGGER.info("Upgrade Option is available");
    }

    @When("User clicks on Upgrade")
    public void userClicksOnUpgrade() {
        LOGGER.info("Clicking on Upgrade");
        supportPage.clicksOnUpgrade();
    }

    @Then("Upgrade details should be provided")
    public void upgradeDetailsShouldBeProvided() {
        String upgradeProMessage = supportPage.getUpgradeProMessage();
        Assert.assertFalse(upgradeProMessage.isEmpty());
        LOGGER.info("Upgrade Pro Message : " + upgradeProMessage);

        Assert.assertTrue("Subscribe Button not available !", supportPage.isSubscribeButtonDisplayed());
        LOGGER.info("Upgrade Details has Subscribe Button");
    }
}
