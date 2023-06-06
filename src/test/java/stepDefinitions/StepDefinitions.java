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

    }

    @Given("User enter the valid datas and login")
    public void user_enter_the_valid_datas_and_login() {
        page.login();
        ReusableMethods.bekle(5);

    }

    @Given("User choose the product")
    public void click_on_the_wedding_party_link() {
        page.chooseTheProduct();
    }

    @Given("User choose the options")
    public void user_choose_the_options() {
       page.options();
    }

    @Given("User completes the purchase")
    public void user_completes_the_purchase() {
        page.buy();
    }





}
