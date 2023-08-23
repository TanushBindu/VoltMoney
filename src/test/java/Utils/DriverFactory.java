package Utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static stepDefinitions.BaseClass.setDriver;

public class DriverFactory
{
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = "chrome";
            driver = createDriver(browser);
        }
        return driver;
    }

    private static WebDriver createDriver(String browser) {
        ChromeDriverManager.chromedriver().setup();
//        switch (browser) {
//            case "chrome":
//                ChromeDriverManager.chromedriver().setup();
//                setDriver(new ChromeDriver());
//            case "firefox":
//                FirefoxDriverManager.firefoxdriver().setup();
//                setDriver(new FirefoxDriver());
//            case "edge":
//                EdgeDriverManager.edgedriver().setup();
//                setDriver(new EdgeDriver());
//            case "ie":
//                InternetExplorerDriverManager.chromedriver().setup();
//                setDriver(new InternetExplorerDriver());
//            default:
//                throw new IllegalArgumentException("Invalid browser name");
//        }
        return new ChromeDriver();
    }
}
