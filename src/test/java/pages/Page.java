package pages;

import com.fasterxml.jackson.databind.JsonSerializable;
import io.cucumber.java.eo.Se;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.Set;

public class Page extends Base {
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js;


    @FindBy(xpath = "//*[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
    private WebElement signInButton;

    @FindBy(id = "join_neu_email_field")
    private WebElement emailTextbox;

    @FindBy (id = "join_neu_password_field")
    private WebElement passwordTextbox;

    @FindBy (xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    private WebElement signInLink;

    @FindBy (xpath = "//span[@id='catnav-primary-link-10983']")
    private WebElement weddingSection;

    @FindBy (xpath = "//*[@target='etsy.851979574']")
    private WebElement choosing;

    @FindBy (id = "variation-selector-0")
    private WebElement options;

    @FindBy (xpath = "(//button[@type='submit'])[2]")
    private WebElement buyButton;

    @FindBy (xpath = "(//button[@class='select_btn wt-btn wt-btn--filled wt-width-full'])[1]")
    private WebElement chooseAddress;

    @FindBy (id = "cc-radio--paymentstep")
    private WebElement cardRadioButton;

    @FindBy (id = "cc-name--paymentstep")
    private WebElement makeSure;

    @FindBy (xpath = "//*[@id='global-enhancements-search-query']")
    private WebElement searchbox;

    @FindBy (xpath = "//*[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    private WebElement searchboxButton;

    @FindBy (xpath = "//*[@id='variation-selector-1']")
    private WebElement option2;

    @FindBy (xpath = "//*[@class='wt-tooltip__trigger wt-tooltip__trigger--icon-only wt-btn wt-btn--transparent wt-btn--icon reduced-margin-xs']")
    private WebElement favorite;

    @FindBy (xpath = "(//div[@class='wt-grid__item-xs-12 wt-p-xs-0 wt-mb-xs-2'])[1]")
    private WebElement shipHere;

    public void signInMethod (){

        signInButton.click();
    }

    public void login(){
        emailTextbox.sendKeys(ConfigReader.getProperty("username"));
        passwordTextbox.sendKeys(ConfigReader.getProperty("password"));
        signInLink.click();
    }

    public void chooseTheProduct(){

        favorite.click();
        choosing.click();
        ReusableMethods.switchtoWindows();

    }

    public void options(){
        Select select = new Select(options);
        select.selectByIndex(3);
        select = new Select(option2);
        select.selectByIndex(4);
        buyButton.click();
    }

    public void buy(){
        shipHere.click();
        cardRadioButton.click();
        actions.sendKeys(Keys.TAB);

    }

}
