package com.tax.calculation.services;


import java.util.List;

import com.tax.calculation.Read;
import com.tax.calculation.TaxCalculator;
import com.tax.calculation.models.Property;
 
public class PropertyService {
	 static String pline="==============================================================================";
	static int propertyId=1;
	public static void addProperty(String username) {
		
		System.out.println("--- ADD PROPERTY ---");
		Property p=new Property();
		
		 System.out.print("ENTER THE BASE VALUE OF LAND: ");
		    double baseValue = Read.sc.nextDouble();
		    if (baseValue <= 0) {
		        System.out.println(" Invalid Base Value! It must be a positive non-zero number.");
		        return;  
		    }
		    p.setBaseValue(baseValue);
		    System.out.print("ENTER THE BUILT-UP AREA OF LAND: ");
		    p.setBuiltUpArea(Read.sc.nextDouble());
		    System.out.print("ENTER THE AGE OF LAND IN YEARS: ");
		    double age = Read.sc.nextDouble();
		    if (age <= 0) {
		        System.out.println(" Invalid Age! It must be a positive non-zero number.");
		        return;
		    }
		    p.setAgeOfConstruction(age);
 
		    System.out.print("IS THE LAND LOCATED IN CITY? (Y:YES, N:NO): ");
		    char city = Character.toUpperCase(Read.sc.next().charAt(0));
 
		    if (city != 'Y' && city != 'N') {
		        System.out.println(" Invalid Input! Please enter only Y or N.");
		        return;
		    }
		    p.setIsCity(city);
		    p.setId(propertyId++);
		TaxCalculator.properties.get(username).add(p);
		}
	
	public static void calculatePropertyTax(String username) {
		List<Property> prop=TaxCalculator.properties.get(username);
		 if (prop == null || prop.isEmpty()) {
		        System.out.println("No properties found. Please add a property first.");
		        return;
		    }
		 displayProperty(username);
			System.out.println("ENTER THE PROPERTY ID");
			int id=Read.sc.nextInt();
			double propertyTax=0.0;
			Property p=null;
		for(Property x:prop) {
			if(x.getId()==id) {
				p=x;
				break;
			}
		}
		if(p==null) {
			System.out.println("NO PROPERTY AVAILABLE WITH ENTERED ID");
			return;
		}
			double area=p.getBuiltUpArea();
			double age=p.getAgeOfConstruction();
			double value=p.getBaseValue();
			char loc=p.getIsCity();
			if(loc=='Y') {
				propertyTax=(area*age*value)+(0.5*area);
				
			}else {
				propertyTax=area*age*value;
	
		}
		p.setPropertyTax(propertyTax);	
	}
	
	public static void displayProperty(String username) {
		System.out.println(pline);
		String propFormat="%5s %15s %15s %12s %10s %15.2f%n";
		Property p;
		List<Property> prop=TaxCalculator.properties.get(username);
		System.out.printf("%5s %15s %15s %12s %10s %15s%n","ID","BUILT-UP AREA","BASE PRICE","AGE(YEARS)","IN CITY","PROPERTY TAX");
		System.out.println(pline);
		for(Property properties:prop) {
			System.out.printf(propFormat,
					properties.getId(),
					properties.getBuiltUpArea(),
					properties.getBaseValue(),
					properties.getAgeOfConstruction(),
					properties.getIsCity(),
					properties.getPropertyTax());
 
		}
		System.out.println(pline);
	}
	
}
 
 