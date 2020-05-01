
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
            System.out.println("         No sucessor found of node " + num);
        } else {
            System.out.println("         " + sucessorResult.data + " sucessor found of node " + num);
        }
        System.out.println(" ");
        System.out.println(" ---------  Print predecessor node  with itrative way of given node ------------   ");
        InsertInBst.Node predecessorResult = in.predecessorItrativeWay(root, num);
        if (predecessorResult == null) {
            System.out.println("         No predecessor found of node " + num);
        } else {
            System.out.println("         " + predecessorResult.data + " predecessor found of node " + num);
        }
        System.out.println(" ");
    }
    public static void inordepreorderr(InsertInBst.Node root, int num) {
        System.out.println(" ");
        System.out.println(" '''''''''' recursive preorder approach display ''''''''''' ");
        Preorder pre = new Preorder();
        pre.recursiveDisplay(root);
        System.out.println(" ");
        System.out.println(" ---------  Print sucessor node with itrative way of given node ------------   ");
        InsertInBst.Node sucessorResult = pre.sucessorItrativeWay(root, num);
        if (sucessorResult == null) {
            System.out.println("         No sucessor found of node " + num);
        } else {
            System.out.println("         " + sucessorResult.data + " sucessor found of node " + num);
        }
        System.out.println(" ---------  Print predecessor node  with itrative way of given node ------------   ");
        InsertInBst.Node predecessorResult = pre.predecessorItrativeWay(root, num);
        if (predecessorResult == null) {
            System.out.println("         No predecessor found of node " + num);
        } else {
            System.out.println("         " + predecessorResult.data + " predecessor found of node " + num);
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int inorderSucessor =10;
        // create object of insert class
        InsertInBst bst = new InsertInBst();
        // call insert function
        insertInBST(bst);
        System.out.println(" ==========   Display Technique ==================");
        inorder(bst.root, inorderSucessor);
        inordepreorderr(bst.root, inorderSucessor);
        System.out.println(" ==========   End Display Technique ==============");
    }
}