package cleanArchitecture.notes.core.application.interfaces;

import cleanArchitecture.notes.core.domain.Note;

import java.util.Collection;

public interface NotePresenter {
    void printAll(Collection<Note> notes);
}
