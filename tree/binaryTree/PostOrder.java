import java.util.Stack;

public class PostOrder {
    public void recursive(BinaryTree.Node currentTree) {
        if (currentTree == null)
            return;
        recursive(currentTree.left);
        recursive(currentTree.rigth);
        System.out.print("\t " + currentTree.data);
    }

    public void itervative(BinaryTree.Node currentTree) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        BinaryTree.Node temp = currentTree;
        while (true) {
            while (temp != null) {
                st.push(temp);
                if (temp.rigth != null) {
                    st.push(temp.rigth);
                    st.push(null);
                }
                temp = temp.left;
            }
            if (st.empty())
                break;
            BinaryTree.Node ptr = st.pop();
            while(ptr!=null){
                System.out.print("\t " + ptr.data); 
                if (st.empty())
                   break;
                ptr = st.pop();
            }
            if (st.empty())
              break;
            temp=st.pop();
        }
    }
    public void anotherLogic(BinaryTree.Node currentNode){
        Stack<BinaryTree.Node> st1 = new Stack<BinaryTree.Node>();
        Stack<BinaryTree.Node> st2 = new Stack<BinaryTree.Node>();
        st1.push(currentNode);
        while(!st1.empty()){
            BinaryTree.Node ptr=st1.pop();
            st2.push(ptr);
            if(ptr.left!=null){
                st1.push(ptr.left);
            }
            if(ptr.rigth!=null){
                st1.push(ptr.rigth);
            }
        }
        while(!st2.empty()){
            BinaryTree.Node ptr=st2.pop();
            System.out.print("\t " + ptr.data);
        }
    }
}