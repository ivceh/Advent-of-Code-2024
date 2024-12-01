package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class AoCDay
{
    String fileName;
    LocalTime t1;
    static DecimalFormat formatter = new DecimalFormat("00");

    public AoCDay(String s) {
        this.fileName = s;
    }

    void read_file() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        read_from_buffer(reader);
        /*try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            read_from_buffer(reader);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        }*/
    }

    abstract void read_from_buffer(BufferedReader reader) throws IOException;

    public void run() throws IOException {
        t1 = LocalTime.now();
        read_file();
        solve();
        System.out.println(t1.until(LocalTime.now(), ChronoUnit.MILLIS) + " ms");
    }

    abstract void solve();
}
