package Modelling3D.models;

public class Flash implements Rotatable, Movable{
    private Point3D location;
    private Angle3D angle3D;

    private Color color;

    private float power;

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle3D() {
        return angle3D;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public Flash(Point3D location, Angle3D angle3D) {
        this.location = location;
        this.angle3D = angle3D;
    }


    @Override
    public void move(Point3D point3D) {
        this.location = point3D;
        System.out.println("flash moved");
    }

    @Override
    public void rotate(Angle3D angle3D) {
        this.angle3D = angle3D;
        System.out.println("flash was rotated");
    }
}
