import java.time.LocalDate;
import java.time.LocalTime;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(LocalDate.now().toString() + " " + LocalTime.now().toString());
        days.Day01 day01 = new days.Day01("input01.txt");
        day01.run();
    }
}