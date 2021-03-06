
public class BST {

    static void insertInBST(InsertInBst bst) {
        bst.insertItrativeWay(50);
        bst.insertItrativeWay(40);
        bst.insertItrativeWay(80);
        bst.insertItrativeWay(30);
        bst.insertItrativeWay(45);
        bst.insertItrativeWay(75);
        bst.insertItrativeWay(90);
        bst.insertItrativeWay(78);
        bst.insertItrativeWay(82);
        bst.insertItrativeWay(91);
        bst.insertItrativeWay(5);
        bst.insertItrativeWay(10);
        bst.insertItrativeWay(35);
        bst.insertItrativeWay(42);
        bst.insertItrativeWay(48);
        bst.insertItrativeWay(44);
        bst.insertItrativeWay(43);
        bst.insertItrativeWay(8);
        bst.insertItrativeWay(9);
    }

    public static void inorder(InsertInBst.Node root, int num) {
        System.out.println(" ");
        System.out.println(" '''''''''' recursive inorder approach display ''''''''''' ");
        Inorder in = new Inorder();
        in.recursiveDisplay(root);
        System.out.println(" ");
        System.out.println(" ---------  Print sucessor node with itrative way of given node ------------   ");
        InsertInBst.Node sucessorResult = in.sucessorItrativeWay(root, num);
        if (sucessorResult == null) {
            System.out.println("         No sucessor found of node without parent node " + num);
        } else {
            System.out.println("         " + sucessorResult.data + " sucessor found of node without parent node " + num);
        }
        InsertInBst.Node sucessorResultParent = in.sucessorWithParentWay(root, num);
        if (sucessorResultParent == null) {
            System.out.println("         No sucessor found of node  with parent node " + num);
        } else {
            System.out.println("         " + sucessorResultParent.data + " sucessor found of node  with parent node " + num);
        }
        System.out.println(" ");
        System.out.println(" ---------  Print predecessor node  with itrative way of given node ------------   ");
        InsertInBst.Node predecessorResult = in.predecessorItrativeWay(root, num);
        if (predecessorResult == null) {
            System.out.println("         No predecessor found of node without parent node " + num);
        } else {
            System.out.println("         " + predecessorResult.data + " predecessor found of node without parent node " + num);
        }
        InsertInBst.Node predecessorParentResult = in.predecessorWithParentWay(root, num);
        if (predecessorParentResult == null) {
            System.out.println("         No predecessor found of node with parent node " + num);
        } else {
            System.out.println("         " + predecessorParentResult.data + " predecessor found of node with parent node " + num);
        }
        System.out.println(" ");
    }
    public static void predorder(InsertInBst.Node root, int num) {
        System.out.println(" ");
        System.out.println(" '''''''''' recursive preorder approach display ''''''''''' ");
        Preorder pre = new Preorder();
        pre.recursiveDisplay(root);
        System.out.println(" ");
        System.out.println(" ---------  Print sucessor node with itrative way of given node ------------   ");
        InsertInBst.Node sucessorResult = pre.sucessorItrativeWay(root, num);
        if (sucessorResult == null) {
            System.out.println("         No sucessor found of node without parent node " + num);
        } else {
            System.out.println("         " + sucessorResult.data + " sucessor found of node without parent node " + num);
        }
        InsertInBst.Node sucessorParentResult = pre.sucessorWithParentWay(root, num);
        if (sucessorParentResult == null) {
            System.out.println("         No sucessor found of node with parent node " + num);
        } else {
            System.out.println("         " + sucessorParentResult.data + " sucessor found of node with parent node " + num);
        }
        System.out.println(" ---------  Print predecessor node  with itrative way of given node ------------   ");
        InsertInBst.Node predecessorResult = pre.predecessorItrativeWay(root, num);
        if (predecessorResult == null) {
            System.out.println("         No predecessor found of node without parent node " + num);
        } else {
            System.out.println("         " + predecessorResult.data + " predecessor found of node without parent node " + num);
        }
        InsertInBst.Node predecessorParentResult = pre.predecessorWithParentWay(root, num);
        if (predecessorParentResult == null) {
            System.out.println("         No predecessor found of node with parent node " + num);
        } else {
            System.out.println("         " + predecessorParentResult.data + " predecessor found of node with parent node " + num);
        }
        System.out.println(" ");
    }
    public static void postorder(InsertInBst.Node root, int num) {
        System.out.println(" ");
        System.out.println(" '''''''''' recursive postorder approach display ''''''''''' ");
        Postorder post = new Postorder();
        post.recursiveDisplay(root);
        System.out.println(" ");
        System.out.println(" ---------  Print sucessor node with itrative way of given node ------------   ");
        InsertInBst.Node sucessorResult = post.sucessorItrativeWay(root, num);
        if (sucessorResult == null) {
            System.out.println("         No sucessor found of node without parent node without parent node " + num);
        } else {
            System.out.println("         " + sucessorResult.data + " sucessor found of node  without parent node without parent node " + num);
        }
        InsertInBst.Node sucessorParentResult = post.sucessorWithParentWay(root, num);
        if (sucessorParentResult == null) {
            System.out.println("         No sucessor found of node without parent node with parent node " + num);
        } else {
            System.out.println("         " + sucessorParentResult.data + " sucessor found of node  without parent node with parent node " + num);
        }
        System.out.println(" ---------  Print predecessor node  with itrative way of given node ------------   ");
        InsertInBst.Node predecessorResult = post.predecessorItrativeWay(root, num);
        if (predecessorResult == null) {
            System.out.println("         No predecessor found of node with parent node " + num);
        } else {
            System.out.println("         " + predecessorResult.data + " predecessor found of node with parent node " + num);
        }
        InsertInBst.Node predecessorParentResult = post.predecessorWithParentWay(root, num);
        if (predecessorParentResult == null) {
            System.out.println("         No predecessor found of node without parent node " + num);
        } else {
            System.out.println("         " + predecessorParentResult.data + " predecessor found of node without parent node " + num);
        }
        System.out.println(" ");
    }
    public static void diplayOtherWay(InsertInBst.Node root){
        System.out.println(" ");
        System.out.println(" '''''''''' Travel via parent node  ''''''''''' ");
        DisplayOtherWay dis = new DisplayOtherWay();
        dis.displayByParentNode(root);
        System.out.println(" ");

    }
    public static void deleteNode(InsertInBst.Node root, int nodeValue){
        System.out.println(" ");
        System.out.println(" '''''''''' Delete node with parent poniter   ''''''''''' ");
        DeleteInBst de = new DeleteInBst();
        de.removeNodeWithParent(root, nodeValue);
        System.out.println(" ");
        de.removeNodeWithOutParent(root, nodeValue);
        System.out.println(" ");
    }
    public static void  printVertialOrder(InsertInBst.Node root){
        VerticalOrderTraversal v= new VerticalOrderTraversal();
        System.out.println(" '''''''''' Recursive approach with hash map   ''''''''''' ");
        v.recursive(root);
        System.out.println(" ");
        System.out.println(" '''''''''' Without hashmap approah order but vertial order will not matter   ''''''''''' ");
        v.withHasMap(root);
        System.out.println(" ");
        System.out.println(" '''''''''' itrative order with haspmap and levelorder but vertial order will matter   ''''''''''' ");
        v.levelOrderWithHaspMap(root);
        System.out.println(" ");
    }
    public static void  printBoundryOrder(InsertInBst.Node root){
        BoundarOrderTraversal b= new BoundarOrderTraversal();
        System.out.println(" '''''''''' Recursive approach Anti-clock wise boundry display ''''''''''' ");
        b.recursive(root);
        System.out.println(" ");
        System.out.println(" '''''''''' Itrative approach Anti-clock wise boundry display ''''''''''' ");
        b.itrativeWayAntiClockWise(root);
        System.out.println(" ");
        System.out.println(" '''''''''' Recursive approach clock wise boundry display ''''''''''' ");
        b.recursiveClockWise(root);
        System.out.println(" ");
        System.out.println(" '''''''''' itrative approach clock wise boundry display ''''''''''' ");
        b.itrativeWayClockWise(root);
        System.out.println(" ");
    }
    public static void main(String[] args) {
        int nodeValue = 80;
        // create object of insert class
        InsertInBst bst = new InsertInBst();
        // call insert function
        insertInBST(bst);
        System.out.println(" ==========   Display Technique ==================");
        inorder(bst.root, nodeValue);
        predorder(bst.root, nodeValue);
        postorder(bst.root, nodeValue);
        // pass any node and display with parent travsal
        diplayOtherWay(bst.root.left.right.left.right.left);
        System.out.println(" ==========   End Display Technique ==============");
        System.out.println(" ==========   Delete Technique ==================");
       // deleteNode(bst.root, nodeValue);
       // predorder(bst.root, nodeValue);
        System.out.println(" ==========   End Delete Technique ==============");
        System.out.println(" ==========   Display Vetrial Order travsersal ==================");
        printVertialOrder(bst.root);
        System.out.println(" ==========   End  Display Vetrial Order travsersal ==============");
        System.out.println("");
        System.out.println(" ==========   Display Boundry Order travsersal ==================");
        printBoundryOrder(bst.root);
        System.out.println(" ==========   End  Display Boundry Order travsersal ==============");
    }
}