package com.automatedtest.sample.basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automatedtest.sample.infrastructure.driver.Setup;
import com.automatedtest.sample.infrastructure.driver.Wait;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = Setup.driver;

    }

    protected WebDriver getDriver() {
        return Setup.driver;
    }

    protected WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

    public void navigateToHomePage() {}
    public void enterSearchPhrase(String phrase) {}
    public boolean pageTitleContains(String phrase) {return true;}
	
}
