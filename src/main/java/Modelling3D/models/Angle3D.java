package Modelling3D.models;

public class Angle3D {
    private  float angleAlpha, angleBeta, angleGamma ;

    public float getAngleAlpha() {
        return angleAlpha;
    }

    public float getAngleBeta() {
        return angleBeta;
    }

    public float getAngleGamma() {
        return angleGamma;
    }

    public Angle3D(float angleAlpha, float angleBeta, float angleGamma) {
        if (angleAlpha + angleBeta + angleGamma > 360) {
            throw new RuntimeException("Angle sum must be less than 360 degrees");
        }
        this.angleAlpha = angleAlpha;
        this.angleBeta = angleBeta;
        this.angleGamma = angleGamma;
    }
}
