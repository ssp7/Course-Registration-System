package edu.unl.cse.csce361.course_registration.backend;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Printer {

	public static void coursePrinter() {


		OnlineCourses online = new OnlineCourses();
		ArrayList<StorageCourse> c = Reader.courseReader("courses.csv");
		System.out.println("Here are courses and its information");
	System.out.printf("\n%s%30s%20s%20s%17s%22s%30s%25s%30s","CourseID", "CourseName","Semester","Section","Room","MeetingTime","NumberOfStudentsRegistered","NumberOfAvailableSeats","URL");  

		
		for(int i = 1; i<= c.size() ; i++) {
			if(c.get(i-1) instanceof OnlineCourses ) {
				c.get(i-1).printInfo();
	

			}

			else{
				c.get(i-1).printInfo();
			}
		
		}

	}


	public static void studentPrinter() {

		StorageStudent stu = new StorageStudent();

		Reader Reader = new Reader();

		ArrayList<StorageStudent> student =  new ArrayList<StorageStudent>();
		ArrayList<StorageCourse>  courses = new ArrayList<StorageCourse>();
		student =  Reader.studentReader("students.csv");
		courses =  Reader.courseReader("courses.csv");


		for(int i = 1; i<= student.size(); i++) {
			System.out.printf("\nNo.%d  Name: %s    ",i, student.get(i-1).getName());
		
		}

	}
	public static void printByName(String name) {

		ArrayList<StorageStudent> studentAll = new ArrayList<StorageStudent>();
		StorageStudent student = new StorageStudent();
		ArrayList<StorageCourse> courses = new ArrayList<StorageCourse>();

		studentAll = Reader.studentReader("students.csv");
		courses = Reader.courseReader("courses.csv");
		student = student.getStudentWithName(studentAll, name);

		System.out.printf("\nName: %s    Major: %s ", student.getName(),student.getMajor() );
		System.out.printf("\nCompleted Courses:\n");
		if(student.getCompletedCoursesID() != null) {
			for( int comp = 1; comp<=student.getCompletedCoursesID().size(); comp++) {
				System.out.printf("%s     ", student.getCompletedCoursesID().get(comp-1));
				if(comp%4 == 0) {
					System.out.println("\n");
				}

			}

		}
		System.out.printf("\nRegistered Courses:\n");

		if(student.getRegisteredCoursesID() != null) {

			for(int s = 1; s <= student.getRegisteredCoursesID().size(); s++) {
				String courseID = student.getRegisteredCoursesID().get(s-1);
				String section = student.getRegisteredCoursesSections().get(s-1);
				if(section.equals("ONLINE")) {
					OnlineCourses online = new OnlineCourses();
					online = (OnlineCourses) StorageCourse.getCourseWithID(courses, courseID, section);
					online.printInfo();
				}
				else {
					ClassroomCourse classroom = new ClassroomCourse();
					classroom = (ClassroomCourse) StorageCourse.getCourseWithID(courses, courseID, section);
					classroom.printInfo();
				}

			}

		}
		

	}

	public static StorageStudent printByNumber(int index) {
	

			ArrayList<StorageStudent> studentAll = new ArrayList<StorageStudent>();
			StorageStudent student = new StorageStudent();
			ArrayList<StorageCourse> courses = new ArrayList<StorageCourse>();

			studentAll = Reader.studentReader("students.csv");
			courses = Reader.courseReader("courses.csv");
			student  = studentAll.get(index-1);

			System.out.printf("\nName: %s    Major: %s ", student.getName(),student.getMajor() );
			System.out.printf("\nCompleted Courses:\n");
			if(student.getCompletedCoursesID() != null) {
				for( int comp = 1; comp<=student.getCompletedCoursesID().size(); comp++) {
					System.out.printf("%s     ", student.getCompletedCoursesID().get(comp-1));
					if(comp%4 == 0) {
						System.out.println("\n");
					}

				}

			}
			System.out.printf("\nRegistered Courses:\n");
			if(student.getRegisteredCoursesID() != null) {

				for(int s = 1; s <= student.getRegisteredCoursesID().size(); s++) {
					String courseID = student.getRegisteredCoursesID().get(s-1);
					String section = student.getRegisteredCoursesSections().get(s-1);
					if(section.equals("ONLINE")) {
						OnlineCourses online = new OnlineCourses();
						online = (OnlineCourses) StorageCourse.getCourseWithID(courses, courseID, section);
						online.printInfo();
					}
					else {
						ClassroomCourse classroom = new ClassroomCourse();
						classroom = (ClassroomCourse) StorageCourse.getCourseWithID(courses, courseID, section);
						classroom.printInfo();
					}

				}

			}
		
		return student ;
	}


}
 