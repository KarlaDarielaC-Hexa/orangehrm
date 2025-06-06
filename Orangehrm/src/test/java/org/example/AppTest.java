package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.pages.AddEmployee;
import org.example.pages.DashPage;
import org.example.pages.LoginPage;
import org.example.pages.Pim;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {

    com.aventstack.extentreports.ExtentReports extent;
    ExtentSparkReporter spark;

    @BeforeSuite
    public void setupReport(){
        spark = new
                ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(spark);
    }

    ExtentTest test;
    @Test
    public void flujoOrangeHrm() throws InterruptedException {

        test = extent.createTest("Test-Creacion de usuario");
        test.info("Inicio de prueba");


        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        LoginPage loginPage = new LoginPage(driver);
        String vUser = "Admin";
        String vPass = "admin123";
        loginPage.GetInputUser();
        loginPage.GetInputPass();
        loginPage.doLogin(vUser, vPass);
        test.info("Paso el login");
        DashPage dashPage = new DashPage(driver);
        dashPage.GetaPim();
        dashPage.btnPim();
        test.info("Paso el Dashboard");
        Pim pim = new Pim(driver);
        pim.GetBtnAdd();
        pim.doCreate();
        AddEmployee addEmployee = new AddEmployee(driver);
        String AName = "Gabriela";
        String AMiddle = "Tovar";
        String ALast = "Tavares";
        String AUser = String.valueOf(Math.random());
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
        test.info("Paso crear usuario");
        Thread.sleep(5000);
        dashPage.btnPim();
        pim.doEId(addEmployee.EUserID);
        Thread.sleep(5000);
        pim.doCompareId(addEmployee.EUserID);
        test.info("Paso confirmar usuario y logout");
        loginPage.doLogin(AUser,APass);
        Thread.sleep(5000);
        test.info("Paso 2do login");
        driver.quit();

        test.pass("Prueba exitosa");
    }

    @AfterSuite
    public void tearDownReport(){
        extent.flush();
    }

}
