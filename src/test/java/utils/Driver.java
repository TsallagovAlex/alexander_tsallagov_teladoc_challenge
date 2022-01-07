
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is a Singleton class. It will make sure that there is a only one instance
 * of WebDriver at any given time
 */
public class Driver {
    private static String propertyPath = "src/test/resources/config/configuration.properties";
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.readProperty("browser", propertyPath)) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    System.out.println("Invalid browser type");
            }
        }
        return driver;
    }

    public static void quitDriver(){
        getDriver().quit();
        driver = null;
    }

}

