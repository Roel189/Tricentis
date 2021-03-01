package com.automatedtest.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automatedtest.sample.basepage.AbstractPage;

public class SelectPriceOptionPage extends AbstractPage {
	public SelectPriceOptionPage(WebDriver driver) {
        super(driver);
    }
	private WebElement selectSilver = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[1]/span"));
	private WebElement selectGold = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[2]/span"));
	private WebElement selectPlatinum = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[3]/span"));
	private WebElement selectUltimate = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[4]/span"));
	
	public void SelectPlan(String plan)
	{
	
		switch (plan) {
        case "Silver":
            selectSilver.click();
            break;
        case "Gold":
            selectGold.click();
            break;
        case "Platinum":
        	selectPlatinum.click();
            break;
        case "Ultimate":
        	selectUltimate.click();
            break;
		}
	}
	public void ClickNextButton()
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nextsendquote']")));
				WebElement nextButton = getDriver().findElement(By.xpath("//*[@id='nextsendquote']"));
		nextButton.click();
	}

}
