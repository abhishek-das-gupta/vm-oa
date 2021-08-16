import command.Command;
import command.CommandExecutorFactory;
import shape.Shape;

import java.io.*;

public class AreaSpec {

    public static void main(final String[] args) throws IOException {
        File inputFile = new File(args[0]);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            System.out.println("File of name " + args[0] +  " not found");
        }
        assert reader != null;
        String input = reader.readLine();
        int index = 0;
        StringBuilder writer = new StringBuilder("{\n");
        while (input != null) {
            if (!input.equals("{") && !input.equals("}")) {
                Shape shape = null;
                try {
                    Command command = new Command(input);
                    shape = CommandExecutorFactory.getShape(command);
                } catch (IllegalArgumentException exp) {
                    System.out.println(exp.getMessage());
                }
                if (shape == null) continue;
                writer.append("{");
                writer.append("\"").append(index).append("\"").append(":");
                writer.append("{").append("\"type").append("\"").append(":").append("\"").append(shape.getType()).append("\"").append(",");
                writer.append("\"area\":").append(shape.area()).append("},\n");
            }
            input = reader.readLine();
            index++;
        }
        writer.append("}");
        assert  writer.toString().equals("{\n" +
                "{\"1\":{\"type\":\"circle\",\"area\":0.6280000000000001},\n" +
                "{\"2\":{\"type\":\"rectangle\",\"area\":8.0},\n" +
                "{\"3\":{\"type\":\"square\",\"area\":4.0},\n" +
                "}");
    }
}
