import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println(LocalDate.now() + " " + LocalTime.now());
        days.Day01 day01 = new days.Day01("input01.txt");
        day01.run();
    }
}