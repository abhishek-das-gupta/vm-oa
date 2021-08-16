package shape;

public class Rectangle extends Shape {
    private final Double length;
    private final Double breadth;

    public Rectangle(Double length, Double breadth) {
        super();
        this.type = "rectangle";
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public Double area() {
        return this.length * this.breadth;
    }
}
