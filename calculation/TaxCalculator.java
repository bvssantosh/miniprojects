package com.tax.calculation;

import java.util.*;

public class TaxCalculator {
	 static String pline="==============================================================================";
	 static String vline="==================================================================================================================";
	 static String tline="+---------------------------------------------------------------+";
	 static HashMap<String,List<Property>> properties=new HashMap<>();
	 static HashMap<String,List<Vehicle>> vehicles=new HashMap<>();
	private static HashMap<String,String> users=new HashMap<>();
	static int vehicleId=0;
	static int propertyId=1;
	static String username="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub	

		users.put("santosh","123");
		while(true) {
		boolean loginAttempt=welcomeScreen();
			while(loginAttempt) {
				int choice=mainMenu();
				switch(choice) {
				case 1:
					propertyMenu();
					break;
				case 2:
					vehicleMenu();
					break;
				case 3:
					showTotalTax();
					break;
				case 4:
					loginAttempt=false;
					System.out.println("Logged out successfully");
					break;
				default:
					System.out.println("Invalid Choice");
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
				addProperty();
				break;
			
			case 2:
				calculatePropertyTax();
				break;
			case 3:
				displayProperty();
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
				addVehicle();
				break;
			case 2:
				calculateVehicleTax();
				break;
			case 3:
				displayVehicle();
				break;
			case 4:
				flag=false;
				break;
			default:
				System.out.println("\nInvalid");
			}
    	}
    }
	public static void addProperty() {
		System.out.println("--- ADD PROPERTY ---");
		Property p=new Property();
		p.setId(propertyId++);
		System.out.print("ENTER THE BASE VALUE OF LAND-");
		p.setBaseValue(Read.sc.nextDouble());
		System.out.print("ENTER THE BUILT-UP AREA OF LAND-");
		p.setBuiltUpArea(Read.sc.nextDouble());
		System.out.print("ENTER THE AGE OF LAND IN YEARS-");
		p.setAgeOfConstruction(Read.sc.nextDouble());
		System.out.print("IS THE LAND LOCATED IN CITY?(Y:YES,N:NO)-" );
		p.setIsCity(Read.sc.next().charAt(0));
		properties.get(username).add(p);
		
	}
	public static void calculatePropertyTax() {
		//if p==null it will throw exception i sfould handle it
		displayProperty();
		System.out.println("ENTER THE PROPERTY ID");
		int id=Read.sc.nextInt();
		double propertyTax=0.0;
		Property p=null;
		List<Property> prop=properties.get(username);
		
		for(Property x:prop) {
			if(x.getId()==id) {
				p=x;
				break;
			}
		}
		if(p==null) {
			System.out.println("NO PROPERTY AVAILABLE WITH ENTERED ID");
			
		}else {
			double area=p.getBuiltUpArea();
			double age=p.getAgeOfConstruction();
			double value=p.getBaseValue();
			char loc=p.getIsCity();
			if(loc=='Y') {
				propertyTax=(area*age*value)+(0.5*area);
				
			}else {
				propertyTax=area*age*value;
				
			}
		}
		p.setPropertyTax(propertyTax);
		//System.out.println(p);
		
		
		
		
	}
	public static void calculateVehicleTax() {
		displayVehicle();
		Vehicle v=null;
		double vehicleTax=0.0;
		System.out.println("ENTER THE REGISTRATION NUMBER");
		String regNo=Read.sc.next();
		List<Vehicle> vehi=vehicles.get(username);
		for(Vehicle vehicle:vehi) {
			if(vehicle.getRegistrationNumber().equals(regNo)) {
				
				v=vehicle;
				break;
			}
		}
		if(v==null) {
			System.out.println("NO VEHICLE AVAILABLE WITH ENTERED REGISTRATION NUMBER");
		}else {
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
			
		}
		v.setVehicleTax(vehicleTax);
		//System.out.println(v);
	}
	public static void addVehicle() {
		System.out.println("---ADD VEHICLE---");
		Vehicle v=new Vehicle();
		
		System.out.println("ENTER THE VEHICLE REGISTRATION NUMBER-");
		v.setRegistrationNumber(Read.sc.next());
		System.out.println("ENTER BRAND OF THE VEHICLE");
		v.setBrandOfVehicle(Read.sc.next());
		System.out.println("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE(KMPH)-");
		v.setMaxVelocity(Read.sc.nextInt());
		System.out.println("ENTER CAPACITY(NUMBER OF SEATS) OF THE VEHICLE -");
		v.setNoOfSeats(Read.sc.nextInt());
		System.out.println("CHOOSE THE TYPE OF THE VEHICLE-");
		System.out.println("1.PETROL DRIVEN");
		System.out.println("2.DIESEL DRIVEN");
		System.out.println("3.CNG/LPG DRIVEN");
		int fuel=Read.sc.nextInt();
		switch(fuel) {
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
			System.out.println("ENTER VALID VEHICLE TYPE");
			
		}
		System.out.println("ENTER THE PURCHASE COST OF THE VEHICLE");
		v.setPurchaseCost(Read.sc.nextInt());
		vehicles.get(username).add(v);	
	}
	public static void displayVehicle() {
		System.out.println(vline);
		String vehicleFormat="%15s %15s %15s %15s %15s %15s %15s%n";
		List<Vehicle> v=vehicles.get(username);
		System.out.printf(vehicleFormat,"REGISTRATION NO","BRAND","MAX. VELOCITY","NO . OF SEATS","VEHICLE TYPE","PURCHASE COST","VEHICLE TAX");
		System.out.println(vline);
		for(Vehicle vehicle:v) {
			System.out.printf(vehicleFormat,
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
	public static void displayProperty() {
		System.out.println(pline);
		String propFormat="%5s %15s %15s %12s %10s %15s%n";
		Property p;
		List<Property> prop=properties.get(username);
		System.out.printf(propFormat,"ID","BUILT-UP AREA","BASE PRICE","AGE(YEARS)","IN CITY","PROPERTY TAX");
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
	public static void showTotalTax() {
		List<Property> p=properties.get(username);
		int totalProperty=p.size();
		List<Vehicle> v=vehicles.get(username);
		int totalVehicles=v.size();
		double propertiesSum=totalPropertiesSum();
		double vehiclesSum=totalVehiclesSum();
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
	public static double totalPropertiesSum() {
		double sum=0.0;
		List<Property> p=properties.get(username);
		for(Property p1:p) {
			sum=sum+p1.getPropertyTax();
		}
		return sum;
		
	}
	public static double totalVehiclesSum() {
		double sum=0.0;
		List<Vehicle> p=vehicles.get(username);
		for(Vehicle p1:p) {
			sum=sum+p1.getVehicleTax();
		}
		return sum;
		
	}
}

