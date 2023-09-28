package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getreport() {
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter spark =new ExtentSparkReporter("C:\\Users\\Akash Gowda\\Desktop\\New folder\\extent\\report.html");
		report.attachReporter(spark);
		spark.config().setReportName("Extent Report Assignment");
		report.setSystemInfo("Tester", "Akash");
		return report;
		
	}

}
