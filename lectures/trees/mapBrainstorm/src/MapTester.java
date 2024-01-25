import java.util.Scanner;

public class MapTester {
    public static void main(String[] args)
    {
        ArrayMap accounts = new ArrayMap();
        accounts.put(123, 50.23);
        accounts.put(456, 234.12);
        accounts.put(789, 98.00);

        System.out.println("What bank account do you want to look at?");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(accounts.get(num));

    }
}
