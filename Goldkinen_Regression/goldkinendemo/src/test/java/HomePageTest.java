import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    
       WebDriver driver;
         @BeforeClass
    public void setup() {
        // Path to your WebDriver executable on Windows
        String chromeDriverPath = System.getenv("CHROMEWEBDRIVER");
        if (chromeDriverPath != null) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        } else {
            // Fallback to local path or throw an exception
            throw new IllegalStateException("ChromeDriver path is not set in the environment variables");
        }
        
         driver = new ChromeDriver();
    }

    @Test
    public void testHomePageLoad(){

        driver.get("http://localhost:5173");
    }
        
    
}
