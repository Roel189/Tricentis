package com.automatedtest.sample.pages;

import java.util.List;

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
		List<String>data = table.asList();

		email.sendKeys(data.get(0));
		phone.sendKeys(data.get(1));
		userName.sendKeys(data.get(2));
		password.sendKeys(data.get(3));
		confirmPassword.sendKeys(data.get(4));
		comments.sendKeys(data.get(5));

	}



	public void ClickSendButton()
	{
	   sendButton.click();
	}
	public String ReturnMessage()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("/html/body/div[4]/div[7]/div/button")));
		WebElement message = getDriver().findElement(By.xpath("/html/body/div[4]/h2"));
		return message.toString();
	}

}
