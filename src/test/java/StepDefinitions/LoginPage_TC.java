package StepDefinitions;

import Pages_PO.LoginPage_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginPage_TC {
    WebDriver driver=null;
    LoginPage_PO loginPagePo;
    @Given("^user is on Chrome browser$")
    public void user_is_on_Chrome_browser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @And("^open Amazon site$")
    public void open_Amazon_site() throws InterruptedException {
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(1000);
    }
    @When("^user SingIn with (.*) and (.*)$")
    public void user_SingIn_with_username_and_password(String username, String password) throws InterruptedException {
        loginPagePo= new LoginPage_PO(driver);
        loginPagePo.validLoginUser(username, password);
    }
    @When("^navigated to the Home page$")
    public void navigated_to_the_Home_page() throws InterruptedException {
        loginPagePo= new LoginPage_PO(driver);
        loginPagePo.verifyHomePage();
    }
    @And("^hits SignOut button$")
    public void hits_SignOut_button() throws InterruptedException {
        loginPagePo= new LoginPage_PO(driver);
        loginPagePo.verifyLogout();
        Thread.sleep(2000);
    }
    @Then("^back to SignIn page$")
    public void back_to_SignIn_page(){
        loginPagePo.backTo_SignInPage();
        driver.close();
    }
}