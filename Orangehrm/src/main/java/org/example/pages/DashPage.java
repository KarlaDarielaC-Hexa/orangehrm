package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashPage
{
    private WebDriver driver;
    public By aPim = By.xpath("//a[contains(@href,'viewPimModule')]");

    public DashPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement GetaPim(){
        return driver.findElement(aPim);
    }

    public void btnPim(){
        GetaPim().click();
    }


}
