package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

public class OrderPage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(tagName = "h1")
    public WebElement orderPageHeader;

    @FindBy(xpath = "//button[text()='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//button[text()='Reset Fields']")
    public WebElement resetFieldButton;


    //Product Information
    @FindBy(name = "quantity")
    public WebElement quantityInput;

    @FindBy(xpath = "button[text()='Calculate']")
    public WebElement calculateButton;

    @FindBy(name = "product")
    public List<WebElement> productSelect;

    @FindBy(xpath = "//select[@name='product']")
    public WebElement product;

    public Select getProductAsSelect() {
        return new Select(product);
    }


    //Address Information
    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "street")
    public WebElement streetInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(name = "state")
    public WebElement stateInput;

    @FindBy(name = "zip")
    public WebElement zipInput;


    //Payment Information
    @FindBy(xpath = "//div[@class='control']/label/input")
    public List<WebElement> cardInputs;

    public WebElement getCardTypeByValue(List<WebElement> elements, String str) {
        WebElement result = null;

        for (WebElement element : elements) {
            if (element.getAttribute("value").equals(str)) {
                result = element;
            }
        }
        return result;
    }

    @FindBy(name = "cardNo")
    public WebElement cardNoInput;

    @FindBy(name = "cardExp")
    public WebElement cardExpInput;


    //String values
    @FindBy(xpath = "//input[@placeholder='Enter the price for an individual unit']")
    public WebElement pricePerUnitElement;

    public String getPricePerUnit() {
        return pricePerUnitElement.getAttribute("value");
    }

    @FindBy(xpath = "//input[contains (@placeholder,'Enter the discount rate e.g.')]")
    public WebElement discountElement;

    public String getDiscount() {
        return discountElement.getAttribute("value");
    }

    @FindBy(xpath = "//div[@class='control __uni']/button/../input[@type='number']")
    public WebElement totalElement;

    public String getTotal() {
        return totalElement.getAttribute("value");
    }


}
