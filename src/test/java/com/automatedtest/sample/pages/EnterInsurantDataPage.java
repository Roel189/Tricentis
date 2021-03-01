package com.automatedtest.sample.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automatedtest.sample.basepage.AbstractPage;

import io.cucumber.datatable.DataTable;

public class EnterInsurantDataPage extends AbstractPage{
	public EnterInsurantDataPage(WebDriver driver) {
        super(driver);
	}
	
	private WebElement firstName = getDriver().findElement(By.xpath("//*[@id='firstname']"));
	private WebElement lastName = getDriver().findElement(By.xpath("//*[@id='lastname']"));
	private WebElement dateOfBirth = getDriver().findElement(By.xpath("//*[@id='birthdate']"));
	private WebElement genderMale = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[4]/p/label[1]/span"));
	private WebElement genderFemale = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[4]/p/label[2]/span"));
	private WebElement streetAddress = getDriver().findElement(By.xpath("//*[@id='streetaddress']"));
	private WebElement country = getDriver().findElement(By.xpath("//*[@id='country']"));
	private WebElement zipCode = getDriver().findElement(By.xpath("//*[@id='zipcode']"));
	private WebElement city = getDriver().findElement(By.xpath("//*[@id='city']"));
	private WebElement occupation = getDriver().findElement(By.xpath("//*[@id='occupation']"));
	private WebElement speeding = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label[1]/span"));
	private WebElement bungeeJumping = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label[2]/span"));
	private WebElement cliffDiving = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label[3]/span"));
	private WebElement skyDiving = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label[4]/span"));
	private WebElement other = getDriver().findElement(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label[5]/span"));
	private String hobby;
	public void FillAllFields(DataTable table)
	{
		List<String>data = table.asList();

		firstName.sendKeys(data.get(0));
		lastName.sendKeys(data.get(1));
		dateOfBirth.sendKeys(data.get(2));
		Gender(data.get(3));
		streetAddress.sendKeys(data.get(4));
	    country.sendKeys(data.get(5));
	    zipCode.sendKeys(data.get(6));
	    city.sendKeys(data.get(7));
	    occupation.sendKeys(data.get(8));
	    Hobbies(data.get(9));
	    

	}
	public void Gender(String gender)
	{
		switch (gender) {
        case "Male":
            genderMale.click();
            break;
        case "Female":
        	genderFemale.click();
        	break;
		}
		
	}
	public void Hobbies(String hobby)
	{
		switch (hobby) {
        case "Speeding":
            speeding.click();
            break;
        case "Bungee Jumping":
            bungeeJumping.click();
            break;
        case "Cliff Diving":
        	cliffDiving.click();
            break;
        case "Skydiving":
        	skyDiving.click();
            break;
        case "Other":
        	other.click();
            break;
		}
	}
	
	public void ClickNextButton()
	{
    	WebElement nextButton = getDriver().findElement(By.xpath("//*[@id='nextenterproductdata']"));
		nextButton.click();
	}
	
}
