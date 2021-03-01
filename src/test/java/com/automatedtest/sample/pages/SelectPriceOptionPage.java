package com.automatedtest.sample.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automatedtest.sample.basepage.AbstractPage;
import io.cucumber.datatable.DataTable;

public class SelectPriceOptionPage extends AbstractPage {
	public SelectPriceOptionPage(WebDriver driver) {
        super(driver);
    }
	private WebElement selectSilver = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[1]/span"));
	private WebElement selectGold = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[2]/span"));
	private WebElement selectPlatinum = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[3]/span"));
	private WebElement selectUltimate = getDriver().findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[4]/span"));
	
	public void SelectPrice(DataTable table)
	{
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		String plan = data.get(0).get("Price Option");
	
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
