package cleanArchitecture.notes.presentation.queries.controllers;

import cleanArchitecture.notes.presentation.queries.views.Presenter;

public abstract class Controller {
    public <T extends Presenter> void  view(T Presenter){

    }
}
