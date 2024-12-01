package days;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Day01 extends AoCDay
{
    public Day01(String s) {
        super(s);
    }

    ArrayList<Integer> L1 = new ArrayList<Integer>();
    ArrayList<Integer> L2 = new ArrayList<Integer>();
    int s=0, s2=0;

    void read_from_buffer(BufferedReader reader) throws IOException
    {
        String line;
        while ((line = reader.readLine()) != null) { // Read each line
            String[] numbers = line.split("   "); // Split the numbers by space
            L1.add(Integer.parseInt(numbers[0]));
            L2.add(Integer.parseInt(numbers[1]));
        }
    }

    void solve() {
        L1.sort(null);
        L2.sort(null);

        for(int i=0; i<L1.size(); ++i) {
            s += Math.abs(L1.get(i) - L2.get(i));
            s2 += L1.get(i) * Collections.frequency(L2, L1.get(i));
        }

        System.out.println("Part 1: " + s);
        System.out.println("Part 2: " + s2);
    }
}
