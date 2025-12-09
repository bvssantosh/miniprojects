package com.tax.calculation;

import java.util.List;

import com.tax.calculation.models.Property;
import com.tax.calculation.models.Vehicle;

public class TotalTax {
	static String tline="+---------------------------------------------------------------+";
	public static void showTotalTax(String username) {
		List<Property> p=TaxCalculator.properties.get(username);
		int totalProperty=p.size();
		List<Vehicle> v=TaxCalculator.vehicles.get(username);
		int totalVehicles=v.size();
		double propertiesSum=totalPropertiesSum(username);
		double vehiclesSum=totalVehiclesSum(username);
		int totalQuantity=totalProperty+totalVehicles;
		double totalSum=propertiesSum+vehiclesSum;
		System.out.println(tline);
		String totalTaxFormat="| %8s %15s %15s %20s |%n";
		
		System.out.printf(totalTaxFormat,"SR. NO.","PARTICULAR","QUANTITY","TAX");
		System.out.println(tline);
		System.out.printf(totalTaxFormat,
				"1",
				"PROPERTIES",
				totalProperty,
				propertiesSum);
		
		System.out.printf(totalTaxFormat,
				"2",
				"VEHICLES",
				totalVehicles,
				vehiclesSum);
		System.out.println(tline);
		System.out.printf(totalTaxFormat,
				"TOTAL",
				"----------",
				totalQuantity,
				totalSum);		
		System.out.println(tline);		
				
		
	}
	public static double totalPropertiesSum(String username) {
		double sum=0.0;
		List<Property> p=TaxCalculator.properties.get(username);
		for(Property p1:p) {
			sum=sum+p1.getPropertyTax();
		}
		return sum;
		
	}
	public static double totalVehiclesSum(String username) {
		double sum=0.0;
		List<Vehicle> p=TaxCalculator.vehicles.get(username);
		for(Vehicle p1:p) {
			sum=sum+p1.getVehicleTax();
		}
		return sum;
		
	}
}
