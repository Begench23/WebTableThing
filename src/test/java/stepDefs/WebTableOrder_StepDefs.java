package stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.Driver;

import java.util.List;

public class WebTableOrder_StepDefs {

    HomePage homePage= new HomePage();
    OrderPage orderPage= new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage= new ViewAllOrdersPage();
    Faker faker = new Faker();
    String orderName= "Michael Roy";

    @Given("user in order page")
    public void userInOrderPage() {

        homePage.orderButton.click();
        String expectedText = "Make an Order";
        String actualText = orderPage.orderPageHeader.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @When("user selects product type")
    public void userSelectsProductType() {

        orderPage.getProductAsSelect().selectByVisibleText("Familybea");
    }

    @And("user enters quantity")
    public void userEntersQuantity() {

        orderPage.quantityInput.sendKeys(faker.numerify("#"));
    }

    @And("user enters customer name")
    public void userEntersCustomerName() {


        orderPage.nameInput.sendKeys(orderName);

    }

    @And("user enters street")
    public void userEntersStreet() {

        orderPage.streetInput.sendKeys(faker.address().streetAddress());
    }

    @And("user enters city")
    public void userEntersCity() {

        orderPage.cityInput.sendKeys(faker.address().cityName());
    }

    @And("user enters state")
    public void userEntersState() {

        orderPage.stateInput.sendKeys(faker.address().state());
    }

    @And("user enter zip")
    public void userEnterZip() {

        orderPage.zipInput.sendKeys(faker.address().zipCode());

    }

    @And("user selects card type")
    public void userSelectsCardType() {

        orderPage.cardInputs.get(1).click();
    }

    @And("user enters card number")
    public void userEntersCardNumber() {

        orderPage.cardNoInput.sendKeys(faker.numerify("############"));
    }

    @And("user enters expiry date")
    public void userEntersExpiryDate() {
        orderPage.cardExpInput.sendKeys(faker.numerify("##/##"));
    }

    @And("user clicks process order button")
    public void userClicksProcessOrderButton() {

        orderPage.processOrderButton.click();
        String actualHeaderText = Driver.getDriver().findElement(By.tagName("h1")).getText();
        String expectedHeaderText = viewAllOrdersPage.getViewAllOrdersPageHeader();
        Assert.assertEquals(expectedHeaderText,actualHeaderText);

    }

    @Then("user should see new order in the table on *view all orders* page")
    public void userShouldSeeNewOrderInTheTableOnViewAllOrdersPage() {

        String actualLastOrderName = viewAllOrdersPage.getLastOrderName();
        String expectedLastOrderName= orderName;

        Assert.assertEquals(expectedLastOrderName, actualLastOrderName);

    }


}
