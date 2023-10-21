package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;
	
	@Test
	public void verifyManageDeliveryBoy() {
		loginpage=new LoginPage(driver);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnManageDeliveryBoy();
		managedeliveryboypage.nameField("merin");
		managedeliveryboypage.phone("878787979");
		managedeliveryboypage.addressField("heaven villa");
		managedeliveryboypage.passwordField("fdfggcg");
		managedeliveryboypage.clickOnSave();
	}
	

}
