package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	@FindBy(xpath ="//p[contains(text(),'Manage Delivery Boy')]")
	private WebElement click;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement EnterName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_input;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement adrs;
	@FindBy(xpath ="//input[@id='password']")
	WebElement password;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement save;
	
	public void clickOnManageDeliveryBoy() {
		click.click();
	}
	public void nameField(String name) {
		EnterName.sendKeys(name);
	}
	public void emailField(String email) {
		email_input.sendKeys(email);
	}
	public void phone(String number) {
		phone.sendKeys(number);
	}
	public void addressField(String address) {
		adrs.sendKeys(address);
	}
	public void passwordField(String passwd) {
		password.sendKeys(passwd);
	}
	public void clickOnSave(){
		save.click();
	}
	

	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
