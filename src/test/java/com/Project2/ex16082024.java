package com.Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ex16082024 {

    @Test
    public void Project2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//OR USE THE ALTERNATE OPTIONS APPROACH MENTIONED ABOVE
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        WebElement makeappBtn = driver.findElement(By.id("btn-make-appointment"));
        makeappBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        Thread.sleep(3000);

        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        usernameInput.sendKeys("John Doe");

        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");

        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        loginBtn.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        String text = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Make Appointment",text);
        //Assert.assertTrue(driver.findElement(By.tagName("h2")).isDisplayed(),text);

        Thread.sleep(2000);
        driver.quit();
    }
}
