package edu.unl.cse.csce361.course_registration;

public interface Student {
    String getName();
    String getMajor();
    void registerForCourse(String courseID, String section);
    void removeCourse(String courseID);
    boolean hasScheduleConflict(MeetingTime meetingTime);
}
