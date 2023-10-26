package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
  HomePage homepage;
  LoginPage loginPage;
  
  @Test
  public void verifyProfileName() {
	    loginPage = new LoginPage(driver);
		loginPage.login();
		homepage = new HomePage(driver);
		homepage.getProfileName();
		
	}
}
