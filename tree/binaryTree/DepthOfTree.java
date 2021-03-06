import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Map;
import java.util.Deque;
import java.util.Iterator;

public class DepthOfTree {
    public int levelOrderDepth(BinaryTree.Node currentNode, int value) {
        int depth = 0;
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(currentNode);
        q.add(null);
        while (!q.isEmpty()) {
            BinaryTree.Node ptr = q.poll();
            if (ptr == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                depth++;
                continue;
            }
            if (ptr.data == value) {
                break;
            }

            if (ptr.left != null) {
                q.add(ptr.left);
            }
            if (ptr.rigth != null) {
                q.add(ptr.rigth);
            }
        }
        if (q.isEmpty()) {
            return 0;
        }
        return depth;
    }

    public int tryWithOtherLogic(BinaryTree.Node currentNode, int num) {
        Stack<BinaryTree.Node> st = new Stack<BinaryTree.Node>();
        Stack<Integer> st1 = new Stack<Integer>();

        BinaryTree.Node temp = currentNode;
        int depth = 0;
        int max = -999;
        while (true) {
            while (temp != null) {
                if (temp.data == num) {
                    max = depth;
                    break;
                }
                depth++;
                st.push(temp);
                st1.push(depth);
                temp = temp.left;
            }
            if (temp != null) {
                break;
            }
            if (st.empty()) {
                break;
            }
            BinaryTree.Node ptr = st.pop();
            depth = st1.pop();
            if (ptr.rigth != null) {
                temp = ptr.rigth;
            }
        }
        return max;
    }

    public void depthSumRecusrsive(BinaryTree.Node currentNode, int num, int sum) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.data == num) {
            System.out.println("       sum of node   " + sum);
        } else {
            depthSumRecusrsive(currentNode.left, num, sum + currentNode.data);
            depthSumRecusrsive(currentNode.rigth, num, sum + currentNode.data);
        }
    }

    public int recursive2(BinaryTree.Node currentNode, int num, int heigth) {
        if (currentNode == null) {
            return 0;
        }
        if (currentNode.data == num) {
            return heigth;
        } else {
            int h = recursive2(currentNode.left, num, heigth + 1);
            int h2 = recursive2(currentNode.rigth, num, heigth + 1);
            if (heigth < h) {
                return h;
            } else {
                if (heigth < h2) {
                    return h2;
                }else{
                    return heigth;
                }
            }
        }
    }

    public void recursivePrintDepathPath(BinaryTree.Node currentNode, int num) {
        DepthPathrecursive(currentNode, new int[1000], 0, num);
    }

    public void DepthPathrecursive(BinaryTree.Node currentNode, int arr[], int pos, int num) {
        if (currentNode == null) {
            return;
        }
        arr[pos] = currentNode.data;
        pos++;
        if (currentNode.data == num) {
            System.out.print(" \t ");
            for (int i = 0; i < pos; i++) {
                System.out.print(arr[i] + " -> ");
            }
            System.out.println(" null");
            System.out.println(" ");
        } else {
            DepthPathrecursive(currentNode.left, arr, pos, num);
            DepthPathrecursive(currentNode.rigth, arr, pos, num);
        }
    }
    public void depthPathItrativeWithMap(BinaryTree.Node currentNode, int num){
        HashMap<BinaryTree.Node, BinaryTree.Node> map=new HashMap<BinaryTree.Node,BinaryTree.Node>();
        Stack<BinaryTree.Node> st=new Stack<BinaryTree.Node>();
        st.push(currentNode);
        map.put(currentNode, null);
        while(!st.isEmpty()){
            BinaryTree.Node temp=st.pop();
            if(temp.data==num){
                // print path and break;
                print(temp, map);
                break;
            }
            if(temp.rigth!=null){
                st.push(temp.rigth);
                map.put(temp.rigth, temp);
            }
            if(temp.left!=null){
                st.push(temp.left);
                map.put(temp.left, temp);
            }
        }
    }
    public void depthPathItrativeWithDequeue(BinaryTree.Node currentNode, int nodeValue){
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
            if (ptr.data == nodeValue) {
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
                break;
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