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

public class SendQuotePage extends AbstractPage {
	public SendQuotePage(WebDriver driver) {
        super(driver);
    }

	private WebElement sendButton = getDriver().findElement(By.xpath("//*[@id='sendemail']"));
	private WebElement email = getDriver().findElement(By.xpath("//*[@id='email']"));
	private WebElement phone = getDriver().findElement(By.xpath("//*[@id='phone']"));
	private WebElement userName = getDriver().findElement(By.xpath("//*[@id='username']"));
	private WebElement password = getDriver().findElement(By.xpath("//*[@id='password']"));
	private WebElement confirmPassword = getDriver().findElement(By.xpath("//*[@id='confirmpassword']"));
	private WebElement comments = getDriver().findElement(By.xpath("//*[@id='Comments']"));

	public void FillAllFields(DataTable table)
	{
		List<Map<String, String>> data = table.asMaps(String.class, String.class);

		email.sendKeys(data.get(0).get("Email"));
		phone.sendKeys(data.get(0).get("Phone"));
		userName.sendKeys(data.get(0).get("Username"));
		password.sendKeys(data.get(0).get("Password"));
		confirmPassword.sendKeys(data.get(0).get("Confirm Password"));
		comments.sendKeys(data.get(0).get("Comments"));

	}



	public void ClickSendButton()
	{
	   sendButton.click();
	}
	public String ReturnMessage()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[7]/div/button")));
		WebElement message = getDriver().findElement(By.xpath("/html/body/div[4]/h2"));
		return message.getText();
	}

}
