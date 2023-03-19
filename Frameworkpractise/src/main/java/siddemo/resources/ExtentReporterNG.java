package siddemo.resources;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports grtreportobject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("PDADMIN REPORT");
		reporter.config().setReportName("Test");
		///////////////////----///////////////////////////
		ExtentReports rep = new ExtentReports();
		rep.attachReporter(reporter);
		rep.setSystemInfo("Tester", "Siddhesh.N.Pasalkar");
		return rep;
		
	}
	
	

}
