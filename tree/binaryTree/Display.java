import java.util.Stack;

public class Display {

    public void sprialOrder(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st1 = new Stack<BinaryTree.Node>();
        Stack<BinaryTree.Node> st2 = new Stack<BinaryTree.Node>();
        st1.push(currentNode);
        while (true) {
            while (!st1.isEmpty()) {
                BinaryTree.Node ptr = st1.pop();
                System.out.print("\t " + ptr.data);
                if (ptr.left != null) {
                    st2.push(ptr.left);
                }
                if (ptr.rigth != null) {
                    st2.push(ptr.rigth);
                }
            }
            while (!st2.isEmpty()) {
                BinaryTree.Node ptr = st2.pop();
                System.out.print("\t " + ptr.data);
                if (ptr.rigth != null) {
                    st1.push(ptr.rigth);
                }
                if (ptr.left != null) {
                    st1.push(ptr.left);
                }
            }
            if (st1.isEmpty() && st2.isEmpty()) {
                break;
            }
        }
    }
}