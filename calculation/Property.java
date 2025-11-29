package com.tax.calculation;

public class Property {
	private int id;
	private double builtUpArea;
	private double baseValue;
	private String isCity;
	private int ageOfConstruction;
	 public Property() {
		 
	 }
	public Property(int id, double builtUpArea, double baseValue, String isCity, int ageOfConstruction) {
		//super();
		this.id = id;
		this.builtUpArea = builtUpArea;
		this.baseValue = baseValue;
		this.isCity = isCity;
		this.ageOfConstruction = ageOfConstruction;
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
	public String isCity() {
		return isCity;
	}
	public void setCity(String isCity) {
		this.isCity = isCity;
	}
	public int getAgeOfConstruction() {
		return ageOfConstruction;
	}
	public void setAgeOfConstruction(int ageOfConstruction) {
		this.ageOfConstruction = ageOfConstruction;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", builtUpArea=" + builtUpArea + ", baseValue=" + baseValue + ", isCity=" + isCity
				+ ", ageOfConstruction=" + ageOfConstruction + "]";
	}
	
	 
}
