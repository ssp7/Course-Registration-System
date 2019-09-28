package edu.unl.cse.csce361.course_registration.backend;
import edu.unl.cse.csce361.course_registration.backend.CSVReaderWriter.*;
import edu.unl.cse.csce361.course_registration.backend.Reader.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Writer {

    public static boolean studentWriter(ArrayList<StorageStudent> students, String filename){
        Set<Map<String, String>> data = null;
        for(StorageStudent student : students){
            Map<String,String> studentMap = null;
            studentMap.put("Name",student.getName());
            studentMap.put("Major",student.getMajor());
            ArrayList<String> registerCourses = student.getRegisteredCoursesID();
            int num = 1;
            for(int i = 0; i < registerCourses.size(); i++){
                studentMap.put("RegisteredCourse"+num,registerCourses.get(i));
                num++;
            }
            ArrayList<String> completedCourses = student.getCompletedCoursesID();
            num = 0;
            for(int i = 0; i < completedCourses.size(); i++){
                studentMap.put("CompletedCourse"+num,completedCourses.get(i));
                num++;
            }
            data.add(studentMap);
        }

        boolean success = CSVReaderWriter.writeCSV(filename, data);
        return success;
    }

    public static boolean courseWriter(ArrayList<StorageCourse> courses, String filename){
        Set<Map<String, String>> data = null;
        for(StorageCourse course : courses){
            Map<String,String> courseMap = null;

            courseMap.put("CourseID", course.getCourseID());
            courseMap.put("Section", course.getSection());
            courseMap.put("CourseName", course.getCourseName());
            courseMap.put("Room",course.getRoom());
            courseMap.put("Days",course.getDays());
            courseMap.put("StartTime",course.getStartTime());
            courseMap.put("Semester",course.getSemester());
            courseMap.put("NumberOfStudentsRegistered",""+course.getStudentsRegistered());
            courseMap.put("NumberOfAvailableSeats",""+course.getAvailableSeats());
            courseMap.put("URL",course.getURL());
            ArrayList<String> prerequisites = course.getPrerequisiteCourseIDs();
            if(prerequisites.size() >= 1){
                courseMap.put("Prerequisite1",prerequisites.get(0));
                if(prerequisites.size() >= 2){
                    courseMap.put("Prerequisite2",prerequisites.get(1));
                }
            }
            data.add(courseMap);
        }

        boolean success = CSVReaderWriter.writeCSV(filename, data);
        return success;
    }

//    public static void main(String[]args) {

//        Reader.studentReader());
//        Reader.courseReader());
//
//    }
}
