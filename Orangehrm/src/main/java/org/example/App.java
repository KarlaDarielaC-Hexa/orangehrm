package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.pages.AddEmployee;
import org.example.pages.DashPage;
import org.example.pages.LoginPage;
import org.example.pages.Pim;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    ExtentReports extent;
    ExtentSparkReporter spark;
    @BeforeSuite
    public void setupReport(){
        spark = new
                ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    public static void main( String[] args ) throws InterruptedException {


        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        LoginPage loginPage = new LoginPage(driver);
        String vUser = "Admin";
        String vPass = "admin123";
        loginPage.GetInputUser();
        loginPage.GetInputPass();
        loginPage.doLogin(vUser, vPass);
        DashPage dashPage = new DashPage(driver);
        dashPage.GetaPim();
        dashPage.btnPim();
        Pim pim = new Pim(driver);
        pim.GetBtnAdd();
        pim.doCreate();
        AddEmployee addEmployee = new AddEmployee(driver);
        String AName = "Gabriela";
        String AMiddle = "Tovar";
        String ALast = "Tavares";
        String AUser = "pruebaqa123";
        String APass = "Prueba123$";
        String ACPass = "Prueba123$";
        addEmployee.GetInputEName();
        addEmployee.GetInputEMiddle();
        addEmployee.GetInputELast();
        addEmployee.doELoginDetails();
        addEmployee.GetInputEUser();
        addEmployee.GetInputEPass();
        addEmployee.GetInputECPass();
        addEmployee.SaveId();
        addEmployee.doAddEmployee(AName,AMiddle,ALast,AUser,APass,ACPass);
        Thread.sleep(10000);
        dashPage.btnPim();
        pim.doEId(addEmployee.EUserID);
        Thread.sleep(10000);
        pim.doCompareId(addEmployee.EUserID);
        loginPage.doLogin(AUser,APass);
        Thread.sleep(30000);
        driver.quit();




    }
}
