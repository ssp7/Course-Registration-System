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
        return StorageCourse.getCourseWithID(courseList, courseID,section).getStudentsRegistered();
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
        boolean isOnline = this.section.equals("ONLINE");
        StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID,section);
        int numStudents = course.getStudentsRegistered();
        if(!isOnline) {
            int seatsAvailable = course.getAvailableSeats();
            if (seatsAvailable != 0) {
                course.setStudentsRegistered(numStudents++);
                seatsAvailable--;
                course.setAvailableSeats(seatsAvailable);
                success = true;
            }
        } else if(isOnline){
            course.setStudentsRegistered(numStudents++);
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
        int studentsRegistered = course.getStudentsRegistered();
        if(studentsRegistered !=0){ //classroom and online course
            course.setStudentsRegistered(studentsRegistered--);
            success = true;
        }

        if(!this.section.equals("ONLINE")){ //classroom course only
            int seatsAvailable = course.getAvailableSeats();
            seatsAvailable++;
            course.setAvailableSeats(seatsAvailable);
        }
        BackendFacade.writeCourses(courseList);
        return success;
    }
}
