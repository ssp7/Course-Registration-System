package edu.unl.cse.csce361.course_registration.backend;
import java.lang.annotation.Target;
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
			if(rcourse1.length() > 1 && rcourse1 != null) {
				registeredCourses.add(rcourse1);
			}
			String rcourse2 = studentData.get("RegisteredCourse2");
			if(rcourse2.length() > 1 && rcourse2 != null) {
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
			if(rcourseSection1 != null && rcourseSection1.length() >0) {
				registeredCoursesSections.add(rcourseSection1);
			}
			String rcourseSection2 = studentData.get("RegisteredCourseSection2");
			if(rcourseSection2 != null && rcourseSection2.length() > 0) {
				registeredCoursesSections.add(rcourseSection2);   
			}
			String rcourseSection3 = studentData.get("RegisteredCourseSection3");
			if(rcourseSection3 != null && rcourseSection3.length() >0) {
				registeredCoursesSections.add(rcourseSection3);
			}
			String rcourseSection4 = studentData.get("RegisteredCourseSection4");
			if(rcourseSection4 != null && rcourseSection4.length() >0) {
				registeredCoursesSections.add(rcourseSection4);   
			}
			String rcourseSection5 = studentData.get("RegisteredCourseSection5");
			if(rcourseSection5 != null && rcourseSection5.length() >0) {
				registeredCoursesSections.add(rcourseSection5);
			}
			String rcourseSection8 = studentData.get("RegisteredCourseSection8");
			if(rcourseSection8 != null && rcourseSection8.length() >0) {
				registeredCoursesSections.add(rcourseSection8);   
			}
			String rcourseSection6 = studentData.get("RegisteredCourseSection6");
			if(rcourseSection6 != null && rcourseSection6.length() >0) {
				registeredCoursesSections.add(rcourseSection6);
			}
			String rcourseSection7 = studentData.get("RegisteredCourseSection7");
			if(rcourseSection7 != null && rcourseSection7.length() >0) {
				registeredCoursesSections.add(rcourseSection7);   
			}
			int numCompleted = 1;
			for(int i = 0; i < 25; i++){
				String completedCourse = studentData.get("CompletedCourse"+numCompleted);

				if(completedCourse != null && completedCourse.length() > 1){
					completedCourses.add(completedCourse);
				}
				numCompleted++;
			}
			student.setCompletedCoursesID(completedCourses);
			student.setRegisteredCoursesID(registeredCourses);
			student.setRegisteredCoursesSections(registeredCoursesSections);
			students.add(student);

		}

		return students;

	}


	public static ArrayList<StorageCourse> courseReader(String filename){
		ArrayList<StorageCourse> arrCourses = new ArrayList<StorageCourse>();
		Set<Map<String, String>> mapData = CSVReaderWriter.readCSV(filename);
		for(Map<String, String> courseData : mapData) {
			String section = courseData.get("Section");
			if(section.equals("ONLINE")) {
				OnlineCourses online = new OnlineCourses();
				online.setCourseID(courseData.get("CourseID"));
				online.setCourseName(courseData.get("CourseName"));
				online.setSemester(courseData.get("Semester"));
				online.setSection(courseData.get("Section"));

				String URL = courseData.get("URL");
				if(URL != null && URL.length() >1) {
					online.setURL(URL);
				}
				arrCourses.add(online);
			}
			else {
				ClassroomCourse classroom = new ClassroomCourse();
				
				String courseID = courseData.get("CourseID");
				classroom.setCourseID(courseID);

				classroom.setSection(section);
				String CourseName = courseData.get("CourseName");
				classroom.setCourseName(CourseName);
				String Room = courseData.get("Room");
				classroom.setRoom(Room);
				String Days = courseData.get("Days");
				classroom.setDays(Days);
				String StartTime = courseData.get("StartTime");
				classroom.setStartTime(StartTime);
				classroom.setMeetingTime();
				String Semester = courseData.get("Semester");
				classroom.setSemester(Semester);
				String studentsReg = courseData.get("NumberOfStudentsRegistered");
				if( studentsReg != null && studentsReg.length() >0) {
					int studentsRegistered = Integer.parseInt(studentsReg);
					classroom.setStudentsRegistered(studentsRegistered);	
				}
				else {
					classroom.setAvailableSeats(0);
				}
				String availableS = courseData.get("NumberOfAvailableSeats");
				if( availableS != null && availableS.length() >0) {
					int availableSeats = Integer.parseInt(availableS);
					classroom.setAvailableSeats(availableSeats);	
				}else {
					classroom.setAvailableSeats(0);
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
               classroom.setPreReq(preReq);
				arrCourses.add(classroom);
				
			}


		
		}
		return arrCourses;
	}


}
