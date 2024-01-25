class LLNode
{
    Object data;
    LLNode next = null;
}

public class LinkedListPlayground {
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
