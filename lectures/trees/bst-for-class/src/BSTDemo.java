public class BSTDemo {
    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.add(0);
        bst.add(5);
        bst.add(8);
        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(4);
        bst.add(15);
        bst.add(25);
        bst.add(35);
        bst.add(45);
        bst.add(55);
        bst.preorder();
        System.out.println();
        bst.inorder();
        System.out.println();
        bst.postorder();

        bst.remove(10);
        bst.inorder();
        System.out.println();

        bst.remove(0);
        bst.inorder();
        System.out.println();

        bst.remove(8);
        bst.inorder();
        System.out.println();

        bst = new BST();
        bst.add(25);
        bst.add(15);
        bst.add(35);
        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(40);
        bst.add(8);
        bst.add(12);
        bst.add(18);
        bst.add(22);
        bst.add(28);
        bst.add(32);
        bst.add(38);
        bst.add(42);
        System.out.println("answer " + bst.countSmaller(31));
    }
}
