package Modelling3D.inMemory;

import Modelling3D.models.Camera;
import Modelling3D.models.Flash;
import Modelling3D.models.PoligonalModel;
import Modelling3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    private final List<ModelChangeObserver> observers = new ArrayList<>();
    private final List<PoligonalModel> models = new ArrayList<>();
    private final List<Flash> flashes = new ArrayList<>();
    private final List<Scene> scenes = new ArrayList<>();
    private final List<Camera> cameras = new ArrayList<>();

    public Scene getScene(int sceneNumber) {
        return scenes.get(sceneNumber);
    }

    public void addModel(PoligonalModel model) {
        models.add(model);
        notifyChange();
    }

    @Override
    public void notifyChange() {
        for (ModelChangeObserver observer : observers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangeObserver o) {
        observers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangeObserver o) {
        observers.remove(0);
    }
}
