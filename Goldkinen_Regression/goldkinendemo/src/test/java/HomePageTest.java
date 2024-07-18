import java.io.File;

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


        // Clean Test Reports    
        //      File testReportsDir = new File("testReports");
        // if (testReportsDir.exists()) {
        //     for (File file : testReportsDir.listFiles()) {
        //         file.delete();
        //     }
        File testReportsDir = new File("testReports");
        if (!testReportsDir.exists()) {
            testReportsDir.mkdir();
        }
            


        // }

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

        String youtube = "https://www.youtube.com/";
        String goldkinen = "http://localhost:5173/";
        String vivasoft = "https://academy.vivasoftltd.com/";
        try {
            driver.get(youtube);
            
            // Optionally, you can print the current URL for verification
            System.out.println("Checkin Youtube");
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            test.pass("Navigated to: " + youtube);
        } catch (Exception e) {
            System.out.println("Failed to navigate to URL: " + e.getMessage());
            test.fail("Failed to navigate to URL: " + e.getMessage());
        }

        try {
            driver.get(goldkinen);
            System.out.println("Checkin Goldkinen");
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            test.pass("Navigated to: " + goldkinen);
        } catch (Exception e) {
            System.out.println("Failed to navigate to URL_2: " + e.getMessage());
            test.fail("Failed to navigate to URL: " + e.getMessage());
        }

        try {
            driver.get(vivasoft);
            System.out.println("Checkin Vivasoft");
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            test.pass("Navigated to: " + vivasoft);
        } catch (Exception e) {
            System.out.println("Failed to navigate to Vivasoft: " + e.getMessage());
            test.fail("Failed to navigate to URL: " + e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() {
        
            driver.quit();
            extent.flush();
        
    }
        
    
}
