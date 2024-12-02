import days.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException {
        InitDays();
        PrintTime();
        SolveDay(2);
        //SolveDays(2);
    }

    static ArrayList<AoCDay> days = new ArrayList<>();
    static void InitDays() {
        days.add(new Day01("src/txt/input01.txt"));
        days.add(new Day02("src/txt/input02.txt"));
    }

    static void PrintTime() {
        System.out.println(LocalDate.now() + " " + LocalTime.now());
    }

    static void SolveDay(Integer n) throws IOException {
        days.get(n - 1).run();
    }

    static void SolveDays(Integer n) throws IOException {
        for(int i = 1; i <= n; ++i) {
            System.out.println();
            SolveDay(i);
        }
    }
}