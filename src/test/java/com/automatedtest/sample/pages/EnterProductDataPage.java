package com.automatedtest.sample.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automatedtest.sample.basepage.AbstractPage;

import io.cucumber.datatable.DataTable;

public class EnterProductDataPage extends AbstractPage{
	public EnterProductDataPage(WebDriver driver) {
        super(driver);
	}
        private WebElement startDate = getDriver().findElement(By.xpath("//*[@id='startdate']"));
    	private WebElement insuranceSum = getDriver().findElement(By.xpath("//*[@id='insurancesum']"));
    	private WebElement meritRating = getDriver().findElement(By.xpath("//*[@id='meritrating']"));
    	private WebElement damageInsurance = getDriver().findElement(By.xpath("//*[@id='damageinsurance']"));
    	private WebElement optionalProducts = getDriver().findElement(By.xpath("//*[@id='selectultimate']"));
    	private WebElement legalDefenseInsurance = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[3]/div[5]/p/label[2]/span"));
    	private WebElement euroProtection = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[3]/div[5]/p/label[1]/span"));
    	private WebElement courtesyCar = getDriver().findElement(By.xpath("//*[@id='courtesycar']"));

    	public void FillAllFields(DataTable table)
    	{
    		List<Map<String, String>> data = table.asMaps(String.class, String.class);

    		startDate.sendKeys(data.get(0).get("Start Date"));
    		insuranceSum.sendKeys(data.get(0).get("Insurance Sum"));
    		meritRating.sendKeys(data.get(0).get("Merit Rating"));
    		damageInsurance.sendKeys(data.get(0).get("Damage Insurance"));
    		OptionalProducts(data.get(0).get("Optional Products"));
    	    courtesyCar.sendKeys(data.get(0).get("Courtesy Card"));

    	}
    	public void OptionalProducts(String option)
    	{
    		
    		switch (option) {
            case "Euro Protection":
            	euroProtection.click();
                break;
            case "Legal Defense Insurance":
            	legalDefenseInsurance.click();
            	break;
    		}
    	}
    	public void ClickNextButton()
    	{
        	WebElement nextButton = getDriver().findElement(By.xpath("//*[@id='nextselectpriceoption']"));
    		nextButton.click();
    	}
}
