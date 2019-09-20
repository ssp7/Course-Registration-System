# Course Registration System

-   Assignment Due: September 27, 2019 at 9:30am
-   Peer Assessment Due: September 27, 2019 at 11:59pm

## Overview

In this assignment you will implement part of a simple course registration
system. You will not be implementing all of the features necessary for a real
course registration system.

You will:

-   Gain additional experience developing software with a partner
-   Demonstrate good software engineering practices
-   Learn three design patterns
    -   Façade Pattern
    -   Singleton Pattern
    -   Template Method Pattern
-   Learn the Three-Tier architectural style

## Instructions

This assignment is to be completed in assigned pairs; **no collaboration
other than with your assigned partner is permitted**.  One of the purposes of
pair-assignments is to practice teamwork. After completing the assignment you
will need to complete a peer assessment. Your contribution grade will be based
on the peer assessments and on the git history.

*Commit material that you worked on individually under your own name* using the
defaults that you set. *When (and only when) you commit material that was
developed using pair programming, override the default commit author to reflect
both authors* so that we can properly credit both authors for their contribution
grades. When you override the default commit author list both students' names,
and for the email address use a fake email address that is unique to the pair
of students by concatenating your Canvas login IDs (the angle brackets around
the email address are required):
```
git commit --author="Herbie Husker and Lil Red <hhusker20lred19@dev.null>"
```

##  Setup

1.  You and your partner will work on a shared repository, which has been
    prepared for you.

    1.  Navigate to your shared directory
        (<https://git.unl.edu/csce_361/fall2019/10pairNN/>, where *NN* is your
        team number).

    1.  Verify that the repository is private, and that you and your partner
        both have Maintainer access.

1.  Both students should:

    1.  Clone the project: `git clone <URL>` (here the angle brackets should
        not be included).

    1.  Import the project into your IDE. The project is set up as a Maven
        project, so you can follow your IDE's instructions to import a Maven
        project.

##  About the Maven directory structure

-   `src/main/java/` - contains the .java files. The namespace for your
    source code begins at this directory, so the
    `edu.unl.cse.csce361.course_registration` package is in the
    `src/main/java/edu/unl/cse/csce361/course_registration/` directory.

-   `src/main/resources/`   - contains resource files, if any. Java code that
    refers to resource files will use this as the base directory for files,
    instead of the working directory.

-   `src/test/java` - contains JUnit tests. The namespace for your test
    code begins at this directory.

-   `target/classes` - contains the .class files. The namespace for your
    byte code begins at this directory. The resource files in
    `/src/main/resources/` will be copied into this directory as well.  The
    `.gitignore` file prevents this file from being included in your repository.

