package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test
	public void verifyAddNewDeliveryBoy() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.openDeliveryBoyPage();
		managedeliveryboypage.clickOnNewButton();
		managedeliveryboypage.enterDeliveryBoyDetails();
		managedeliveryboypage.clickOnSave();
		boolean sucessMessageDisplayed = managedeliveryboypage.successMessageIsDisplayed();
		Assert.assertTrue(sucessMessageDisplayed);
	}

}
