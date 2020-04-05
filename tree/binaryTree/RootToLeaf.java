
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
/**
 * Problem: Root to leaf path sun equal to a given number
 * 21 –> 10 – 8 – 3
   23 –> 10 – 8 – 5
   14 –> 10 – 2 – 2
 * So the returned value should be true only for numbers 21, 23 and 14. 
 * For any other number, returned value should be false.
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

    public void recursivePrint(BinaryTree.Node currentNode) {
        recursive(currentNode, new int[1000], 0);
    }

    public void recursive(BinaryTree.Node currentNode, int arr[], int pos) {
        if (currentNode == null) {
            return;
        }
        arr[pos] = currentNode.data;
        pos++;
        if (currentNode.left == null && currentNode.rigth == null) {
            System.out.print(" \t ");
            for (int i = 0; i < pos; i++) {
                System.out.print(arr[i] + " -> ");
            }
            System.out.println(" null");
            System.out.println(" ");
        } else {
            recursive(currentNode.left, arr, pos);
            recursive(currentNode.rigth, arr, pos);
        }

    }

    /**
     * Given a binary tree and a number, return true if the tree has a root-to-leaf
     * path such that adding up all the values along the path equals the given
     * number. Return false if no such path can be found.
     * 
     * @param current
     * @param map
     */
    public void rootToLeafSum(BinaryTree.Node currentNode, int sum) {
        Map<BinaryTree.Node, BinaryTree.Node> map = new HashMap<BinaryTree.Node, BinaryTree.Node>();
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        st.push(currentNode);
        map.put(currentNode, null);
        while (!st.isEmpty()) {
            BinaryTree.Node ptr = st.pop();
            if (ptr.left == null && ptr.rigth == null) {
                // print bpttom to root
                if (sumCheck(ptr, map, sum)) {
                    st.push(ptr);
                    break;
                }
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
        if (st.isEmpty()) {
            System.out.println(" \t No Path found for given sum " + sum);
        }
    }

    public void rootToLeafSumWithDeque(BinaryTree.Node currentNode, int sum) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Deque<Integer> deque = new LinkedList<Integer>();
        BinaryTree.Node temp = currentNode;
        int nodeSum = 0;
        while (true) {
            while (temp != null) {
                nodeSum = nodeSum + temp.data;
                st.push(temp);
                deque.addLast(temp.data);
                temp = temp.left;
            }
            if (st.empty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            if (nodeSum == sum) {
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
                st.push(temp);
                break;
            }
            int num = deque.removeLast();
            if (num < 0) {
                nodeSum = nodeSum + num;
                while (num < 0) {
                    num = deque.removeLast();
                    if (num < 0) {
                        nodeSum = nodeSum + num;
                    }
                }
            }
            if (ptr.rigth != null) {
                deque.addLast(-ptr.data);
                temp = ptr.rigth;
            } else {
                nodeSum = nodeSum - num;
            }
        }
        if (st.isEmpty()) {
            System.out.println(" \t No Path found for given sum " + sum);
        }
    }

    public void rootToleafRecursiveSum(BinaryTree.Node currentNode, int sum) {
        rootToLeafSumRecursive(currentNode, sum, 0, new int[1000], 0);
    }

    public void rootToLeafSumRecursive(BinaryTree.Node currentNode, int sum, int nodeSum, int arr[], int pos) {
        if (currentNode == null) {
            return;
        }
        nodeSum = currentNode.data + nodeSum;
        arr[pos] = currentNode.data;
        pos++;
        if (sum == nodeSum) {
            System.out.print(" \t ");
            for (int i = 0; i < pos; i++) {
                System.out.print(arr[i] + " -> ");
            }
            System.out.println(" null");
            System.out.println(" ");
            return;
        }
        rootToLeafSumRecursive(currentNode.left, sum, nodeSum, arr, pos);
        rootToLeafSumRecursive(currentNode.rigth, sum, nodeSum, arr, pos);
    }
    /**
     * Recursively check if left or right child has path sum equal to ( number – value at current node)
     * Given a tree and a sum, return true if there is a path from the root 
     down to a leaf, such that adding up all the values along the path 
     equals the given sum. 
    
     Strategy: subtract the node value from the sum when recurring down, 
     and check to see if the sum is 0 when you run out of tree. 
     */
    boolean rootToLeafSumCheck(BinaryTree.Node node, int sum){
        if (node == null) 
            return (sum == 0); 
        else 
        { 
            boolean ans = false;    
           /* otherwise check both subtrees */
            int subsum = sum - node.data; 
            if (subsum == 0 && node.left == null && node.rigth == null) 
                return true; 
            if (node.left != null) 
                ans = ans || rootToLeafSumCheck(node.left, subsum); 
            if (node.rigth != null) 
                ans = ans || rootToLeafSumCheck(node.rigth, subsum); 
            return ans; 
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

    private boolean sumCheck(BinaryTree.Node current, Map<BinaryTree.Node, BinaryTree.Node> map, int sum) {
        Stack<Integer> st = new Stack<Integer>();
        BinaryTree.Node temp = current;
        int nodeSum = 0;
        while (temp != null) {
            nodeSum = nodeSum + temp.data;
            st.push(temp.data);
            temp = map.get(temp);
        }
        if (nodeSum == sum) {
            System.out.print(" \t ");
            while (!st.isEmpty()) {
                int value = st.pop();
                System.out.print(value + " -> ");
            }
            System.out.println(" null");
            System.out.println(" ");
            return true;
        } else {
            return false;
        }

    }
}