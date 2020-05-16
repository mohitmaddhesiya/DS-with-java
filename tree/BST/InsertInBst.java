
public class InsertInBst {
    public static Node root = null;

    static class Node {
        Node left;
        Node right;
        Node parent;
        int data;

        Node(int num) {
            data = num;
            left = null;
            right = null;
            parent = null;
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
                        newNode.parent = ptr;
                        break;
                    }
                } else {
                    if (ptr.right != null) {
                        ptr = ptr.right;
                    } else {
                        ptr.right = newNode;
                        newNode.parent = ptr;
                        break;
                    }
                }

            }
        }
    }

    
}