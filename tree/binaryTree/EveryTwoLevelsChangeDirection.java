
/**
 * Given a binary tree, 
 * print the level order traversal in such a way,
 *  that first two levels are printed from left to right, 
 * next two levels are printed from right to left, then next two from left to right and so on. 
 * So, the problem is to reverse the direction of level order traversal of binary tree after every two levels.
 * Input: 
            1     
          /   \
        2       3
      /  \     /  \
     4    5    6    7
    / \  / \  / \  / \ 
   8  9 3   1 4  2 7  2
     /     / \    \
    16    17  18   19

    Output:
    
    1
    2 3
    7 6 5 4
    2 7 2 4 1 3 9 8
    16 17 18 19

    In the above example, first two levels
    are printed from left to right, next two
    levels are printed from right to left,
    and then last level is printed from 
    left to right.
 */
/**
 * solution: 
 * We make use of queue and stack here. 
 * Queue is used for performing normal level order traversal. 
 * Stack is used for reversing the direction of traversal after every two levels.
 * While doing normal level order traversal, 
 * first two levels nodes are printed at the time when they are popped out from the queue. 
 * For the next two levels, we instead of printing the nodes, pushed them onto the stack. 
 * When all nodes of current level are popped out, we print the nodes in the stack. 
 * In this way, we print the nodes in right to left order by making use of the stack. 
 * Now for the next two levels we again do normal level order traversal for printing nodes from left to right. 
 * Then for the next two nodes, we make use of the stack for achieving right to left order.
 */
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class EveryTwoLevelsChangeDirection {

  static void modifiedLevelOrder(BinaryTree.Node currentNode) {
    Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
    Stack<BinaryTree.Node> s = new Stack<BinaryTree.Node>();
    q.add(currentNode);
    q.add(null);
    int leveChange = 0;
    boolean rightToleft = false;
    while (!q.isEmpty()) {
      BinaryTree.Node ptr = q.poll();
      if (ptr == null) {
        if (q.peek() != null) {
          q.add(null);
          leveChange++;
        }
        if (rightToleft) {
          while (!s.isEmpty()) {
            System.out.print(" " + s.pop().data);
          }
        }
        if (leveChange == 2) {
          leveChange = 0;
          rightToleft = !rightToleft;
        }
        System.out.println("  ");
        continue;
      }
      if (rightToleft) {
        s.push(ptr);
      } else {
        System.out.print(" " + ptr.data);
      }
      if (leveChange == 2) {
        s.push(ptr);
      }
      if (ptr.left != null)
        q.add(ptr.left);
      if (ptr.rigth != null)
        q.add(ptr.rigth);
    }
  }
}