import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    
       WebDriver driver;
         @BeforeClass
    public void setup() {
        // Path to your WebDriver executable on Windows
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", "G:/ChromeDriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
       
    }

    @Test
    public void testHomePageLoad(){

        String url = "http://localhost:5173";
        driver.get(url);
        System.out.println("Navigated to: " + driver.getCurrentUrl());
    }
        
    
}
