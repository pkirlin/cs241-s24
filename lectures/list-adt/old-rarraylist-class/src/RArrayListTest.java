public class RArrayListTest
{
    public static void main(String[] args)
    {
        RArrayList mylist = new RArrayList(); // the list should be empty
        System.out.println(mylist);
        System.out.println("the user thinks the list size is " + mylist.size());
        mylist.append(20);
        System.out.println(mylist);
        System.out.println(mylist.toInternalString());
        System.out.println("the user thinks the list size is " + mylist.size());

        mylist.append(40);
        System.out.println(mylist);
        System.out.println(mylist.toInternalString());
        System.out.println("the user thinks the list size is " + mylist.size());

        mylist.append(60);
        System.out.println(mylist);
        System.out.println(mylist.toInternalString());
        System.out.println("the user thinks the list size is " + mylist.size());

        mylist.append(80);
        System.out.println(mylist);
        System.out.println(mylist.toInternalString());
        System.out.println("the user thinks the list size is " + mylist.size());
    }
}
