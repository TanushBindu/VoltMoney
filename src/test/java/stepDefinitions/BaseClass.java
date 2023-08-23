package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utils.DriverFactory.getDriver;

public class BaseClass
{
    protected static WebDriver driver;

    // Constructor to initialize driver
    public BaseClass()
    {
        setDriver();
        PageFactory.initElements(driver, this);
    }

    // Set driver
    public static void setDriver() {
        driver = getDriver();
    }

}
