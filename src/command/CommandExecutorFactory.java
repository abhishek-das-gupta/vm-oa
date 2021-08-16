package command;

import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    public static Shape getShape(Command command) {
        switch (command.getType()) {
            case "rectangle":
                return new Rectangle(Double.parseDouble(command.getParams().get(0)), Double.parseDouble(command.getParams().get(1)));
            case "circle":
                return new Circle(Double.parseDouble(command.getParams().get(0)));
            case "square":
                return new Square(Double.parseDouble(command.getParams().get(0)));
            default:
                throw new IllegalArgumentException("Shape of type" + command.getType() + " not supported yet!");
        }
    }
}
