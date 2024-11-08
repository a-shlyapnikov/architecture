package cleanArchitecture.notes.core.application.interfaces;

import cleanArchitecture.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {
    void printAll();

}
