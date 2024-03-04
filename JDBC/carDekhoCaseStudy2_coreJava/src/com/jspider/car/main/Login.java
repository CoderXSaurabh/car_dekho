package com.jspider.car.main;

import java.util.Scanner;

import com.jspider.car.operations.JDBCServices;

public class Login {
	private static JDBCServices j = new JDBCServices();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println(" \n-----LoGiN PaGe-----"
					+ "\n 1) To sign up \n 2) To Login \n 3)Exit \n Enter valid Choice : ");
			int choice= scanner.nextInt();
			switch(choice) {
			case 1:
				j.signUp();
				break;
			case 2:
				j.logIn();
				break;
			case 3:
				System.out.println("Thank You...."
						+ "\nVisit Again....");
				flag = false;
				break;
			default:
				break;
			}	
		}
		
	}
}
