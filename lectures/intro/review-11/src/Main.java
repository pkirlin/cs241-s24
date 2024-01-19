import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Time t1 = new Time(); // t1 is midnight
        Time t2 = new Time(11, 18);  // t2 represents 11:18 AM
        System.out.println(t1);   // calls t1.toString()
        System.out.println(t2);   // calls t2.toString()
        System.out.println(t2.toStringDebug());

        System.out.println(t2.getHour());
        t2.setHour(238);
        System.out.println(t2);

        Time t3 = new Time(11, 18);

        System.out.println(t2.equals(t3));
        t3.setMinute(59);
        System.out.println(t3.compareTo(t2));

        TimeSeconds t4 = new TimeSeconds();
        System.out.println(t4);
        t4.setHour(11);
        t4.setMinute(18);

        ArrayList<Time> times = new ArrayList<>();
        times.add(t4);
        times.add(t3);
        times.add(t2);
        times.add(t1);

        System.out.println(times);
        Collections.sort(times);
        System.out.println(times);
    }
}