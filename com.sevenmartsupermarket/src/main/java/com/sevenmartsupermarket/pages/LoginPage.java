package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fi;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	@CacheLookup
	private WebElement User_name_Field;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement password_Field;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement remember_checkbox_Field;
	@FindBy(xpath = "//label[starts-with(@for,'remember')]")
	private WebElement remember_TextField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signin_click;

	public LoginPage(WebDriver driver) {
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH); // to read file
			properties.load(fi); // to load file
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) { // for code reusability
		User_name_Field.sendKeys(userName);

	}

	public void enterPassword(String password) {
		password_Field.sendKeys(password);

	}

	public void clickOnSigninButton() {
		signin_click.click();

	}

	public void login() {
		String username = properties.getProperty("username");// add key in brackets
		String password = properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickOnSigninButton();
	}

	public void login(String userName, String password) { // method overloading
		enterUserName(userName);
		enterPassword(password);
		clickOnSigninButton();

	}
}
