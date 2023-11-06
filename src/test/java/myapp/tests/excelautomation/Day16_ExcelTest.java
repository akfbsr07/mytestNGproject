package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day16_ExcelTest {

    // WITH NO EXCEL
    @Test
    public void userCreationTest(){

        //When user go to https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");
        WaitUtils.waitFor(2);
        //Click on the new button
        dataTablesPage = new DataTablesPage();
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(2);
        //When user enters all fields
        dataTablesPage.firstName.sendKeys("john");
        WaitUtils.waitFor(2);
        dataTablesPage.lastName.sendKeys("lennon");
        WaitUtils.waitFor(2);
        dataTablesPage.position.sendKeys("musician");
        WaitUtils.waitFor(2);
        dataTablesPage.office.sendKeys("LA");
        WaitUtils.waitFor(2);
        dataTablesPage.extension.sendKeys("52345");
        WaitUtils.waitFor(2);
        dataTablesPage.startDate.sendKeys("2023-12-27");
        WaitUtils.waitFor(2);
        dataTablesPage.salary.sendKeys("1000000");
        WaitUtils.waitFor(2);
        //When clicks create button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(2);
        //And search for the first name
        dataTablesPage.searchBox.sendKeys("john");
        WaitUtils.waitFor(2);
        //Then verify the name fields contains first name
        Assert.assertTrue(dataTablesPage.nameField.getText().contains("john"));
        WaitUtils.waitFor(2);

        Driver.closeDriver();
    }


    // WITH EXCEL
    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils; //to access ExcelUtils objects and methods
    List<Map<String, String>> dataList; //this container will hold the excel data

    @Test
    public void userCreationWithExcel(){
        //path of the excel
        String pathOfDataSheet = "C:\\Users\\Akif\\IdeaProjects\\mytestNGproject\\resources\\data_sheet.xlsx";
        //instantiating excel util object to have access to the excel utils methods
        excelUtils = new ExcelUtils(pathOfDataSheet, "user_data");
        //get data from excel using reusable method
        dataList = excelUtils.getDataList();
        //System.out.println(dataList);

        // LOOP BEGINS
        for (Map<String,String> eachData: dataList) {

            System.out.println(eachData);

            //When user go to https://editor.datatables.net/
            Driver.getDriver().get("https://editor.datatables.net/");
            WaitUtils.waitFor(2);
            //Click on the new button
            dataTablesPage = new DataTablesPage();
            dataTablesPage.newButton.click();
            WaitUtils.waitFor(2);
            //When user enters all fields
            dataTablesPage.firstName.sendKeys(eachData.get("first_name"));
            WaitUtils.waitFor(2);
            dataTablesPage.lastName.sendKeys(eachData.get("last_name"));
            WaitUtils.waitFor(2);
            dataTablesPage.position.sendKeys(eachData.get("position"));
            WaitUtils.waitFor(2);
            dataTablesPage.office.sendKeys(eachData.get("office"));
            WaitUtils.waitFor(2);
            dataTablesPage.extension.sendKeys(eachData.get("extension"));
            WaitUtils.waitFor(2);
            dataTablesPage.startDate.sendKeys(eachData.get("start_date"));
            WaitUtils.waitFor(2);
            dataTablesPage.salary.sendKeys(eachData.get("salary"));
            WaitUtils.waitFor(2);
            //When clicks create button
            dataTablesPage.createButton.click();
            WaitUtils.waitFor(2);
            //And search for the first name
            dataTablesPage.searchBox.sendKeys(eachData.get("first_name"));
            WaitUtils.waitFor(2);
            //Then verify the name fields contains first name
            Assert.assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));
            WaitUtils.waitFor(2);
        }
        // LOOP ENDS

        Driver.closeDriver();

    }







}
