public class Main {
    public static void main(String[] args) {
        Time t1 = new Time();  // t1 is midnight
        Time t2 = new Time(9, 50);  // t2 is 9:50
        System.out.println(t1);   // calls toString
        System.out.println(t2);   // calls toString
        System.out.println(t2.toStringDebug());

        System.out.println("the minute is " + t2.getMinute());
        t2.setHour(10);
        t2.setMinute(7);
        System.out.println("the new time is " + t2);  // calls toString

        Time t3 = new Time(10, 7);
        System.out.println(t2 == t3); // false
        System.out.println(t2.equals(t3));

        TimeSeconds t4 = new TimeSeconds();
        System.out.println("my time seconds is " + t4);
    }
}