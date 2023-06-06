package pages;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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

    @FindBy (xpath = "//div[@class='wt-height-full']")
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

    public void signInMethod (){

        signInButton.click();
    }

    public void login(){
        emailTextbox.sendKeys(ConfigReader.getProperty("username"));
        passwordTextbox.sendKeys(ConfigReader.getProperty("password"));
        signInLink.click();
    }

    public void chooseTheProduct(){
        /*js.executeScript("arguments[0].scrollIntoView(true)", weddingSection);
        ReusableMethods.bekle(1);

         */
        weddingSection.click();




    }

}
