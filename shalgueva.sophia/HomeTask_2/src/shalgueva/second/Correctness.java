package shalgueva.second;

import java.util.Scanner;

public class Correctness {
	/*public String nameCor_;
	public int ageCor_;
	public double salaryCor_;
	public int indexCor_;*/
	
	public static String checkCorStr() {
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextLine()) {
	        System.out.println("That not a string!");
	        scan.next(); 
	    }
		String res = scan.nextLine();
		return res;
	}
	
	public static int checkCorInt() {
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextInt()) {
	        System.out.println("That not a number!");
	        scan.next(); 
	    }
		int res = scan.nextInt();
		return res;
	}
	
	public static double checkCorDouble() {
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextDouble()) {
	        System.out.println("That not a double number!");
	        scan.next(); 
	    }
		double res = scan.nextDouble();
		return res;
	}

}
