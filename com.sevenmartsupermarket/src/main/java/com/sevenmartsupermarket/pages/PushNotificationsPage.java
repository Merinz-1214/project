package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationsPage {
	WebDriver driver;
	@FindBy(xpath = "//p[contains(text(),'Push')]")
	private WebElement PN_Click;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement Enter_Title;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement description;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement send_btn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	
	
	public void clickOnPushNotification() {
		PN_Click.click();
	}
	public void enterTitle(String title) {
		Enter_Title.sendKeys(title);
	}
	public void description(String descrip) {
		description.sendKeys(descrip);
	}
	public void clickOnSendButton() {
		send_btn.click();
	}
	public boolean alertIsDisplayed() {
		return alertmsg.isDisplayed();
	}
	public void sendNotification(String title,String description) {
		enterTitle(title);
		description(description);
		clickOnSendButton();
		
	}
	//public String getSuccessMsg() {
	//	return alert.getText();}
	
	public PushNotificationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

}
