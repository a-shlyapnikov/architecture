package cleanArchitecture.notes.core.application;

import cleanArchitecture.notes.core.application.interfaces.NoteEditor;
import cleanArchitecture.notes.core.application.interfaces.NotePresenter;
import cleanArchitecture.notes.core.application.interfaces.NotesDatabaseContext;
import cleanArchitecture.notes.core.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {
    private final NotesDatabaseContext dbContext;
    private final NotePresenter notePresenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,NotePresenter notePresenter ) {
        this.dbContext = dbContext;
        this.notePresenter = notePresenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getByID(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(new Date());
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getByID(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll() ;
    }

    @Override
    public void printAll() {
        notePresenter.printAll(getAll());
    }
}
