package com.sevenmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	static int counter = 0;
	static int limit = 3; //1 is default and additional three 

	@Override
	public boolean retry(ITestResult result) {
		if (counter < limit) {
			counter++;
			return true;
		} else {
			return false;
		}

	}

}
