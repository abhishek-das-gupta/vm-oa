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
                this.params.add(matcher.group(2));
                if (matcher.groupCount() == 3) {
                    this.params.add(matcher.group(3));
                }
                break;
            }
        }
    }
}

