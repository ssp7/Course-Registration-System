package edu.unl.cse.csce361.course_registration.frontend;
import edu.unl.cse.csce361.course_registration.*;

import edu.unl.cse.csce361.course_registration.backend.*;
import edu.unl.cse.csce361.course_registration.logic.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Welcome to the course regester");
		Scanner scan = new Scanner(System.in);

		System.out.println("Would you like to login as a Student or an Advisor. ");
		System.out.println("Press 0 for Advisor and 1 for Student");
     int menuCheck = scan.nextInt();
		
		StorageStudent stu = new StorageStudent();
		StorageCourse stuCourse = new StorageCourse();
		Reader studentReader = new Reader();

		ArrayList<StorageStudent> student =  new ArrayList<StorageStudent>();
		ArrayList<StorageCourse> courses = new ArrayList<StorageCourse>();
		student =  studentReader.studentReader(stu);
        courses =  studentReader.courseReader(stuCourse);
        int index =0;
        
		if(menuCheck == 0) {
		for(int i = 0; i< student.size(); i++) {
//			 System.out.printf("\nName: %s    Major: %s ", student.get(i).getName(),student.get(i).getMajor() );
//			System.out.printf("\nCompleted Courses:");
//			System.out.printf("\n  %s", student.get(i).getCompletedCoursesID());
//			System.out.printf("\nRegistered Courses:");
//			System.out.printf("\n%s  %s  %s  %s  %s  %s  %s  %s  %s  %s  %s  %s  ","CourseID", "Section", "CourseName","Room","Days","StartTime","Semester","NumberOfStudentsRegistered","NumberOfAvailableSeats","URL","Prerequisite1","Prerequisite2");  
	
			System.out.println(student.get(i).getRegisteredCoursesID().size());
		 for(int s = 0; s < student.get(i).getRegisteredCoursesID().size(); s++) {
		   index++;
			 
		 }
		
		  
      }
		System.out.println(index);
		}
	
      else {
    	  System.out.println("Please enter your name");
    	  String name = scan.next();
    	  for(int i = 0; i<student.size(); i++) {
    		  boolean check = student.get(i).getName().contains(name);
    		  System.out.println(check);
    		 /*
    		  if(check == true) {
    			  System.out.println("Name is right");
    		  }
    		  else {
    			  System.out.println("name is wrong");
    			  break;
    		  }
    		  */
    	  }
    	   
      }
			//System.out.printf("\n%s",student.get(i).getCompletedCoursesID());
		
		
		
	}
}
