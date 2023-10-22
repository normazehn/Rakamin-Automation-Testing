package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user in login page sauce demo")
    public void login_page_saucedemo(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(baseurl);
    }

    @When("user input username : standard_user")
    public void userInputUsernameStandard_user() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password : secret_sauce")
    public void userInputPasswordSecret_sauce() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user tap Login button")
    public void userTapLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user successfully login")
    public void userSuccessfullyLogin() {
        driver.findElement(By.xpath("div[contains(text(), 'Swag Labs')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(), 'Swag Labs')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "standard_user");
    }

    @And("user input password : try-and-error")
    public void userInputPasswordTryAndError(){
            driver.findElement(By.id("password")).sendKeys("try-and-error");
            String errorLogin = driver.findElement(By.xpath("//h3[@role='alert']")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
    }
