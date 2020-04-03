import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class DepthOfTree {
    public int levelOrderDepth(BinaryTree.Node currentNode, int value) {
        int depth = 0;
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        q.add(null);
        while (!q.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            if (ptr == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                depth++;
                continue;
            }
            if (ptr.data == value) {
                break;
            }

            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        if (q.isEmpty()) {
            return 0;
        }
        return depth;
    }

    public int tryWithOtherLogic(BinaryTree.Node currentNode, int num) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Stack<Integer> st1 = new Stack<Integer>();

        BinaryTree.Node temp = currentNode;
        int depth = 0;
        int max = -999;
        while (true) {
            while (temp != null) {
                if(temp.data==num){
                    max=depth;
                   break;
                }
                depth++;
                st.push(temp);
                st1.push(depth);
                temp = temp.left;
            }
            if(temp!=null){
                break;
            }
            if (st.empty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            depth = st1.pop();
            if (ptr.rigth != null) {
                temp = ptr.rigth;
            }
        }
        return max;
    }
    public void recursive1(BinaryTree.Node currentNode, int num, int heigth, int sum){
     if(currentNode==null){
         return;
     }
     if(currentNode.data==num){
           System.out.println(" Heigth with data==num  " + heigth);
           System.out.println(" sum of node   " + sum);
     }
     //System.out.println(" currentNode.data "  + currentNode.data + " and heigth "+ heigth);
     recursive1(currentNode.left,num,heigth+1, sum+currentNode.data);
     recursive1(currentNode.rigth, num,heigth+1, sum+currentNode.data);
    // return;
    }
}