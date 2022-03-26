package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ViewAllOrdersPage {

    public ViewAllOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (tagName = "h1" )
    public WebElement viewAllOrdersPageHeader;
    public String getViewAllOrdersPageHeader(){
        return viewAllOrdersPageHeader.getText();
    }


    @FindBy (xpath = "//tbody/tr[1]/td[1]")
    public WebElement lastOrderName;
    public String getLastOrderName(){
        return lastOrderName.getText();
    }

}
