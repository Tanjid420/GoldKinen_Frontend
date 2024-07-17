import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class HomePageTest {
    
       WebDriver driver;
       ExtentReports extent;
       ExtentTest test;

         @BeforeTest
         public void config(){
            String path = System.getProperty("user.dir") + "\\testReports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
                reporter.config().setReportName("Goldkinen Automation");
                reporter.config().setDocumentTitle("Test Results");
        

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Arnob");
         }

    @BeforeClass
    public void setup() {
        
        // Set the path to the chromedriver executable
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        if (chromeDriverPath == null || chromeDriverPath.isEmpty()) {
            throw new IllegalStateException("CHROME_DRIVER_PATH environment variable is not set or empty");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
       
    }

    @Test
    public void testHomePageLoad(){

        test = extent.createTest("Navigating");

        String url_1 = "https://www.youtube.com/";
        String url_2 = "http://localhost:5173/";
        try {
            driver.get(url_1);
            
            // Optionally, you can print the current URL for verification
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            test.pass("Navigated to: " + url_1);
        } catch (Exception e) {
            System.out.println("Failed to navigate to URL: " + e.getMessage());
            test.fail("Failed to navigate to URL: " + e.getMessage());
        }

        try {
            driver.get(url_2);
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            test.pass("Navigated to: " + url_2);
        } catch (Exception e) {
            System.out.println("Failed to navigate to URL_2: " + e.getMessage());
            test.fail("Failed to navigate to URL: " + e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }
    }
        
    
}
