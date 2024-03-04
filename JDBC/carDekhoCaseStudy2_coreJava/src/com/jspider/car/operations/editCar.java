package com.jspider.car.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.car.main.menu;

public class editCar {
	public static menu mn = new menu(); 
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		editCars();
	}
	public static void editCars(){
		int id = 0;
		String name;
		boolean b = true;
//		 id = 1;		
			try {
				openConnection();
				
				while(b) {
				
					
				System.out.println("\nEnter Id to Edit car: ");
			    id = scanner.nextInt();
			    System.out.println("What You Want to Edit \n 1) Name \n 2) Brand \n 3) Fuel \n 4) Color \n 5) Price \n 6) Exit");
			    System.out.println("Enter Your choice: ");
			    int choice = scanner.nextInt();
			    switch(choice) {
			    case 1:
			    	System.out.println("Enter New Name: ");
			    	name = scanner.next();
			    	query = "UPDATE car SET name = ? where id = ?";
			    	preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
					    break;
			    case 2:
			    	System.out.println("Enter New Brand: ");
			    	name = scanner.next();
			    	query = "UPDATE car SET brand = ? where id = ?";
			    	preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
			    	break;
			    case 3:
			    	System.out.println("Enter New Fuel Type: ");
			    	name = scanner.next();
			    	query = "UPDATE car SET fuel = ? where id = ?";
			    	preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
					break;
			    case 4:
			    	System.out.println("Enter New Color: ");
			    	name = scanner.next();
			    	query = "UPDATE car SET color = ? where id = ?";
			    	preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
					break;
			    case 5:
			    	System.out.println("Enter New Price: ");
			    	int p = scanner.nextInt();
			    	query = "UPDATE car SET price = ? where id = ?";
			    	preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, p);
					preparedStatement.setInt(2, id);
			    	break;
			    case 6:
			    	b = false;
			    	break;
			    default:
			    	System.out.println("Enter Valid Choice.....");
//			    	b = false;
			    	break;
			    }
			    
			  
			    int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate() for DELETE
			    if(rowsAffected > 0) {
			        System.out.println("CAR UPDATED...");
			        
			        System.out.println("DO You Want To Edit Car Again type \n 1-> Edit Car "
			        		+ "\n 2 -> Exit");
				    int op = scanner.nextInt();
				    if(op == 1) {
				    	b = true;
				    }
				    else {
				    	System.out.println("Exited Successfully...");
				    	b = false;
				    }
			    }
			    else {
			        System.out.println("No record found with the given id.");
			    }
			    
			    
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
