package edu.unl.cse.csce361.course_registration.logic;

import edu.unl.cse.csce361.course_registration.MeetingTime;
import edu.unl.cse.csce361.course_registration.Student;
import edu.unl.cse.csce361.course_registration.backend.*;

import java.util.ArrayList;

public class LogicStudent implements Student {
    private String studentName;
    private ArrayList<StorageCourse> courseList;
    private ArrayList<StorageStudent> studentList;
    private int maxEnrollment;

    public LogicStudent(String studentName, int maxEnrollment) {
        this.studentName = studentName;
        this.courseList = BackendFacade.readCourses();
        this.studentList = BackendFacade.readStudents();
        this.maxEnrollment = maxEnrollment;
    }

    public static boolean isNameValid(String name){
        ArrayList<StorageStudent> studentList = BackendFacade.readStudents();
        boolean valid = false;
        int index = 0;
        while(index < studentList.size() && !valid){
            String studentName = studentList.get(index).getName();
            if(studentName.equals(name)){
                valid = true;
            }
            index++;
        }

        return valid;
    }

    public static boolean isCourseValid(String courseID){
        ArrayList<StorageCourse> courseList = BackendFacade.readCourses();
        boolean valid = false;
        int index = 0;
        while(index < courseList.size() && !valid){
            String courseIDInList = courseList.get(index).getCourseID();
            if(courseIDInList.equals(courseID)){
                valid = true;
            }
            index++;
        }
        return valid;
    }

    public static boolean isSectionValid(String courseID, String section){
        ArrayList<StorageCourse> courseList = BackendFacade.readCourses();
        boolean valid = false;
        int index = 0;
        while(index < courseList.size() && !valid){
            String courseIDInList = courseList.get(index).getCourseID();
            String sectionInList = courseList.get(index).getSection();
            if(courseIDInList.equals(courseID) && sectionInList.equals(section)){
                valid = true;
            }
            index++;
        }
		return valid;
    }

    public boolean fulfillsPrerequisites(String courseID, String section){

        boolean requiredCoursesCompleted = true;
        StorageStudent student = StorageStudent.getStudentWithName(studentList, studentName);
        ArrayList<String> completedCourses = student.getCompletedCoursesID();
        ClassroomCourse course = (ClassroomCourse) StorageCourse.getCourseWithID(courseList, courseID, section);
        ArrayList<String> requiredCourses = course.getPreReq();
        if(requiredCourses.size() > 0){
            //first PreReq
            if(requiredCourses.get(0).contains("OR")){
                String[] options =requiredCourses.get(0).split(" OR ");
                if(!completedCourses.contains(options[0]) && !completedCourses.contains(options[1])){
                    requiredCoursesCompleted = false;
                }
            }else{
                if(!completedCourses.contains(requiredCourses.get(0))){
                    requiredCoursesCompleted = false;
                }
            }
        }

        if(requiredCourses.size() > 1){
            //second PreReq
            if(requiredCourses.get(1).contains("OR")){
                String[] options =requiredCourses.get(1).split(" OR ");
                if(!completedCourses.contains(options[0]) && !completedCourses.contains(options[1])){
                    requiredCoursesCompleted = false;
                }
            }else{
                if(!completedCourses.contains(requiredCourses.get(0))){
                    requiredCoursesCompleted = false;
                }
            }
        }
        return requiredCoursesCompleted;
    }


    @Override
    public String getName() {
        return StorageStudent.getStudentWithName(studentList, studentName).getName();
    }

    @Override
    public String getMajor() {
        return StorageStudent.getStudentWithName(studentList, studentName).getMajor();
    }

    @Override
    public void registerForCourse(String courseID, String section) {
        StorageStudent student = StorageStudent.getStudentWithName(studentList, studentName);
        //has the student reached the enrollment limit.
        if (student.getRegisteredCoursesID().size() >= this.maxEnrollment){
            System.out.println("You have reached your course registration limit.");
        }else {
            StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID, section);
            //Has the student already completed the course
            if (student.getCompletedCoursesID().contains(courseID)) {
                System.out.println("You have already completed that course.");
            } else if(student.getRegisteredCoursesID().contains(courseID)){
                System.out.println("You can not register for multiple sections of the same course.");
            }else if (course instanceof OnlineCourses) {
                OnlineCourses onlineCourses = (OnlineCourses) course;
                student.getRegisteredCoursesID().add(courseID);
                student.getRegisteredCoursesSections().add(section);
                BackendFacade.writeStudents(studentList);
                System.out.println("The course has been added to your schedule.");
            } else if (course instanceof ClassroomCourse) {
                ClassroomCourse classroomCourse = (ClassroomCourse) course;
                //does the course conflict with the students schedule
                if(hasScheduleConflict(classroomCourse.getMeetingTime())){
                    System.out.println("This course does not fit in your schedule. If available, try another section.");
                }else{
                    if(fulfillsPrerequisites(courseID, section)){
                        LogicCourse newCourse = new LogicCourse(courseID, section);
                        if(newCourse.addStudent()){
                            student.getRegisteredCoursesID().add(courseID);
                            student.getRegisteredCoursesSections().add(section);
                            BackendFacade.writeStudents(studentList);
                            System.out.println("The course has been added to your schedule.");
                        }else{
                            System.out.println("The course is full.");
                        }
                    }else{
                        System.out.println("Prerequisites not fulfilled.");
                    }
                }
            }
        }

    }

    @Override
    public void removeCourse(String courseID) {
        StorageStudent student = StorageStudent.getStudentWithName(studentList, studentName);
        if(student.getRegisteredCoursesID().contains(courseID)){
            int index  = student.getRegisteredCoursesID().indexOf(courseID);
            String section = student.getRegisteredCoursesSections().get(index);
            StorageCourse course = StorageCourse.getCourseWithID(courseList, courseID, section);
            if(course instanceof OnlineCourses){
                student.getRegisteredCoursesID().remove(index);
                student.getRegisteredCoursesSections().remove(index);
                BackendFacade.writeStudents(studentList);
                System.out.println("The course has been removed.");
            }else if(course instanceof ClassroomCourse){
                LogicCourse courseToRemove = new LogicCourse(courseID, section);
                if(courseToRemove.removeStudent()){
                    student.getRegisteredCoursesID().remove(index);
                    student.getRegisteredCoursesSections().remove(index);
                    BackendFacade.writeStudents(studentList);
                    System.out.println("The course has been removed.");
                }else{
                    System.out.println("The course is already empty.");
                }
            }
        }else{
            System.out.println("You can only drop courses you have registered for.");
        }
    }

    @Override
    public boolean hasScheduleConflict(MeetingTime meetingTime) {
        boolean hasConflict = false;
        StorageStudent student = StorageStudent.getStudentWithName(studentList, studentName);
        ArrayList<String> registerCoursesIDs = student.getRegisteredCoursesID();
        ArrayList<String> registerCoursesSections = student.getRegisteredCoursesSections();

        int index = 0;
        while (index < registerCoursesIDs.size() && !hasConflict){
            StorageCourse course = StorageCourse.getCourseWithID(courseList,registerCoursesIDs.get(index), registerCoursesSections.get(index));
            if(course instanceof ClassroomCourse){
                MeetingTime courseMeetingTime = ((ClassroomCourse) course).getMeetingTime();
                if(courseMeetingTime.equals(meetingTime)){
                    hasConflict = true;
                }
            }
            index++;
        }
        return hasConflict;
    }
}
