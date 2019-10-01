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
	public static void courseMenu() {

	}
	public static void mainMenu() {
		boolean exit = false;
		Scanner s = new Scanner(System.in);
		while(exit == false) {
			System.out.println("Login as Student press 0");
			System.out.println("Login as Advisor press 1");
			System.out.println("To exit press 2");
			int press = s.nextInt();
			switch(press) {
			case 0:
				studentMenu();
				break;
			case 1:
				advisorMenu();
				break;
			case 2:
				exit = true;
				break;
			}
		}

	}
	public static void studentMenu() {
		int maxEnrollmentStudent = 6;
		boolean exit = false;
		boolean nameValid = false;
		Scanner s = new Scanner(System.in);

		System.out.println("Please enter your name");
		String name= null;
		while(nameValid == false) {
			name = s.nextLine();
			nameValid = LogicFacade.isNameValid(name);
			if(nameValid == false) {
				System.out.println("Please enter a valid name");
				name = s.nextLine();		
			}
		}
		LogicFacade.printStudentByName(name);

		while(exit == false) {

			System.out.println("To add a course press 0");
			System.out.println("To remove a course press 1");
			System.out.println("To go back to mainmenu press 2");
			int coursePress = 0;
			coursePress = s.nextInt();
			switch(coursePress){
			case 0:
				LogicFacade.printCourseList();
				System.out.println("Please enter the courseID for the course you would like to add");
				String courseID = null;
				String  section = null;
				boolean courseCheck = false;
				while(courseCheck == false) {
					courseID = s.nextLine();
					courseCheck = LogicFacade.isCourseValid(courseID);
					if(courseCheck == true) {
						System.out.println("Please enter the section of the course");

						boolean sectionCheck = false;
						while(sectionCheck == false) {
							section = s.nextLine();
							sectionCheck = LogicFacade.isSectionValid(courseID, section);
							if(sectionCheck  == false) {
								System.out.println("Please enter a valid section");
							}

						}
					}

				}
				LogicFacade.enrollStudentInCourse(name, maxEnrollmentStudent, courseID, section);
				maxEnrollmentStudent--;
			case 1:
				LogicFacade.printCourseList();
				System.out.println("Please enter the courseID for the course you would like to remove");
				String courseIDtoremove = null;
				String  sectiontoremove = null;
				boolean courseChecktoremove = false;
				while(courseChecktoremove == false) {
					courseIDtoremove = s.nextLine();
					courseChecktoremove = LogicFacade.isCourseValid(courseIDtoremove);
					if(courseChecktoremove == true) {
						System.out.println("Please enter the section of the course");

						boolean sectionChecktoremove = false;
						while(sectionChecktoremove == false) {
							sectiontoremove = s.nextLine();
							sectionChecktoremove = LogicFacade.isSectionValid(courseIDtoremove, sectiontoremove);
							if(sectionChecktoremove  == false) {
								System.out.println("Please enter a valid section");
							}

						}
					}

				}
				LogicFacade.dropStudentFromCourse(name, courseIDtoremove);
			case 2:
				exit =true;
			}

		}

	}
	public static void advisorMenu() {
		Scanner s = new Scanner(System.in);

		LogicFacade.printStudentList();
		int indexForStudent = 0;
		int maxEnrollmentAdvisor = 8;
		boolean exit = false;
		while(exit == false) {
			System.out.println("Please enter the no. for student you would like to modify the data for");
			indexForStudent = s.nextInt();
			String name =  LogicFacade.printStudentByIndex(indexForStudent);
			while(exit == false) {

				System.out.println("To add a course press 0");
				System.out.println("To remove a course press 1");
				System.out.println("To go back to mainmenu press 2");
				int coursePress = 0;
				coursePress = s.nextInt();
				switch(coursePress){
				case 0:
					LogicFacade.printCourseList();
					System.out.println("Please enter the courseID for the course you would like to add");
					String courseID = null;
					String  section = null;
					boolean courseCheck = false;
					while(courseCheck == false) {
						courseID = s.nextLine();
						courseCheck = LogicFacade.isCourseValid(courseID);
						if(courseCheck == true) {
							System.out.println("Please enter the section of the course");

							boolean sectionCheck = false;
							while(sectionCheck == false) {
								section = s.nextLine();
								sectionCheck = LogicFacade.isSectionValid(courseID, section);
								if(sectionCheck  == false) {
									System.out.println("Please enter a valid section");
								}

							}
						}

					}
					LogicFacade.enrollStudentInCourse(name, maxEnrollmentAdvisor, courseID, section);
					maxEnrollmentAdvisor--;
				case 1:
					LogicFacade.printCourseList();
					System.out.println("Please enter the courseID for the course you would like to remove");
					String courseIDtoremove = null;
					String  sectiontoremove = null;
					boolean courseChecktoremove = false;
					while(courseChecktoremove == false) {
						courseIDtoremove = s.nextLine();
						courseChecktoremove = LogicFacade.isCourseValid(courseIDtoremove);
						if(courseChecktoremove == true) {
							System.out.println("Please enter the section of the course");

							boolean sectionChecktoremove = false;
							while(sectionChecktoremove == false) {
								sectiontoremove = s.nextLine();
								sectionChecktoremove = LogicFacade.isSectionValid(courseIDtoremove, sectiontoremove);
								if(sectionChecktoremove  == false) {
									System.out.println("Please enter a valid section");
								}

							}
						}

					}
					LogicFacade.dropStudentFromCourse(name, courseIDtoremove);
				case 2:
					exit =true;
				}

			}

		}
	}
	public static void main(String[] args) {

		System.out.println("Welcome to the course regester");
		mainMenu();

	}

}
