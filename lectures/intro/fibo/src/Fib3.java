import java.util.Scanner;

public class Fib3 {
    private static long fib(int n) {
        if (n <= 1)
            return 1;

        long a = 1, b = 1, curr = 0;

        for (int x = 2; x <= n; x++)
        {
            curr = a + b;
            a = b;
            b = curr;
        }

        return curr;
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