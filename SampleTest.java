package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SampleTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("Google Search Test", "Sample test to open Google");
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        if (title.contains("Google")) {
            test.pass("Navigated to Google successfully!");
        } else {
            test.fail("Google title not found!");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}

