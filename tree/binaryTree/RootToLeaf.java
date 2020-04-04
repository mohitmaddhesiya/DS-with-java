/**
 * Print ALL path from root to leaf e.g : 10 / \ 20 40 \ / \ 30 50 60 output:
 * 10->20->30 10->40->50 10->40->60
 */

import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;

public class RootToLeaf {
     /**
      * Approach 1 using queue: we are storing element in queue
      * we are marking rigth sub tree as negative mark
      * @param currentNode
      */
     public void printAllRootToLeafPath(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Deque<Integer> deque = new LinkedList<Integer>();
        BinaryTree.Node temp = currentNode;
        // deque.addFirst(temp);
        while (true) {
            while (temp != null) {
                st.push(temp);
                deque.addLast(temp.data);
                temp = temp.left;
            }
            if (st.empty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            if (ptr.left == null && ptr.rigth == null) {
                System.out.print(" \t ");
                Iterator iterator = deque.iterator();

                while (iterator.hasNext()){
                    int value=(int)iterator.next();
                    if(value<0){
                        System.out.print( -value + " -> ");
                    }else{
                        System.out.print( value + " -> ");
                    }
                }
                System.out.println(" null");
                System.out.println(" ");
            }
            int num = deque.removeLast();
            if (num < 0) {
                while (num < 0) {
                    num = deque.removeLast();
                }
            }
            if (ptr.rigth != null) {
                deque.addLast(-ptr.data);
                temp = ptr.rigth;
            }
        }
    }

}