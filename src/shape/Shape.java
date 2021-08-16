package shape;

public abstract class Shape {
    protected String type;

    public abstract Double area();

    public String getType() {
        return type;
    }
}
