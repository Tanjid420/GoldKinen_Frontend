import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    
       WebDriver driver;
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

        String url = "http://localhost:5173";
        driver.get(url);
        System.out.println("Navigated to: " + driver.getCurrentUrl());
    }
        
    
}
