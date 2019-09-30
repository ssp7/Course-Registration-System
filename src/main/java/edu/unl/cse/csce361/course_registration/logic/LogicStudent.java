package edu.unl.cse.csce361.course_registration.logic;

import edu.unl.cse.csce361.course_registration.MeetingTime;
import edu.unl.cse.csce361.course_registration.Student;
import edu.unl.cse.csce361.course_registration.backend.BackendFacade;
import edu.unl.cse.csce361.course_registration.backend.StorageCourse;
import edu.unl.cse.csce361.course_registration.backend.StorageStudent;

import java.util.ArrayList;

public class LogicStudent implements Student {
    private String studentID;
    private ArrayList<StorageCourse> courseList;
    private ArrayList<StorageStudent> studentList;

    public LogicStudent(String studentID) {
        this.studentID = studentID;
        this.courseList = BackendFacade.readCourses();
        this.studentList = BackendFacade.readStudents();
    }

    @Override
    public String getName() {
        return StorageStudent.getStudentWithName(studentList, studentID).getName();
    }


    @Override
    public String getMajor() {
        return StorageStudent.getStudentWithName(studentList, studentID).getMajor();
    }

    @Override
    public void registerForCourse(String courseID) {

    }

    @Override
    public void removeCourse(String courseID) {

    }

    @Override
    public boolean hasScheduleConflict(MeetingTime meetingTime) {

        return false;
    }
}
