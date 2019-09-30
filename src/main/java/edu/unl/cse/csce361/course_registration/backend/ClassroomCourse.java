package edu.unl.cse.csce361.course_registration.backend;

import java.util.ArrayList;

import edu.unl.cse.csce361.course_registration.MeetingTime;

public class ClassroomCourse extends StorageCourse{
  
	
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
    private ArrayList<String> preReq;
    
    
	public ArrayList<String> getPreReq() {
		return preReq;
	}


	public void setPreReq(ArrayList<String> preReq) {
		this.preReq = preReq;
	}


	public ClassroomCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nClassroomCourse [courseID=" + courseID + ", section=" + section + ", courseName=" + courseName
				+ ", room=" + room + ", days=" + days + ", startTime=" + startTime + ", semester=" + semester
				+ ", meetingTime=" + meetingTime + ", studentsRegistered=" + studentsRegistered + ", availableSeats="
				+ availableSeats + ", preReq=" + preReq + "]";
	}


	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		
        System.out.println(this.courseID+ "  " +this.courseName+"  "+this.semester+"  "+this.section+"  "+this.room+"  "+this.meetingTime+"  "+this.studentsRegistered+"  "+this.availableSeats);
	}
	
	 public void setMeetingTime(){
	    	if(this.getSection().equals("ONLINE")) {
	    		this.meetingTime = MeetingTime.ONLINE;
	    	}
	    	else {
	        if( this.days!= null && this.days.equals("MONDAY") && this.days.length() > 0){
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
	        }else if(this.days != null && this.days.equals("TUESDAY") && this.days.length() > 0){
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
	                    break;
	            }
	        }else{
	            this.meetingTime = MeetingTime.ONLINE;
	        }
	    	}
	 }


	public String getCourseID() {
		return courseID;
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


	public MeetingTime getMeetingTime() {
		return meetingTime;
	}


	public void setMeetingTime(MeetingTime meetingTime) {
		this.meetingTime = meetingTime;
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
}
