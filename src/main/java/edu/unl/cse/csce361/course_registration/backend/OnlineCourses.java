package edu.unl.cse.csce361.course_registration.backend;

import java.awt.geom.Area;
import java.util.ArrayList;

public class OnlineCourses extends StorageCourse {

	private String CourseID;
	private String CourseName;
	private String Semester;
	private String URL;
	private String Section;
	
	public String getSection() {
		return Section;
	}
	
	

	@Override
	public String toString() {
		return "OnlineCourses [CourseID=" + CourseID + ", CourseName=" + CourseName + ", Semester=" + Semester
				+ ", URL=" + URL + ", Section=" + Section + ", getSection()=" + getSection() + ", getCourseID()="
				+ getCourseID() + ", getCourseName()=" + getCourseName() + ", getSemester()=" + getSemester()
				+ ", getURL()=" + getURL() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



	public void setSection(String section) {
		Section = section;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public OnlineCourses() {
		super();
	}

	public OnlineCourses(String courseID, String courseName, String semester, String uRL) {
		super();
		CourseID = courseID;
		CourseName = courseName;
		Semester = semester;
		URL = uRL;
	}

	@Override
	public void printInfo() {
    	System.out.printf("\n%s%30s%20s%20s%130s",getCourseID(),getCourseName(),getSemester(),getSection(),getURL());
	}

}
