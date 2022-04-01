package stepDefs;

import io.cucumber.java.en.Then;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pages.OrderPage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelParameters_StepDefs {


    OrderPage orderPage = new OrderPage();

/*
    @Then("get discountPercentage, unitPrice, totalPrice to *DataInput* excel file")
    public void getDiscountPercentageUnitPriceTotalPriceToDataInputExcelFile() throws IOException {

        String discount = orderPage.getDiscount();
        String pricePerUnit = orderPage.getPricePerUnit();
        String totalPrice = orderPage.getTotal();

        FileInputStream fileIn = new FileInputStream("Book.xlsx");

        XSSFWorkbook exelBook = new XSSFWorkbook(fileIn);

        XSSFSheet excelSheet = exelBook.getSheet("One");

        int lastRowNum = excelSheet.getLastRowNum();

        XSSFCell excelCell1 = excelSheet.getRow(3).createCell(0);
        excelCell1.setCellValue("cc");
        XSSFCell excelCell2 = excelSheet.getRow(4).createCell(1);
        excelCell2.setCellValue(pricePerUnit);
        XSSFCell excelCell3 = excelSheet.getRow(5).createCell(1);
        excelCell3.setCellValue(totalPrice);

        FileOutputStream fileOut = new FileOutputStream("Book.xlsx");

        exelBook.write(fileOut);
        fileIn.close();
        fileOut.close();
        exelBook.close();
    }


 */

}
