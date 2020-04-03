import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    Node root = null;

    static class Node {
        Node rigth = null;
        Node left = null;
        int data;

        Node(int num) {
            data = num;
        }
    }

    public void insert(int num) {
        Node newNode = new Node(num);
        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            while (!q.isEmpty()) {
                Node ptr = q.poll();
                if (ptr.left == null) {
                    ptr.left = newNode;
                    break;
                } else {
                    q.add(ptr.left);
                }
                if (ptr.rigth == null) {
                    ptr.rigth = newNode;
                    break;
                } else {
                    q.add(ptr.rigth);
                }
            }
        }
    }
    // postorder recursive
    public void postOrderRecusive(Node currentNode){
        if(currentNode ==null){
          return;
        }
        postOrderRecusive(currentNode.left);
        postOrderRecusive(currentNode.rigth);
        System.out.print(" \t " +  currentNode.data);
    }
}