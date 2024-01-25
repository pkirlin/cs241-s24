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
        mylist.append(50);
        System.out.println(mylist);
        mylist.append(60);
        System.out.println(mylist);
        mylist.append(70);
        System.out.println(mylist);
        mylist.prepend(80);
        System.out.println(mylist);
        mylist.set(4, 1000);
        System.out.println(mylist);
        System.out.println("array index 4 is " + mylist.get(4));
    }
}
