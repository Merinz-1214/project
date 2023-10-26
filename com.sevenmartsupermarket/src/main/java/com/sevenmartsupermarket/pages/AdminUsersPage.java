package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	@FindBy(xpath = "//table[contains(@class,'table')]//tbody//tr//td[1]")
	List<WebElement> names;
	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminUsers_click;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-danger')]")
	private WebElement new_click;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement username_label;
	@FindBy(xpath = "(//input[@class='form-control'])[3]")
	private WebElement password_label;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement Select_userType;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement save_click;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userCreatedMsgField;

	public void clickOnAdminUsersPage() {
		adminUsers_click.click();
	}

	public void clickOnNewLabel() {
		new_click.click();
	}

	public void userNameField(String username) {
		username_label.sendKeys(username);
	}

	public void passwordField(String password) {
		password_label.sendKeys(password);
	}

	public void selectUserType() {
		pageutility = new PageUtility(driver);
		pageutility.select_byVisibleText(Select_userType, "Staff");
	}

	public void clickOnSave() {
		save_click.click();
	}

	public void addNewUser(String username, String password) {
		clickOnAdminUsersPage();
		clickOnNewLabel();
		userNameField(username);
		passwordField(password);
		selectUserType();
		clickOnSave();
	}

	public boolean userCreatedMessage() {
		return userCreatedMsgField.isDisplayed();
	}

	public void deactivateUser(String personName) {
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalutility.get_text_of_elemets(names);
		System.out.println(userNames);
		int index = 0;
		for (index = 0; index < userNames.size(); index++) {
			if (userNames.get(index).equals(personName)) {
				index++;
				break;
			}
		}
		WebElement deactivateButton = driver
				.findElement(By.xpath("//table[contains(@class,'table')]//tbody//tr[" + index + "]//td[5]/a[1]"));
		pageutility.scrollAndClick(deactivateButton);
	}

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}