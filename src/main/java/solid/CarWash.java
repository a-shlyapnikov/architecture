package solid;

public class CarWash implements IWash{
    public CarWash() {
    }

    @Override
    public void wash() {
        System.out.println("washing...");
    }
}
