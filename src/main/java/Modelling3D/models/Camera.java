package Modelling3D.models;

public class Camera implements Rotatable, Movable{
    private Point3D location;
    private Angle3D angle3D;

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle3D() {
        return angle3D;
    }

    public Camera(Point3D location, Angle3D angle3D) {
        this.location = location;
        this.angle3D = angle3D;
    }

    @Override
    public void move(Point3D point3D) {
        this.location = point3D;
        System.out.println("camera moved");
    }

    @Override
    public void rotate(Angle3D angle3D) {
        this.angle3D = angle3D;
        System.out.println("camera was rotated");
    }
}
