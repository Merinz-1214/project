package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listeners.RetryAnalyser;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.Excel;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	Excel excel=new Excel();
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void verifyNewUserAddition() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		String username= GeneralUtility.getFirstName();
		excel.setExcelFile("AdminPassword","AdminUserData");
		String password=excel.getCellData(0,1);
		adminuserspage.addNewUser(username,password);
		adminuserspage.userCreatedMessage();
		boolean userCreatedSuccessMsg=adminuserspage.userCreatedMessage();
		Assert.assertTrue(userCreatedSuccessMsg);		
	}
	
	@Test
	public void verifyUserDeactivator() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersPage();
		adminuserspage.deactivateUser("Menon");
	}
	
}
