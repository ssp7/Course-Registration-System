# Code Review

## Code Under Review
Course Registration System

## Presenter
Ryan Thomas

## Reviewer
Qiwei Ge

## Comments

##### Positive Comments:
1. Using a switch instead of else-if chain.  
>`Menu.java` (line 24 -34)
```
			switch(press) {
			case 0:
				studentMenu();
				break;
			case 1:
				advisorMenu();
				break;
			case 2:
				exit = true;
				break;
			}
```
>If you need to choose between a large set of values, the switch statement will run much faster than the equivalent logic encoded with else-if statement.

2. Variables used to index short for loops named i,j,k, etc.  
>`Writer.java` (line 22)
```
            for(int i = 0; i < 8; i++){
```
>It's widely known and understood, and quite succinct.

3. The methods' name are descriptive.  
>For example: `BackendFacade.java` (line 13 - 44), one of the examples is,  
```
     public static void printStudentByName(String studentName){  
          Printer.printByName(studentName);  
          }
```
>printStudentByName is a meaningful name. This is a method to print out student information when you type in the student's name.

4. Combining multiple pieces of data into an ArrayList.
>One of the examples is from `Reader.java` (line 16 - 107)  
```
     ArrayList<StorageStudent> students  = new ArrayList<StorageStudent>();
          for(Map<String, String> studentData : mapData) {
            StorageStudent student = new StorageStudent();
			      student.setName(studentData.get("Name"));
			      String major = studentData.get("Major");
			      student.setMajor(major);
			      ArrayList<String> registeredCourses = new ArrayList<String>();
			      ...  
			      student.setRegisteredCoursesID(registeredCourses);
			      student.setRegisteredCoursesSections(registeredCoursesSections);
			      students.add(student);
          }
```
>Get all the informations from students by calling ArrayList students.

##### Improvement Comments:
1. Unused import.  
>`OnlineCourses.java` line 3,4. There are two unused import\
`import java.awt.geom.Area;` and `import java.util.ArrayList;`.\
There may no any performance impact for the program, but for readability you can make it clean.

2. Code marked with “TODO” Comments.
>`OnlineCourses.java` line 61 and line 73.\
 There are two `// TODO Auto-generated method stub` Comments. It is better to delete the `TODO` comments when you've done that.\
`TODO` that has not been deleted will cause misunderstanding to developer.

3. Local variable is not used.
>`LogicStudent.java` line 134.\
 It has a never used variable `OnlineCourses onlineCourses = (OnlineCourses) course;` Unused variables make the intent of your code unclear. Clean them will make your code better.

4. Absence of useful comments (provide context for code).
 >`LogicStudent.java` line 22-35.
```
       public static boolean isNameValid(String name){
            ArrayList<StorageStudent> studentList =   BackendFacade.readStudents();
            boolean valid = false;
            int index = 0;
            while(index < studentList.size() && !valid){
                String studentName = studentList.get(index).getName();
                if(studentName.equals(name)){
                    valid = true;
                  }
                  index++;
                }
                return valid;
              }
```
>The methods in some java files clearly explain the purpose of the method.   
`isNameValid` it may be the student's name, the name of the course you added, and the name of the course you deleted. It's hard for the maintainer to judge.  
So a meaningful comment is very important here.

5. Over-long method.
 >`LogicStudent.java` line 66-107.
 >`public boolean fulfillsPrerequisites(String courseID, String section)` This method contains multiple parts, it has printers, two if-else statements. It can break into smaller methods.

6. Uncaught/unhandled runtime exceptions.
>`Menu.java` line 173-194.
```
				 System.out.println("\nPlease enter the courseID for the course you would like to remove");
					String courseIDtoremove = null;
					String  sectiontoremove = null;
					boolean courseChecktoremove = false;
					while(courseChecktoremove == false) {
						courseIDtoremove = s.nextLine();
						courseChecktoremove = LogicFacade.isCourseValid(courseIDtoremove);
						if(courseChecktoremove == true) {
							System.out.println("Please enter the section of the course");
							boolean sectionChecktoremove = false;
							while(sectionChecktoremove == false) {
								sectiontoremove = s.nextLine();
								sectionChecktoremove = LogicFacade.isSectionValid(courseIDtoremove, sectiontoremove);
								if(sectionChecktoremove  == false) {
									System.out.println("Please enter a valid section");
								}
							}
						}
					}
```
>What I am worried is after the message say `Please enter the courseID for the course you would like to remove`. \
If I have a input with wrong `courseID`, the program will never print this message again.\
Users would like consider there is no error The easy way to improve this issue is put printer into your first `while` loop;

7. Names that are misspelled.
>`LogicStudent.java` line 66.
```
       public boolean fulfillsPrerequisites(String courseID, String section){
```
>Wrong spelling name increases the difficulty of maintainer. Try to avoid spelling mistakes in method names.

8. Mismatch in array dimensions, causing an array index out-of-bounds exception.
>`Printer.java` line 108.
```
 			student  = studentAll.get(index-1);
```
>When select as advisor, if the incorrect input is greater than the number of students. An error outOfBounds will occurred.\
A `boolean` method may avoid this type of error.

9. Resource leak.
>`Menu.java` line 18, line 42, and line 126.
```
		Scanner s = new Scanner(System.in);
```
>This condition is normally the result of a bug in a program. It's better use `s.close()` to close the `Scanner` if you don't need it.

10. Misplaced responsibility.
>`Menu.java` and `Printer.java`.\
>`Menu.jave` has a lot of print methods, it increased reviewer's reading difficulty and will increase the difficulty of maintenance. It's better put print method in the `Printer.java`.

11. Nonspecific error messages.
>`Menu.java` line 67-88.
```
             System.out.println("\nPlease enter the courseID for the course you would like to add");
                      ...
      	       while(courseCheck == false) {
					courseID = s.nextLine();
					courseCheck = LogicFacade.isCourseValid(courseID);
					if(courseCheck == true) {
						System.out.println("Please enter the section of the course");
						boolean sectionCheck = false;
						while(sectionCheck == false) {
							section = s.nextLine();
							sectionCheck = LogicFacade.isSectionValid(courseID, section);
							if(sectionCheck  == false) {
								System.out.println("Please enter a valid section");
							}
						}
					}
				}
```
>If user enter a wrong CousreID, there are no any message shows up.
```
       ...
        CSCE461      ADV TOP IN SOFTWARE ENGR                1198                   1             BESY108          MONDAY1230                   0                  19
        CSCE155                    COMP SCI I                1198              ONLINE                                                                                                                              null
        CSCE196                SPECIAL TOPICS                1198                   2              LPH137          MONDAY1030                  16                   3
        Please enter the courseID for the course you would like to add
        sad
        111
        CSCE
        CSCE8899
```
>Error messages should give the user enough information to diagnose or fix the problem.\
Ideally, should also provide instructions on what steps the user should take next
