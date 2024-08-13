package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class SampleStepDefinitions {
//    @BeforeClass
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//    }
    WebDriver driver;
    @Given("^Open the Google website$")
    public void OpenGoogleWebsite(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Then("^Verify the title is \"([^\"]*)\"$")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
}