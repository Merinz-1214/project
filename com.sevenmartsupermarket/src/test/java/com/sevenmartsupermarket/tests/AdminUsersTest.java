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
	public void verifyNewUserAddition() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.addNewUser("useradmindsd", "1234567");
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
