package com.jspider.car.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.car.main.menu;

public class removeCar {
	public static menu mn = new menu(); 
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		removeCars();
	}
	public static void removeCars() {
//		boolean b = true;
		int id = 0;
		 id = 1;		
			try {
				openConnection();
				System.out.println("Enter Id to remove car: ");
			    id = scanner.nextInt();
			    query = "DELETE FROM car WHERE id = ?";
			    preparedStatement = connection.prepareStatement(query);
			    preparedStatement.setInt(1, id);
			    int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate() for DELETE
			    if(rowsAffected > 0) {
			        System.out.println("Deleted");
			    }
			    else {
			        System.out.println("No record found with the given id.");
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			} finally {
			    try {
			        closeConnection();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}

		}
//		return true;
		
//	}
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
