package com.jspider.car.main;

import java.util.Scanner;

import com.jspider.car.operations.addCar;
import com.jspider.car.operations.editCar;
import com.jspider.car.operations.rangeCar;
import com.jspider.car.operations.removeCar;
import com.jspider.car.operations.searchCar;
import com.jspider.car.operations.viewCar;

public class menu {
	static Scanner sc = new Scanner(System.in);
	static boolean b = true;
	static int n;
	static viewCar v = new viewCar();
	static searchCar s = new searchCar();
	static addCar a = new addCar();
	static removeCar r = new removeCar();
	static editCar e = new  editCar(); 
	static rangeCar rc = new rangeCar();
//	public static boolean b = true;
	public static void main(String[] args) throws Exception {
//		try {
//			menumethod();
//		} catch (Exception e) {
//			System.out.println("First catch");
//			e.printStackTrace();
//		}
	}

	public static void menumethod() throws Exception{
	
	try {
	 while (b) {
		System.out.println("---------Main Menu---------\n" + "1-> View all Cars" + "\n2-> Search Car"
				+ "\n3-> Add Car" + "\n4-> Remove Car" + "\n5-> Edit Car \n6-> Give Price Range \n7-> Exit");	
		n = sc.nextInt();
		switch(n) {
		case 1:
			v.viewCars();
			break;
		case 2:
			s.searchCars();
			break;
		case 3:
			a.addCars();
			break;
		case 4:
			r.removeCars();
			break;
		case 5:
			e.editCars();
			break;
		case 6:
			rc.ranges();
			break;
		case 7:
			System.out.println("Thank you Visit again...");
			b = false;
			break;
		default:
			System.out.println("Enter Valid Option....");
//			b = false;
			break;
			
		}
	 }
	}catch (Exception e) {
		System.out.println("While loop gandala");
//		e.printStackTrace();
	}
	
	}
}

//
//int n = 0;
//
//while (b) {
//	System.out.println("---------Main Menu---------\n" + "1-> View all Cars" + "\n2-> Search Car"
//			+ "\n3-> Add Car" + "\n4-> Remove Car" + "\n5-> Edit Car \n6-> Give range \n7-> Exit");
//	Scanner sc = new Scanner(System.in);
//	n = sc.nextInt();
//	switch (n) {
//	case 1:
//		viewCar v1 = new viewCar();
//		v1.viewCar();
//		break;
//			op.viewcars();
//			b=true;
//			break;
//		case 2:
//			op.searchCar();
//			break;
//		case 3:
//			op.addCar();
//			break;
//		case 4:
//			op.removeCar();
//			break;
//		case 5:
//			op.editCar();
//			break;
//		case 6:
//			op.rangeCar();
//			break;
//		case 7:
//			System.out.println("Thank You....\nVisit Again....");
//			b = false;
//			break;
//		default:
//			System.out.println("Wrong Input.....");
//			break;
//	}

//}

