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
    public void iClickOnTheButtonForTheItem(String arg0, String arg1) throws InterruptedException {
        clickONProduct(arg1).clickOnAddCart();
    }

    @Then("I should see a success message indicating that the item was added to the cart")
    public void iShouldSeeASuccessMessageIndicatingThatTheItemWasAddedToTheCart() {
        
    }


    @And("I have already added the item {string} to the cart")
    public void iHaveAlreadyAddedTheItemToTheCart(String arg0) throws InterruptedException {
        clickONProduct(arg0);
    }


    @And("I have added the item {string} to the cart")
    public void iHaveAddedTheItemToTheCart(String arg0) {
        
    }

    @And("I go back to the products page")
    public void iGoBackToTheProductsPage()
    {
        clickProductBackButton();
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
    public void navigateToCartAndVerfyItemIsPresent(String arg0){
        clickONCart().VerifyProductIsDisplayed(arg0);
    }

    @And("the cart icon should display the updated number of items should be {string}")
    public void theCartIconShouldDisplayTheUpdatedNumberOfItemsShouldBe(String arg0)
    {
        cartCountVerification(arg0);

    }

    @When("Verify that Remove button is displayed")
    public void verifyThatRemoveButtonIsDisplayed() {

    }

    @And("Navigate to Cart and Verfy {string} item is not present")
    public void navigateToCartAndVerfyItemIsNotPresent(String arg0){
        clickONCart().VerifyProductIsDisplayed(arg0);
    }

    @Then("Verify that Remove button is displayed and Click on Remove Button")
    public void verifyThatRemoveButtonIsDisplayedAndClickOnRemoveButton()
    {
        verifyRemoveButtonIsDisplayed().clickRemoveButton();
    }

    @And("Try to add the same product {string} to the cart")
    public void tryToAddTheSameProductToTheCart(String arg0) throws InterruptedException {
        clickONProduct(arg0).clickOnAddCart();
    }

    @And("Click on Checkout button")
    public void clickOnCheckoutButton() {
        clickCheckoutButton();
    }

    @And("Enter the First Name as {string} Last Name as {string} and postal code as {string}")
    public void enterTheFirstNameAsLastNameAsAndPostalCodeAs(String arg0, String arg1, String arg2) {
        enterFirstName(arg0).enterLastName(arg1).enterPinCode(arg2);
    }

    @And("Click on Contiune button and Finish Button")
    public void clickOnContiuneButtonAndFinishButton() {
        clickOnContiuneButton().clickONFinishButton();
    }

    @Then("Verify user should see {string} text")
    public void verifyUserShouldSeeText(String arg0) {
        checkoutSuccessfulVerification(arg0);
    }

    @And("Click on Back Home button")
    public void clickOnBackHomeButton()
    {
        clickONBackHomeButton();
    }


    @And("Enter the user {string} {string} {string}")
    public void enterTheUser(String arg0, String arg1, String arg2)
    {
        enterFirstName(arg0).enterLastName(arg1).enterPinCode(arg2);
    }
}
