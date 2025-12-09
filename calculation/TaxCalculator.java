package com.tax.calculation;


import java.util.*;

import com.tax.calculation.models.Property;
import com.tax.calculation.models.Vehicle;
import com.tax.calculation.services.PropertyService;
import com.tax.calculation.services.VehicleService;

public class TaxCalculator {
	 
	 public static HashMap<String,List<Property>> properties=new HashMap<>();
	 public static HashMap<String,List<Vehicle>> vehicles=new HashMap<>();
	private static HashMap<String,String> users=new HashMap<>();
	static String username="";
	public static void main(String[] args) {
		users.put("santosh","123");
		while(true) {
		boolean loginAttempt=welcomeScreen();
			while(loginAttempt) {
				int choice=mainMenu();
				try {
				switch(choice) {
				case 1:
					propertyMenu();
					break;
				case 2:
					vehicleMenu();
					break;
				case 3:
					TotalTax.showTotalTax(username);
					break;
				case 4:
					loginAttempt=false;
					System.out.println("Logged out successfully");
					break;
				default:
					System.out.println("Invalid Choice");
				}
				}catch(Exception e) {
					  System.out.println("Invalid input. Kindly enter a number");
			            Read.sc.nextLine();
				}
			}
		}
	}
	public static boolean welcomeScreen() {
	 System.out.println("========================================================");
		 System.out.println("                 TAX CALCULATOR APP");
		 System.out.println("========================================================");
		 System.out.print("User Name -");
		  username=Read.sc.next();
		  System.out.print("Password -");
		  String password=Read.sc.next();
		  
		  properties.put(username,new ArrayList<Property>());
		
		  vehicles.put(username,new ArrayList<Vehicle>());
	  if(users.containsKey(username)&&users.get(username).equals(password)) {
		  System.out.println("\nLogin Successful");
		  return true;			  
		  }else {
			  System.out.println("\nInvalid Credentials");
			  return false;			  
		  }		
	}	
	public static int mainMenu() {
		System.out.println("1) PROPERTY TAX");
		System.out.println("2) VEHICLE TAX");
		System.out.println("3) TOTAL");
		System.out.println("4) EXIT");
		int choice=Read.sc.nextInt();
		return choice;
	}

   public static void propertyMenu() {
   	boolean flag=true;
		while(flag) {
			System.out.println("1) ADD PROPERTY DETAILS");
			System.out.println("2) CALCULATE PROPERTY TAX");
			System.out.println("3) DISPLAY ALL PROPERTIES");
			System.out.println("4) BACK TO MAIN MENU");
			int input=Read.sc.nextInt();
			switch(input) {
			case 1:
				PropertyService.addProperty(username);
				break;
			
			case 2:
				PropertyService.calculatePropertyTax(username);
				break;
			case 3:
				PropertyService.displayProperty(username);
				break;			
			case 4:
				flag=false;
				break;
			default:
				System.out.println("\nInvalid");
				
			}
			}			
		}
   public static void vehicleMenu() {
   	boolean flag=true;
   	while(flag) {
   		System.out.println("1) ADD VEHICLE DETAILS");
			System.out.println("2) CALCULATE VEHICLE TAX");
			System.out.println("3) DISPLAY ALL VEHICLES");
			System.out.println("4) BACK TO MAIN MENU");
			int ch=Read.sc.nextInt();
			switch(ch) {
			case 1:
				VehicleService.addVehicle(username);
				break;
			case 2:
				VehicleService.calculateVehicleTax(username);
				break;
			case 3:
				VehicleService.displayVehicle(username);
				break;
			case 4:
				flag=false;
				break;
			default:
				System.out.println("\nInvalid");
			}
   	}
   }
	
}