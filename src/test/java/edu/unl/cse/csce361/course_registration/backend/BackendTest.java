package edu.unl.cse.csce361.course_registration.backend;

import org.junit.Test;

import java.security.PublicKey;

public class BackendTest {

    @Test
    public void testReadStudents(){
        BackendFacade.readStudents();
    }

    @Test
    public void testWriteStudents(){
        BackendFacade.writeStudents(BackendFacade.readStudents());
    }

    @Test
    public void testReadCourses(){
        BackendFacade.readCourses();
    }

    @Test
    public void testWriteCourse(){
        BackendFacade.writeCourses(BackendFacade.readCourses());
    }

}
