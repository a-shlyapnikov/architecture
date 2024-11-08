package cleanArchitecture.notes.core.application.interfaces;

import cleanArchitecture.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {
     Collection<Note> getAll();
     boolean saveChanges();

}
