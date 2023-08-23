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

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartClick;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement itemName;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartCount;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickOnCart;

    public CartPage clickONProduct(String prod) {
        for (WebElement ele : productNameClick) {
            if (ele.getText().equalsIgnoreCase(prod)) {
                ele.click();
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

    public CartPage clickONCart() {
        clickOnCart.click();
        return this;
    }

    public void itemNameVericationInCart(String prod) {
        assertThat("Item is not matching",itemName.getText(), equalToIgnoringCase(prod));
    }
}
