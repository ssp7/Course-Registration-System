package edu.unl.cse.csce361.course_registration.logic;

public class LogicFacade {
    
    private LogicFacade(){
        
    }

    public static void enrollStudentInCourse(String studentName, int maxEnrollment, String courseID, String section){
        LogicStudent student = new LogicStudent(studentName, maxEnrollment);
        student.registerForCourse(courseID, section);
    }

    public static void dropStudentFromCourse(String studentName, String courseID){
        LogicStudent student = new LogicStudent(studentName, 8);
        student.removeCourse(courseID);
    }

    
    public static void printCourseList(){
        BackendFacade.printCourseList();
    }

    public static void printStudentList(){
        BackendFacade.printStudentList()
    }

    public static void printStudentByName(String studentName){
       BackendFacade.printStudentByName(studentName);
    }

    public static void printStudentByIndex(int index){
       BackendFacade.printStudentByIndex(index);
    }
}
