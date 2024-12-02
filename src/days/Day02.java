package days;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day02 extends AoCDay {
    public Day02(String s) {
        super(s);
    }

    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    int s1 = 0, s2 = 0;

    void read_from_buffer(BufferedReader reader) throws IOException
    {
        /*String line = reader.readLine(); // Read the single line containing the numbers
        if (line != null)
        {
            String[] numbers = line.split(" "); // Split the numbers by space
            for (String num : numbers)
            {
                sum += Integer.parseInt(num); // Convert to integer and add to sum
            }
        }*/

        // alternative
        String line;
        while ((line = reader.readLine()) != null) { // Read each line
            if (line != null)
            {
                ArrayList<Integer> L = new ArrayList<>();
                String[] numbers = line.split(" "); // Split the numbers by space
                for (String num : numbers)
                {
                    L.add(Integer.parseInt(num)); // Convert to integer and add to sum
                }
                A.add(L);
            }
        }
    }

    void solve() {
        Boolean up, down;
        for (ArrayList<Integer> L : A) {
            up = down = true;
            for (int i=0; i<L.size() - 1; ++i){
                if(!(L.get(i+1) > L.get(i) && L.get(i+1) <= L.get(i) + 3)) {
                    up = false;
                }
                if(!(L.get(i+1) < L.get(i) && L.get(i+1) >= L.get(i) - 3)) {
                    down = false;
                }
            }
            if (up || down)
                ++s1;
        }
        System.out.println("Part 1: " + s1);

        HashSet<Integer> unsafe_up, unsafe_down;
        for (ArrayList<Integer> L : A) {
            unsafe_up = new HashSet<>();
            unsafe_down = new HashSet<>();
            for (int i=0; i<L.size() - 1; ++i) {
                if(!(L.get(i+1) > L.get(i) && L.get(i+1) <= L.get(i) + 3)) {
                    if(!unsafe_up.contains(i) && (i + 2 >= L.size() ||
                            L.get(i+2) > L.get(i) && L.get(i+2) <= L.get(i) + 3))
                        unsafe_up.add(i+1);
                    else if(i == 0 ||
                            L.get(i+1) > L.get(i-1) && L.get(i+1) <= L.get(i-1) + 3)
                        unsafe_up.add(i);
                    else {
                        unsafe_up.add(-1);
                        unsafe_up.add(-2);
                    }
                }
                if(!(L.get(i+1) < L.get(i) && L.get(i+1) >= L.get(i) - 3)) {
                    if(!unsafe_down.contains(i) && (i + 2 >= L.size() ||
                            L.get(i+2) < L.get(i) && L.get(i+2) >= L.get(i) - 3))
                        unsafe_down.add(i+1);
                    else if(i == 0 ||
                            L.get(i+1) < L.get(i-1) && L.get(i+1) >= L.get(i-1) - 3)
                        unsafe_down.add(i);
                    else {
                        unsafe_down.add(-1);
                        unsafe_down.add(-2);
                    }
                }
            }
            System.out.println(L + " " + unsafe_up + " " + unsafe_down);
            if(unsafe_up.size() <= 1 || unsafe_down.size() <= 1)
                ++s2;
        }
        System.out.println("Part 2: " + s2);
    }
}
