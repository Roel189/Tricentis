package com.automatedtest.sample.pages;

import org.openqa.selenium.WebElement;

public class VehicleData {
	private String make;
	private String model;
	private String cylinderCapacity;
	private String performance;
	private String dateOfManufacture;
	private String seats;
	private String payload;
	private String totalWeight;
	private String listPrice;
	private String annualMileage;
	private String fuelType;
	
	public VehicleData() {
	
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCylinderCapacity() {
		return cylinderCapacity;
	}
	public void setCylinderCapacity(String cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
		
	}
	public String getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getListPrice() {
		return listPrice;
	}
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}
	public String getAnnualMileage() {
		return annualMileage;
	}
	public void setAnnualMileage(String annualMileage) {
		this.annualMileage = annualMileage;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getRightHandDrive() {
		return rightHandDrive;
	}
	public void setRightHandDrive(String rightHandDrive) {
		this.rightHandDrive = rightHandDrive;
	}
	private String rightHandDrive;



}
