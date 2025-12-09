package com.tax.calculation.models;

public class Vehicle {
	private String registrationNumber;
	private String brandOfVehicle;
	private int purchaseCost;
	private Integer maxVelocity;
	private Integer noOfSeats;
	private FuelType fuelType;
	//private int id;
	private double vehicleTax;
	public Vehicle(){
		
	}
	public Vehicle(String registrationNumber, String brandOfVehicle, int purchaseCost, Integer maxVelocity,
			Integer noOfSeats, FuelType fuelType, double vehicleTax) {
		super();
		this.registrationNumber = registrationNumber;
		this.brandOfVehicle = brandOfVehicle;
		this.purchaseCost = purchaseCost;
		this.maxVelocity = maxVelocity;
		this.noOfSeats = noOfSeats;
		this.fuelType = fuelType;
		//this.id = id;
		this.vehicleTax = vehicleTax;
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
	public int getPurchaseCost() {
		return purchaseCost;
	}
	public void setPurchaseCost(int purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	public Integer getMaxVelocity() {
		return maxVelocity;
	}
	public void setMaxVelocity(Integer maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public double getVehicleTax() {
		return vehicleTax;
	}
	public void setVehicleTax(double vehicleTax) {
		this.vehicleTax = vehicleTax;
	}
	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", brandOfVehicle=" + brandOfVehicle
				+ ", purchaseCost=" + purchaseCost + ", maxVelocity=" + maxVelocity + ", noOfSeats=" + noOfSeats
				+ ", id=" + ", vehicleTax=" + vehicleTax + "]";
	}
	
	
	
	
	

}
