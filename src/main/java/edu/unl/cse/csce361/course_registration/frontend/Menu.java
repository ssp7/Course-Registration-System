package edu.unl.cse.csce361.course_registration.frontend;
import edu.unl.cse.csce361.course_registration.*;

import edu.unl.cse.csce361.course_registration.backend.*;
import edu.unl.cse.csce361.course_registration.logic.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Welcome to the course regester");
		Scanner scan = new Scanner(System.in);

		Scanner scanName = new Scanner(System.in);
		System.out.println("Would you like to login as a Student or an Advisor. ");
		System.out.println("Press 0 for Advisor and 1 for Student");
		int menuCheck = scan.nextInt();
		Printer print = new Printer();

		if(menuCheck == 0) {

			print.studentPrinter();
			System.out.println("Please enter the number who's data you need to modify");
			int studentName = scanName.nextInt();
			print.printByNumber(studentName);


		}

		else {

			StorageStudent studentByName = new StorageStudent();
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Please enter your name");
			String name = scanName.nextLine();
			print.printByName(name);
			scan.close();
		}
	}
}
