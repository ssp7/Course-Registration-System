package edu.unl.cse.csce361.course_registration.backend;

import edu.unl.cse.csce361.course_registration.MeetingTime;

import java.util.ArrayList;

public class StorageCourse {
    private String courseID;
    private String section;
    private String courseName;
    private String room;
    private String days;
    private String startTime;
    private String semester;
    private MeetingTime meetingTime;
    private int studentsRegistered;
    private int availableSeats;
    private String URL;
    private ArrayList<String> prerequisiteCourseIDs;

    public String getCourseID() {
        return courseID;
    }

    @Override
	public String toString() {
		return "StorageCourse [courseID=" + courseID + ", section=" + section + ", CourseName=" + courseName + ", Room="
				+ room + ", Days=" + days + ", StartTime=" + startTime + ", Semester=" + semester
				+ ", studentsRegistered=" + studentsRegistered + ", availableSeats=" + availableSeats + ", URL=" + URL
				+ ", prerequisiteCourseIDs=" + prerequisiteCourseIDs + ", getCourseID()=" + getCourseID()
				+ ", getSection()=" + getSection() + ", getCourseName()=" + getCourseName() + ", getRoom()=" + getRoom()
				+ ", getDays()=" + getDays() + ", getStartTime()=" + getStartTime() + ", getSemester()=" + getSemester()
				+ ", getStudentsRegistered()=" + getStudentsRegistered() + ", getAvailableSeats()="
				+ getAvailableSeats() + ", getURL()=" + getURL() + ", getPrerequisiteCourseIDs()="
				+ getPrerequisiteCourseIDs() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

    public String printInfo(){
        if(this.section.equals("ONLINE")){
            return printOnlineCourse();
        }else{
            return printClassroomCourse();
        }
    }

	public String printClassroomCourse(){
        String space = "   ";
        String courseInfo = this.courseID + space + this.courseName + space + this.semester
                + space + this.section + space + this.section + space + this.room +space
                + this.meetingTime + space + this.studentsRegistered + space + this.availableSeats;
        return courseInfo;
    }

    public String printOnlineCourse(){
        String space = "   ";
        String courseInfo = this.courseID + space + this.courseName + space + this.semester + space + this.URL;
        return courseInfo;
    }

	public void setCourseID(String courseID) {
        this.courseID = courseID;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getStudentsRegistered() {
        return studentsRegistered;
    }

    public void setStudentsRegistered(int studentsRegistered) {
        this.studentsRegistered = studentsRegistered;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public ArrayList<String> getPrerequisiteCourseIDs() {
        return prerequisiteCourseIDs;
    }

    public void setPrerequisiteCourseIDs(ArrayList<String> prerequisiteCourseIDs) {
        this.prerequisiteCourseIDs = prerequisiteCourseIDs;
    }

    public StorageCourse getCourseFromID(ArrayList<StorageCourse> course, String courseID){
        for (StorageCourse desiredCourse : course) {
            if (desiredCourse.getCourseID().equals(courseID)) {
                return desiredCourse;
            }
        }
        return null;
    }
}
