package myapp.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    // Data Provider Method to get the employee credentials
    @DataProvider
    public Object[][] employeeCredentialsProvider(){
        Object[][] employeeInfo={
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com",	"v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return employeeInfo;
    }

    // Data Provider to get the employee credentials from the Excel Sheet
    @DataProvider
    public Object[][] excelEmployeeData(){
        String excelPath = "C:\\Users\\Akif\\IdeaProjects\\mytestNGproject\\resources\\data_sheet.xlsx";
        String sheetName = "employee_credentials";
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Object[][] employeeInfo = excelUtils.getDataArrayWithoutFirstRow();
        return employeeInfo;
    }

    //Data Provider to get data from user_data excel sheet
    @DataProvider
    public Object[][] excelUserData(){
        String excelPath = "C:\\Users\\Akif\\IdeaProjects\\mytestNGproject\\resources\\data_sheet.xlsx"; //user data in this excel
        String sheetName = "user_data"; //user data in this sheet
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        Object[][] userData = excelUtils.getDataArrayWithoutFirstRow();
        return userData;
    }






}
