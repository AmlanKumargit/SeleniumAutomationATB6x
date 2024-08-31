package com.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ex160824 {

    @Test
    public static void VWOLoginNegative() {

        /*ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL)// 3 options - EAGER, NORMAL, NONE
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);*/
        //ALTERNATE APPROACH FOR PASSING WINDOW SIZE, MAXIMIZE, MINIMIZE

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//OR USE THE ALTERNATE OPTIONS APPROACH MENTIONED ABOVE
        driver.get("https://app.vwo.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");

        WebElement usernameInputBox = driver.findElement(By.id("login-username"));
        usernameInputBox.sendKeys("admin@abc.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("abc@123");

        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorText = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorText.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }


    @Test
    public static void VWOLoginPositive(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/");

        WebElement usernameInputBox = driver.findElement(By.id("login-username"));
        usernameInputBox.sendKeys("vwo@1secmail.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("Vwo@1234");

        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String dashboardText = driver.findElement(By.cssSelector("[data-qa='lufexuloga']")).getText();
        Assert.assertEquals(dashboardText, "V W");

        WebElement user_icon = driver.findElement(By.xpath("(//img[@alt='V W'])[2]"));
        user_icon.click();
        WebElement logoutBtn = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu-list Miw(140px)\"]/li[2]"));
        logoutBtn.click();

        driver.quit();
    }
}
