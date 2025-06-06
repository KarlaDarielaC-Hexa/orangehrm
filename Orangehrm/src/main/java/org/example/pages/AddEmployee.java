package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddEmployee {
    private WebDriver driver;
    public By inputENameBy = By.xpath("//*[@placeholder = 'First Name']");
    public By inputEMiddleBy = By.xpath("//*[@placeholder = 'Middle Name']");
    public By inputELastBy = By.xpath("//*[@placeholder = 'Last Name']");
    public By inputEIdBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    public By btnELoginDetailsBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span");
    public By inputEUserBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
    public By inputEPassBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
    public By inputECPassBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
    public By btnESaveBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    public String EUserID;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement GetInputEName() {
        return driver.findElement(inputENameBy);
    }
    public WebElement GetInputEMiddle() {
        return driver.findElement(inputEMiddleBy);
    }
    public WebElement GetInputELast() {
        return driver.findElement(inputELastBy);
    }
    public WebElement GetInputEId() {
        return driver.findElement(inputEIdBy);
    }
    public WebElement GetBtnELoginDetails() {
        return driver.findElement(btnELoginDetailsBy);
    }
    public WebElement GetInputEUser() {
        return driver.findElement(inputEUserBy);
    }
    public WebElement GetInputEPass() {
        return driver.findElement(inputEPassBy);
    }
    public WebElement GetInputECPass() {
        return driver.findElement(inputECPassBy);
    }
    public WebElement GetBtnESave() {
        return driver.findElement(btnESaveBy);
    }

    public void SaveId () {
        WebElement inputEIdBy = GetInputEId();
        Assert.assertNotNull(inputEIdBy);
        Assert.assertFalse(inputEIdBy.getAttribute("value").isEmpty());
        String userId = inputEIdBy.getAttribute("value");
        EUserID = userId;
        System.out.println("ID: "+userId);
    }


    public void doAddEmployee(String AName, String AMiddle, String ALast,String AUser, String APass, String ACPass){

        WebElement inputENameBy = GetInputEName();
        inputENameBy.sendKeys(AName);
        WebElement inputEMiddleBy = GetInputEMiddle();
        inputEMiddleBy.sendKeys(AMiddle);
        WebElement inputELastBy = GetInputELast();
        inputELastBy.sendKeys(ALast);
        WebElement inputEUserBy = GetInputEUser();
        inputEUserBy.sendKeys(AUser);
        WebElement inputEPassBy = GetInputEPass();
        inputEPassBy.sendKeys(APass);
        WebElement inputECPassBy = GetInputECPass();
        inputECPassBy.sendKeys(ACPass);
        GetBtnESave().click();
        System.out.println("Se agrego el usuario");


    }
    public void doELoginDetails(){
        GetBtnELoginDetails().click();
    }
}
