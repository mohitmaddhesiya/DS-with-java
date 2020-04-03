import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class HeigthOfTree {
    public int levelOrderHeigth(BinaryTree.Node currentNode) {
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        q.add(null);
        int count = 0;
        while (!q.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            if (ptr == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                count++;
                continue;
            }
            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        return count;
    }

    public int tryWithOtherLogic(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Stack<Integer> st1 = new Stack<Integer>();

        BinaryTree.Node temp = currentNode;
        int heigth = 0;
        int max = -999;
        while (true) {
            while (temp != null) {
                heigth++;
                st.push(temp);
                st1.push(heigth);
                temp = temp.left;
            }
            if (st.empty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            heigth = st1.pop();
            if (ptr.left == null && ptr.rigth == null) {
                if (max < heigth) {
                    max = heigth;
                }
                temp = null;
            } else {
                if (ptr.rigth != null) {
                    temp = ptr.rigth;
                } else {
                    temp = null;
                }
            }
        }
        return max;
    }

    public int recursive1(BinaryTree.Node currentNode){
       if(currentNode==null){
             return 0;
       }else{
           int l=recursive1(currentNode.left);
           int r=recursive1(currentNode.rigth);
           return max(l,r)+1;
       }
    }
    public int recursive2(BinaryTree.Node currentNode){
        if(currentNode==null)
            return 0;
         return 1+max(recursive1(currentNode.left),recursive1(currentNode.rigth));
    }
    int max(int a,int b){
           if(a>b){
               return a;
           }else{
               return b;
           }
    }
}