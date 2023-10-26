package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationsPage;
import com.sevenmartsupermarket.utilities.Excel;

public class PushNotificationsTest extends Base {
	LoginPage loginpage;
	PushNotificationsPage pushnotificationspage;
	Excel excel = new Excel();

	@Test(groups = { "sanity", "smoke" })
	public void verifyPushNotification() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		pushnotificationspage = new PushNotificationsPage(driver);
		excel.setExcelFile("notifications", "PushNotifications"); 
		pushnotificationspage.clickOnPushNotification();
		String title = excel.getCellData(0, 0);
		String description = excel.getCellData(0, 1);
		pushnotificationspage.sendNotification(title, description);
		pushnotificationspage.alertIsDisplayed();
		boolean alertSucessMessageActual = pushnotificationspage.alertIsDisplayed();
		Assert.assertTrue(alertSucessMessageActual);
	}

}