-   `pom.xml` - this file contains the build instructions. Notice the line
    `<mainClass>edu.unl.cse.csce361.course_registration.Main</mainClass>`. The
    `<mainClass>` tag identifies the class that contains the `main` method (the
    class does not have to be called `Main`; that's just an example) to create
    a jar manifest. **Change this tag to the namespace+name of the class that
    contains your `main` method.**

##  Assignment

You and your partner will implement a course registration system with limited
functionality.

### Architecture

The system should have a layered architecture; specifically, a three-tier
architecture.  These should be opaque layers.  See Kung pp148-150.

### Design Patterns

-   Use the *Façade Pattern* to hide the internal details of the logic layer
    and the backend. The façade objects should not do any work; they should
    delegate to objects within their corresponding subsystems.
    -	Figure 21.8 on Kung p554
    -   HFDP, [second half of Chapter 7](https://learning.oreilly.com/library/view/head-first-design/0596007124/ch07.html#home_sweet_home_theater)
-   Use the *Singleton Pattern* to create the façade objects. That is, the
    backend façade should be a singleton, and the logic layer façade should be
    a singleton.
    -	Figure 10.2 on Kung p255
    -   HFDP, [Chapter 5](https://learning.oreilly.com/library/view/head-first-design/0596007124/ch05.html)
-   Use the *Template Method Pattern* in the code to display course data, as
    described below.
    -	Figure 17.16 on Kung p441
    -   HFDP, [Chapter 8](https://learning.oreilly.com/library/view/head-first-design/0596007124/ch08.html)

### Starter Code

-   The directory structure is prepared for a three-tier architecture. Place
    the code for the frontend subsystem in the
    `src/main/java/edu/unl/cse/csce361/course_registration/frontend/`
    directory, the code for the logic layer in the
    `src/main/java/edu/unl/cse/csce361/course_registration/logic/` directory,
    and the code for the backend in the
    `src/main/java/edu/unl/cse/csce361/course_registration/backend/` directory.
-   `CSVReaderWriter.java`
    -   `readCSV(filename)` will read the named CSV file and create a `Map` for
        each non-header line in the file. This `Map` is a map of the field
        names (the headers in the file) to the fields' values (the entries on
        the remaining lines). The method will return all of these `Map`s
        collected into a `Set`.
        -   You only need to provide the name of the file; the code will look
            for the file in the `target/csv/` directory.
        -   You can use these `Map`s to create and populate `Student` and
            `CourseOffering` objects with initial values.
        -   Some of the fields would more sensibly be grouped together into a
            collection (such as the completed courses); however, the CSV file
            structure does not allow for collections.
        -   When interpreting the prerequisite courses, each field represents a
            mandatory prerequisite; however, if more than one course can
            satisfy a prerequisite then the field will separate the course IDs
            with "OR". For example, CSCE351's prerequisites are
            `Prerequisite1="CSCE230 OR CSCE231"` `Prerequisite2="CSCE310"`,
            meaning that to take CSCE351, a student *must* take CSCE310 first,
            but may have taken either CSCE230 or CSCE231 for the other
            prerequisite.
    -   `writeCSV(filename,data)` will write the `Set` of `Map`s to the named
        file in CSV format.
        -   You only need to provide the name of the file; the code will look
            for the file in the `target/csv/` directory.
        -   The method will overwrite the existing file. (It will leave the
            copy of the file in `src/resources/csv/` untouched.)
        -   The file must already exist; however, if you plan to overwrite
            `students.csv` and `courses.csv` then this won't be an issue.
        -   The method returns a boolean to indicate whether it was able to
            write to the file.
    -   This code does not yet correctly parse and write CSV entries that
        contain commas and/or double-quotation marks. Please bear this in mind
        if you chose to edit `students.csv` or `courses.csv`.
    -   If you read a CSV file and then (over)write it, the order of the fields
        and the order of the rows may be different than the original orders.
        This is not incorrect behavior.
-   `students.csv` and `courses.csv` contain sample data for `Student`s and
    `CourseOffering`s.
-   `Student.java` and `CourseOffering.java` are interface definitions for the
    entity objects that your system will operate on. `MeetingTime.java` is an
    enumerated type that represents the timeslots that classroom courses meet;
    the readable names are based on the start time of the first day of the week
    the course meets.

### Functional Requirements

-   The user interface can be a simple console-based menuing system. You *may*
    write a GUI, but you will receive no extra credit for doing so.

-   The user shall be able to perform the following actions:

    1.  Log in as student

        1.  The student will be prompted to provide their name.

            1.  The student's course registration data will be displayed, and
                the student can begin registration actions.

            1.  The student can modify only their own course registration data.

    1.  Log in as advisor

        1.  An enumerated list of students will be displayed.

        1.  The advisor shall be able to select a student from the list by
            selecting the number next to the student's name.

            1.  The selected student's course registration data will be
                displayed, and the advisor can begin registration actions.

            1.  The advisor can modify any student's course registration data.

    1.  Exit

-   When registering a student:

    4.  The student's data will be displayed, and

    The user shall be able to perform the following actions:

    5.  Add a course

        1.  The system shall display the list of courses.

        1.  The user shall be able to type the course ID to be added to the
            student's schedule.

        1.  If the course ID matches a course the student is already scheduled
            for, or a course the student has already completed, then:

            1.  the system shall display a user-friendly and informative error
                message, and

            1.  the user shall be given the opportunity to re-type the course
                ID or return to the previous menu.

        1.  If the course ID does not match a course the student is already
            scheduled for, nor a course the student has already completed, then:

            1.  if the student has not completed the prerequisite course(s),
                then:

                1.  the system shall display a user-friendly and informative
                    error message, and

                1.  the user shall be given the opportunity to re-type the
                    course ID or return to the previous menu.

            1.  if none of the available sections with seats available fit in
                the student's schedule, then:

                1.  the system shall display a user-friendly and informative
                    error message, and

                1.  the user shall be given the opportunity to re-type the
                    course ID or return to the previous menu.

            1.  if the student has completed the prerequisite course(s) and at
                least one section fits in the student's schedule, then:

                1.  one of the sections that fits the student's schedule will
                    be added to the student's schedule, and

                1.  if the course is a classroom course then the section's
                    number of students registered will increase by one and the
                    number of available seats will decrease by one.

        1.  Save any changes to the CSV files.

    1.  Remove a course

        1.  The user shall be able to type the course ID to be removed from the
            student's schedule.

        1.  If the course ID matches a course the student is registered for,
            then:

            1.  the course will be removed from the student's schedule, and

            1.  if the course is a classroom course then the section's number
                of students registered will decrease by one and the number of
                available seats will increase by one.

        1.  If the course ID does not match a course the student is registered
            for, then:

            1.  the system shall display a user-friendly and informative error
                message, and

            1.  the user shall be given the opportunity to re-type the course
                ID or return to the previous menu.

        1.  The system shall disallow removing a course from the list of
            courses the student has already completed.

        1.  Save any changes to the CSV files.

    1.  Return to Main Menu

-   Types of courses

    8.  A classroom course may have multiple sections.

        1.  Each section is held in a room, which has a maximum occupancy. This
            manifests in the invariant that for each section, the number of
            students registered plus the number of available seats is constant.

        1.  Each section is held at a particular time. For our purposes, a
            section meets either Monday/Wednesday/Friday or Tuesday/Thursday.
            We can check for schedule conflicts based solely on the first day
            of the week the section meets and the start of class time.

    1.  An online course does not have a particular class time or location and
        so is not divided into sections, nor does it have a maximum occupancy.
        Instead, it has a URL that students use to access the course.

-   Data display requirements:

    10.  When a student's data is displayed, it will be:
    ```
       Name: StudentName        Major: StudentMajor
       Courses Completed:
           Course1ID       Course2ID       Course3ID       Course4ID
           Course5ID       Course6ID       Course7ID       Course8ID
           ...
       Registered Courses:
           Course1ID       Course1information
           Course2ID       Course2information
           ...
    ```
    Completed courses will only have their names shown. Registered courses will
    be shown as described in the next requirement.

    11. When a course's data is displayed, it will be in these forms:

        1.  Classroom course
        ```
        CourseID   CourseName   Semester   Section   Room   MeetingTime   NumberOfStudentsRegistered   NumberOfAvailableSeats
        ```

        1.  Online course
        ```
        CourseID   CourseName   Semester   URL
        ```

        **Note**: Use the Template Method Pattern in the code to display course
        data.

-   Limitations on adding courses:

    12. A student can add courses until they are registered for six courses.

    1.  An advisor can add courses to a student until the student is registered
        for eight courses.

-   Additional notes:

    -   You may change any of the starter code that you need to.
    -   You do not need to write code to associate a course offering with a
        room.
    -   You do not need to write code to change the courses offered.
    -   You do not need to write code to add/remove students to the system.
    -   If you want to change students and/or course offerings, you can edit
        the CSV files using Excel or any other spreadsheet program. Be sure to
        save it as a CSV when you are finished.

### Tests

Every non-trivial public method and package-visible method should have at least
one unit test using JUnit.

-   The unit tests should not use implicit oracles.
-   Trivial getter methods that do nothing but return the value of a field do
    not need to be tested.
-   Methods that do nothing but delegate to another method do not need to be
    tested.
-   The `main()` method does not need a unit test.
-   You do not need to write tests for `CSVReaderWriter.java`.
-   You do not need to attain statement coverage, nor do you need to cover all
    blackbox partitions.

While we're only requiring at least one JUnit unit test per method, you should
keep any JUnit tests you create to help with debugging.

### Issue Tracker

We have pre-populated your repository's Issue Tracker with issues for the
various parts of the assignment that need to be completed. **We do *not*
guarantee that the pre-populated issues are complete; this document is the
authoritative source of requirements.**

-   A good way to coordinate who is working on which parts of the code is to
    use the [web interface](https://docs.gitlab.com/ee/user/project/issues/index.html#issue-page)
    to "assign" an issue to a team member.
-   You may [add more issues](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#create-a-new-issue)
    to the Issue Tracker if you wish. This is common when you discover more
    tasks that need to be accomplished or when you want to divide an existing
    issue into finer-grained tasks (the original issue would still exist, but
    the finer-grained issues may make it easier to divide the work).
-   When you have completed a task, [close the corresponding issue](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues).
    You can do this through the issue tracker, or you can do it through a
    commit message.
    -   To close an issue through a commit message, include a keyword such as
        `closes #12` in a commit message. You cannot create a commit message
        only to close an issue; this must be a commit message for adding/
        changing/removing files or for a merge.  See <https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#default-closing-pattern>
        for keywords that will close an issue.

### Preparation for Next Assignment

After you've finished this assignment, each student should fork a copy of the
repository to their own gitlab account.

## Deliverables

For grading, we will clone your copy of the project after it is due, and we
will look for:

-   Source code for your course registration system
-   Unit tests for your source code

*It is your responsibility to ensure that your work is in the **correct
repository** and that we can access the repository at the **time the assignment
is due**.  We will grade what we can retrieve from the repository at the time
it is due.  Any work that is not in the correct repository, or that we cannot
access, will not be graded.*

## Assignment Rubric

The assignment is worth **35 points**:

-   **4 points** for implementing an opaque three-tier architecture
    -   The backend retrieves and stores data
    -   The frontend provides a user interface
    -   The logic layer implements the business rules
    -   Each subsystem requests services only of the subsystem immediately
        below it. (You can think of the file system as being immediately below
        the backend subsystem.)

-   **4 points** for implementing the Façade Pattern
    -   Create a façade for the logic layer
    -   Create a façade for the backend
    -   Requests for services are made only through the façade objects
    -   The façade objects do no work, but rather delegate to objects within
        their corresponding subsystems

-   **4 points** for implementing the Singleton Pattern
    -   Make the backend façade a singleton
    -   Make the logic façade a singleton
    -   Private constructor
    -   Public static accessor that always returns the same object

-   **4 points** for implementing the Template Method Pattern
    -   The method to display information about a course provides performs the
        behavior that is common to all types of courses (in this case, prints
        the information that is common to all types of courses) and calls an
        abstract method for the behavior that is specific to the type of course
    -   Subclasses override the called method and provide the behavior (print
        the information) that is specific to the type of course

-   **5 points** for implementing the functionality as specified

-   **5 points** for including unit tests as required

-   **4 points** for using good design principles

<!-- -   **0 points** for coding style. -->

-   **2 points** for making regular commits; *i.e.*, not waiting until the end
    of the project to make a massive commit.

-   **3 point** for meaningful commit messages.

This assignment is scoped for a team of 2 students. If, despite your attempts
to engage your partner, your partner does not contribute to the assignment then
we will take that into account when grading.

*If **at any time** your repository is public or has internal visibility then
you will receive a 10% penalty. Further, if another student accesses your
non-private repository and copies your solution then I will assume that you are
complicit in their academic dishonesty.*


## Contribution Rubric

The contribution is worth **10 points**:

-   **1 point** for completing peer assessment
-   **5 points** for equitable contribution based on peer assessments
-   **4 points** for equitable contribution based on git history
