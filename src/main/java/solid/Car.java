package solid;

import java.awt.*;

public abstract class Car {
    //region Constructors
    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }
    //endregion
    //region Public Methods
    public abstract void movement();
    public abstract void maintenance();
    public abstract boolean gearShifting();
    public abstract boolean switchHeadlights();
    public abstract boolean switchWipers();
    public boolean switchFogLights(){
        return !fogLights;
    }
    //endregion
    //region Private Fields
    private String make;
    private String model;
    private Color color;
    private  int wheelCount;
    private FuelType fuelType;
    private GearboxType gearboxType;
    private double engineCapacity;
    private boolean fogLights = false;

    protected Car() {
    }

    //endregion


}
