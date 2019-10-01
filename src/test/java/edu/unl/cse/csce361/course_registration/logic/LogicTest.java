package edu.unl.cse.csce361.course_registration.logic;

import org.junit.Test;

public class LogicTest {

    @Test
    public void testAddCourse(){
        LogicFacade.enrollStudentInCourse("Stu Dent", 6, "CSCE310", "1");
    }

    @Test
    public void testRemoveCourse(){
        LogicFacade.dropStudentFromCourse("Stu Dent", "CSCE10");
    }
}
