package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
        // It is anticipated that the 'getDriver()' and 'closeDriver()' methods in the Driver class in the POM
        // will be used in a static manner.
        // Using object creation is prevented for these methods
        // or to prevent the use of the POM in different applications by creating objects,
        // the Singleton Pattern has been preferred.
    }
    /*
        Create 'getDriver()' that returns a WebDriver object to where it is called

        Let's create 'getDriver()'

        If 'getDriver()' executes the line driver = new ChromeDriver(); each time it is called,
        a new WebDriver object is created with each use.

        We want it to create a new WebDriver when used for the first time (i.e., when it is null),
        and in subsequent uses, it should use the assigned value.
    */

    static WebDriver driver;

    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (driver == null) {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.close();
        if (driver != null){
            driver = null;
        }
    }

    public static void quitDriver(){
        driver.quit();
        if (driver != null){
            driver = null;
        }
    }
}
