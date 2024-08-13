package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {
    WebDriver driver;
    @Given("^user is on chrome browser$")
    public void user_is_on_chrome_browser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @And("^open google site$")
    public void open_google_site(){
        driver.navigate().to("https://www.google.com");
    }
    @When("^user search any keyword$")
    public void user_search_any_keyword(){
        driver.findElement(By.name("q")).sendKeys("Cucumber automation");
    }
    @And("^hits enter$")
    public void hits_enter(){
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("^verify the search result$")
    public void verify_the_search_result(){
        driver.getPageSource().equals("Cucumber - Overview");
        driver.close();
    }
}