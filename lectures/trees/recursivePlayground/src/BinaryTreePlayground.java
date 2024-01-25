class TreeNode
{
    Object data;
    TreeNode left = null;
    TreeNode right = null;
}

public class BinaryTreePlayground {
    public static void main(String[] args)
    {
        TreeNode a = new TreeNode();
        TreeNode b = new TreeNode();
        TreeNode c = new TreeNode();
        TreeNode d = new TreeNode();
        TreeNode e = new TreeNode();
        TreeNode f = new TreeNode();
        TreeNode g = new TreeNode();

        a.data = '+';
        a.left = b;
        a.right = c;

        b.data = '*';
        b.left = d;
        b.right = e;

        c.data = '/';
        c.left = f;
        c.right = g;

        d.data = 3;
        e.data = 4;
        f.data = 6;
        g.data = 2;

        func(a);
    }

    public static void func(TreeNode node)
    {
        if (node != null) {
            System.out.println(node.data);
            func(node.left);
            func(node.right);
        }
    }
}
