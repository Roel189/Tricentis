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

import java.util.Map;



public class VehicleDataPage extends BasePage {
	private static final String PAGE_HOME_URL = "http://sampleapp.tricentis.com/101/app.php";
    private static final By BY_SEARCH_FIELD = By.name("[kW]");
	//private WebElement automobile = driver.findElement(By.xpath("//*[@id='nav_automobile']"));
    private List<VehicleData> vehicles = new ArrayList<>();
	private VehicleData vehicle;

	public VehicleDataPage(WebDriver driver) {
        //super(driver);
    }
	public VehicleDataPage() {
        PageFactory.initElements(driver, this);
    }
	//public VehicleDataPage() {
    //}
	//public VehicleDataPage() {
      //  PageFactory.initElements(getDriver(), this);
    //}

    public void navigateToHomePage() {
    	driver.navigate().to(PAGE_HOME_URL);
    }
    
	//Select dropdownMake = new Select(getDriver().findElement(By.xpath("//*[@id='make']")));
    
	
	public void ClickAutomobile()
	{
		WebElement automobile = driver.findElement(By.xpath("//*[@id='nav_automobile']"));
		automobile.click();
	}
	public void AddVehicleMakeRadomically()
	{
		List<WebElement> options = driver.findElements(By.xpath("//*[@role='menu']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();

	}
	
	
	public void FillEnginePerformance(String performance)
	{
		vehicle = new VehicleData();
		vehicle.setPerformance(performance);
	}
	
	public void AddNumberOfSeatsRandomically()
	{
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='numberofseats']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();
	}
	public void AddFuelTypeRandomically()
	{
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='fuel']"));
		options.get(getRandomNumberInBetween(1, options.size() - 1)).click();
	}
	
	public void FillAllFields(DataTable table)
	{
		
		//List<String>data = table.asList();
		List<Map<String, String>> data = table.asMaps(String.class, String.class);

		driver.findElement(By.xpath("//*[@id='make']")).sendKeys(data.get(0).get("Make"));
		driver.findElement(By.xpath("//*[@id='engineperformance']")).sendKeys(data.get(0).get("Engine"));
		driver.findElement(By.xpath("//*[@id='dateofmanufacture']")).sendKeys(data.get(0).get("Manufacture Date"));
		driver.findElement(By.xpath("//*[@id='numberofseats']")).sendKeys(data.get(0).get("Seats"));
		driver.findElement(By.xpath("//*[@id='fuel']")).sendKeys(data.get(0).get("Fuel Type"));
		driver.findElement(By.xpath("//*[@id='listprice']")).sendKeys(data.get(0).get("Price"));
		driver.findElement(By.xpath("//*[@id='licenseplatenumber']")).sendKeys(data.get(0).get("License"));
		driver.findElement(By.xpath("//*[@id='annualmileage']")).sendKeys(data.get(0).get("Annual Mileage"));

	}

    public void ClickNextButton()
	{
    	WebElement nextButton = driver.findElement(By.xpath("//*[@id='nextenterinsurantdata'] | //*[@id='nextenterproductdata'] | //*[@id='nextselectpriceoption'] | //*[@id='nextsendquote']"));
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
