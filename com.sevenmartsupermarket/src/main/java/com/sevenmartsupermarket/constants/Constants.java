package com.sevenmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.Excel;

public class Constants {
	Excel excel=new Excel();
	public static final String CONFIG_FILE_PATH =System.getProperty("user.dir")+"//src//main//resources//config.properties";//to get file path of config properties
	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")
			+ "//src//main//resources//ExcelFiles//";
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"//screenshots//";
    public static final String EXTENT_REPORT_FILEPATH=System.getProperty("user.dir")+"//ExtentReports";
    public static final String CONFIG_MNG_DELIVERY_BOY_CREDENTIALS=System.getProperty("user.dir")+"//src//main//resources//ConfigForMngDlvryBoys.properties";
    /**Login TestCase data**/
    @DataProvider(name="AdminUsers_")
	public Object[][] CredentialDataAdminUser()
	{
		excel.setExcelFile("AdminUsers", "valid_Credentials");
        return excel.getMultiDiamensionalData(3, 2);
	}
}

