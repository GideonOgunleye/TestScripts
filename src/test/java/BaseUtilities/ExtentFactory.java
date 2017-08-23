package BaseUtilities;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\Sanity Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance2() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\Regression Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance3() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\Smoke Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance4() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\IndexPageCrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance5() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\MainNavBrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance6() {
		ExtentReports extent;

		String Path = "C:\\ExtentReport\\SubNavBrokenLinks Test.html";

		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}


}
