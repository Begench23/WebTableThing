package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfReader;
import utils.Driver;

public class Hooks {

    //elements
    LoginPage loginPage =  new LoginPage();
    HomePage homePage = new HomePage();

    @Before
    public void setUpScenario(){

    Driver.getDriver().get(ConfReader.getKey("env"));

    //login
    loginPage.usernameInput.sendKeys(ConfReader.getKey("username"));
    loginPage.passwordInput.sendKeys(ConfReader.getKey("password"));
    loginPage.loginButton.click();

    //assertion
    String expectedText = "Web Table App";
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
