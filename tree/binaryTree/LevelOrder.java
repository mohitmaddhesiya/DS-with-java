import java.util.LinkedList;
import java.util.Queue;


public class LevelOrder {
    public void Itrator(BinaryTree.Node currentNode) {
        System.out.println(" ================================== ");
        if (currentNode == null) {
            System.out.println(" No Binary Tree found to display ");
            return;
        }
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        while (!q.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            System.out.print(" \t " + ptr.data);
            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        System.out.println();
        System.out.println(" ====================================== ");
    }
}