package com.tax.calculation;

public class Property {
	private int id;
	private double builtUpArea;
	private double baseValue;
	private char isCity;
	private double ageOfConstruction;
	private double propertyTax;
	
	public Property() {
		super();
		
	}
	
	public Property(int id, double builtUpArea, double baseValue, char isCity, double ageOfConstruction,
			double propertyTax) {
		super();
		this.id = id;
		this.builtUpArea = builtUpArea;
		this.baseValue = baseValue;
		this.isCity = isCity;
		this.ageOfConstruction = ageOfConstruction;
		this.propertyTax = propertyTax;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBuiltUpArea() {
		return builtUpArea;
	}
	public void setBuiltUpArea(double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}
	public double getBaseValue() {
		return baseValue;
	}
	public void setBaseValue(double baseValue) {
		this.baseValue = baseValue;
	}
	public char getIsCity() {
		return isCity;
	}
	

	public void setIsCity(char isCity) {
		this.isCity = isCity;
	}
	public double getAgeOfConstruction() {
		return ageOfConstruction;
	}
	public void setAgeOfConstruction(double ageOfConstruction) {
		this.ageOfConstruction = ageOfConstruction;
	}
	public double getPropertyTax() {
		return propertyTax;
	}
	public void setPropertyTax(double propertyTax) {
		this.propertyTax = propertyTax;
	}
	
	@Override
	public String toString() {
		return "Property [id=" + id + ", builtUpArea=" + builtUpArea + ", baseValue=" + baseValue + ", isCity=" + isCity
				+ ", ageOfConstruction=" + ageOfConstruction + ", propertyTax=" + propertyTax + "]";
	}
	
	 
}
