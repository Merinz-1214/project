package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	FileInputStream fi;
	PageUtility pageUtility;
	Properties properties = new Properties();
	@FindBy(xpath = "//p[contains(text(),'Delivery')]")
	private WebElement click;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-danger')]")
	private WebElement new_click;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement EnterNameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNoField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save_click;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement successAlert;

	public void clickOnManageDeliveryBoy() {
		click.click();
	}

	public void openDeliveryBoyPage() {
		LoginPage loginPage = new LoginPage(driver);
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		loginPage.login(userName, password);
		clickOnManageDeliveryBoy();
	}

	public void clickOnNewButton() {
		new_click.click();
	}

	public void enterDeliveryBoyDetails() {
		String deliveryBoyName = GeneralUtility.getFirstName();
		EnterNameField.sendKeys(deliveryBoyName);
		String deliveryBoyEmail = deliveryBoyName + "@gmail.com";
		emailField.sendKeys(deliveryBoyEmail);
		String deliveryBoyPhone = properties.getProperty("phone");
		phoneNoField.sendKeys(deliveryBoyPhone);
		String deliveryBoyAddress = GeneralUtility.getStreetAdress();
		addressField.sendKeys(deliveryBoyAddress);
		userNameField.sendKeys(deliveryBoyName);
		String deliverBoyPassword = properties.getProperty("newuserpassword");
		passwordField.sendKeys(deliverBoyPassword);

	}

	public void clickOnSave() {
		pageUtility = new PageUtility(driver);
		pageUtility.jsClick(save_click);
	}

	public boolean successMessageIsDisplayed() {
		return successAlert.isDisplayed();
	}

	public ManageDeliveryBoyPage(WebDriver driver) {
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
