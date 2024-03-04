package com.jspider.car.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.car.main.menu;

public class viewCar {
	public static menu mn = new menu(); 
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner scanner = new Scanner(System.in);
//	private static menu mn = new menu();

	public static void main(String[] args) {
		viewCars();
	}
	public static void viewCars() {
		boolean b = true;
		int id = 0;
		while(b) {
//		System.out.println("Enter Id of the Car");
		 id = 1;
//		scanner.close();
		
		try {
			openConnection();
			do {
			query = "SELECT * FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.print("   "+resultSet.getInt(1));
				System.out.print("\t"+resultSet.getString(2));
				System.out.print("\t\t"+resultSet.getString(3));
				System.out.print("\t\t"+resultSet.getString(4));
				System.out.print("\t\t"+resultSet.getString(5));
				System.out.println(" \t"+resultSet.getInt(6));
			}
			else {
				b= false;
//				System.out.println("User Not Found");
//				System.out.println("Back to main menu...");
			}
			id++;
			}while(b!=false);
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
}
