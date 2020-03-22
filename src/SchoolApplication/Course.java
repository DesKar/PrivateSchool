package SchoolApplication;

import java.time.LocalDate;

public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String print(int index) {
        return String.format("|%-5s|%-25s|%-30s|%-13s|%-13s|%-13s|", index, title, stream, type, startDate, endDate);

    }

    @Override
    public String toString() {
        return String.format("%s\n|%-25s|%-30s|%-13s|%-13s|%-13s|","Selected Course: " , title, stream, type, startDate, endDate);
    }

}
