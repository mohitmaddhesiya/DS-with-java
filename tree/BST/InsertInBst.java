
public class InsertInBst {
    public static Node root = null;

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int num) {
            data = num;
            left = null;
            right = null;
        }
    }

    public static void insertItrativeWay(int num) {
        Node newNode = new Node(num);
        if (root == null) {
            root = newNode;
        } else {
            Node ptr = root;
            while (ptr != null) {
                if (ptr.data > num) {
                    if (ptr.left != null) {
                        ptr = ptr.left;
                    } else {
                        ptr.left = newNode;
                        break;
                    }
                } else {
                    if (ptr.right != null) {
                        ptr = ptr.right;
                    } else {
                        ptr.right = newNode;
                        break;
                    }
                }

            }
        }
    }
}