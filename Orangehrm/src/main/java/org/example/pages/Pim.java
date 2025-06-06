package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Pim {
    private WebDriver driver;
    public By BtnAddBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    public By BtnSearchBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    public By inputEIdBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    public By listEmployeeBy = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");
    public By dropUserBy = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span");
    public By logoutBy = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");

    public Pim(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement GetBtnAdd(){
        return driver.findElement(BtnAddBy);
    }
    public WebElement GetLogout(){
        return driver.findElement(logoutBy);
    }
    public WebElement GetDropUser(){
        return driver.findElement(dropUserBy);
    }
    public WebElement GetBtnSearch(){
        return driver.findElement(BtnSearchBy);
    }
    public WebElement GetInputEId(){
        return driver.findElement(inputEIdBy);
    }
    public WebElement GetListEmployee(){
        return driver.findElement(listEmployeeBy);
    }

    public void doCreate(){
        GetBtnAdd().click();
    }
    public void doSearch(){
        GetBtnSearch().click();
    }
    public void doDropUser(){
        GetDropUser().click();
    }
    public void doLogout(){
        GetLogout().click();
    }


    public void doEId(String EId){
        WebElement inputEIdBy = GetInputEId();
        inputEIdBy.sendKeys(EId);
    }
    public void doCompareId (String EId) {
        doSearch();
        WebElement listEmployeeBy = GetListEmployee();
        String listId = listEmployeeBy.getText();
        System.out.println("Lista EID: " + EId + " ListaId " +listId + " Usuario existe");
        Assert.assertEquals(EId,listId);
        doDropUser();
        doLogout();

    }
}
