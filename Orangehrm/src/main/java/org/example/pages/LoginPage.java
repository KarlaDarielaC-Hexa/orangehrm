package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

    private WebDriver driver;
    public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public By inputUserBy = By.xpath("//input[@name='username']");
    public By inputPassBy = By.xpath("//input[@name='password']");
    public By btnLoginBy = By.xpath("//button[contains(@class,'login-button')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get(baseUrl);
    }

        public WebElement GetInputUser() {
        return driver.findElement(inputUserBy);
        }

        public WebElement GetInputPass() {
        return driver.findElement(inputPassBy);
        }

        public WebElement GetBtnLogin() {
        return driver.findElement(btnLoginBy);
        }

        public void doLogin(String Cuser, String Cpass){
            WebElement inputUserBy = GetInputUser();
            inputUserBy.sendKeys(Cuser);
            WebElement inputPassBy = GetInputPass();
            inputPassBy.sendKeys(Cpass);
            GetBtnLogin().click();
            System.out.println(Cuser + Cpass);
        }


    }


