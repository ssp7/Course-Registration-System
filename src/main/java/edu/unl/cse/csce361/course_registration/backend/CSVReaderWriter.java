/*
 * CSV Reader/Writer, copyright (c) 2019 Christopher A. Bohn, bohn@unl.edu.
 */

package edu.unl.cse.csce361.course_registration.backend;

import java.io.*;
import java.net.URL;
import java.util.*;

public class CSVReaderWriter {
    // this does not (yet) handle data elements that include commas and/or are surrounded by quotation marks
    private static final String DELIMTER = ",";
    private static final char BYTE_ORDER_MARK = '\ufeff';

    public static Set<Map<String, String>> readCSV(String filename) {
        Set<Map<String, String>> csvSet = null;
        ClassLoader classLoader = CSVReaderWriter.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("csv/" + filename)) {
            csvSet = parseCSV(inputStream);
        } catch (IOException ioException) {
            System.err.println("Error loading " + filename + ".  " + ioException);
        }
        return csvSet;
    }

    public static boolean writeCSV(String filename, Set<Map<String, String>> data) {
        boolean wroteFile = true;
        ClassLoader classLoader = CSVReaderWriter.class.getClassLoader();
        URL resource = classLoader.getResource("csv/" + filename);
        if (resource != null) {
            File file = new File(resource.getPath());
            try (OutputStream outputStream = new FileOutputStream(file)) {
                placeCSVonStream(data, outputStream);
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Could not open " + filename + "; probably due to a bad pathname.  " + fileNotFoundException);
                wroteFile = false;
            } catch (IOException ioException) {
                System.err.println("Error opening " + filename + ".  " + ioException);
                wroteFile = false;
            }
        } else {
            System.err.println("csv/" + filename + " not found. Cannot overwrite file unless it exists.");
            wroteFile = false;
        }
        return wroteFile;
    }

    static Set<Map<String, String>> parseCSV(InputStream inputStream) throws IOException {
        Set<Map<String, String>> csvSet = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        List<String> fieldNames = new ArrayList<>();
        boolean header = true;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(DELIMTER);
            if (header) {
                if (elements[0].charAt(0) == BYTE_ORDER_MARK) {
                    elements[0] = elements[0].substring(1);     // remove text-encoding character sometimes added by Excel
                }
                fieldNames.addAll(Arrays.asList(elements));
                header = false;
            } else {
                Map<String, String> row = new HashMap<>();
                int column = 0;
                for (String element : elements) {
                    row.put(fieldNames.get(column++), element);
                }
                csvSet.add(row);
            }
        }
        return csvSet;
    }

    static void placeCSVonStream(Set<Map<String, String>> data, OutputStream outputStream) {
        PrintStream writer = new PrintStream(outputStream);
        Set<String> fieldNames = null;
        int number_of_fields = 0;
        for (Map<String, String> row : data) {
            int field_number = 0;
            if (fieldNames == null) {
                fieldNames = row.keySet();
                number_of_fields = fieldNames.size();
                for (String field : fieldNames) {
                    writer.print(field);
                    writer.print(++field_number < number_of_fields ? "," : "\n");
                }
            }
            field_number = 0;
            for (String field : fieldNames) {
                String value = row.get(field);
                writer.print(value != null ? value : "");
                writer.print(++field_number < number_of_fields ? "," : "\n");
            }
        }
    }

/*
    public static void main(String[] args) {
        Set<Map<String, String>> demo = readCSV("demo.csv");
        boolean success = writeCSV("out.csv", demo);
        System.out.println(success ? "Wrote file!" : "Didn't write file");
    }
*/
}
