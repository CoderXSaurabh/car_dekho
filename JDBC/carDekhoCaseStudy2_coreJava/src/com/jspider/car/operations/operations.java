package com.jspider.car.operations;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspider.car.entity.car;
import com.jspider.car.main.menu;

public class operations {
	static Scanner sc = new Scanner(System.in);
	static menu m = new menu();
	static ArrayList<car> cars = new ArrayList<>();
	
//	View All Cars
	public static void viewcars(){
		viewCar v1 = new viewCar();
		v1.viewCar();
//		boolean flag =true;
//		for(car ca:cars) {
//			flag = false;
//			System.out.println(ca);
//		}
//		if(flag) {
//			System.out.println("No Car is Added....\n");
//		}
//		m.menumethod();
	}
//	Search Car 
	public static void searchCar() {
		boolean flag= true;
		while(flag) {
		System.out.println("WELCOME TO SEARCH CAR...");
		System.out.println("1) Search car By id \n2)Search Car By name\n3)Search Car By Brand\n4)Search Car By Color \n5)Search Car by price\n6)Back To Main Menu");
		int id=sc.nextInt();
		
		switch(id) {
		case 1:
			operations.searchCarById();
			break;
		case 2:
			operations.searchByName();
			break;
		case 3:
			operations.searchByBrand();
			break;
		case 4:
			operations.searchByColor();
			break;
		case 5:
			operations.searchByPrice();
			break; 	
		case 6:
			flag = false;
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		}
		
	}
	static int idgen = 1;
	public static void addCar() {
		System.out.println("Hello Operation add Car");
		boolean b = true;
		while (b) {
			System.out.println("How many cars you want to add: ");
			int choice = sc.nextInt();
			for(int i = 1;i<=choice;i++) {
				car Car = new car();
				System.out.println("Id of car is : "+idgen);
				Car.setId(idgen);
				idgen++;
//				Car.setId(sc.nextInt());
				System.out.println("Enter name : ");
				Car.setName(sc.next());
				System.out.println("Enter Brand : ");
				Car.setBrand(sc.next());
				System.out.println("Enter Fuel Type : ");
				Car.setFuelType(sc.next());
				System.out.println("Enter Color : ");
				Car.setColour(sc.next());
				System.out.println("Enter Price : ");
				Car.setPrice(sc.nextDouble());
				cars.add(Car);
				
			}
			b=false;
		}
			
	}
	
	
	
	
	
//	Search BY methods
	public static void searchCarById() {
		Boolean flag = true;
		System.out.println("Search car by id");
		System.out.println("Enter Id to Search");
		int id = sc.nextInt();
		for(car ca:cars) {
			if(ca.getId()==id) {
				
				System.out.println(ca);
			}	
			
		}
		if(flag = false) {
			System.out.println("Car Not Found");
		}
		
	}
	public static void searchByName() {
		System.out.println("Search car by name");
		boolean flag = true;
		System.out.println("Enter name of car: ");
		String name = sc.next();
		for(car car:cars){
			if(car.getName().equals(name)) {
			System.out.println(car);
			flag=false;
			break;
			}
		}
		if(flag){
			System.out.println("Car Not found");
		}
	}
	public static void searchByBrand() {
		System.out.println("Search car by Brand");
		boolean flag = true;
		System.out.println("Enter Brand of car: ");
		String brand = sc.next();
		for(car car:cars){
			if(car.getBrand().equals(brand)) {
			System.out.println(car);
			flag=false;
			break;
			}
		}
		if(flag){
			System.out.println("Car Not found");
		}
	}
	public static void searchByColor() {
		System.out.println("Search car by Color");
		boolean flag = true;
		System.out.println("Enter Color of car: ");
		String color = sc.next();
		for(car car:cars){
			if(car.getColour().equals(color)) {
			System.out.println(car);
			flag=false;
			break;
			}
		}
		if(flag){
			System.out.println("Car Not found");
		}
	}
	
	public static void searchByPrice() {
		Boolean flag = true;
		System.out.println("Search car by id");
		System.out.println("Enter Price to Search:");
		int price = sc.nextInt();
		for(car ca:cars) {
			if(ca.getPrice()==price) {
				
				System.out.println(ca);
			}	
			
		}
		if(flag = false) {
			System.out.println("Car Not Found");
		}
	}
	
	
	public static void removeCar() {
		boolean b = true;
//		System.out.println("Hello from remove car");
		while(b) {
		System.out.println("1)Remove Car By ID\n2)Remove Car By Name\n3)Remove Car By Price\n4)Remove Car By brand\n5)Remove Car By color\n6)Go Back");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			removeId();
		break;
		case 2:
			removeName();
		break;
		case 3:
			removePrice();
		break;
		case 4:
			removeBrand();
			break;
		case 5:
			removeColor();
			break;
		case 6:
			b=false;
//			System.out.println("");
		break;
		default:
			System.out.println("Enter Valid Choice");
		}
		}
	}
	public static void removeId() {
		boolean flag = false;
		System.out.println("Enter Id Of Car to remove: ");
		int id = sc.nextInt();
		for(car ca:cars) {
		if(ca.getId()==id) {
			cars.remove(ca);
			flag=true;
			System.out.println("Car Removed Successfully....");
			break;
		}
		}
		if(!flag) {
			System.out.println("Car Not Found...\n");
		}
	}
	public static void removeName() {
		System.out.println("Remove By Name");
		boolean flag = false;
		System.out.println("Enter Name Of Car to remove: ");
		String name = sc.next();
		for(car ca:cars) {
		if(ca.getName().equals(name)) {
			cars.remove(ca);
			flag=true;
			System.out.println("Car Removed Successfully....");
			break;
		}
		}
		if(!flag) {
			System.out.println("Car Not Found...\n");
		}
		
	}
	public static void removeBrand() {
		System.out.println("Remove By Brand");
		boolean flag = false;
		System.out.println("Enter Brand Of Car to remove: ");
		String brand = sc.next();
		for(car ca:cars) {
		if(ca.getBrand().equals(brand)) {
			cars.remove(ca);
			flag=true;
			System.out.println("Car Removed Successfully....");
			break;
		}
		}
		if(!flag) {
			System.out.println("Car Not Found...\n");
		}
		
	}
	public static void removeColor() {
		System.out.println("Remove By Color");
		boolean flag = false;
		System.out.println("Enter Name Of Car to remove: ");
		String color = sc.next();
		for(car ca:cars) {
		if(ca.getColour().equals(color)) {
			cars.remove(ca);
			flag=true;
			System.out.println("Car Removed Successfully....");
			break;
		}
		}
		if(!flag) {
			System.out.println("Car Not Found...\n");
		}
		
	}
	
