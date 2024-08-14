package com.amlankumar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Demo {

    @Test
    public static void VWOLogin() {

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

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        Assert.assertEquals(driver.getTitle(),"Login - VWO");

        driver.quit();
    }

}
