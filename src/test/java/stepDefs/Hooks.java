package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfReader;
import utils.Driver;

public class Hooks {

    //elements
    LoginPage loginPage =  new LoginPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @Before
    public void setUpScenario(){

    Driver.getDriver().get(ConfReader.getKey("env"));

    //login
    loginPage.usernameInput.sendKeys(ConfReader.getKey("username"));
    loginPage.passwordInput.sendKeys(ConfReader.getKey("password"));
    loginPage.loginButton.click();

    //assertion
    String expectedText = "Web Table App";

    wait.until(ExpectedConditions.textToBePresentInElement(homePage.appNameHeader,expectedText));

    String actualText = homePage.appNameHeader.getText();
    Assert.assertEquals("login fail!",expectedText,actualText);

    }

    @After
    public void tearDownScenario(Scenario scenario){



            TakesScreenshot screen = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = screen.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpg", scenario.getName());


        homePage.logoutButton.click();
        Driver.closeDriver();

    }







}
