import java.util.Scanner;

public class Fib1 {
    private static long fib(int n) {
        if (n <= 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
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