import java.util.ArrayList;
import java.util.Scanner;

public class Fib2 {
    private static long fib(int n) {
        ArrayList<Long> cache = new ArrayList<Long>();
        cache.add((long)1);     // sets cache[0] = 1
        cache.add((long)1);     // sets cache[1] = 1
        for (int x = 2; x <= n; x++)
        {
            long newnumber = cache.get(x - 1) + cache.get(x - 2);
            cache.add(newnumber);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        while (true)
        {
            System.out.print("Enter an integer: ");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i == -1) break;
            System.out.println(fib(i));
        }
    }
}