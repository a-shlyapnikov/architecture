package Modelling3D.models;

import java.util.List;

public class Scene {
    private int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;

    private List<Camera> cameras;

    public Scene() {
    }

    public void ShootScene(){
        System.out.println("Scene shooted");
    }

    public int getId() {
        return id;
    }

    public List<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(List<PoligonalModel> models) {
        this.models = models;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(List<Flash> flashes) {
        this.flashes = flashes;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }
}
