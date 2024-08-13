package Pages_PO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginPage_PO {
    WebDriver driver;
    Actions action;
    By menuBar= By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    By signIn_Menu= By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']");
    By txt_username = By.xpath("//input[@id='ap_email_login']");
    By btn_Continue = By.xpath("//input[@class=\"a-button-input\"]");
    By txt_password = By.id("ap_password");
    By btn_Login = By.id("signInSubmit");
    By mnu_user = By.xpath("//span[normalize-space()='Account & Lists']");
    By btn_Logout = By.xpath("//span[normalize-space()='Sign Out']");
    public LoginPage_PO(WebDriver driver) {
        this.driver = driver;
    }
    public void validLoginUser(String username, String password) throws InterruptedException {
        WebElement menu = driver.findElement(menuBar);
        action = new Actions(driver);
        action.moveToElement(menu).perform();
        driver.findElement(signIn_Menu).click();
        Thread.sleep(1000);

            driver.findElement(txt_username).sendKeys(username);
            driver.findElement(btn_Continue).click();
            driver.findElement(txt_password).sendKeys(password);
            driver.findElement(btn_Login).click();
    }
    public void verifyHomePage() throws InterruptedException {
        String actual= driver.getCurrentUrl();
        String expected= "https://www.amazon.in/?ref_=nav_signin";
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
        WebElement loggedinUser = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        System.out.println(loggedinUser.getText());

        WebElement Menu = driver.findElement(mnu_user);
        action = new Actions(driver);
        action.moveToElement(Menu).perform();
        driver.findElement(btn_Logout).click();
        System.out.println("======user logged out successfully======");
    }
//        public void verifyLogout() {
//            WebElement Menu = driver.findElement(mnu_user);
//            action = new Actions(driver);
//            action.moveToElement(Menu).perform();
//            driver.findElement(btn_Logout).click();
//
//            String actual= driver.getCurrentUrl();
//            String expected= "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_Account";
//            Assert.assertEquals(actual, expected);
//        }
//        public void backTo_SignInPage() {
//            String actual= driver.getCurrentUrl();
//            String expected= "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_Account";
//            Assert.assertEquals(actual, expected);
//        }
    }