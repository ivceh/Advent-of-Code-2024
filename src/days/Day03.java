package days;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends AoCDay {
    public Day03(String s) {
        super(s);
    }

    Long s1 = 0L, s2 = 0L;
    Long i = 0L;
    Boolean enabled = true;
    SortedMap<Long, String> matches = new TreeMap<Long, String>();
    String regex = "mul\\((\\d+),(\\d+)\\)"; // Regular expression to find sequences of digits
    String regex2 = "do(n't)?\\(\\)";

    void read_from_buffer(BufferedReader reader) throws IOException
    {
        String line;
        while ((line = reader.readLine()) != null) {
            for (String s : new String[]{regex, regex2}) {
                // Compile the pattern
                Pattern pattern = Pattern.compile(s);
                Matcher matcher = pattern.matcher(line);

                // Find all matches
                while (matcher.find()) {
                    Integer j = matcher.start();
                    String v = matcher.group();// Print each matching substring
                    matches.put(1000000 * i + j, v);
                }
            }
            ++i;
        }
    }

    void solve() {
        for (String v : matches.values()) {
            // Compile the pattern
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(v);

            // Find all matches
            if (matcher.matches()) {
                int n1 = Integer.parseInt(matcher.group(1));
                int n2 = Integer.parseInt(matcher.group(2));
                s1 += n1 * n2;
                if (enabled)
                    s2 += n1 * n2;
            }
            else if (v.equals("do()"))
                enabled = true;
            else
                enabled = false;
        }
        System.out.println("Part 1: " + s1);
        System.out.println("Part 2: " + s2);
    }
}
