import java.util.Queue;
import java.util.LinkedList;

public class Identical {
    public boolean levelOrder(BinaryTree.Node currentNode, BinaryTree.Node currentNode1) {
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        Queue<BinaryTree.Node> q1 = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        q1.add(currentNode1);
        while (!q.isEmpty() && !q1.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            BinaryTree.Node ptr1 = q1.poll();
            if (ptr != null && ptr1 != null) {
                if (ptr1.data != ptr.data) {
                    q.add(ptr);
                    break;
                }
            } else {
                if ((ptr1 != null && ptr == null) || (ptr != null && ptr1 == null)) {
                    break;
                }
            }
            if (ptr != null) {
                if (ptr.left != null) {
                    q.add(ptr.left);
                } else {
                    q.add(null);
                }
                if (ptr.rigth != null) {
                    q.add(ptr.rigth);
                } else {
                    q.add(null);
                }
            }
            if (ptr1 != null) {
                if (ptr1.left != null) {
                    q1.add(ptr1.left);
                } else {
                    q1.add(null);
                }
                if (ptr1.rigth != null) {
                    q1.add(ptr1.rigth);
                } else {
                    q1.add(null);
                }
            }

        }
        if (q.isEmpty() && q1.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    boolean recursive(BinaryTree.Node currentNode, BinaryTree.Node currentNode1) {
        if (currentNode == null && currentNode1 == null) {
            return true;
        }
        if (currentNode != null && currentNode1 != null) {
            boolean check = false;
            ;
            if (currentNode.data == currentNode1.data) {
                check = true;
            }
            return (check && recursive(currentNode.left, currentNode1.left)
                    && (recursive(currentNode.rigth, currentNode1.rigth)));
        }
        return false;
    }

}