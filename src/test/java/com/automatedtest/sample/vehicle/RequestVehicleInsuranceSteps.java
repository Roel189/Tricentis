package com.automatedtest.sample.vehicle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automatedtest.sample.basepage.AbstractPage;
import com.automatedtest.sample.pages.EnterInsurantDataPage;
import com.automatedtest.sample.pages.EnterProductDataPage;
import com.automatedtest.sample.pages.SelectPriceOptionPage;
import com.automatedtest.sample.pages.SendQuotePage;
import com.automatedtest.sample.pages.VehicleDataPage;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestVehicleInsuranceSteps   {
	private VehicleDataPage vehiclePage;
	private EnterInsurantDataPage insurantDataPage;
	private EnterProductDataPage productDataPage;
	private SendQuotePage sendQuotePage;
	private SelectPriceOptionPage selectPriceOptionPage;
    private AbstractPage searchPage;
	private VehicleDataPage vehicleData  ;
    private WebDriver driver;
	@Given("^The user wants to submit a vehicle insurance request")
	public void GivenTheUserWantsToSubmitAVehicleInsuranceRequest() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}
	@When("^The user fills the Vehicle Data Form$")
    public void WhenTheUserFillsTheVehicleData(DataTable table) throws Throwable {
		
		vehiclePage= new VehicleDataPage(driver);
		this.vehiclePage.ClickAutomobile();
		this.vehiclePage.FillAllFields(table);
		vehiclePage.ClickNextButton();
    }
	@When("^fills the Enter Insurant Data Form$")
	public void fillsTheEnterInsurantData(DataTable table) {
		insurantDataPage= new EnterInsurantDataPage(driver);
		insurantDataPage.FillAllFields(table);
		insurantDataPage.ClickNextButton();

	}
	@When("fills Enter Product Data Form")
	public void fillsEnterProductData(DataTable table) {
		productDataPage= new EnterProductDataPage(driver);
		productDataPage.FillAllFields(table);
		productDataPage.ClickNextButton();
	}
	@When("selects Price Option")
	public void fillsSelectPriceOption(DataTable table) {
		selectPriceOptionPage= new SelectPriceOptionPage(driver);
		selectPriceOptionPage.SelectPrice(table);
		selectPriceOptionPage.ClickNextButton();
	}
	@When("fills Send Quote")
	public void fillsSendQuote(DataTable table) {
		sendQuotePage = new SendQuotePage(driver);
		sendQuotePage.FillAllFields(table);
		sendQuotePage.ClickSendButton();

	}

	@Then("The system notifies that email has been sent")
	public void theSystemReturnsInTheScreen() {
	Assert.assertEquals("Sending e-mail success!", sendQuotePage.ReturnMessage());	}
	
}