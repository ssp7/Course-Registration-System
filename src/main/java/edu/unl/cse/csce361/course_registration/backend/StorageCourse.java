package edu.unl.cse.csce361.course_registration.backend;

import edu.unl.cse.csce361.course_registration.MeetingTime;

import java.util.ArrayList;

public abstract class StorageCourse {
    private String courseID;
    private String section;
    private String courseName;
  
    private String semester;



   
   public StorageCourse() {
        this.courseID = "";
        this.section = "";
        this.courseName = "";
        this.semester = "";
    

    }



    public abstract String printInfo();

	

	public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }




   
    

    public static StorageCourse getCourseWithID(ArrayList<StorageCourse> courses, String courseID, String section){
        StorageCourse requestedCourse = null;
        StorageCourse candidateCourse;
        int counter = 0;
        while((requestedCourse == null) && counter < courses.size()){
            candidateCourse = courses.get(counter);
            if(candidateCourse.getCourseID().equals(courseID) && candidateCourse.getSection().equals(section)){
                requestedCourse = candidateCourse;
            }
            counter++;
        }

        return requestedCourse;
    }
    
    
    
    
    public static void main(String[]args) {
    	ArrayList<StorageCourse> coursesAll = new ArrayList<StorageCourse>();
    	coursesAll = Reader.courseReader("courses.csv");
    }
}


