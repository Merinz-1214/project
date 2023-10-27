package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test
	public void verifyAddNewDeliveryBoy() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoy();
		managedeliveryboypage.clickOnNewButton();
		String name=GeneralUtility.getFirstName();
		String address=GeneralUtility.getStreetAdress();
		String username_mngdeliveryboy=GeneralUtility.getFirstName();
		managedeliveryboypage.enterDeliveryBoyDetails(name, "test@gmail.com","65636363");
		managedeliveryboypage.enterDeliveryBoyDetails1(address, username_mngdeliveryboy, "mntv");
		managedeliveryboypage.clickOnSave();
		boolean issucessMessageDisplayed = managedeliveryboypage.successMessageIsDisplayed();
		Assert.assertTrue(issucessMessageDisplayed);
	}

}
