package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listeners.RetryAnalyser;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void verifyAdminUsersPage() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersPage();
		adminuserspage.clickOnNewLabel();
		adminuserspage.userNameField("Appu");
		adminuserspage.passwordField("appu");
		adminuserspage.selectUserType();
		adminuserspage.clickOnSave();
		boolean userCreatedSuccessMsg=adminuserspage.userCreatedMessage();
		Assert.assertTrue(userCreatedSuccessMsg);	
	}
	
	@Test
	public void verifyUserDeactivator() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersPage();
		adminuserspage.deactivateUser("Wendy");
	}
}
