package playwright1.playwright1;

import java.io.FileReader;
import java.util.Properties;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

public class Util {
	ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");

	// Create ExtentReports and attach the reporter
	ExtentReports extent = new ExtentReports();

	public static void clickUse(String locator, Page page) {
		page.click(locator);
		System.out.println("Click on element " + locator);
	}

	public static void dataFill(Page page, String locator, String data) {
		page.fill(locator, data);
		System.out.println("Click on element " + locator);
	}

	public void generateReportHeader() {
		System.out.println("facebook");
		Reporter.log("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<style>\r\n" + "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n" + "}\r\n" + "</style>\r\n" + "<body>\r\n"
				+ "<table style=\"width:100%\">\r\n" + "  <tr>\r\n" + "    <th>Sno</th>\r\n"
				+ "    <th>Test Case</th>\r\n" + "    <th>Result</th>\r\n" + "  </tr>\r\n");

	}

	public void generateReportRow(String sno, String testCase, boolean execution) {
		System.out.println("facebook");
		Reporter.log("  <tr>\r\n" + "    <td>" + sno + "</td>\r\n" + "    <td>" + testCase + "</td>\r\n" + "    <td>"
				+ execution + "</td>\r\n" + "  </tr>\r\n" + "</table>\r\n" + "</body>\r\n" + "</html>\r\n");

	}

	public static String dataRead(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("./Resourses/DataFile.properties"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.get(key).toString();
	}

	public void GenerateReport(String testCaseName) {
		extent.attachReporter(spark);

		// Create a test
		ExtentTest test = extent.createTest(testCaseName);

		test.pass("Test Passed!");
		test.info("This is additional info.");
		test.fail("Test Failed.");

		// Flush the report
		extent.flush();
	}

}
