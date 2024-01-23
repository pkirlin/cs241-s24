import java.util.Iterator;

public class RArrayListDemo {
    public static void main(String[] args)
    {
        RArrayList mylist = new RArrayList();
        System.out.println(mylist);
        mylist.append(1);
        mylist.append(2);
        System.out.println(mylist);
        mylist.append(4);
        mylist.append(7);
        System.out.println(mylist);

        for (Iterator<Integer> it = mylist.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }
    }
}
