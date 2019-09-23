package edu.unl.cse.csce361.course_registration.backend;
import edu.unl.cse.csce361.course_registration.backend.CSVReaderWriter.*;

import java.util.Map;
import java.util.Set;

public class Writer {

    public boolean writeStudent(){
        return false;
    }

    public  boolean writeCourse(StorageCourse course){
        Set<Map<String, String>> data = null;

        boolean success = CSVReaderWriter.writeCSV("courses", data);
        return success;
    }
}
