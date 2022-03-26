package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    private Driver() {
        // no driver
    }

    public static WebDriver getDriver() {

        if (driver.get() == null){

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        return driver.get();

    }

    public static void closeDriver(){

        if (driver.get() != null ){

            driver.get().quit();
            driver.remove();
            driver.set(null);
        }
    }

}
