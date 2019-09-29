package edu.unl.cse.csce361.course_registration.backend;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Reader {

	public static ArrayList<StorageStudent> studentReader(String filename) {


		Set<Map<String, String>> mapData;
		mapData = CSVReaderWriter.readCSV(filename);
		ArrayList<StorageStudent> students  = new ArrayList<StorageStudent>();

		for(Map<String, String> studentData : mapData) {

			StorageStudent student = new StorageStudent();
			student.setName(studentData.get("Name"));
			String major = studentData.get("Major");
			student.setMajor(major);
			ArrayList<String> registeredCourses = new ArrayList<String>();
			ArrayList<String> registeredCoursesSections = new ArrayList<String>();
			ArrayList<String> completedCourses = new ArrayList<String>();

			String rcourse1 = studentData.get("RegisteredCourse1");
    	   if(rcourse1.length() > 0 && rcourse1 != null) {
    		   registeredCourses.add(rcourse1);
    	   }
    	   String rcourse2 = studentData.get("RegisteredCourse2");
    	   if(rcourse2.length() > 0 && rcourse2 != null) {
    		   registeredCourses.add(rcourse2);
    	   }
    	   String rcourse3 = studentData.get("RegisteredCourse3");
    	   if(rcourse3 != null && rcourse3.length() >1) {
    		   registeredCourses.add(rcourse3);
    	   }
    	   String rcourse4 = studentData.get("RegisteredCourse4");
    	   if(rcourse4 != null && rcourse4.length() > 1) {
    		   registeredCourses.add(rcourse4);
    	   }
    	   String rcourse5 = studentData.get("RegisteredCourse5");
    	   if(rcourse5 != null  && rcourse5.length() > 1) {
    		   registeredCourses.add(rcourse5);
    	   }
    	   String rcourse6 = studentData.get("RegisteredCourse6");
    	   if(rcourse6 != null  && rcourse6.length() > 1) {
    		   registeredCourses.add(rcourse6);
    	   }
    	   String rcourse7 = studentData.get("RegisteredCourse7");
    	   if(rcourse7 != null  && rcourse7.length() > 1) {
    		   registeredCourses.add(rcourse7);
    	   }
    	   String rcourse8 = studentData.get("RegisteredCourse8");
    	   if(rcourse8 != null && rcourse8.length() > 1) {
    		   registeredCourses.add(rcourse8);
    	   }
    	   String rcourseSection1 = studentData.get("RegisteredCourseSection1");
    	   if(rcourseSection1 != null && rcourseSection1.length() > 1) {
    		   registeredCoursesSections.add(rcourseSection1);
    	   }
    	   String rcourseSection2 = studentData.get("RegisteredCourseSection2");
    	   if(rcourseSection2 != null && rcourseSection2.length() > 1) {
    		   registeredCoursesSections.add(rcourseSection2);   
    	   }
            int numCompleted = 1;
            for(int i = 0; i < 25; i++){
                String completedCourse = studentData.get("CompletedCourse"+numCompleted);
                //System.out.println(completedCourse);
                if(completedCourse != null && completedCourse.length() > 1){
                    completedCourses.add(completedCourse);
                }
                numCompleted++;
            }
            student.setCompletedCoursesID(completedCourses);
            student.setRegisteredCoursesID(registeredCourses);
			students.add(student);

		}

		return students;

	}
	public static ArrayList<StorageCourse> courseReader(String filename){
		ArrayList<StorageCourse> arrCourses = new ArrayList<StorageCourse>();
		Set<Map<String, String>> mapData = CSVReaderWriter.readCSV(filename);
		for(Map<String, String> courseData : mapData) {
			StorageCourse course = new StorageCourse();
			String courseID = courseData.get("CourseID");
			course.setCourseID(courseID);
			String section = courseData.get("Section");
			course.setSection(section);
			String CourseName = courseData.get("CourseName");
			course.setCourseName(CourseName);
			String Room = courseData.get("Room");
			course.setRoom(Room);
			String Days = courseData.get("Days");
			course.setDays(Days);
			String StartTime = courseData.get("StartTime");
			course.setStartTime(StartTime);
			course.setMeetingTime();
			String Semester = courseData.get("Semester");
			course.setSemester(Semester);
			String studentsReg = courseData.get("NumberOfStudentsRegistered");
		     if( studentsReg != null && studentsReg.length() >0) {
		       int studentsRegistered = Integer.parseInt(studentsReg);
				 course.setStudentsRegistered(studentsRegistered);	
		     }
		     else {
		    	 course.setAvailableSeats(0);
		     }
			String availableS = courseData.get("NumberOfAvailableSeats");
     if( availableS != null && availableS.length() >0) {
       int availableSeats = Integer.parseInt(availableS);
		 course.setAvailableSeats(availableSeats);	
     }
     else {
    	 course.setAvailableSeats(0);
     }
			String URL = courseData.get("URL");
			if(URL != null) {
				course.setURL(URL);
			}
           ArrayList<String> preReq = new ArrayList<String>();
		 String prerequisite1 = courseData.get("Prerequisite1");
		 if(prerequisite1 != null && prerequisite1.length() > 1) {
			 preReq.add(prerequisite1);
		 }
		 String prerequisite2 = courseData.get("Prerequisite2");
		 if(prerequisite2 != null && prerequisite2.length() > 1) {
			 preReq.add(prerequisite2);
		 }
		 course.setPrerequisiteCourseIDs(preReq);
	arrCourses.add(course);
		}

           
		return arrCourses;
	}

//	public static void main(String[]args) {
//		ArrayList<StorageStudent> students = studentReader("students.csv");
//		System.out.println(students);
//
//		ArrayList<StorageCourse> courses = courseReader("courses.csv");
//		System.out.println(courses);
//
//
//
////	//	courseReader(courses);
////		for(int i = 0 ; i< student.size() ; i++) {
////			System.out.println( student.get(i).getName() +"  Reg : - "+ student.get(i).getRegisteredCousrsesID() +" size "+ student.get(i).getRegisteredCousrsesID() .size());
////		}
////
//
//	}

}
