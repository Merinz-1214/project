package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	GeneralUtility generalutility;
	WebDriver driver;
	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileName;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getProfileName() {
		generalutility = new GeneralUtility(driver);
		String s = profileName.getText();
		System.out.println(s);
		return s;
		
	}
	public boolean getProfileName1() {
		generalutility = new GeneralUtility(driver);
		String s = profileName.getText();
		System.out.println(s);
		return generalutility.is_text_present(profileName, "Admin");
	}

}
