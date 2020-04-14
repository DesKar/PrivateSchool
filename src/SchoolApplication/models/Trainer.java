package SchoolApplication.models;

public class Trainer {

    private int id;
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer(int id, String firstName, String lastName, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public String print(int index) {
        return String.format("|%-5s|%-15s|%-15s|", index, firstName, lastName, subject);
    }
    
    @Override
    public String toString() {
        return "\"" + firstName + " " + lastName + "\"";
    }
}
