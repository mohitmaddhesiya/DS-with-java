import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class CountLeafNode {
    public void levelOrderCountLeaf(BinaryTree.Node currentnode) {
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentnode);
        while (!q.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            if (ptr.left == null & ptr.rigth == null) {
                System.out.print(" \t " + ptr.data);
            }
            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        System.out.println(" ");
    }

    public void itrativeOrderWithStack(BinaryTree.Node currentnode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        BinaryTree.Node temp = currentnode;
        while (true) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            if (st.isEmpty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            if (ptr.left == null && ptr.rigth == null) {
                System.out.print(" \t " + ptr.data);
            }
            if (ptr.rigth != null) {
                temp = ptr.rigth;
            }

        }
        System.out.println(" ");
    }
    public void recursiveCheck(BinaryTree.Node currentnode){
        if(currentnode==null){
              return ;
        }
        if(currentnode.left==null && currentnode.rigth==null){
            System.out.print(" \t " + currentnode.data);
        }
        recursiveCheck(currentnode.left);
        recursiveCheck(currentnode.rigth);
    }
}