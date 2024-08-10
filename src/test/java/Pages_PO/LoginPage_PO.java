package Pages_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.sql.Driver;

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
        WebElement menu= driver.findElement(menuBar);
        action= new Actions(driver);
        action.moveToElement(menu).perform();
        driver.findElement(signIn_Menu).click();

        Thread.sleep(2000);
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(btn_Continue).click();
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(btn_Login).click();
    }
    public void verifyHomePage() throws InterruptedException {
        boolean elemnt= driver.getCurrentUrl().contains("/?ref_=nav_custrec_signin");
        Thread.sleep(3000);
        WebElement loggedinUser = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        System.out.println(loggedinUser.getText());
    }
        public void verifyLogout() {
            WebElement Menu = driver.findElement(mnu_user);
            action = new Actions(driver);
            action.moveToElement(Menu).perform();
            driver.findElement(btn_Logout).click();
        }
        public void backTo_SignInPage() {
            boolean elemnt1= driver.getCurrentUrl().contains("/ap/signin?");
            driver.close();
        }
    }