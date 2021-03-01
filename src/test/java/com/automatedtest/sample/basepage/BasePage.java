package com.automatedtest.sample.basepage;

import com.automatedtest.sample.infrastructure.driver.Setup;
import com.automatedtest.sample.infrastructure.driver.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
    public String captureTextToast() {
        return driver.findElement(By.id("//*[@id='insurance-form']")).getText();
    }
}
