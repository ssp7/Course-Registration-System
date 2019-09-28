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

    public StorageCourse() {
        this.courseID = "";
        this.section = "";
        this.courseName = "";
        this.room = "";
        this.days = "";
        this.startTime = "";
        this.semester = "";
        this.meetingTime = null;
        this.studentsRegistered = 0;
        this.availableSeats = 0;
        this.URL = "";
        this.prerequisiteCourseIDs = new ArrayList<>();

    }


    @Override
	public String toString() {
		return "StorageCourse [courseID=" + courseID + ", section=" + section + ", CourseName=" + courseName + ", Room="
				+ room + ", Days=" + days + ", StartTime=" + startTime + ", Semester=" + semester
				+ ", studentsRegistered=" + studentsRegistered + ", availableSeats=" + availableSeats + ", URL=" + URL
				+ ", prerequisiteCourseIDs=" + prerequisiteCourseIDs + "]" + "\n";
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

    public void setMeetingTime(){
        if(this.days == "MONDAY"){
            switch (this.startTime){
                case "0830":
                    this.meetingTime = MeetingTime.MONDAY0830;
                    break;
                case "0930":
                    this.meetingTime = MeetingTime.MONDAY0930;
                    break;
                case "1030":
                    this.meetingTime = MeetingTime.MONDAY1030;
                    break;
                case "1130":
                    this.meetingTime = MeetingTime.MONDAY1130;
                case "1230":
                    this.meetingTime = MeetingTime.MONDAY1230;
                    break;
                case "1330":
                    this.meetingTime = MeetingTime.MONDAY1330;
                    break;
                case "1430":
                    this.meetingTime = MeetingTime.MONDAY1430;
                    break;
                case "1530":
                    this.meetingTime = MeetingTime.MONDAY1530;
                    break;
                case "1630":
                    this.meetingTime = MeetingTime.MONDAY1630;
                    break;
                default:
                    this.meetingTime = null;
            }
        }else if(this.days == "TUESDAY"){
            switch (this.startTime){
                case "0800":
                    this.meetingTime = MeetingTime.TUESDAY0800;
                    break;
                case "0930":
                    this.meetingTime = MeetingTime.TUESDAY0930;
                    break;
                case "1100":
                    this.meetingTime = MeetingTime.TUESDAY1100;
                    break;
                case "1230":
                    this.meetingTime = MeetingTime.TUESDAY1230;
                    break;
                case "1400":
                    this.meetingTime = MeetingTime.TUESDAY1400;
                    break;
                case "1530":
                    this.meetingTime = MeetingTime.TUESDAY1530;
                    break;
                case "1700":
                    this.meetingTime = MeetingTime.TUESDAY1700;
            }
        }else{
            this.meetingTime = null;
        }
    }

    public static StorageCourse getCourseWithID(ArrayList<StorageCourse> courses, String courseID){
        StorageCourse requestedCourse = null;
        StorageCourse candidateCourse;
        int counter = 0;
        while((requestedCourse == null) && counter < courses.size()){
            candidateCourse = courses.get(counter);
            if(candidateCourse.getCourseID().equals(courseID)){
                requestedCourse = candidateCourse;
            }
        }

        return requestedCourse;
    }
}
