package stepDefs;

import io.cucumber.java.Before;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;
import utils.ConfReader;
import utils.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StepCheck {



    @Test
    public void check() throws IOException {

        //elements
        LoginPage loginPage =  new LoginPage();
        HomePage homePage = new HomePage();
        OrderPage orderPage = new OrderPage();


            Driver.getDriver().get(ConfReader.getKey("env"));

            //login
            loginPage.usernameInput.sendKeys(ConfReader.getKey("username"));
            loginPage.passwordInput.sendKeys(ConfReader.getKey("password"));
            loginPage.loginButton.click();

            //assertion
            String expectedText = "Web Table App";
            String actualText = homePage.appNameHeader.getText();
            Assert.assertEquals("login fail!",expectedText,actualText);

            homePage.orderButton.click();

            String discount = orderPage.getDiscount();
             System.out.println(discount);

        FileInputStream fileIn = new FileInputStream("Book.xlsx");

        XSSFWorkbook exelBook = new XSSFWorkbook(fileIn);

        XSSFSheet excelSheet = exelBook.getSheet("One");

//        int lastRowNum = excelSheet.getLastRowNum();
//        System.out.println(lastRowNum);

        XSSFCell excelCell1 = excelSheet.getRow(1).createCell(0);
        excelCell1.setCellValue("cc");
        XSSFCell excelCell2 = excelSheet.getRow(0).createCell(1);
        excelCell2.setCellValue("BBB");
        XSSFCell excelCell3 = excelSheet.getRow(0).createCell(1);
        excelCell3.setCellValue("ccc");


        FileOutputStream fileOut = new FileOutputStream("Book.xlsx");


        exelBook.write(fileOut);
        fileIn.close();
        fileOut.close();
        exelBook.close();


    }

}
