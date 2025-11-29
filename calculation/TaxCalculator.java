package com.tax.calculation;

import java.util.*;

public class TaxCalculator {
	private static final List<Property> properties=new ArrayList<>();
	
	private static final Map<String,String> users=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		welcomeScreen();
		clearScreen();
		mainMenuScreen();
	

	}
	public static void welcomeScreen() {

		 System.out.println("========================================================");
		 System.out.println("                 TAX CALCULATOR APP");
		 System.out.println("========================================================");
		 System.out.print("User Name -");
		  String userName=Read.sc.nextLine().trim();
		  System.out.print("Password -");
		  String password=Read.sc.nextLine().trim();
		  users.put(userName,password);
		  System.out.println("\nLogin successful for user: " + userName);
		 
	}

    private static void clearScreen() {     
        System.out.flush();
    }
    public static void mainMenuScreen() {
		while(true) {
			System.out.println("1) PROPERTY TAX");
			System.out.println("2) VEHICLE TAX");
			System.out.println("3) TOTAL");
			System.out.println("4) EXIT");
			int choice=Read.sc.nextInt();
			switch(choice) {
			case 1->{
				propertyScreen();
				System.out.println("property tax");
			}
			case 2->{
				//vehicleScreen();//to be implemented
				System.out.println("vehicle tax");
			}
			case 3->{
				
				System.out.println("total");
			}
			case 4->{
				System.out.println("exiting the application Goodbye! ");
			}
			}
			
			
		}
	}
	public static void propertyScreen() {
		while(true) {
			System.out.println("1) ADD PROPERTY DETAILS");
			System.out.println("2) CALCULATE PROPERTY TAX");
			System.out.println("3) DISPLAY ALL PROPERTIES");
			System.out.println("4) BACK TO MAIN MENU");
			int input=Read.sc.nextInt();
			switch(input) {
			case 1->{addProperties();}
			case 2->{
				
				System.out.println("vehicle tax");
			}
			case 3->{
				displayProperties();
			}
			case 4->{
				System.out.println("exiting the application Goodbye! ");
			}
			}
	}
	

}
	public static void addProperties() {
		System.out.println("--- ADD PROPERTY ---");
		System.out.print("ENTER THE ID-");
		int id=Read.sc.nextInt();
		System.out.print("ENTER THE BASE VALUE OF LAND-");
		double baseValue=Read.sc.nextDouble();
		System.out.print("ENTER THE BUILT-UP AREA OF LAND-");
		double builtUpArea=Read.sc.nextDouble();
		System.out.print("ENTER THE AGE OF LAND IN YEARS-");
		int ageOfConstruction=Read.sc.nextInt();
		System.out.print("IS THE LAND LOCATED IN CITY?(Y:YES,N:NO)-" );
		String isCity=Read.sc.next();
		Property p=new Property(id,builtUpArea,baseValue,isCity,ageOfConstruction);
		properties.add(p);
		
	}
	public static void displayProperties() {
		
	}
}

