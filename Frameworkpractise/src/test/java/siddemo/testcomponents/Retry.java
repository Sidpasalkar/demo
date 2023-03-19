package siddemo.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {

		int count = 0;
		int Maxtry = 1;
		if (count < Maxtry) {
             //for failed method give parameter as retryAnalyzer=Retry.class 
			count++;
			return true;
		}

		return false;
	}

}
