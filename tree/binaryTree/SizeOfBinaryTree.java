import java.util.Queue;
import java.util.LinkedList;
public class SizeOfBinaryTree {
    public int SizeWithLevelOrder(BinaryTree.Node currentNode) {
        int count = 0;
        if (currentNode == null) {
            System.out.println("No binary tree found to calculate size");
            return count;
        }
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        while (!q.isEmpty()) {
            count++;
            BinaryTree.Node ptr = q.poll();
            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        return count;
    }
    public int sizeWithRecursive(BinaryTree.Node current){
        if(current==null)
          return 0;
        if(current.left==null && current.rigth==null)
          return 1;
        return sizeWithRecursive(current.left) + 1 + sizeWithRecursive(current.rigth);

    }
   /* public int sizeWithPreOrderRecusive(BinaryTree.Node currentNode){
       if(currentNode==null)
         return 1;
        
    }*/
    //postoreder with recusion
    //inoder with recusion


}