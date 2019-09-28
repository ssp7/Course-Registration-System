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
    	   String completedCourse1 = studentData.get("CompletedCourse1");
			if(completedCourse1 != null) {
				completedCourses.add(completedCourse1);
			}
			 String completedCourse2 = studentData.get("CompletedCourse2");
				if(completedCourse2 != null) {
					completedCourses.add(completedCourse2);
				}
				 String completedCourse3 = studentData.get("CompletedCourse3");
					if(completedCourse3 != null) {
						completedCourses.add(completedCourse3);
					}
					 String completedCourse4 = studentData.get("CompletedCourse4");
						if(completedCourse4 != null) {
							completedCourses.add(completedCourse4);
						}
						 String completedCourse5 = studentData.get("CompletedCourse5");
							if(completedCourse5 != null) {
								completedCourses.add(completedCourse5);
							}
							String completedCourse6 = studentData.get("CompletedCourse6");
							if(completedCourse6 != null) {
								completedCourses.add(completedCourse5);
							}
							 String completedCourse7 = studentData.get("CompletedCourse7");
								if(completedCourse7 != null) {
									completedCourses.add(completedCourse7);
								}
							
								 String completedCourse8 = studentData.get("CompletedCourse8");
									if(completedCourse8 != null) {
										completedCourses.add(completedCourse8);
									}
									 String completedCourse9 = studentData.get("CompletedCourse9");
										if(completedCourse9 != null) {
											completedCourses.add(completedCourse9);
										}
										 String completedCourse10 = studentData.get("CompletedCourse10");
											if(completedCourse10 != null) {
												completedCourses.add(completedCourse10);
											}
											 String completedCourse11 = studentData.get("CompletedCourse11");
												if(completedCourse11 != null) {
													completedCourses.add(completedCourse11);
												}
												 String completedCourse12 = studentData.get("CompletedCourse12");
													if(completedCourse12 != null) {
														completedCourses.add(completedCourse12);
													}
													 String completedCourse13 = studentData.get("CompletedCourse13");
														if(completedCourse13 != null) {
															completedCourses.add(completedCourse13);
														}
														 String completedCourse14 = studentData.get("CompletedCourse14");
															if(completedCourse14 != null) {
																completedCourses.add(completedCourse14);
															}
															 String completedCourse15 = studentData.get("CompletedCourse15");
																if(completedCourse15 != null) {
																	completedCourses.add(completedCourse15);
																}
																String completedCourse16 = studentData.get("CompletedCourse16");
																if(completedCourse16 != null) {
																	completedCourses.add(completedCourse16);
																}
																String completedCourse17 = studentData.get("CompletedCourse17");
																if(completedCourse17 != null) {
																	completedCourses.add(completedCourse17);
																}
																String completedCourse18 = studentData.get("CompletedCourse18");
																if(completedCourse18 != null) {
																	completedCourses.add(completedCourse18);
																}
																String completedCourse19 = studentData.get("CompletedCourse19");
																if(completedCourse19 != null) {
																	completedCourses.add(completedCourse19);
																}
																String completedCourse20 = studentData.get("CompletedCourse20");
																if(completedCourse20 != null) {
																	completedCourses.add(completedCourse20);
																}
																String completedCourse21 = studentData.get("CompletedCourse21");
																if(completedCourse21 != null) {
																	completedCourses.add(completedCourse21);
																}
																String completedCourse22 = studentData.get("CompletedCourse22");
																if(completedCourse22 != null) {
																	completedCourses.add(completedCourse22);
																}
																String completedCourse23 = studentData.get("CompletedCourse23");
																if(completedCourse23 != null) {
																	completedCourses.add(completedCourse23);
																}
																String completedCourse24 = studentData.get("CompletedCourse24");
																if(completedCourse24 != null) {
																	completedCourses.add(completedCourse24);
																}
																String completedCourse25 = studentData.get("CompletedCourse25");
																if(completedCourse25 != null) {
																	completedCourses.add(completedCourse25);
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
		 if(prerequisite1 != null) {
			 preReq.add(prerequisite1);
		 }
		 String prerequisite2 = courseData.get("Prerequisite2");
		 if(prerequisite2 != null) {
			 preReq.add(prerequisite2);
		 }
		 course.setPrerequisiteCourseIDs(preReq);
	arrCourses.add(course);
		}

           
		return arrCourses;
	}

	public static void main(String[]args) {
		ArrayList<StorageStudent> students = studentReader("students.csv");
		System.out.println(students);

		ArrayList<StorageCourse> courses = courseReader("courses.csv");
		System.out.println(courses);



//	//	courseReader(courses);
//		for(int i = 0 ; i< student.size() ; i++) {
//			System.out.println( student.get(i).getName() +"  Reg : - "+ student.get(i).getRegisteredCousrsesID() +" size "+ student.get(i).getRegisteredCousrsesID() .size());
//		}
//

	}

}
