package edu.unl.cse.csce361.course_registration.logic;

import edu.unl.cse.csce361.course_registration.CourseOffering;
import edu.unl.cse.csce361.course_registration.Student;
import edu.unl.cse.csce361.course_registration.backend.BackendFacade;
import edu.unl.cse.csce361.course_registration.backend.Reader;
import edu.unl.cse.csce361.course_registration.backend.StorageCourse;
import edu.unl.cse.csce361.course_registration.backend.StorageStudent;

import java.util.ArrayList;

public class LogicCourse implements CourseOffering {
    private String courseID;
    private ArrayList<StorageCourse> courseList;
    private ArrayList<StorageStudent> studentList;

    public LogicCourse(String courseID) {
        this.courseID = courseID;
        this.courseList = BackendFacade.readCourses();
        this.studentList = BackendFacade.readStudents();
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public String getCourseName() {
        return StorageCourse.getCourseWithID(courseList, courseID).getCourseName();
    }

    @Override
    public int getSemester() {
        return  Integer.parseInt(StorageCourse.getCourseWithID(courseList, courseID).getSemester());
    }

    @Override
    public int getNumberOfStudentsRegistered() {
        return StorageCourse.getCourseWithID(courseList, courseID).getStudentsRegistered();
    }

    private void updateCourseList(){
        this.courseList = BackendFacade.readCourses();
    }


    @Override
    public void addStudent() {
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID);
        int numStudents = course.getStudentsRegistered();
        if(course.getSection() != "ONLINE") {
            int seatsAvailable = course.getAvailableSeats();
            if (seatsAvailable != 0) {
                course.setStudentsRegistered(numStudents++);
                seatsAvailable--;
                course.setAvailableSeats(seatsAvailable);
            }
        } else if(course.getSection() == "ONLINE"){
            course.setStudentsRegistered(numStudents++);
        }
        BackendFacade.writeCourses(courseList);
    }

    @Override
    public void removeStudent() {
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID);
        int studentsRegistered = course.getStudentsRegistered();
        if(studentsRegistered !=0){
            course.setStudentsRegistered(studentsRegistered--);
        }

        if(course.getSection() != "ONLINE"){
            int seatsAvailable = course.getAvailableSeats();
            seatsAvailable++;
            course.setAvailableSeats(seatsAvailable);
        }
        BackendFacade.writeCourses(courseList);
    }
}
