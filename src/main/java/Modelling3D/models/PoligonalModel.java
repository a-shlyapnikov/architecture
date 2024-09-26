package Modelling3D.models;

import java.util.List;

public class PoligonalModel {
    List<Poligon> poligons;
    List<Texture> textures;

    public PoligonalModel(List<Poligon> poligons, List<Texture> textures) {
        this.poligons = poligons;
        this.textures = textures;
    }

    public PoligonalModel(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public List<Poligon> getPoligons() {
        return poligons;
    }

    public List<Texture> getTextures() {
        return textures;
    }
}
