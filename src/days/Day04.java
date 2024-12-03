package days;

import java.io.BufferedReader;
import java.io.IOException;

public class Day04 extends AoCDay {
    public Day04(String s) {
        super(s);
    }

    int s1 = 0, s2 = 0;

    void read_from_buffer(BufferedReader reader) throws IOException
    {
        String line;
        while ((line = reader.readLine()) != null) { // Read each line
            String[] numbers = line.split(" "); // Split the numbers by space
            for (String num : numbers)
            {
                s1 += Integer.parseInt(num); // Convert to integer and add to sum
            }
        }
    }

    void solve() {
        System.out.println("Part 1: " + s1);
        System.out.println("Part 2: " + s2);
    }
}
