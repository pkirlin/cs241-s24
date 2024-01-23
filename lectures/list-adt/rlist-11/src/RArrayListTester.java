public class RArrayListTester {
    public static void main(String[] args) {
        RArrayList mylist = new RArrayList();
        System.out.println(mylist);   // this calls mylist.toString()
        mylist.append(10);
        System.out.println(mylist);
        mylist.append(20);
        System.out.println(mylist);
        mylist.append(30);
        System.out.println(mylist);
        mylist.append(40);
        System.out.println(mylist);
    }
}
