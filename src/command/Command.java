package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {
    private String type;
    private List<String> params;

    public String getType() {
        return type;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(final String inputLine) {
        processCommand(inputLine);
    }

    private void processCommand(String inputLine) {
        List<Pattern> patterns = Arrays.asList(Pattern.compile("\"\\d+\"\\:\\{\"type\":\"(\\w+)\",\"radius\":(.*)}"),
                Pattern.compile("\"\\d+\"\\:\\{\"type\":\"(\\w+)\",\"l\":\"(.*)\",\"b\":(.*)}"),
                Pattern.compile("\"\\d+\"\\:\\{\"type\":\"(\\w+)\",\"side\":(.*)}"));

        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(inputLine);
            if (matcher.matches()) {
                this.type = matcher.group(1);
                this.params = new ArrayList<>();
                int i = 2;
                while (i <= matcher.groupCount()) {
                    params.add(matcher.group(i++));
                }
                break;
            }
        }
    }
}

