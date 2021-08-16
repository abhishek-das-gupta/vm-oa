package shape;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return 3.14 * this.radius;
    }
}
