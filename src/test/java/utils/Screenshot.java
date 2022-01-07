package utils;

import pages.CommonPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import step_def.Hooks;

public class Screenshot {
    public static void takeScreenshot(){
        Selenium.waitForPageToLoad();
        try{
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Hooks.currentScenario.attach(screenshot, "image/png", "Screenshot | " + CommonPage.CURRENT_DATETIME);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }
}
