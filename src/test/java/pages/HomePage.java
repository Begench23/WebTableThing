package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (tagName = "h2")
    public WebElement appNameHeader;

    @FindBy (xpath = "//button[text()='Logout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//button[text()='Order']")
    public WebElement orderButton;

    @FindBy(xpath = "//button[text()='View all orders']")
    public WebElement viewAllOrdersButton;


    
    

}
