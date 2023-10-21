package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.Screenshot;
import com.sevenmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fi;

	public Base() {
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH); // to read file
			properties.load(fi); // to load file
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	/* Launching Browser **/
	public void intialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new EdgeDriver(options);
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_TIMEOUT)); //used for page load

	}

	@Parameters("browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) {
		String url = properties.getProperty("url");// add key in brackets

		intialize(browser, url);
	}
	@BeforeMethod(enabled = true, alwaysRun = true)
	public void launchBrowser() {
		String url = properties.getProperty("url");// add key in brackets
		String browser = properties.getProperty("browser");
		intialize(browser, url);
}

	@AfterMethod
	public void terminateSession(ITestResult itestresult) {
		Screenshot screenshot=new Screenshot();
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			screenshot.takeScreenShot(driver, itestresult.getName());
		}
		
	}

}
