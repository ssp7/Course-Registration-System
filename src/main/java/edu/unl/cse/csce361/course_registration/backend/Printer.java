package edu.unl.cse.csce361.course_registration.backend;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
public class Printer {
	
	public static void coursePrinter() {
		Reader r = new Reader();
		StorageCourse course = new StorageCourse();
		
		ArrayList<StorageCourse> c = Reader.courseReader("courses.csv");
		System.out.println("Here are courses and its information");
		System.out.printf("\n%s  %15s %25s %15s  %10s    %10s    %10s  %15s  %15s  %21s  %25s  ","CourseID", "Section", "CourseName","Room","Days","StartTime","Semester","NumberOfStudentsRegistered","NumberOfAvailableSeats","URL","Prerequisites");  
	
		for(int i = 1; i<= c.size() ; i++) {
			
			System.out.printf("\n%s%15s     %25s %15s %10s  %10s   %10s  %17d  %25d  %30s  %23s", c.get(i-1).getCourseID(),c.get(i-1).getSection(),c.get(i-1).getCourseName(),c.get(i-1).getRoom(),c.get(i-1).getDays(),c.get(i-1).getStartTime(),c.get(i-1).getSemester(),c.get(i-1).getStudentsRegistered(),c.get(i-1).getAvailableSeats(),c.get(i-1).getURL(),c.get(i-1).getPrerequisiteCourseIDs());
			System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			//System.out.printf("SR.%d s",i,.get(i).getCourseID(),c.get(i).getSection(),c.get(i).getCourseName(),c.get(i).getRoom(),c.get(i).getDays(),c.get(i).getDays(),c.get(i).getStartTime(),c.get(i).getSemester(),c.get(i).getStudentsRegistered(),c.get(i).getAvailableSeats(),c.get(i).getURL(),c.get(i).getPrerequisiteCourseIDs());
		   System.out.println(i);
		}
		
	}
	
	
	public static void studentPrinter() {
		StorageCourse cour = new StorageCourse();
		StorageStudent stu = new StorageStudent();
		
		Reader Reader = new Reader();

		ArrayList<StorageStudent> student =  new ArrayList<StorageStudent>();
        ArrayList<StorageCourse>  courses = new ArrayList<StorageCourse>();
		student =  Reader.studentReader("students.csv");
        courses =  Reader.courseReader("courses.csv");
   
		
		for(int i = 1; i<= student.size(); i++) {
		 System.out.printf("\nName: %s    Major: %s ", student.get(i-1).getName(),student.get(i-1).getMajor() );
			System.out.printf("\nCompleted Courses:");
			if(student.get(i-1).getCompletedCoursesID() != null) {
				for( int comp = 1; comp<=student.get(i-1).getCompletedCoursesID().size(); comp++) {
					System.out.printf("\n  %s", student.get(i-1).getCompletedCoursesID().get(comp-1));
				}

			}
			System.out.printf("\nRegistered Courses:");
			System.out.printf("\n%s  %s  %s  %s  %s  %s  %s  %s  %s  %s  %s  %s  ","CourseID", "Section", "CourseName","Room","Days","StartTime","Semester","NumberOfStudentsRegistered","NumberOfAvailableSeats","URL","Prerequisite1","Prerequisite2");  
	
	if(student.get(i-1).getRegisteredCoursesID() != null) {
		 for(int s = 1; s <= student.get(i-1).getRegisteredCoursesID().size(); s++) {
			    cour.getCourseWithID(courses, student.get(i-1).getRegisteredCoursesID().get(s-1));
		 }
		
	}
      }
	
		}
	
	
	public static void main(String[]args) {
		studentPrinter();
	}

}
