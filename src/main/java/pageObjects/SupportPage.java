package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepDefinitions.HomeSteps;
import java.time.Duration;

public class SupportPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeSteps.class);

    WebDriver driver;
    WebDriverWait wait;

    public SupportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    @FindBy(xpath = "//a[contains(text(),'Support ReqRes')]")
    WebElement supportOption;

    @FindBy(xpath = "//label[contains(text(),'One-time payment')]")
    WebElement oneTimePayment;

    @FindBy(xpath = "//label[contains(text(),'Monthly support')]")
    WebElement monthlySupport;

    @FindBy(id = "trigger-pro")
    WebElement upgradePro;

    @FindBy(id = "pro-form")
    WebElement upgradeProForm;

    @FindBy(name = "subscribe")
    WebElement subscribeButton;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clicksSupportOption() {
        if (supportOption.isDisplayed())
            supportOption.click();
    }

    public boolean isOneTimePaymentOptionDisplayed() {
        return oneTimePayment.isDisplayed();
    }

    public boolean isMonthlySupportOptionDisplayed() {
        return monthlySupport.isDisplayed();
    }

    public boolean isUpgradeOptionDisplayed() {
        return upgradePro.isDisplayed();
    }

    public void clicksOnUpgrade() {
        upgradePro.click();
    }

    public String getUpgradeProMessage() {
        return upgradeProForm.getText();
    }

    public boolean isSubscribeButtonDisplayed() {
        return supportOption.isDisplayed();
    }

}
