import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import com.aventstack.extentreports.util.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Buffer_and_Crash_Test {

    WebDriver driver;
    
    




    @BeforeClass
    public void setup() {
        
        //Set the path to the chromedriver executable
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        if (chromeDriverPath == null || chromeDriverPath.isEmpty()) {
            throw new IllegalStateException("CHROME_DRIVER_PATH environment variable is not set or empty");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.get("https://dev.mymirakey.com/auth/login");

        // Enter email and password
        // WebElement emailInput = driver.findElement(By.xpath("//input[@name = 'email']"));
        // emailInput.sendKeys("");

        // WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        // passwordInput.sendKeys("");

        // Click the login button
        // WebElement signIn = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='css-r7scqu emmy3ya2']")));
        // signIn.click();

        // Wait for the login to complete
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains("https://dev.mymirakey.com/"));


        // Test Reports
        // String path = System.getProperty("user.dir") + "\\testReports\\index.html";
        //     ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        //         reporter.config().setReportName("Mirakey Automation");
        //         reporter.config().setDocumentTitle("Test Results");
        

        //     extent = new ExtentReports();
        //     extent.attachReporter(reporter);
        //     extent.setSystemInfo("Tester", "Arnob");


       
        
       
    }

    

    @DataProvider(name = "urls")
    public Object[][] getURLs() {
        return new Object[][] {
            {"https://dev.mymirakey.com/", "Dashboard"},
            {"https://dev.mymirakey.com/products/directory/list", "Product Directory"},
            {"https://dev.mymirakey.com/products/promotion/list", "Product Promotions"},
            {"https://dev.mymirakey.com/products/category/list", "Product Categories"},
            {"https://dev.mymirakey.com/products/supplier/list", "Product Supplier"},
            {"https://dev.mymirakey.com/products/order/list", "Product Order"},
            {"https://dev.mymirakey.com/customer/list", "Customer"},
            {"https://dev.mymirakey.com/users/list", "Users Directory"},
            {"https://dev.mymirakey.com/users/activity/list", "User Clock In/Out"},
            {"https://dev.mymirakey.com/reports/sales-report/summary", "Sales Report"},
            {"https://dev.mymirakey.com/reports/sales-inventory/summary", "Inventory Report"},
            {"https://dev.mymirakey.com/reports/sales-customer/summary", "Customer Report"},
            // {"http://nonexistentwebsite.com", "Failed on Purpose"},
            {"https://dev.mymirakey.com/reports/employee-report/sales", "Employee Report"},
            {"https://dev.mymirakey.com/settings/store/info/store" , "My Store Settings"},
            {"https://dev.mymirakey.com/settings/sales/main/sales", "My Sales Settings"},
            {"https://dev.mymirakey.com/account/profile", "My Account"}
            
            
        };
    }

    /**
     * Test method to check for long buffering or crash on a single URL.
     * 
     * @param url the URL to test
     * @param urlName the name of the URL
     */
    @Test(dataProvider = "urls")
    public void testURL(String url, String urlName) {
        System.out.println("Testing " + urlName + ": " + url);

        // Get the test result object
        // ITestResult result = Reporter.getCurrentTestResult();
        // Create a new extent test with the correct test ID and name
        // ExtentTest test = extent.createTest(result.getMethod().getMethodName() + " - " + urlName, "Test URL: " + url);

        try {
            // Navigate to the URL
            driver.get(url);

            // Wait for 2 minutes for the page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // If the page loads within 2 minutes, log a pass
            System.out.println("Page loaded successfully within 2 minutes");
            
        } catch (Exception e) {
            // If the page does not load within 2 minutes, log a fail
           System.out.println("Page did not load within 2 minutes: " + e.getMessage());
           Assert.fail("Page did not load within 2 minutes: " + e.getMessage());
            
        }
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();

       
    }

}
