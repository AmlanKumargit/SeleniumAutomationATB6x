package com.amlankumar.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MakeMyTrip {

    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0


    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement closebtn = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closebtn.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        WebElement toCity = driver.findElement(By.id("toCity"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        actions.moveToElement(fromCity).click().sendKeys(fromCity,"Mumbai").keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        actions.moveToElement(toCity).click().build().perform();
        Thread.sleep(4000);

        //ul.react-autosuggest__suggestions-list > li

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));


        for(WebElement e: list_auto_complete){
            if(e.getText().contains("Chennai")){
                e.click();
                Thread.sleep(2000);
                break;
            }


        }



        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
