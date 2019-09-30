package edu.unl.cse.csce361.course_registration.backend;

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
		return "\nOnlineCourses [CourseID=" + CourseID + ", CourseName=" + CourseName + ", Semester=" + Semester
				+ ", URL=" + URL + ", Section=" + Section + ", getSection()=" + getSection() + ", getCourseID()="
				+ getCourseID() + ", getCourseName()=" + getCourseName() + ", getSemester()=" + getSemester()
				+ ", getURL()=" + getURL() + ", printInfo()=" + printInfo() + ", getClass()=" + getClass()
			   + "]";
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
		// TODO Auto-generated constructor stub
	}
	public OnlineCourses(String courseID, String courseName, String semester, String uRL) {
		super();
		CourseID = courseID;
		CourseName = courseName;
		Semester = semester;
		URL = uRL;
	}

	@Override
	public String printInfo() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
