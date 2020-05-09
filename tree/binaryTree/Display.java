import java.util.HashMap;
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

    public void printAncetorPath(BinaryTree.Node root, int key){
        if(root == null) 
            return; 
          
         // Create a stack to hold ancestors 
        Stack<BinaryTree.Node> st = new Stack<>(); 
          
        // Traverse the complete tree in postorder way till we find the key 
        while(true) 
        { 
              
            // Traverse the left side. While traversing, push the nodes into 
            // the stack so that their right subtrees can be traversed later 
            while(root != null && root.data != key) 
            { 
                st.push(root);   // push current node 
                root = root.left;   // move to next node 
            } 
              
            // If the node whose ancestors are to be printed is found, 
            // then break the while loop. 
            if(root != null && root.data == key) 
                break; 
              
            // Check if right sub-tree exists for the node at top 
            // If not then pop that node because we don't need this 
            // node any more. 
            if(st.peek().rigth == null) 
            { 
                root =st.peek(); 
             //   System.out.println(" if right null "+ root.data);
                st.pop(); 
                // If the popped node is right child of top, then remove the top 
                // as well. Left child of the top must have processed before. 
                while( st.empty() == false && st.peek().rigth == root) 
                { 
                    root = st.peek(); 
              //      System.out.println(" if right == root "+ root.data);
                    st.pop(); 
                } 
            } 
             
            // if stack is not empty then simply set the root as right child 
            // of top and start traversing right sub-tree. 
            root = st.empty() ? null : st.peek().rigth; 
            //System.out.println(" check root right "+ root.data);
            if(st.empty()){
                System.out.print(" \t Node does not exist in binary three Please check you value ");
                break;
            }
        } 
          
        // If stack is not empty, print contents of stack 
        // Here assumption is that the key is there in tree 
        if(!st.empty()){
            print(st);
        }
    }
    public void printAncetorPathWithMap(BinaryTree.Node currentNode, int data){
        BinaryTree.Node temp=currentNode;
        Stack<BinaryTree.Node> st =new Stack<BinaryTree.Node>();
        HashMap<BinaryTree.Node, BinaryTree.Node> map = new HashMap<BinaryTree.Node, BinaryTree.Node>();
        map.put(temp, null);
        while(true){
            while(temp!=null){
                map.put(temp.left, temp);
                st.push(temp);
                if(temp.data == data){
                    printMap(map, temp);
                    break;
                }
                temp = temp.left;
            }
            if(temp!=null){
                break;
            }
            if(st.isEmpty()){
                System.out.print(" \t Node does not exist in binary three Please check you value ");
                break;
            }
            BinaryTree.Node ptr=st.pop();
            if(ptr.rigth!=null ){
                map.put(ptr.rigth, ptr);
                temp=ptr.rigth;
            }
        }
    }

    private void print(Stack<BinaryTree.Node> st){
        System.out.print(" \t ");
        while(!st.isEmpty()){
            BinaryTree.Node temp=st.pop();
            System.out.print(temp.data + " -> ");
        }
        System.out.println(" null");
    }
    private void printMap(HashMap<BinaryTree.Node, BinaryTree.Node> map, BinaryTree.Node node){
        BinaryTree.Node temp=map.get(node);
        System.out.print(" \t ");
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = map.get(temp);
        }
        System.out.println(" null");
    }
    public void recursivePrint(BinaryTree.Node currentNode, int data) {
        recursive(currentNode, new int[1000], 0, data);
    }

    public void recursive(BinaryTree.Node currentNode, int arr[], int pos, int data) {
        if (currentNode == null) {
            return;
        }
        arr[pos] = currentNode.data;
        pos++;
        if (currentNode.data==data) {
            System.out.print(" \t ");
            for (int i = 0; i < pos; i++) {
                System.out.print(arr[i] + " -> ");
            }
            System.out.println(" null");
            return;
        } else {
            recursive(currentNode.left, arr, pos, data);
            recursive(currentNode.rigth, arr, pos, data);
        }

    }

}