/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. 
 * The boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. 
 * (The values of the nodes may still be duplicates.)
 * The left boundary is defined as the path from the root to the left-most node. 
 * The right boundary is defined as the path from the root to the right-most node. 
 * If the root doesn’t have left subtree or right subtree, 
 * then the root itself is left boundary or right boundary. 
 * Note this definition only applies to the input binary tree, and not apply to any subtrees.
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists. 
 * If not, travel to the right subtree. Repeat until you reach a leaf node.
 * Input:
              18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   20
 * 
 * Output: 18 15 40 50 100 20 30
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BoundarOrderTraversal {
    /**
     * 1) Traverse left-most nodes of the tree from top to down. (Left boundary)
     * 2) Traverse bottom-most level of the tree from left to right. (Leaf nodes)
     * 3) Traverse right-most nodes of the tree from bottom to up. (Right boundary)
     * 
     * We can traverse the left boundary quite easily with the help of a while loop that checks when the node doesn’t have any left child. 
     * Similarly, we can traverse the right boundary quite easily with the help of a while loop that checks when the node doesn’t have any right child.
     * The main challenge here is to traverse the last level of the tree in left to right order. 
     * To traverse level-wise there is BFS and order of left to right can be taken care of by pushing left nodes in the queue first. 
     * So the only thing left now is to make sure it is the last level. 
     * Just check whether the node has any child and only include them.
     * We will have to take special care of the corner case that same nodes are not traversed again. 
     * In the example above 40 is a part of the left boundary as well as leaf nodes. 
     * Similarly, 20 is a part of the right boundary as well as leaf nodes.
     *  So we will have to traverse only till the second last node of both the boundaries in that case. 
     * Also keep in mind we should not traverse the root again.
     * 
     * 
     * Below is the implementation of the above approach:
     */
     public void recursive(InsertInBst.Node root){
         //return if root null
         if(root==null)
            return;
        // print root node
        System.out.print(" " + root.data);
        // Traverse left-most nodes of the tree from top to down
        printLeftMostChild(root.left);
        // Traverse bottom-most level of the tree from left to right of left subtree. (Leaf nodes)
        printLeafNode(root.left);
        // Traverse bottom-most level of the tree from left to right of right subtree. (Leaf nodes)
        printLeafNode(root.right);
        // Traverse right-most nodes of the tree from bottom to up. (Right boundary)
        printRightMostChild(root.right);

     }
     public void itrativeWayAntiClockWise(InsertInBst.Node root){
         //return if root null
         if(root==null)
            return;
        // print root node
        // Traverse left-most nodes of the tree from top to down
        Stack<InsertInBst.Node> st=new Stack<InsertInBst.Node>();
        InsertInBst.Node temp = root;
        // Traverse left-most nodes of the tree from top to down
        while(temp!=null){
            System.out.print(" " + temp.data);
            // temp = temp.left;
            if(temp.left==null){
                temp  = temp.right;
                if(temp.left==null && temp.right==null){
                    break;
                }
            }else{
                temp = temp.left;
            }
        }
        temp = root;
        //Traverse bottom-most level of the tree from left to right and rigth to left of root. (Leaf nodes)
        while(true){
            while(temp!=null){
                st.push(temp);
                temp = temp.left;
            }
            if(st.isEmpty())
                break;
            InsertInBst.Node ptr = st.pop();
            if(ptr.left==null && ptr.right==null)
                System.out.print(" " + ptr.data);
            if(ptr.right!=null){
                temp=ptr.right;
            }
        }
        // Traverse right-most nodes of the tree from bottom to up. (Right boundary)
        temp=root.right;
        while(temp!=null){
            if(temp.left==null && temp.right==null){
                break;
            }
            st.push(temp);
            if(temp.right==null){
                temp  = temp.left;
            }else{
                temp = temp.right;
            }
        }
        while(!st.isEmpty()){
            System.out.print(" " + st.pop().data);
        }

     }
    // private void print
     // A function to print all left boundary nodes, except a leaf node. 
    // Print the nodes in TOP DOWN manner 
     private void printLeftMostChild(InsertInBst.Node root){
         if(root==null){
            return;
         }
        if(root.left!=null){
            System.out.print(" " + root.data);
            printLeftMostChild(root.left);
        }else{
            if(root.right!=null){
                System.out.print(" " + root.data);
                printLeftMostChild(root.right);
            }
        }
     }
     // A simple function to print leaf nodes of a binary tree 
     private void printLeafNode(InsertInBst.Node root){
         if(root==null)
            return;
         printLeafNode(root.left);   
         if(root.left==null && root.right==null)
            System.out.print(" " + root.data);
         printLeafNode(root.right);    
     }
    // A function to print all right boundary nodes, except a leaf node 
    // Print the nodes in BOTTOM UP manner 
     private void printRightMostChild(InsertInBst.Node root){
        if(root==null){
            return;
         }
        if(root.right!=null){
            printLeftMostChild(root.right);
            System.out.print(" " + root.data);
        }else{
            if(root.left!=null){
                printLeftMostChild(root.left);
                System.out.print(" " + root.data);
            }
        }
     }
    // Clock wise display boundry traversal
    /* 1) Traverse right-most nodes of the tree from top to down. (right boundary)
     * 2) Traverse bottom-most level of the tree from right to left. (Leaf nodes)
     * 3) Traverse left-most nodes of the tree from bottom to up. (left boundary)
     * */
    public void recursiveClockWise(InsertInBst.Node root){
        //return if root null
        if(root==null)
        return;
         // print root node
        System.out.print(" " + root.data);
        // Traverse right-most nodes of the tree from top to down
         printRightMostChildWithClockWise(root.right);
         // Traverse bottom-most level of the tree from right to left of right subtree. (Leaf nodes)
         printLeafNodeWithClockWise(root.right);
         // Traverse bottom-most level of the tree from right to left of left subtree. (Leaf nodes)
         printLeafNodeWithClockWise(root.left);
         // Traverse left-most nodes of the tree from bottom to up. (left boundary)
         printLeftMostChildWithClockWise(root.left);
    }
    public void itrativeWayClockWise(InsertInBst.Node root){
         //return if root null
        if(root==null)
         return;
        // print root node
        System.out.print(" " + root.data);
        Stack<InsertInBst.Node> st=new Stack<InsertInBst.Node>();
        InsertInBst.Node temp = root;
        // Traverse right-most nodes of the tree from up to bottom. (Right boundary)
        temp=root.right;
        while(temp!=null){
            if(temp.left==null && temp.right==null){
                break;
            }
            System.out.print(" " + temp.data);
            if(temp.right==null){
                temp  = temp.left;
            }else{
                temp = temp.right;
            }
        }
        temp=root;
         //Traverse bottom-most level of the tree from left to right and rigth to left of root. (Leaf nodes)
         while(true){
            while(temp!=null){
                st.push(temp);
                temp = temp.right;
            }
            if(st.isEmpty())
                break;
            InsertInBst.Node ptr = st.pop();
            if(ptr.left==null && ptr.right==null)
                System.out.print(" " + ptr.data);
            if(ptr.left!=null){
                temp=ptr.left;
            }
        }
        // Traverse right-most nodes of the tree from bottom to up. (Right boundary)
        temp=root.left;
        while(temp!=null){
            if(temp.left==null && temp.right==null){
                break;
            }
            st.push(temp);
            if(temp.left==null){
                temp  = temp.right;
            }else{
                temp = temp.left;
            }
        }
        while(!st.isEmpty()){
            System.out.print(" " + st.pop().data);
        }

    }
    private void printRightMostChildWithClockWise(InsertInBst.Node root){
        if(root==null)
        return;
        if(root.right!=null){
            System.out.print(" " + root.data);
            printRightMostChildWithClockWise(root.right);
        }else{
            if(root.left!=null){
                System.out.print(" " + root.data);
                printRightMostChildWithClockWise(root.left);
            }
        }
    }
    // A simple function to print leaf nodes of a binary tree 
    private void printLeafNodeWithClockWise(InsertInBst.Node root){
        if(root==null)
            return;
        
        printLeafNodeWithClockWise(root.right);   
        if(root.left==null && root.right==null)
            System.out.print(" " + root.data);
        printLeafNodeWithClockWise(root.left);    
    }
    // right most print element
    private void printLeftMostChildWithClockWise(InsertInBst.Node root){
        if(root==null){
            return;
         }
        if(root.left!=null){
            printLeftMostChildWithClockWise(root.left);
            System.out.print(" " + root.data);
        }else{
            if(root.right!=null){
                printLeftMostChildWithClockWise(root.right);
                System.out.print(" " + root.data);
            }
        }
     }
    
}