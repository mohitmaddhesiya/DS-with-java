
public class Inorder {
    public static void recursiveDisplay(InsertInBst.Node root) {
        if (root == null) {
            return;
        }
        recursiveDisplay(root.left);
        System.out.print("  \t " + root.data);
        recursiveDisplay(root.right);
    }

    public static InsertInBst.Node sucessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node sucessorNode = null;
        while (root != null) {
            if (root.data == value) {
                root = root.right;
                break;
            }
            if (root.data > value) {
                sucessorNode = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        while (root != null) {
            sucessorNode = root;
            root = root.left;
        }
        return sucessorNode;
    }

    public static InsertInBst.Node predecessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        while (root != null) {
            if (root.data == value) {
                root = root.left;
                break;
            }
            if (root.data > value) {
                root = root.left;
            } else {
                predecessorNode = root;
                root = root.right;
            }
        }
        while (root != null) {
            predecessorNode = root;
            root = root.right;
        }
        return predecessorNode;
    }
}