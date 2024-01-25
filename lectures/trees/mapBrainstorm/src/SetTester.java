import java.util.Scanner;

public class SetTester {
    public static void main(String[] args)
    {
        ArraySet rNumbers = new ArraySet();
        rNumbers.add(123);
        rNumbers.add(456);
        rNumbers.add(789);

        System.out.println("Enter an R number:");
        Scanner scan = new Scanner(System.in);
        int who = scan.nextInt();
        System.out.println(rNumbers.contains(who));

    }
}
