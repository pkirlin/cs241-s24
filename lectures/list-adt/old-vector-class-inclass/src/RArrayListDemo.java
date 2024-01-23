public class RArrayListDemo
{
    public static void main(String[] args)
    {
        RArrayList mylist = new RArrayList();
        System.out.println(mylist);
        mylist.append(7);
        System.out.println(mylist);
        mylist.append(9);
        System.out.println(mylist);
        mylist.append(2);
        System.out.println(mylist);
        mylist.append(-1);
        System.out.println(mylist);
        mylist.prepend(6);
        System.out.println(mylist);
        mylist.prepend(10);
        mylist.prepend(11);
        System.out.println(mylist);
    }
}