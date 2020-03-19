package privateschool;

import java.util.Scanner;

public class MainClass {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        School syntheticSchool = new SyntheticSchool();
//        School school = new CodingSchool();
        syntheticSchool.printListOfStudents();
        syntheticSchool.printListOfTrainers();
        syntheticSchool.printListOfAssignments();
        syntheticSchool.printListOfCourses();
    }

}
