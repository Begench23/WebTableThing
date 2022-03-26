package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.OrderPage;
import pages.ViewAllOrdersPage;

public class ParameterizeWebTableOrder_StepDefs {

    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
    String expectedCostumerName;

    @When("user selects product type {int}")
    public void userSelectsProductType(Integer int1) {
        orderPage.getProductAsSelect().selectByIndex(int1);

    }

    @When("user enters quantity {int}")
    public void userEntersQuantity(Integer int1) {
        orderPage.quantityInput.sendKeys(int1.toString());
    }

    @When("user enters customer name {string}")
    public void userEntersCustomerName(String string) {
        expectedCostumerName = string;
        orderPage.nameInput.sendKeys(string);

    }

    @When("user enters street {string}")
    public void userEntersStreet(String string) {
        orderPage.streetInput.sendKeys(string);

    }

    @When("user enters city {string}")
    public void userEntersCity(String string) {

        orderPage.cityInput.sendKeys(string);
    }

    @When("user enters state {string}")
    public void userEntersState(String string) {

        orderPage.stateInput.sendKeys(string);

    }

    @When("user enter zip {int}")
    public void userEnterZip(Integer int1) {
        orderPage.zipInput.sendKeys(int1.toString());
    }

    @When("user selects card type {string}")
    public void userSelectsCardType(String string) {

        orderPage.getCardTypeByValue(orderPage.cardInputs, string).click();
    }

    @When("user enters card number {string}")
    public void userEntersCardNumber(String str) {
        orderPage.cardNoInput.sendKeys(str);
    }

    @When("user enters card expiry date {string}")
    public void userEntersCardExpiryDate(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }

    @Then("user should see customer name in the table on *view all orders* page")
    public void userShouldSeeCustomerNameInTheTableOnViewAllOrdersPage() {

        String actualCostumerName = viewAllOrdersPage.getLastOrderName();
        Assert.assertEquals(expectedCostumerName, actualCostumerName);


    }

}
