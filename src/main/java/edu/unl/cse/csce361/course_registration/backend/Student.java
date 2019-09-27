package edu.unl.cse.csce361.course_registration.backend;

import edu.unl.cse.csce361.course_registration.MeetingTime;

public interface Student {
    String getName();
    String getEmail();
    String getMajor();
    void registerForCourse(String courseID);
    void removeCourse(String courseID);
    boolean hasScheduleConflict(MeetingTime meetingTime);
    
    
}
