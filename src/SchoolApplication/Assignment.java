package SchoolApplication;

import java.time.LocalDate;
import java.util.Objects;

public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int localMark;

    public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int localMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.localMark = localMark;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
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
        this.subDateTime = subDateTime;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public void setLocalMark(int localMark) {
        this.localMark = localMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", oralMark=" + oralMark + ", localMark=" + localMark + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.subDateTime);
        hash = 29 * hash + this.oralMark;
        hash = 29 * hash + this.localMark;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assignment other = (Assignment) obj;
        if (this.oralMark != other.oralMark) {
            return false;
        }
        if (this.localMark != other.localMark) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subDateTime, other.subDateTime)) {
            return false;
        }
        return true;
    }
    
    

}
