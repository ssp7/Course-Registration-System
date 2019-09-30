package edu.unl.cse.csce361.course_registration.logic;

import edu.unl.cse.csce361.course_registration.CourseOffering;
import edu.unl.cse.csce361.course_registration.Student;
import edu.unl.cse.csce361.course_registration.backend.*;

import java.util.ArrayList;

public class LogicCourse implements CourseOffering {
    private String courseID;
    private String section;
    private ArrayList<StorageCourse> courseList;

    public LogicCourse(String courseID, String section) {
        this.courseID = courseID;
        this.section = section;
        this.courseList = BackendFacade.readCourses();
    }

    @Override
    public String getCourseID() {
        return courseID;
    }

    @Override
    public String getCourseName() {
        return StorageCourse.getCourseWithID(courseList, courseID,section).getCourseName();
    }

    @Override
    public int getSemester() {
        return  Integer.parseInt(StorageCourse.getCourseWithID(courseList, courseID,section).getSemester());
    }

    @Override
    public int getNumberOfStudentsRegistered() {
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID,section);
        if(course instanceof ClassroomCourse) {
            ClassroomCourse classroom = (ClassroomCourse) course;
            return classroom.getStudentsRegistered();
        }
        return 0;
    }

    private void updateCourseList(){
        this.courseList = BackendFacade.readCourses();
    }

    /**
     * Increment students registered, decrease available seats for classroom courses.
     * @return true if success, false if no seats available
     */
    @Override
    public boolean addStudent() {
        boolean success = false;
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID,section);
        if(course instanceof ClassroomCourse){
            ClassroomCourse classroom = (ClassroomCourse) course;
            int numStudents = classroom.getStudentsRegistered();
            int seatsAvailable = classroom.getAvailableSeats();
            if (seatsAvailable != 0) {
                classroom.setStudentsRegistered(numStudents++);
                seatsAvailable--;
                classroom.setAvailableSeats(seatsAvailable);
                success = true;
            }
        }

        if(success){
            BackendFacade.writeCourses(courseList);
        }
        return success;
    }

    /**
     * Decrease students registered, increase available seats for classroom courses.
     * @return true if success, false if empty
     */
    @Override
    public boolean removeStudent() {
        boolean success = false;
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID,section);
        if(course instanceof  ClassroomCourse){
            ClassroomCourse classroom = (ClassroomCourse) course;
            int studentsRegistered = classroom.getStudentsRegistered();
            if(studentsRegistered !=0){ //classroom and online course
                classroom.setStudentsRegistered(studentsRegistered--);
                int seatsAvailable = classroom.getAvailableSeats();
                seatsAvailable++;
                classroom.setAvailableSeats(seatsAvailable);
                success = true;
            }
        }
        BackendFacade.writeCourses(courseList);
        return success;
    }
}
