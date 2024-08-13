package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("^user is on Login page$")
    public void user_is_on_Login_page(){
        System.out.println("Inside step- user is on Login page");
        //throw new io.cucumber.java.PendingException();
    }
    @When("^user enter username and password$")
    public void user_enter_username_and_password(){
        //System.out.println("Inside step- user enter username and password");
        //throw new io.cucumber.java.PendingException();
    }
    @And("^click on Login button$")
    public void click_on_Login_button(){
        System.out.println("Inside step - click on Login button");
        //throw new io.cucumber.java.PendingException();
    }
    @Then("^user is navigated to Home page$")
    public void user_is_navigated_to_Home_page(){
        System.out.println("Inside step - user is navigated to Home page");
        //throw new io.cucumber.java.PendingException();
    }
}