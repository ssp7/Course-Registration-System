package edu.unl.cse.csce361.course_registration;

public interface CourseOffering {
    String getCourseID();
    String getCourseName();
    int getSemester();
    int getNumberOfStudentsRegistered();
    void addStudent();
    void removeStudent();
}
