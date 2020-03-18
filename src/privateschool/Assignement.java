
package privateschool;

import java.time.LocalDate;

public class Assignement {
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int LocalMark;

    public Assignement(String title, String description, LocalDate subDateTime, int oralMark, int LocalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.LocalMark = LocalMark;
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
        return LocalMark;
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

    public void setLocalMark(int LocalMark) {
        this.LocalMark = LocalMark;
    }
    
}
