package edu.unl.cse.csce361.course_registration.backend;

import java.util.ArrayList;

public class StorageStudent {
 
	public String name;
	//public String email;
	public String major;
	public ArrayList<String> registeredCousrsesID;
	public ArrayList<String> completedCoursesID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public ArrayList<String> getRegisteredCousrsesID() {
		return registeredCousrsesID;
	}
	public void setRegisteredCousrsesID(ArrayList<String> registeredCousrsesID) {
		this.registeredCousrsesID = registeredCousrsesID;
	}
	public ArrayList<String> getCompletedCoursesID() {
		return completedCoursesID;
	}
	public void setCompletedCoursesID(ArrayList<String> completedCoursesID) {
		this.completedCoursesID = completedCoursesID;
	}
	public StorageStudent(String name,String major, ArrayList<String> registeredCousrsesID,
			ArrayList<String> completedCoursesID) {
		super();
		this.name = name;
		this.major = major;
		this.registeredCousrsesID = registeredCousrsesID;
		this.completedCoursesID = completedCoursesID;
	}
	@Override
	public String toString() {
		return "StorageStudent [name=" + name + ", major=" + major + ", registeredCousrsesID=" + registeredCousrsesID
				+ ", completedCoursesID=" + completedCoursesID + ", getName()=" + getName() + ", getMajor()="
				+ getMajor() + ", getRegisteredCousrsesID()=" + getRegisteredCousrsesID() + ", getCompletedCoursesID()="
				+ getCompletedCoursesID() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public StorageStudent() {
		// TODO Auto-generated constructor stub
	}
	

	
}
