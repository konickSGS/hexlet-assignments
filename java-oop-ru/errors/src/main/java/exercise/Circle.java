package exercise;

// BEGIN
public class Circle {
    private double radius;
    public Circle(Point center, double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Радиус у круга меньше 0");
        }
        return Math.PI * radius * radius;
    }
}
// END
