import java.util.Stack;
public class InOrder {
    public void recursive(BinaryTree.Node currentNode) {
        if (currentNode == null) {
            return;
        }
        recursive(currentNode.left);
        System.out.print("\t " + currentNode.data);
        recursive(currentNode.rigth);
    }

    public void itertive(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        BinaryTree.Node temp = currentNode;
        //int count=0;
        while(true){
            while (temp != null) {
                st.push(temp);
                temp=temp.left;
            }
            if(st.empty()){
                break;
            }
            BinaryTree.Node ptr = st.pop();
            System.out.print("\t " + ptr.data);
            //count++;
            if (ptr.rigth != null) {
               temp=ptr.rigth;
            }     
        }
       // System.out.println(" size of tree with inorder" + count);
    }
}