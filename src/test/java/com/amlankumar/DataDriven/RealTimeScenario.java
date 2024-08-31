package com.amlankumar.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RealTimeScenario {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));}

    @Test(dataProvider = "loginData")
    public void TestDataDriven(String email, String password, String expectedResult){

        // Valid - vwo@1secmail.com, Vwo@1234
        driver.get("https://app.vwo.com/");
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("js-login-btn"));
        loginBtn.click();
        if(expectedResult.equalsIgnoreCase("Valid"))
        {

            String dashboardText = driver.findElement(By.cssSelector("[data-qa='lufexuloga']")).getText();
            Assert.assertEquals(dashboardText, "V W");
            WebElement user_icon = driver.findElement(By.xpath("(//img[@alt='V W'])[2]"));
            user_icon.click();
            WebElement logoutBtn = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu-list Miw(140px)\"]/li[2]"));
            logoutBtn.click();

        }
        if(expectedResult.equalsIgnoreCase("Invalid"))
        {
            WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(error_msg));
            String error = error_msg.getText();
            Assert.assertEquals(error, "Your email, password, IP address or location did not match");
        }
    }

    //hardcoded data - just replace this with an excel reader/file
 /*   @DataProvider(name ="loginData")
    public Object[][] testData(){
        return new Object[][]{

                {"vwo@1secmail.com", "Vwo@1234", "Valid"},
                {"vwo@xyz.com", "Vwo@123", "Invalid"},

        };
    }*/

    @DataProvider(name ="loginData")
    public String[][] testData() throws IOException {

            String fileLocation = "src/test/resources/Login1.xlsx";
            ExcelReader excel = new ExcelReader(fileLocation);
            String[][] data = excel.getDatafromSheet(fileLocation, "LoginData");
            return data;
        };


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
