package edu.unl.cse.csce361.course_registration.backend;

import java.util.ArrayList;

public class StorageCourse {
    private String courseID;
    private String section;
    private String CourseName;
    private String Room;
    private String Days;
    private String StartTime;
    private String Semester;
    private int studentsRegistered;
    private int availableSeats;
    private String URL;
    private ArrayList<String> prerequisiteCourseIDs;

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
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
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
        StorageCourse newCourse = null;
        for (StorageCourse desiredCourse : course) {
            if (desiredCourse.getCourseID().equals(courseID)) {
                newCourse = desiredCourse;
            }
        }
        return newCourse;
    }
}
