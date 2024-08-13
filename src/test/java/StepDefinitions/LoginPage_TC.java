package StepDefinitions;

import Pages_PO.LoginPage_PO;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
public class LoginPage_TC {
    WebDriver driver;
    LoginPage_PO loginPagePo;
//    @Parameters({"browsername", "driverpath"})
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Given("user is on Amazon page {string}")
    public void user_is_on_Amazon_page(String url) throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(1000);
    }
    @When("user enters username as {string} and password as {string}")
    public void verifyLoginpage(String username, String password) throws InterruptedException {
        loginPagePo= new LoginPage_PO(driver);
        loginPagePo.validLoginUser(username, password);
    }
    @Then("user should be able to login successfully and Home page is open")
    public void verifyHomepage() throws InterruptedException {
        loginPagePo= new LoginPage_PO(driver);
        loginPagePo.verifyHomePage();
    }
//    @When("^hits SignOut button$")
//    public void verifyLogout() throws InterruptedException {
//        loginPagePo= new LoginPage_PO(driver);
//        loginPagePo.verifyLogout();
//        Thread.sleep(2000);
//    }

//    @Then("^back to Login page$")
//    public void verifyBackToSignInPage(){
//        loginPagePo.backTo_SignInPage();
//    }
    @Then("user should be able to see the error message {string}")
    public void verifyErrMessage(String expectedErrorMessage){
        WebElement element = driver.findElement(By.xpath("//h1[@class='a-size-medium-plus a-spacing-small']"));
        System.out.println(element.getText());
        if (element.isDisplayed()==true) {
            Assert.assertEquals(expectedErrorMessage, element);
        }else {
            String actual= driver.getCurrentUrl();
            String expected= "https://www.amazon.in/ax/claim/intent";
            Assert.assertEquals(actual, expected);
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}