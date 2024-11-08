package cleanArchitecture.notes;

import cleanArchitecture.database.NotesDatabase;
import cleanArchitecture.notes.core.application.ConcreteNoteEditor;
import cleanArchitecture.notes.infrastructure.persistance.NotesDbContext;
import cleanArchitecture.notes.presentation.queries.controllers.NotesController;
import cleanArchitecture.notes.presentation.queries.views.NotesConsolePresenter;

public class Program {
    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter())
        );
        controller.routeGetAll();
    }
}
