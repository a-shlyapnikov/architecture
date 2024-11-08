package cleanArchitecture.database;

import java.util.Date;

public class NotesRecord {
    private static int counter = 1000;

    {
        id = ++counter;
    }
    private int userId;
    private int id;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    public NotesRecord(String title, String details) {
        this.title = title;
        this.details = details;
        this.creationDate = new Date();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }
}
