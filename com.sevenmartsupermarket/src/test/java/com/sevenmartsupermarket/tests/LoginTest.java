package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	
	
	@Test(groups ="sanity")
	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		//loginpage.login("janaki","jani123");
		String Expected_profile_Name="Admin";
		String Actual_Profile_Name=homepage.getProfileName();
		Assert.assertEquals(Actual_Profile_Name, Expected_profile_Name);
		
	}
	
	

}
