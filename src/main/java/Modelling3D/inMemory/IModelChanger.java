package Modelling3D.inMemory;

public interface IModelChanger {
    void notifyChange();
    void registerModelChanger(ModelChangeObserver o);
    void  removeModelChanger(ModelChangeObserver o);
}
