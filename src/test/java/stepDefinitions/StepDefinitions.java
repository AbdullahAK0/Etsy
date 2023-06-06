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

    @Given("User click on the Sign in button enter the valid datas and login")
    public void click_on_the_sign_in_button() {
        page.login();
        ReusableMethods.bekle(3);

    }

    @Given("User choose the product")
    public void click_on_the_wedding_party_link() {
        page.chooseTheProduct();
    }

    @Given("User choose the options")
    public void user_choose_the_options() {
       page.options1();

       page.options2();
    }

    @Given("User completes the purchase")
    public void user_completes_the_purchase() {
        page.buy();
    }





}
