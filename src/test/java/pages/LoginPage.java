package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (name = "username")
    public WebElement usernameInput;

    @FindBy (name = "password")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[text()='Login']")
    public WebElement loginButton;




}
