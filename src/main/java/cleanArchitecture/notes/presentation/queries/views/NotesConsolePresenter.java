package cleanArchitecture.notes.presentation.queries.views;

import cleanArchitecture.notes.core.application.interfaces.NotePresenter;
import cleanArchitecture.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotePresenter {

    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }
    }
}
