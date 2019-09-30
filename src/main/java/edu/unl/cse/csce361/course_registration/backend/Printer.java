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
		System.out.printf("\n%s  %15s %25s %15s  %10s    %10s    %10s  %15s  %15s  %21s  %25s  ","CourseID", "Section", "CourseName","Room","Days","StartTime","Semester","NumberOfStudentsRegistered","NumberOfAvailableSeats","URL","Prerequisites");

		for(int i = 1; i<= c.size() ; i++) {
			if(c.get(i-1) instanceof OnlineCourses ) {
				c.get(i-1).printInfo();
				System.out.printf("\n%s  %15s %25s %15s","CourseID", "CourseName", "Semester","URL");
				System.out.printf("\n%s%s%s%s", c.get(i-1).getCourseID(),c.get(i-1).getCourseName(),c.get(i-1).getSemester(),  ((OnlineCourses) c.get(i-1)).getURL());


			}

			else{
				c.get(i-1).printInfo();
			}
			//System.out.printf("\n%s%15s     %25s %15s %10s  %10s   %10s  %17d  %25d  %30s  %23s", c.get(i-1).getCourseID(),c.get(i-1).getSection(),c.get(i-1).getCourseName(),c.get(i-1).getRoom(),c.get(i-1).getDays(),c.get(i-1).getStartTime(),c.get(i-1).getSemester(),c.get(i-1).getStudentsRegistered(),c.get(i-1).getAvailableSeats(),c.get(i-1).getURL(),c.get(i-1).getPrerequisiteCourseIDs());
			//System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			//System.out.printf("SR.%d s",i,.get(i).getCourseID(),c.get(i).getSection(),c.get(i).getCourseName(),c.get(i).getRoom(),c.get(i).getDays(),c.get(i).getDays(),c.get(i).getStartTime(),c.get(i).getSemester(),c.get(i).getStudentsRegistered(),c.get(i).getAvailableSeats(),c.get(i).getURL(),c.get(i).getPrerequisiteCourseIDs());

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
			System.out.println("\nNumber for Student: " + i);
			System.out.printf("\nName: %s    Major: %s ", student.get(i-1).getName(),student.get(i-1).getMajor() );
			System.out.printf("\nCompleted Courses:\n");
			if(student.get(i-1).getCompletedCoursesID() != null) {
				for( int comp = 1; comp<=student.get(i-1).getCompletedCoursesID().size(); comp++) {
					System.out.printf("%s     ", student.get(i-1).getCompletedCoursesID().get(comp-1));
					if(comp%4 == 0) {
						System.out.println("\n");
					}

				}

			}
			System.out.printf("\nRegistered Courses:\n");


			if(student.get(i-1).getRegisteredCoursesID() != null) {

				for(int s = 1; s <= student.get(i-1).getRegisteredCoursesID().size(); s++) {
					String courseID = student.get(i-1).getRegisteredCoursesID().get(s-1);
					String section = student.get(i-1).getRegisteredCoursesSections().get(s-1);
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

	public static void printByNumber(int index) {
		if(index >14){
			System.out.println("Please enter proper number");

		}
		else {

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
		}
	}


}
 