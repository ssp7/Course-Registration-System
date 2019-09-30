package edu.unl.cse.csce361.course_registration.backend;
import edu.unl.cse.csce361.course_registration.backend.CSVReaderWriter.*;
import edu.unl.cse.csce361.course_registration.backend.Reader.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Writer {

    public static boolean studentWriter(ArrayList<StorageStudent> students, String filename){
        Set<Map<String, String>> data = new HashSet<Map<String, String>>();
        for(StorageStudent student : students){
            Map<String,String> studentMap = new HashMap<>();
            studentMap.put("Name",student.getName());
            studentMap.put("Major",student.getMajor());
            ArrayList<String> registeredCourses = student.getRegisteredCoursesID();
            ArrayList<String> registeredCoursesSection = student.getRegisteredCoursesSections();
            int numRegistered = 1;
            for(int i = 0; i < 8; i++){
                if(registeredCourses.size() >= numRegistered){
                studentMap.put("RegisteredCourse"+numRegistered,registeredCourses.get(i));
                studentMap.put("RegisteredCourseSection"+numRegistered,registeredCoursesSection.get(i));
                numRegistered++;
                }else{
                    studentMap.put("RegisteredCourse"+numRegistered, null);
                    studentMap.put("RegisteredCourseSection"+numRegistered,null);
                    numRegistered++;
                }
            }
            System.out.println(studentMap);
            ArrayList<String> completedCourses = student.getCompletedCoursesID();

            int numCompleted = 1;
            for(int i = 0; i < 25; i++){
                if(completedCourses.size() >= numCompleted){
                    studentMap.put("CompletedCourse"+numCompleted,completedCourses.get(i));
                    numCompleted++;
                }else{
                    studentMap.put("CompletedCourse"+numCompleted, null);
                    numCompleted++;
                }

            }
            data.add(studentMap);
        }

        boolean success = CSVReaderWriter.writeCSV(filename, data);
        return success;
    }

    public static boolean courseWriter(ArrayList<StorageCourse> courses, String filename){
        Set<Map<String, String>> data = new HashSet<Map<String, String>>();
        for(StorageCourse course : courses){
            Map<String,String> courseMap = new HashMap<>();
            String section = course.getSection();
            courseMap.put("CourseID", course.getCourseID());
            courseMap.put("Section", course.getSection());
            courseMap.put("CourseName", course.getCourseName());
            courseMap.put("Semester",course.getSemester());
            if(section.equals("ONLINE")){
                OnlineCourses online = (OnlineCourses) course;
                courseMap.put("URL",online.getURL());
            }else{
                ClassroomCourse classroom = (ClassroomCourse) course;
                courseMap.put("Room",classroom.getRoom());
                courseMap.put("Days",classroom.getDays());
                courseMap.put("StartTime",classroom.getStartTime());

                courseMap.put("NumberOfStudentsRegistered",""+ classroom.getStudentsRegistered());
                courseMap.put("NumberOfAvailableSeats","" +classroom.getAvailableSeats());

                ArrayList<String> prerequisites = classroom.getPreReq();
                if(prerequisites.size() > 0){
                    courseMap.put("Prerequisite1",prerequisites.get(0));
                    if(prerequisites.size() > 1){
                        courseMap.put("Prerequisite2",prerequisites.get(1));
                    }else{
                        courseMap.put("Prerequisite2", null);
                    }
                }
            }

            data.add(courseMap);
        }

        boolean success = CSVReaderWriter.writeCSV(filename, data);
        return success;
    }

//    public static void main(String[]args) {
//        System.out.println("Original CSV Files");
//        ArrayList<StorageStudent> students = Reader.studentReader("students.csv");
//        System.out.println(students);
//        //ArrayList<StorageCourse> courses = Reader.courseReader("courses.csv");
//        //System.out.println(courses);
//
//        boolean wroteStudents = studentWriter(students, "testStudents.csv");
//        //boolean wroteCourses = courseWriter(courses, "testCourses.csv");
//    }
}
