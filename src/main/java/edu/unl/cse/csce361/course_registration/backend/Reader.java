package edu.unl.cse.csce361.course_registration.backend;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Reader {

	public static ArrayList<StorageStudent> studentReader(StorageStudent student) {

		Set<Map<String, String>> demo = CSVReaderWriter.readCSV("students.csv");
		ArrayList<StorageStudent> students  = new ArrayList<StorageStudent>();
		
		for(Map<String, String> s : demo) {
			StorageStudent stu = new StorageStudent();  
			String names = s.get("﻿Name");
			stu.setName(names);
			String major = s.get("Major");
			stu.setMajor(major);
			ArrayList<String> registeredCourses = new ArrayList<String>();
			ArrayList<String> completedCourses = new ArrayList<String>();
			String rcourse1 = s.get("RegisteredCourse1");
		
    	   if(rcourse1.length() > 0 && rcourse1 != null) {
    		   registeredCourses.add(rcourse1);
    	   }
    	   String rcourse2 = s.get("RegisteredCourse2");
    	   if(rcourse2.length() > 0 && rcourse2 != null) {
    		   registeredCourses.add(rcourse2);
    	   }
    	   String rcourse3 = s.get("RegisteredCourse3");
    	   if(rcourse3 != null) {
    		   registeredCourses.add(rcourse3);
    	   }
    	   String rcourse4 = s.get("RegisteredCourse4");
    	   if(rcourse4 != null) {
    		   registeredCourses.add(rcourse4);
    	   }
    	   String rcourse5 = s.get("RegisteredCourse5");
    	   if(rcourse5 != null) {
    		   registeredCourses.add(rcourse5);
    	   }
    	   String rcourse6 = s.get("RegisteredCourse6");
    	   if(rcourse6 != null) {
    		   registeredCourses.add(rcourse6);
    	   }
    	   String rcourse7 = s.get("RegisteredCourse7");
    	   if(rcourse7 != null) {
    		   registeredCourses.add(rcourse7);
    	   }
    	   String rcourse8 = s.get("RegisteredCourse8");
    	   if(rcourse8 != null) {
    		   registeredCourses.add(rcourse8);
    	   } 
    	   String completedCourse1 = s.get("CompletedCourse1");
			if(completedCourse1 != null) {
				completedCourses.add(completedCourse1);
			}
			 String completedCourse2 = s.get("CompletedCourse2");
				if(completedCourse2 != null) {
					completedCourses.add(completedCourse2);
				}
				 String completedCourse3 = s.get("CompletedCourse3");
					if(completedCourse3 != null) {
						completedCourses.add(completedCourse3);
					}
					 String completedCourse4 = s.get("CompletedCourse4");
						if(completedCourse4 != null) {
							completedCourses.add(completedCourse4);
						}
						 String completedCourse5 = s.get("CompletedCourse5");
							if(completedCourse5 != null) {
								completedCourses.add(completedCourse5);
							}
							String completedCourse6 = s.get("CompletedCourse6");
							if(completedCourse6 != null) {
								completedCourses.add(completedCourse5);
							}
							 String completedCourse7 = s.get("CompletedCourse7");
								if(completedCourse7 != null) {
									completedCourses.add(completedCourse7);
								}
							
								 String completedCourse8 = s.get("CompletedCourse8");
									if(completedCourse8 != null) {
										completedCourses.add(completedCourse8);
									}
									 String completedCourse9 = s.get("CompletedCourse9");
										if(completedCourse9 != null) {
											completedCourses.add(completedCourse9);
										}
										 String completedCourse10 = s.get("CompletedCourse10");
											if(completedCourse10 != null) {
												completedCourses.add(completedCourse10);
											}
											 String completedCourse11 = s.get("CompletedCourse11");
												if(completedCourse11 != null) {
													completedCourses.add(completedCourse11);
												}
												 String completedCourse12 = s.get("CompletedCourse12");
													if(completedCourse12 != null) {
														completedCourses.add(completedCourse12);
													}
													 String completedCourse13 = s.get("CompletedCourse13");
														if(completedCourse13 != null) {
															completedCourses.add(completedCourse13);
														}
														 String completedCourse14 = s.get("CompletedCourse14");
															if(completedCourse14 != null) {
																completedCourses.add(completedCourse14);
															}
															 String completedCourse15 = s.get("CompletedCourse15");
																if(completedCourse15 != null) {
																	completedCourses.add(completedCourse15);
																}
																String completedCourse16 = s.get("CompletedCourse16");
																if(completedCourse16 != null) {
																	completedCourses.add(completedCourse16);
																}
																String completedCourse17 = s.get("CompletedCourse17");
																if(completedCourse17 != null) {
																	completedCourses.add(completedCourse17);
																}
																String completedCourse18 = s.get("CompletedCourse18");
																if(completedCourse18 != null) {
																	completedCourses.add(completedCourse18);
																}
																String completedCourse19 = s.get("CompletedCourse19");
																if(completedCourse19 != null) {
																	completedCourses.add(completedCourse19);
																}
																String completedCourse20 = s.get("CompletedCourse20");
																if(completedCourse20 != null) {
																	completedCourses.add(completedCourse20);
																}
																String completedCourse21 = s.get("CompletedCourse21");
																if(completedCourse21 != null) {
																	completedCourses.add(completedCourse21);
																}
																String completedCourse22 = s.get("CompletedCourse22");
																if(completedCourse22 != null) {
																	completedCourses.add(completedCourse22);
																}
																String completedCourse23 = s.get("CompletedCourse23");
																if(completedCourse23 != null) {
																	completedCourses.add(completedCourse23);
																}
																String completedCourse24 = s.get("CompletedCourse24");
																if(completedCourse24 != null) {
																	completedCourses.add(completedCourse24);
																}
																String completedCourse25 = s.get("CompletedCourse25");
																if(completedCourse25 != null) {
																	completedCourses.add(completedCourse25);
																}
																stu.setCompletedCoursesID(completedCourses);
																stu.setRegisteredCoursesID(registeredCourses);
																
			students.add(stu);

		}

		return students;

	}
	public static ArrayList<StorageCourse> courseReader(StorageCourse course){
		ArrayList<StorageCourse> arrCourses = new ArrayList<StorageCourse>();
		Set<Map<String, String>> demo = CSVReaderWriter.readCSV("courses.csv");
		for(Map<String, String> s : demo) {
			StorageCourse courses = new StorageCourse();
			String courseID = s.get("﻿CourseID");
			courses.setCourseID(courseID);
			String section = s.get("Section");
			courses.setSection(section);
			String CourseName = s.get("CourseName");
			courses.setCourseName(CourseName);
			String Room = s.get("Room");
			courses.setRoom(Room);
			String Days = s.get("Days");
			courses.setDays(Days);
			String StartTime = s.get("StartTime");
			courses.setStartTime(StartTime);
			String Semester = s.get("Semester");
			courses.setSemester(Semester);
			int studentsRegistered = Integer.parseInt(s.get("NumberOfStudentsRegistered"));
			
			courses.setStudentsRegistered(studentsRegistered);
		  
		int availableSeats = Integer.parseInt(s.get("NumberOfAvailableSeats"));
		 courses.setAvailableSeats(availableSeats);	
		  
			String URL = s.get("URL");
			if(URL != null) {
				courses.setURL(URL);
			}
           ArrayList<String> preReq = new ArrayList<String>();
		 String prerequisite1 = s.get("Prerequisite1");
		 if(prerequisite1 != null) {
			 preReq.add(prerequisite1);
		 }
		 String prerequisite2 = s.get("Prerequisite2");
		 if(prerequisite2 != null) {
			 preReq.add(prerequisite1);
		 }
		 courses.setPrerequisiteCourseIDs(preReq);
	arrCourses.add(courses);
		}

           
		return arrCourses;
	}
	public static void main(String[]args) {

		StorageStudent student = new StorageStudent();
//		studentReader(student);
		StorageCourse courses = new StorageCourse();
	//	courseReader(courses);
		System.out.println(studentReader(student));
		System.out.println(courseReader(courses));
	
	}

}
