package edu.unl.cse.csce361.course_registration.backend;

import java.util.ArrayList;

public class StorageStudent {
 
	public String name;
	//public String email;
	public String major;
	public ArrayList<String> registeredCoursesID;
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
	public ArrayList<String> getRegisteredCoursesID() {
		return registeredCoursesID;
	}
	public void setRegisteredCoursesID(ArrayList<String> registeredCoursesID) {
		this.registeredCoursesID = registeredCoursesID;
	}
	public ArrayList<String> getCompletedCoursesID() {
		return completedCoursesID;
	}
	public void setCompletedCoursesID(ArrayList<String> completedCoursesID) {
		this.completedCoursesID = completedCoursesID;
	}
	public StorageStudent(String name,String major, ArrayList<String> registeredCoursesID,
			ArrayList<String> completedCoursesID) {
		super();
		this.name = name;
		this.major = major;
		this.registeredCoursesID = registeredCoursesID;
		this.completedCoursesID = completedCoursesID;
	}

	public StorageStudent(){
		//blank student constructor
	}

	@Override
	public String toString() {
		return "StorageStudent [name=" + name + ", major=" + major + ", registeredCousrsesID=" + registeredCoursesID
				+ ", completedCoursesID=" + completedCoursesID + ", getName()=" + getName() + ", getMajor()="
				+ getMajor() + ", getRegisteredCousrsesID()=" + getRegisteredCoursesID() + ", getCompletedCoursesID()="
				+ getCompletedCoursesID() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public static StorageStudent getStudentWithName(ArrayList<StorageStudent> students, String name){
		StorageStudent requestedStudent = null;
		StorageStudent candidateStudent;
		int counter = 0;
		while(requestedStudent == null && counter < students.size()){
			candidateStudent = students.get(counter);
			if(candidateStudent.getName().equals(name)){
				requestedStudent = candidateStudent;
			}
		}
		return requestedStudent;
	}

	

	
}
