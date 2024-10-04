package solid;

import java.awt.*;

public class Harvester extends Car implements Washable{

    private IWash carWash;
    public Harvester(String make, String model, Color color) {
        super(make, model, color);
    }

    public void setCarWash(IWash carWash) {
        this.carWash = carWash;
    }


    @Override
    public void wash() {
        if (carWash != null) {
            carWash.wash();
        }
    }
    public void sweeping() {
        System.out.println("sweeeep");
    }
    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }


}
