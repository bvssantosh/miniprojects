package com.tax.calculation.services;


import java.util.List;

import com.tax.calculation.Read;
import com.tax.calculation.TaxCalculator;
import com.tax.calculation.models.FuelType;
import com.tax.calculation.models.Vehicle;
 
public class VehicleService {
	static String vline="==================================================================================================================";
	public static void calculateVehicleTax(String username) {
		List<Vehicle> vehi=TaxCalculator.vehicles.get(username);
		if(vehi==null||vehi.isEmpty()) {
			System.out.println("No vehicles found,please enter vehicles first");
			return;			
		}
		VehicleService.displayVehicle(username);
		Vehicle v=null;
		double vehicleTax=0.0;
		System.out.println("ENTER THE REGISTRATION NUMBER");
		String regNo=Read.sc.next();		
		for(Vehicle vehicle:vehi) {
			if(vehicle.getRegistrationNumber().equals(regNo)) {			
				v=vehicle;
				break;
			}
		}
		if(v==null) {
			System.out.println("NO VEHICLE AVAILABLE WITH ENTERED REGISTRATION NUMBER");
			return;
		}
			double speed=v.getMaxVelocity();
			double capacity=v.getNoOfSeats();
			double cost=v.getPurchaseCost();
			if(v.getFuelType()==FuelType.PETROL) {
				vehicleTax=speed+capacity+(0.1*cost);
				
			}else if(v.getFuelType()==FuelType.DIESEL) {
				vehicleTax=speed+capacity+(0.11*cost);
				
			}else {
				vehicleTax=speed+capacity+(0.12*cost);
			}	
		v.setVehicleTax(vehicleTax);
		
	}
	public static void addVehicle(String username) {
		  System.out.println("--- ADD VEHICLE ---");
		    Vehicle v = new Vehicle();		  
		    System.out.print("ENTER THE VEHICLE REGISTRATION NUMBER- ");
		    String reg = Read.sc.next();
		    if (!reg.matches("[0-9]{4}")) {
		        System.out.println(" Registration number must be exactly 4 digits.");
		        return;
		    }
		    if (reg.equals("0000")) {
		        System.out.println(" Registration number cannot be 0000.");
		        return;
		    }
		    v.setRegistrationNumber(reg);		  
		    System.out.print("ENTER BRAND OF THE VEHICLE");
		    String brand = Read.sc.next();
		    if (!brand.matches("[a-zA-Z]+")) {
		        System.out.println(" Brand must contain only alphabets.");
		        return;
		    }
		    v.setBrandOfVehicle(brand);		   
		    System.out.print("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE(KMPH)- ");
		    int velocity = Read.sc.nextInt();
		    if (velocity < 120 || velocity > 300) {
		        System.out.println("Velocity must be between 120 and 300 kmph.");
		        return;
		    }
		    v.setMaxVelocity(velocity);		   
		    System.out.print("ENTER CAPACITY(NUMBER OF SEATS) OF THE VEHICLE -");
		    int seats = Read.sc.nextInt();
 
		    if (seats < 2 || seats > 50) {
		        System.out.println(" Number of seats must be between 2 and 50.");
		        return;
		    }
		    v.setNoOfSeats(seats);		  
		    System.out.println("CHOOSE THE TYPE OF THE VEHICLE-");
		    System.out.println("1. PETROL");
		    System.out.println("2. DIESEL");
		    System.out.println("3. CNG/LPG");
		    int fuel = Read.sc.nextInt();
		    switch (fuel) {
		        case 1:
		            v.setFuelType(FuelType.PETROL);
		            break;
		        case 2:
		            v.setFuelType(FuelType.DIESEL);
		            break;
		        case 3:
		            v.setFuelType(FuelType.CNG);
		            break;
		        default:
		            System.out.println(" Invalid fuel type selected. Must be 1, 2, or 3.");
		            return;
		    }		    
		    System.out.print("ENTER THE PURCHASE COST OF THE VEHICLE-");
		    int cost = Read.sc.nextInt();
		    if (cost < 50000 || cost > 1000000) {
		        System.out.println(" Purchase cost must be between ₹50,000 and ₹10,00,000.");
		        return;
		    }
		    v.setPurchaseCost(cost);
 
		    TaxCalculator.vehicles.get(username).add(v);	
	}
	public static void displayVehicle(String username) {
		System.out.println(vline);
		String vehicleFormat="%15s %15s %15s %15s %15s %15s %15.2f%n";
		List<Vehicle> v=TaxCalculator.vehicles.get(username);
		System.out.printf(vehicleFormat,"REGISTRATION NO","BRAND","MAX. VELOCITY","NO . OF SEATS","VEHICLE TYPE","PURCHASE COST","VEHICLE TAX");
		System.out.println(vline);
		for(Vehicle vehicle:v) {
			System.out.printf("%15s %15s %15s %15s %15s %15s %15s%n",
					vehicle.getRegistrationNumber(),
					vehicle.getBrandOfVehicle(),
					vehicle.getMaxVelocity(),
					vehicle.getNoOfSeats(),
					vehicle.getFuelType(),
					vehicle.getPurchaseCost(),
					vehicle.getVehicleTax());	
		}
		System.out.println(vline);	  
	}
}
