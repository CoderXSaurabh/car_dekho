package com.jspider.car.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class addCar {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) throws SQLException {
		addCars();
	}
	public static void addCars() throws SQLException {
		boolean b = true;
	    int num2;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("How Many Cars You want to add: ");
	    int num = sc.nextInt();
	    for(int i = 0;i<num;i++) {
	    	System.out.println("Enter Id: ");
		    int id = sc.nextInt();
		    sc.nextLine();

		    System.out.println("Enter Name: ");
		    String name = sc.nextLine();
		    System.out.println("Enter Brand: ");
		    String brand = sc.nextLine();
		    System.out.println("Enter Fuel: ");
		    String fuel = sc.nextLine();
		    System.out.println("Enter Color: ");
		    String color = sc.nextLine();
		    System.out.println("Enter Price: ");
		    int price = sc.nextInt();
		    
		    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
		         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car VALUES(?,?,?,?,?,?)")) {
		        
		        preparedStatement.setInt(1, id);
		        preparedStatement.setString(2, name);
		        preparedStatement.setString(3, brand);
		        preparedStatement.setString(4, fuel);
		        preparedStatement.setString(5, color); 
		        preparedStatement.setInt(6, price);
		        
		        preparedStatement.executeUpdate(); // Execute the insert statement
		        
//		        if(id == resultSet.getInt(id)) {
//		        	System.out.println("Data is present");
//		        }
		        System.out.println("Data Inserted");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
//	private static Connection connection;
//	private static PreparedStatement preparedStatement;
//	private static ResultSet resultSet;
//	private static String query;
//	
//	public static void main(String[] args) throws SQLException {
//		addCars();
//	}
//	public static void addCars() throws SQLException {
//	    boolean b = true;
//	    int num2;
//	    Scanner sc = new Scanner(System.in);
//	    System.out.println("How Many Cars You want to add: ");
//	    int num = sc.nextInt();
//	    for(int i = 0;i<num;i++) {
//	    	System.out.println("Enter Id: ");
//		    int id = sc.nextInt();
//		    sc.nextLine();
//
//		    System.out.println("Enter Name: ");
//		    String name = sc.nextLine();
//		    System.out.println("Enter Brand: ");
//		    String brand = sc.nextLine();
//		    System.out.println("Enter Fuel: ");
//		    String fuel = sc.nextLine();
//		    System.out.println("Enter Color: ");
//		    String color = sc.nextLine();
//		    System.out.println("Enter Price: ");
//		    int price = sc.nextInt();
//		    
//		    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
//		         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car VALUES(?,?,?,?,?,?)")) {
//		        
//		        preparedStatement.setInt(1, id);
//		        preparedStatement.setString(2, name);
//		        preparedStatement.setString(3, brand);
//		        preparedStatement.setString(4, fuel);
//		        preparedStatement.setString(5, color); 
//		        preparedStatement.setInt(6, price);
//		        
//		        preparedStatement.executeUpdate(); // Execute the insert statement
//		        
////		        if(id == resultSet.getInt(id)) {
////		        	System.out.println("Data is present");
////		        }
//		        System.out.println("Data Inserted");
//		    } catch (SQLException e) {
//		    	System.out.println("Data is alredy Present...");
//		        e.printStackTrace();
//		    }
//		}
//	    }
//	    

}
