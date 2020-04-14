package SchoolApplication.models;

import java.time.LocalDate;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;

    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String print(int index) {
        return String.format("|%-5s|%-15s|%-15s|%-15s|%-15s|", index, firstName, lastName, dateOfBirth, tuitionFees);
    }

    @Override
    public String toString() {
        return "\"" + firstName + " " + lastName + "\"";
    }

}
