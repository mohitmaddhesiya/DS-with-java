import java.util.Stack;

public class PreOrder {
    public void recursive(BinaryTree.Node currentNode) {
        if (currentNode == null)
            return;
        System.out.print("\t " + currentNode.data);
        recursive(currentNode.left);
        recursive(currentNode.rigth);
    }

    public void itertive(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        BinaryTree.Node temp = currentNode;
        while (temp != null) {
            System.out.print("\t " + temp.data);
            if (temp.rigth != null)
                st.push(temp.rigth);
            if (temp.left != null) {
                temp = temp.left;
            } else {
                if(st.empty()){
                    break;
                }
                temp = st.pop();
            }
        }
    }

    public void anotherLogic(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        BinaryTree.Node temp = currentNode;
        // st.push(temp);
       // int count=0;
        while (true) {
            while (temp != null) {
          //      count++;
                System.out.print("\t " + temp.data);
                st.push(temp.rigth);
                temp = temp.left;
            }
            if (st.empty()) {
                break;
            }
            temp = st.pop();
        }
      //  System.out.println(" szie of tree with PreOrder" + count);
    }
}