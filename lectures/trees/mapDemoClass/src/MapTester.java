import java.util.ArrayList;
import java.util.Scanner;

public class MapTester {
    public static void main(String[] args)
    {
        ArrayMap bankAccounts = new ArrayMap();
        bankAccounts.put(123, 100);
        bankAccounts.put(456, 250);
        bankAccounts.put(789, 160);

        double bal = bankAccounts.get(456);
        System.out.println(bal);

        //ArrayList<Integer> bankAccounts2;
        //bankAccounts2.add(123);


    }
}
