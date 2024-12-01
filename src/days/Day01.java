package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01 extends AoCDay
{
    public Day01(String s) {
        super(s);
    }

    int sum = 0;

    void read_from_buffer(BufferedReader reader) throws IOException
    {
        String line = reader.readLine(); // Read the single line containing the numbers
        if (line != null)
        {
            String[] numbers = line.split(" "); // Split the numbers by space
            for (String num : numbers)
            {
                sum += Integer.parseInt(num); // Convert to integer and add to sum
            }
        }

        /* // alternative
        String line;
        while ((line = reader.readLine()) != null) { // Read each line
            sum += Integer.parseInt(line.trim()); // Convert line to integer and add to sum
        } */
    }

    void solve() {
        System.out.println("The sum of the numbers is: " + sum);
    }
}
