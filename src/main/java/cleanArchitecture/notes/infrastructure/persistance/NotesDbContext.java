package cleanArchitecture.notes.infrastructure.persistance;

import cleanArchitecture.database.NotesDatabase;
import cleanArchitecture.database.NotesRecord;
import cleanArchitecture.notes.core.application.interfaces.NotesDatabaseContext;
import cleanArchitecture.notes.core.domain.Note;
import cleanArchitecture.notes.infrastructure.persistance.configs.NoteConfig;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    public void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfig());
    }

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;

    }
}
