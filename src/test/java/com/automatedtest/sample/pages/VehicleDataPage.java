package com.automatedtest.sample.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automatedtest.sample.basepage.AbstractPage;
import com.automatedtest.sample.basepage.BasePage;

import io.cucumber.datatable.DataTable;




public class VehicleDataPage extends AbstractPage {
	private static final String PAGE_HOME_URL = "http://sampleapp.tricentis.com/101/app.php";
    private static final By BY_SEARCH_FIELD = By.name("[kW]");
	private WebElement automobile = getDriver().findElement(By.xpath("//*[@id='nav_automobile']"));
    private List<VehicleData> vehicles = new ArrayList<>();
	private VehicleData vehicle;

	public VehicleDataPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

	
    
	Select dropdownMake = new Select(getDriver().findElement(By.xpath("//*[@id='make']")));
    
	
	public void ClickAutomobile()
	{
		automobile.click();
	}
	public void AddVehicleMakeRadomically()
	{
		List<WebElement> options = getDriver().findElements(By.xpath("//*[@role='menu']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();

	}
	public void enterSearchPhrase(String phrase) {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_FIELD));
        searchField.sendKeys(phrase);
        searchField.submit();
    }
	
	public void FillEnginePerformance(String performance)
	{
		vehicle = new VehicleData();
		vehicle.setPerformance(performance);
	}
	
	public void AddNumberOfSeatsRandomically()
	{
		List<WebElement> options = getDriver().findElements(By.xpath("//*[@id='numberofseats']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();
	}
	public void AddFuelTypeRandomically()
	{
		List<WebElement> options = getDriver().findElements(By.xpath("//*[@id='fuel']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();
	}
	
	public void FillAllFields(DataTable table)
	{
		List<String>data = table.asList();
		getDriver().findElement(By.xpath("//*[@id='make']")).sendKeys(data.get(0));
		getDriver().findElement(By.xpath("//*[@id='engineperformance']")).sendKeys(data.get(1));
		getDriver().findElement(By.xpath("//*[@id='dateofmanufacture']")).sendKeys(data.get(2));
	    getDriver().findElement(By.xpath("//*[@id='numberofseats']")).sendKeys(data.get(3));
		getDriver().findElement(By.xpath("//*[@id='fuel']")).sendKeys(data.get(4));
	    getDriver().findElement(By.xpath("//*[@id='listprice']")).sendKeys(data.get(5));
		getDriver().findElement(By.xpath("//*[@id='licenseplatenumber']")).sendKeys(data.get(6));
		getDriver().findElement(By.xpath("//*[@id='annualmileage']")).sendKeys(data.get(7));

	}

    public void ClickNextButton()
	{
    	WebElement nextButton = getDriver().findElement(By.xpath("//*[@id='nextenterinsurantdata'] | //*[@id='nextenterproductdata'] | //*[@id='nextselectpriceoption'] | //*[@id='nextsendquote']"));
		nextButton.click();
	}
	public void addVehicle(VehicleData vehicle) {
		vehicles.add(vehicle);
    }
	private static int getRandomNumberInBetween(int lowerBound, int upperBound) {
        Random r = new Random();
        return (r.nextInt(upperBound) + lowerBound);
    }

}
