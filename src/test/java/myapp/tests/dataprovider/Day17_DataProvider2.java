package myapp.tests.dataprovider;

import myapp.pages.DataTablesPage;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_DataProvider2 {

     /*
        1. create a data provider source in utils will take data from user_data sheet
        2. connect this test method to data provider by using dataProvider and dataProviderClass
        3. complete your test case with the data that comes from excel
        NOTE: try using existing code that might help.We will use userCreationWithExcel method
     */

    DataTablesPage dataTablesPage;

    @Test(dataProvider = "excelUserData", dataProviderClass = DataProviderUtils.class)
    public void userCreatingWithDataProvider(
            String firstName,
            String lastName,
            String position,
            String office,
            String extension,
            String startDate,
            String salary
    ){

        //When user go to https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");
        WaitUtils.waitFor(2);
        //Click on the new button
        dataTablesPage = new DataTablesPage();
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(2);
        //When user enters all fields
        //dataTablesPage.firstName.sendKeys(eachData.get("first_name"));
        dataTablesPage.firstName.sendKeys(firstName);
        WaitUtils.waitFor(2);
        //dataTablesPage.lastName.sendKeys(eachData.get("last_name"));
        dataTablesPage.lastName.sendKeys(lastName);
        WaitUtils.waitFor(2);
        //dataTablesPage.position.sendKeys(eachData.get("position"));
        dataTablesPage.position.sendKeys(position);
        WaitUtils.waitFor(2);
        //dataTablesPage.office.sendKeys(eachData.get("office"));
        dataTablesPage.office.sendKeys(office);
        WaitUtils.waitFor(2);
        //dataTablesPage.extension.sendKeys(eachData.get("extension"));
        dataTablesPage.extension.sendKeys(extension);
        WaitUtils.waitFor(2);
        //dataTablesPage.startDate.sendKeys(eachData.get("start_date"));
        dataTablesPage.startDate.sendKeys(startDate);
        WaitUtils.waitFor(2);
        //dataTablesPage.salary.sendKeys(eachData.get("salary"));
        dataTablesPage.salary.sendKeys(salary);
        WaitUtils.waitFor(2);
        //When clicks create button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(2);
        //And search for the first name
        //dataTablesPage.searchBox.sendKeys(eachData.get("first_name"));
        dataTablesPage.searchBox.sendKeys(firstName);
        WaitUtils.waitFor(2);
        //Then verify the name fields contains first name
        Assert.assertTrue(dataTablesPage.nameField.getText().contains(firstName));
        WaitUtils.waitFor(2);

        Driver.closeDriver();

    }






}
