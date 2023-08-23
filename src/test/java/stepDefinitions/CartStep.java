package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CartPage;
import page.Login;

public class CartStep extends CartPage {

    Login login;
    @And("I am on the products page")
    public void iAmOnTheProductsPage() {
        login.productTextVerification();
    }

    @When("I click on the {string} button for the item {string}")
    public void iClickOnTheButtonForTheItem(String arg0, String arg1) {
        clickONProduct(arg1).clickOnAddCart();
    }

    @Then("I should see a success message indicating that the item was added to the cart")
    public void iShouldSeeASuccessMessageIndicatingThatTheItemWasAddedToTheCart() {
        
    }


    @And("I have already added the item {string} to the cart")
    public void iHaveAlreadyAddedTheItemToTheCart(String arg0) {
        
    }

    @When("I try to click on the {string} button for the same item")
    public void iTryToClickOnTheButtonForTheSameItem(String arg0) {
        
    }

    @When("I remove the item from the cart")
    public void iRemoveTheItemFromTheCart() {
        
    }

    @And("I have added the item {string} to the cart")
    public void iHaveAddedTheItemToTheCart(String arg0) {
        
    }

    @And("I go back to the products page")
    public void iGoBackToTheProductsPage() {
    }

    @Given("I am logged in username {string} and password {string} on the saucedemo website")
    public void iAmLoggedInUsernameAndPasswordOnTheSaucedemoWebsite(String arg0, String arg1)
    {
        login = new Login();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login.enterUserName(arg0).enterPasswordName(arg1).clickLoginButton();
    }

    @Then("Navigate to Cart and Verfy {string} item is present")
    public void navigateToCartAndVerfyItemIsPresent(String arg0)
    {
        clickONCart().clickONProduct(arg0);
    }

    @And("the cart icon should display the updated number of items should be {string}")
    public void theCartIconShouldDisplayTheUpdatedNumberOfItemsShouldBe(String arg0)
    {
        cartCountVerification(arg0);

    }
}
