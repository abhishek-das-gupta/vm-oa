import command.Command;
import command.CommandExecutorFactory;
import shape.Shape;

import java.io.*;

public class Main {

    public static void main(final String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File of name " + args[0] +  " not found");
        }
        assert reader != null;
        String input = reader.readLine();
        while (input != null) {
            if (!input.equals("{") && !input.equals("}")) {
                Command command = new Command(input);
                try {
                    Shape shape = CommandExecutorFactory.getShape(command);
                    System.out.println(shape.area());
                } catch (IllegalArgumentException exp) {
                    System.out.println(exp.getMessage());
                }
            }
            input = reader.readLine();
        }
    }
}
