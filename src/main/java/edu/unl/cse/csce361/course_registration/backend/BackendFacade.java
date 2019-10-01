package edu.unl.cse.csce361.course_registration.backend;

import java.util.ArrayList;

public class BackendFacade {

   private boolean nameCheck;

   public static ArrayList<StorageStudent> readStudents(){
      return Reader.studentReader("students.csv");
   }

   public static ArrayList<StorageCourse> readCourses(){
      return Reader.courseReader("courses.csv");
   }

   public static boolean writeStudents(ArrayList<StorageStudent> students){
      return Writer.studentWriter(students, "students.csv");
   }

   public static boolean writeCourses(ArrayList<StorageCourse> courses){
      return Writer.courseWriter(courses, "courses.csv");
   }

   public static void printCourseList(){
      Printer.coursePrinter();
   }

   public static void printStudentList(){
      Printer.studentPrinter();
   }

   public static void printStudentByName(String studentName){
      Printer.printByName(studentName);
   }

   public static String printStudentByIndex(int index){
    String name =   Printer.printByNumber(index).getName();
    return name;
   }

}
