public class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double getTotalSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    public double getLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return String.format("Silinder;%.2f;%.2f;%.4f;%.4f;%.4f", radius, height, getTotalSurfaceArea(), getLateralSurfaceArea(), getVolume());
    }
}
