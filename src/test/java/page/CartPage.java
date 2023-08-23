package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinitions.BaseClass;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class CartPage extends BaseClass {

    public CartPage() {
        super();
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productNameClick;

    @FindBy(xpath = "//button[.='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[.='Checkout']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//button[.='Finish']")
    private WebElement checkOutFinishButton;

    @FindBy(xpath = "//h2[.='Thank you for your order!']")
    private WebElement thanksText;

    @FindBy(xpath = "//button[.='Back Home']")
    private WebElement backHomeButton;

    @FindBy(xpath = "//input[@name='continue']")
    private WebElement contiuneButtonCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameText;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameText;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement pinCodeText;

    @FindBy(xpath = "//button[.='Back to products']")
    private WebElement backButtonProductPage;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartClick;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement itemName;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartCount;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickOnCart;

    public CartPage clickONProduct(String prod) throws InterruptedException {
        for (WebElement ele : productNameClick) {
            if (ele.getText().equalsIgnoreCase(prod)) {
                ele.click();
                break;
            }
            Thread.sleep(3000);
        }
        return this;
    }

    public CartPage VerifyProductIsDisplayed(String prod) {
        for (WebElement ele : productNameClick) {
            if (ele.getText().equalsIgnoreCase(prod)) {
                ele.isDisplayed();
                break;
            }
        }
        return this;
    }

    public void clickOnAddCart() {
        addToCartClick.click();
    }

    public void cartCountVerification(String count) {
        System.out.println(cartCount.getText());
        assertThat("Count is not matching", Integer.parseInt(cartCount.getText()), is(Integer.parseInt(count)));
    }


    public CartPage clickONCart(){
        clickOnCart.click();
        return this;
    }

    public CartPage verifyRemoveButtonIsDisplayed()
    {
        assertThat("Remove button is not present",removeButton.isDisplayed(),is(true));
        return this;
    }

    public CartPage clickRemoveButton()
    {
        removeButton.click();
        return this;
    }


    public CartPage clickProductBackButton()
    {
        backButtonProductPage.click();
        return this;
    }

    public CartPage clickCheckoutButton()
    {
        checkOutButton.click();
        return this;
    }

    public CartPage enterFirstName(String name)
    {
        firstNameText.sendKeys(name);
        return this;
    }

    public CartPage enterLastName(String name)
    {
        lastNameText.sendKeys(name);
        return this;
    }

    public CartPage enterPinCode(String name)
    {
        pinCodeText.sendKeys(name);
        return this;
    }

    public CartPage clickOnContiuneButton()
    {
        contiuneButtonCheckout.click();
        return this;
    }

    public CartPage clickONFinishButton()
    {
        checkOutFinishButton.click();
        return this;
    }

    public CartPage clickONBackHomeButton()
    {
        backHomeButton.click();
        return this;
    }

    public void itemNameVericationInCart(String prod) {
        assertThat("Item is not matching",itemName.getText(), equalToIgnoringCase(prod));
    }

    public void checkoutSuccessfulVerification(String text) {
        assertThat("Text is not matching",thanksText.getText(), equalToIgnoringCase(text));
    }
}
