/** problem: 
 *        1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9            
    The output of print this tree vertically will be:
    4
    2
    1 5 6
    3 8
    7
    9 
 */
import java.util.HashMap;
import java.util.TreeMap;
import java.util.SortedMap; 
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    static class Pair {
        int hd;
        InsertInBst.Node treeNode; 
        Pair(int value, InsertInBst.Node node){
            hd = value;
            treeNode = node;
        }
    }
    int min=99999;
    int max=-9999;
    HashMap<Integer, LinkedList> map= new HashMap<Integer, LinkedList>();
    /**
     * an efficient solution based on the hash map is discussed. 
     * We need to check the Horizontal Distances from the root for all nodes. 
     * If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line. 
     * The idea of HD is simple. HD for root is 0, 
     * a right edge (edge connecting to right subtree) is considered as +1 horizontal distance 
     * and a left edge is considered as -1 horizontal distance. For example, in the above tree, 
     * HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
     * We can do preorder traversal of the given Binary Tree. While traversing the tree, 
     * we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root. 
     * For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. 
     * For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1. 
     * For every HD value, we maintain a list of nodes in a hash map. Whenever we see a node in traversal, 
     * we go to the hash map entry and add the node to the hash map using HD as a key in a map.
     * 
     * @param node
     * @param root
     * 
     */
    // node in this salution order will not matter , it will print anyorder
    public void recursive(InsertInBst.Node node){
        recursiveCall(node,0);
        for (Map.Entry<Integer, LinkedList> entry : map.entrySet()){
            System.out.println("group = " + entry.getKey() +  ", values = " + entry.getValue()); 

        }  

    }
    private void recursiveCall(InsertInBst.Node node, int root){
        if(node==null)
            return;      
        if(map.get(root)==null){
            LinkedList<Integer>  temp = new LinkedList<Integer>();
            temp.addFirst(node.data);
            map.put(root,temp);
        }else{
            map.get(root).addLast(node.data); 
        }
        //map.put(root, node);
        recursiveCall(node.left, root-1);
        recursiveCall(node.right, root+1);
    }
    /**
     * The above solution uses preorder traversal and Hashmap to store nodes according to horizontal distances. 
     * Since above approach uses preorder traversal, 
     * nodes in a vertical line may not be prined in same order as they appear in tree. 
     * For example, the above solution prints 12 before 9 in below tree. See this for a sample run.

             1
          /     \
         2       3
        /  \    /  \
       4    5  6    7
                \  /  \
                 8 10  9 
                     \
                     11
                       \
                        12      
     * If we use level order traversal, 
     * we can make sure that if a node like 12 comes below in same vertical line, 
     * it is printed after a node like 9 which comes below in vertical line.
     * Time Complexity of below implementation is O(n Log n). 
     * Note that below implementation use sorted map which is implemented using self-balancing BST.
     * We can reduce time complexity to O(n) using unordered_map. To print nodes in desired order, 
     * we can have 2 variables denoting min and max horizontal distance.
     *  We can simply iterate from min to max horizontal distance and get corresponding values from Map. 
     * So it is O(n)
     * @param node
     * @param root
     */
    public void levelOrderWithHaspMap(InsertInBst.Node node){
        SortedMap<Integer, LinkedList> vertialOrder=new TreeMap<Integer, LinkedList>();
       // LinkedList<Integer> linked=new LinkedList<Integer>();
        Queue<Pair> queue=new LinkedList<Pair>();
        queue.add(new Pair(0, node));
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            //System.out.println("group = " + pair.hd); 

            LinkedList getValue = vertialOrder.get(pair.hd);
            if(getValue==null){
                getValue = new LinkedList<Integer>();
                getValue.add(pair.treeNode.data);
               // getValue.add(pair.treeNode.data);
                vertialOrder.put(pair.hd,getValue);
            }else{ 
                getValue.addLast(pair.treeNode.data);
                vertialOrder.put(pair.hd, getValue);
            }
            if(pair.treeNode.left!=null){
                queue.add(new Pair(pair.hd-1, pair.treeNode.left));
            }
            if(pair.treeNode.right!=null){
                queue.add(new Pair(pair.hd+1, pair.treeNode.right));
            } 
        }
       // vertialOrder
       for (Map.Entry<Integer, LinkedList> entry : vertialOrder.entrySet()){
            System.out.println("group = " + entry.getKey() +  ", values = " + entry.getValue()); 

        }
    } 
    /**
     * The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root. 
     * For the tree shown above, minimum distance is -3 (for node with value 4) and maximum distance is 3 (For node with value 9).
     * Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root, 
     * and for each vertical line traverse the tree and print the nodes which lie on that vertical line.
     * complexity is  O(n2) solution
     * @param node
     */
    public void withHasMap(InsertInBst.Node node){
        findMinMax(node, 0);
        for(int i=min;i<=max;i++){
            System.out.print(" group  = " + i + " \t");
            printVerticalOrder(node, 0, i);
            System.out.println("");
        }
    }
    private void printVerticalOrder(InsertInBst.Node node, int hd, int group){
        if(node==null){
            return;
        }
        if(hd==group){
            System.out.print(" " + node.data);
        }
        printVerticalOrder(node.left, hd-1, group);
        printVerticalOrder(node.right, hd+1, group);
    }

    private void findMinMax(InsertInBst.Node node, int hd){
        if(node==null)
            return;
        if(hd<min)
            min=hd;
        if(hd>max)
            max=hd;
        findMinMax(node.left, hd-1);
        findMinMax(node.right, hd+1);
    }
}