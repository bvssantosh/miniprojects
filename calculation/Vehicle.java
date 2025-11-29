package com.tax.calculation;

public class Vehicle {
	private String registrationNumber;
	private String brandOfVehicle;
	private double purchaseCost;
	private int maxVelocity;
	private int noOfSeats;
	private int fuelType;
	public Vehicle(){
		
	}
	
	public Vehicle(String registrationNumber, String brandOfVehicle, double purchaseCost, int maxVelocity,
			int noOfSeats, int fuelType) {
		super();
		this.registrationNumber = registrationNumber;
		this.brandOfVehicle = brandOfVehicle;
		this.purchaseCost = purchaseCost;
		this.maxVelocity = maxVelocity;
		this.noOfSeats = noOfSeats;
		this.fuelType = fuelType;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getBrandOfVehicle() {
		return brandOfVehicle;
	}
	public void setBrandOfVehicle(String brandOfVehicle) {
		this.brandOfVehicle = brandOfVehicle;
	}
	public double getPurchaseCost() {
		return purchaseCost;
	}
	public void setPurchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	public int getMaxVelocity() {
		return maxVelocity;
	}
	public void setMaxVelocity(int maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getFuelType() {
		return fuelType;
	}
	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", brandOfVehicle=" + brandOfVehicle
				+ ", purchaseCost=" + purchaseCost + ", maxVelocity=" + maxVelocity + ", noOfSeats=" + noOfSeats
				+ ", fuelType=" + fuelType + "]";
	}

	

}
