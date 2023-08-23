package page;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinitions.BaseClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Login extends BaseClass
{

    public Login() {
        super();
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;


    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productText;


    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    private WebElement wrongPWDErrorMessage;

    public Login enterUserName(String userName)
    {
        usernameInput.sendKeys(userName);
        return this;
    }

    public Login enterPasswordName(String pwd)
    {
        passwordInput.sendKeys(pwd);
        return this;
    }

    public Login clickLoginButton()
    {
        loginButton.click();
        return this;
    }

    public Login productTextVerification()
    {
        assertThat("Product Title is not matching",productText.getText(),is(equalToIgnoringCase("products")));
        return this;
    }

    public Login wrongPWDErrorVerification(String error)
    {
        assertThat("Error message is not matching",wrongPWDErrorMessage.getText(),is(equalToIgnoringCase(error)));
        return this;
    }
}
