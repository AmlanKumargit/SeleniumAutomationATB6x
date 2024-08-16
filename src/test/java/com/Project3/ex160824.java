package com.Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ex160824 {

    @Test
    public static void Project3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.idrive360.com/enterprise/login");

        WebElement unameTxtbx = driver.findElement(By.id("username"));
        unameTxtbx.sendKeys("augtest_040823@idrive.com");

        WebElement pwdTxtbx = driver.findElement(By.id("password"));
        pwdTxtbx.sendKeys("123456");

        WebElement loginBtn = driver.findElement(By.id("frm-btn"));
        loginBtn.click();
        Thread.sleep(10000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.idrive360.com/enterprise/account?upgradenow=true");

        WebElement trialTxt = driver.findElement(By.className("id-card-title"));
        String txt = trialTxt.getText();
        Assert.assertTrue(trialTxt.isDisplayed(),txt);


    }
}
