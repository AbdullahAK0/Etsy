package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class StepDefinitions {
    Page page = new Page();


    @Given("User goes to {string}")
    public void user_goes_to(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
    }

    @Given("Click on the Sign in button")
    public void click_on_the_sign_in_button() {
        page.signInMethod();
        ReusableMethods.switchtoWindows();

    }

    @Given("User enter the valid datas and login")
    public void user_enter_the_valid_datas_and_login() {
        page.login();
        ReusableMethods.switchtoWindows();
    }

    @Given("Click on the Wedding & Party link")
    public void click_on_the_wedding_party_link() {
        page.chooseTheProduct();
    }



}
