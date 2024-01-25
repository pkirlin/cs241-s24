import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class DLNode
{
    Object data;
    DLNode next = null, prev = null;
}

public class LinkedListPlayground2 {
    public static void main(String[] args)
    {
        LLNode a = new LLNode();
        LLNode b = new LLNode();
        LLNode c = new LLNode();
        a.data = 1;
        b.data = 2;
        c.data = 3;
        a.next = b;
        b.next = c;
        func(a);
    }

    public static void func(LLNode node)
    {
        if (node != null) {
            func(node.next);
            System.out.println(node.data);
            func(node.next);
        }
    }
}

class Whatevs
{
    public static void main(String[] args)
    {
        test3();
    }

    public static void test1() // forwads
    {
        DLNode a = new DLNode();
        DLNode b = new DLNode();
        DLNode c = new DLNode();
        DLNode d = new DLNode();
        DLNode e = new DLNode();
        DLNode f = new DLNode();
        a.data = 1;
        b.data = 2;
        c.data = 3;
        d.data = 4;
        e.data = 5;
        f.data = 6;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        a.prev = null;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;

        DLNode curr = a;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
    }

    public static void test2()  // backwards
    {
        DLNode a = new DLNode();
        DLNode b = new DLNode();
        DLNode c = new DLNode();
        DLNode d = new DLNode();
        DLNode e = new DLNode();
        DLNode f = new DLNode();
        a.data = 1;
        b.data = 2;
        c.data = 3;
        d.data = 4;
        e.data = 5;
        f.data = 6;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        a.prev = null;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;

        DLNode curr = f;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.prev;
        }
    }

    public static void test3()  // every other element
    {
        DLNode a = new DLNode();
        DLNode b = new DLNode();
        DLNode c = new DLNode();
        DLNode d = new DLNode();
        DLNode e = new DLNode();
        DLNode f = new DLNode();
        a.data = 1;
        b.data = 2;
        c.data = 3;
        d.data = 4;
        e.data = 5;
        f.data = 6;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        a.prev = null;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;

        DLNode curr = a;
        DLNode curr2 = e;
        boolean boo = true;

        while (curr != null && curr2 != null) {
            if (boo)
                System.out.print(curr.data);
            else
                System.out.print(curr2.data);

            boo = !boo;

            curr = curr.next;
            curr2 = curr2.prev;
        }
    }

}