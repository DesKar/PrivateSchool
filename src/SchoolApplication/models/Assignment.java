package SchoolApplication.models;

import java.time.LocalDate;
import java.util.Objects;

public class Assignment {

    private int id;
    private String title;
    private String description;
    private LocalDate subDate;
    private int oralMark;
    private int localMark;

    public Assignment(int id, String title, String description, LocalDate subDate, int oralMark, int localMark) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.subDate = subDate;
        this.oralMark = oralMark;
        this.localMark = localMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubDateTime() {
        return subDate;
    }

    public int getOralMark() {
        return oralMark;
    }

    public int getLocalMark() {
        return localMark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDate = subDateTime;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public void setLocalMark(int localMark) {
        this.localMark = localMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + ", subDate=" + subDate + '}';
    }
}
