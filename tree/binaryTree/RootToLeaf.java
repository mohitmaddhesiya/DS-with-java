/**
 *    6
     /    \
    3      5
  /   \     \
 2     5     4
     /   \
    7     4

There are 4 leaves, hence 4 root to leaf paths -
  6->3->2              
  6->3->5->7
  6->3->5->4
  6->5>4
 */

import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class RootToLeaf {
    /**
     * Approach 1 using queue: we are storing element in queue we are marking rigth
     * sub tree as negative mark
     * 
     * @param currentNode
     */
    public void printAllRootToLeafPath(BinaryTree.Node currentNode) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Deque<Integer> deque = new LinkedList<Integer>();
        BinaryTree.Node temp = currentNode;
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

                while (iterator.hasNext()) {
                    int value = (int) iterator.next();
                    if (value < 0) {
                        System.out.print(-value + " -> ");
                    } else {
                        System.out.print(value + " -> ");
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

    /**
     * We can traverse tree iteratively (we have used iterative preorder). The
     * question is, how to extend the traversal to print root to leaf paths? The
     * idea is to maintain a map to store parent pointers of binary tree nodes. Now
     * whenever we encounter a leaf node while doing iterative preorder traversal,
     * we can easily print root to leaf path using parent pointer. Below is
     * implementation of this idea.
     */
    public void rootToLeafMap(BinaryTree.Node currentNode) {
        Map<BinaryTree.Node, BinaryTree.Node> map = new HashMap<BinaryTree.Node, BinaryTree.Node>();
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        st.push(currentNode);
        map.put(currentNode, null);
        while (!st.isEmpty()) {
            BinaryTree.Node ptr = st.pop();
            if (ptr.left == null && ptr.rigth == null) {
                // print bpttom to root
                print(ptr, map);
            }
            if (ptr.rigth != null) {
                st.push(ptr.rigth);
                map.put(ptr.rigth, ptr);
            }
            if (ptr.left != null) {
                st.push(ptr.left);
                map.put(ptr.left, ptr);
            }
        }

    }
  public void recursivePrint(BinaryTree.Node currentNode){
    recursive(currentNode, new int[1000], 0);
  }
    public void recursive(BinaryTree.Node currentNode, int arr[], int pos){
        if(currentNode==null){
            return;
        }
        arr[pos]=currentNode.data;
        pos++;
        if(currentNode.left==null && currentNode.rigth==null){
            System.out.print(" \t ");
            for(int i=0;i<pos;i++){
                System.out.print(arr[i] + " -> ");
            }
            System.out.println(" null");
            System.out.println(" ");
        }else{
            recursive(currentNode.left, arr, pos);
            recursive(currentNode.rigth, arr, pos);
        }

    }

    private void print(BinaryTree.Node current, Map<BinaryTree.Node, BinaryTree.Node> map) {
        Stack<Integer> st = new Stack<Integer>();
        BinaryTree.Node temp = current;
        while (temp != null) {
            st.push(temp.data);
            temp = map.get(temp);
        }
        System.out.print(" \t ");
        while (!st.isEmpty()) {
            int value = st.pop();
            System.out.print(value + " -> ");
        }
        System.out.println(" null");
        System.out.println(" ");
    }
}