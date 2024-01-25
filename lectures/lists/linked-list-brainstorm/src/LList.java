public class LList {
    private static class Node
    {
        public int data;
        public Node next = null;
    }

    private static void print1(Node node)
    {
        if (node != null)
        {
            System.out.println(node.data + " ");
            print1(node.next);
        }
    }

    private static void print2(Node node)
    {
        if (node != null)
        {
            print2(node.next);
            System.out.println(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Node mylist = new Node();
        mylist.data = 1;
        mylist.next = new Node();
        mylist.next.data = 2;
        mylist.next.next = new Node();
        mylist.next.next.data = 3;
        mylist.next.next.next = new Node();
        mylist.next.next.next.data = 4;

        print2(mylist);
    }


















    public static void main2(String[] args)
    {
        Node h1 = new Node();
        h1.data = 3;
        h1.next = new Node();
        h1.next.data = 6;
        h1.next.next = new Node();
        h1.next.next.data = 8;
        h1.next.next.next = new Node();
        h1.next.next.next.data = 9;

        Node h2 = new Node();
        h2.data = 1;
        h2.next = new Node();
        h2.next.data = 4;
        h2.next.next = new Node();
        h2.next.next.data = 6;

        //printCombined(h1, h2);
        //printCombined2(h1, h2);
        printCombined3(h1, h2);

        LList l1 = new LList();
        l1.append(5);
        l1.append(7);
        LList l2 = new LList();
        l2.append(5);
        //printCombined2(l1.head, l2.head);
        //printCombined(l1.head, l2.head);
    }

    public static void printCombined(Node h1, Node h2)
    {
        Node curr1 = h1, curr2 = h2;
        while (curr1 != null || curr2 != null)
        {
            if (curr1 == null)
            {
                System.out.println(curr2.data);
                curr2 = curr2.next;
            }
            else if (curr2 == null)
            {
                System.out.println(curr1.data);
                curr1 = curr1.next;
            }
            else if (curr1.data < curr2.data)
            {
                System.out.println(curr1.data);
                curr1 = curr1.next;
            }
            else if (curr2.data < curr1.data)
            {
                System.out.println(curr2.data);
                curr2 = curr2.next;
            }
            else // equal
            {
                System.out.println(curr2.data);
                curr2 = curr2.next;
                curr1 = curr1.next;
            }
        }
    }

    public static void printCombined2(Node h1, Node h2)
    {
        Node curr1 = h1, curr2 = h2;
        while (curr1 != null && curr2 != null)
        {
            if (curr1.data < curr2.data)
            {
                System.out.println(curr1.data);
                curr1 = curr1.next;
            }
            else if (curr2.data < curr1.data)
            {
                System.out.println(curr2.data);
                curr2 = curr2.next;
            }
            else // equal
            {
                System.out.println(curr2.data);
                curr2 = curr2.next;
                curr1 = curr1.next;
            }
        }
        while (curr1 != null) {
            System.out.println(curr1.data);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            System.out.println(curr2.data);
            curr2 = curr1.next;
        }
    }

    public static void printCombined3(Node head1, Node head2) {
        if (head1 == null) {
            while (head2 != null) {
                System.out.println(head2.data);
                head2 = head2.next;
            }
            return;
        } else if (head2 == null) {
            while (head1 != null) {
                System.out.println(head1.data);
                head1 = head1.next;
            }
            return;
        }
        if (head1.data < head2.data) {
            System.out.println(head1.data);
            head1 = head1.next;
            printCombined3(head1, head2);
        } else if (head2.data < head1.data) {
            System.out.println(head2.data);
            head2 = head2.next;
            printCombined3(head1, head2);
        } else if (head2.data == head1.data) {
            System.out.println(head2.data);
            head2 = head2.next;
            head1 = head1.next;
            printCombined3(head1, head2);
        }

    }

    private Node head;

    public LList copy()
    {
        // Copy head manually.
        Node head_newlist = new Node();
        head_newlist.data = head.data;
        Node prev_newlist = head_newlist;

        Node curr = head.next;  // already copied head, so skip it
        while (curr != null)
        {
            Node curr_newlist = new Node();
            curr_newlist.data = curr.data;
            prev_newlist.next = curr_newlist;
            prev_newlist = curr_newlist; // advance newlist

            curr = curr.next; // advance this list
        }

        LList newlist = new LList();
        newlist.head = head_newlist;
        return newlist;
    }

    public void append(int value) {
        if (head == null)
        {
            head = new Node();
            head.data = value;
        }
        else
        {
            Node curr = head;
            while (curr.next != null) // find last node
            {
                curr = curr.next; // walk through list
            }
            // last node found!
            Node newnode = new Node();
            newnode.data = value;
            curr.next = newnode;
        }
    }

    public String toString()
    {
        String answer = "[ ";
        Node curr = head;
        while (curr != null)
        {
            answer += (curr.data + " ");
            curr = curr.next;
        }
        return answer + "]";
    }
}
