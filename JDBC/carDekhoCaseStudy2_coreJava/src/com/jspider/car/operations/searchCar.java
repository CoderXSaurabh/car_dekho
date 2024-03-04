package com.jspider.car.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.car.main.menu;

public class searchCar {
	public static menu mn = new menu(); 
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner scanner = new Scanner(System.in);
//	private static menu mn = new menu();

	public static void main(String[] args) {
		searchCars();
	}
	public static void searchCars() {
		boolean b = true;
		int id = 0;
		int choice = 0;
		String name;
		
		while(b) {
			try {
			openConnection();
			System.out.println("----Search Car---- \n 1) Search car By Id \n 2) Search Car By Name \n 3) Search Car By Brand \n 4) Search Car By Fuel Type \n 5) Search Car By Color \n 6) Search Car By Price \n 7) Exit");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Id of the Car");
				id = scanner.nextInt();
				query = "SELECT * FROM car WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				break;
			case 2:
				System.out.println("Enter Name of the Car");
				name = scanner.next();
				query = "SELECT * FROM car WHERE name = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				resultSet = preparedStatement.executeQuery();
				break;
			case 3:
				System.out.println("Enter Brand of the Car");
				name = scanner.next();
				query = "SELECT * FROM car WHERE brand = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				resultSet = preparedStatement.executeQuery();
				break;
			case 4:
				System.out.println("Enter Fuel Type of the Car");
				name = scanner.next();
				query = "SELECT * FROM car WHERE fuel = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				resultSet = preparedStatement.executeQuery();
				break;
			
			case 5:
				System.out.println("Enter Color of the Car");
				name = scanner.next();
				query = "SELECT * FROM car WHERE color = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				resultSet = preparedStatement.executeQuery();
				break;
			case 6:
				System.out.println("Enter Price of the Car");
				id = scanner.nextInt();
				query = "SELECT * FROM car WHERE price = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				break;
			case 7:
				b=false;
				break;
			default:
				System.out.println("Enter valid Option");
				break;
			}
			
			printResult();
			
			
			
			
			
			
			
//		scanner.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
//		return true;
		
	}
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private static void closeConnection() throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	
	}
	private static void printResult() throws Exception {
		try {
			
		
		if(resultSet.next()) {
			do {
			System.out.print("   "+resultSet.getInt(1));
			System.out.print("\t"+resultSet.getString(2));
			System.out.print("\t\t"+resultSet.getString(3));
			System.out.print("\t\t"+resultSet.getString(4));
			System.out.print("\t\t"+resultSet.getString(5));
			System.out.println(" \t"+resultSet.getInt(6));
			}while(resultSet.next());
		}
		else {
//			b= false;
			System.out.println("User Not Found");
			System.out.println("Back to main menu...");
		}
		} catch (Exception e) {
			System.out.println("Thank You for exit from search car....");
			mn.menumethod();
			// TODO: handle exception
		}
	}
}