	public static void removePrice() {
		boolean flag = false;
		System.out.println("Enter Price Of Car to remove: ");
		int price = sc.nextInt();
		for(car ca:cars) {
		if(ca.getPrice()==price) {
			cars.remove(ca);
			flag=true;
			System.out.println("Car Removed Successfully....");
			break;
		}
		}
		if(!flag) {
			System.out.println("Car Not Found...\n");
		}
	}
	
	public static void editCar() {
		System.out.println("Enter Id to Edit Car Details: ");
		int id=sc.nextInt();
		for(car ca:cars) {
			if(ca.getId()==id) {
				ca.setId(id);
				System.out.println("Enter Name: ");
				ca.setName(sc.next());
				System.out.println("Enter Brand: ");
				ca.setBrand(sc.next());
				System.out.println("Enter Fuel Type:");
				ca.setFuelType(sc.next());
				System.out.println("Enter Colour:");
				ca.setColour(sc.next());
				System.out.println("Enter Price: ");
				ca.setPrice(sc.nextDouble());
				System.out.println("Car Updated Successfully");
				break;
			}
		}
	}
	public void rangeCar() {
		System.out.println("Enter Minimum Price: ");
		int minPrice= sc.nextInt();
		System.out.println("Enter Maximum Price: ");
		int maxPrice= sc.nextInt();
		for(car car:cars) {
			if(car.getPrice() > minPrice && car.getPrice() < maxPrice ) {
				System.out.println(car);
			}
			else {
				continue;
			}
		}
		
	}
}
