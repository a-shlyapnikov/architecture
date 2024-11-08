package cleanArchitecture.database;

import cleanArchitecture.notes.infrastructure.persistance.Database;

public class NotesDatabase implements Database {
    private NotesTable notesTable;

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }
}
