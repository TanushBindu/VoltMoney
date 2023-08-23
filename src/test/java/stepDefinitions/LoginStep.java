package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Login;

public class LoginStep extends Login
{
    @Given("I am on the saucedemo login page")
    public void iAmOnTheSaucedemoLoginPage()
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String string, String string2) {
        enterUserName(string).enterPasswordName(string2);
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        clickLoginButton();
    }
    @Then("I should be on the saucedemo products page")
    public void i_should_be_on_the_saucedemo_products_page() {
        productTextVerification();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String string) {
        wrongPWDErrorVerification(string);
    }
}
