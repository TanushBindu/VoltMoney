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
        switch (browser) {
            case "chrome":
                ChromeDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                FirefoxDriverManager.firefoxdriver().setup();
                new FirefoxDriver();
            case "edge":
                EdgeDriverManager.edgedriver().setup();
                new EdgeDriver();
            case "ie":
                InternetExplorerDriverManager.chromedriver().setup();
               new InternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Invalid browser name");
        }
    }
}
