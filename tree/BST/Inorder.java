
public class Inorder {
    public static void recursiveDisplay(InsertInBst.Node root) {
        if (root == null) {
            return;
        }
        recursiveDisplay(root.left);
        System.out.print("  \t " + root.data);
        recursiveDisplay(root.right);
    }

    /**
     * Two case to find sucessor 
     * case 1: If the node has a right subtree then find
     * least value node from that right 
     *                          or 
     * case 1: if right subtree of node is not
     * NULL, then succ lies in right subtree. Do following. Go to right subtree and
     * return the node with minimum key value in right subtree. 
     *                          or 
     * case 1: If there is right subtree of node, inorder successsor is left most child in right
     * subtree. 
     *                          and 
     * case 2: If the node does not have right subtree such that 'P'
     * from root, the root the node from where we take last left in the ancestor. 
     *                          or
     * case 2: If there is no right subtree , inorder sucessor is the node where
     * last left turn was taken to reach given node. 
     *                          or
     * case 2: If right sbtree of node is NULL, then start from root and us search like technique. 
     * Do following. Travel down the tree, if a node’s data is greater than root’s data then go
     * right side, otherwise go to left side
     * 
     * @param root
     * @param value
     * @return node object
     */

    public static InsertInBst.Node sucessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node sucessorNode = null;
        while (root != null) {
            if (root.data == value) {
                root = root.right;
                break;
            }
            if (root.data > value) {
                sucessorNode = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        while (root != null) {
            sucessorNode = root;
            root = root.left;
        }
        return sucessorNode;
    }

    /**
     * same case as sucessor , it has also two case. 
     * case 1: If the node has a left subtree then find max value node from that left 
     *                          or 
     * case 1: if left subtree of node is not NULL, then succ lies in left subtree. Do following. 
     * Go to left subtree and return the node with max key value in left subtree. 
     *                          or 
     * case 1: If there is left subtree of node, inorder successsor is right most child in left
     * subtree. 
     *                          and 
     * case 2: If the node does not have left subtree such that 'P' from root, 
     * the root the node from where we take last right in the ancestor.
     *                          or 
     * case 2: If there is no left subtree , inorder sucessor is the node where
     * last right turn was taken to reach given node. 
     *                          or
     * case 2: If left sbtree of node is NULL, then start from root and us search like technique. 
     * Do following. Travel down the tree, if a node’s data is samller than root’s data then go
     * left side, otherwise go to right side
     * 
     * @param root
     * @param value
     * @return node object
     */

    public static InsertInBst.Node predecessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        while (root != null) {
            if (root.data == value) {
                root = root.left;
                break;
            }
            if (root.data > value) {
                root = root.left;
            } else {
                predecessorNode = root;
                root = root.right;
            }
        }
        while (root != null) {
            predecessorNode = root;
            root = root.right;
        }
        return predecessorNode;
    }
    /**
     * logic for sucessor is same as define in above comments
     * this approach check if it is leaf node then go to parent node
     * there will be a parent node define in tree
     * caculate parent node and check sucessor
     * @param root
     * @param value
     * @return node object
     */
    public InsertInBst.Node sucessorWithParentWay(InsertInBst.Node root, int value) {
        InsertInBst.Node sucessorNode = null;
        while (root != null) {
            if (root.data == value) {
                //root = root.right;
                break;
            }
            if (root.data > value) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if(root.right!=null){
            root= root.right;
            while(root!=null){
                sucessorNode = root;
                root = root.left;
            }
        }else{
            while(root!=null && root.parent !=null && root.parent.left!=root){
                root=root.parent;
            }
            if(root!=null){
                sucessorNode = root.parent;
            }else{
                sucessorNode = root;
            }
        }
       return sucessorNode;
        
    }
        /**
     * logic for predecessor is same as define in above comments
     * this approach check if it is leaf node then go to parent node
     * there will be a parent node define in tree
     * caculate parent node and check predecessor
     * @param root
     * @param value
     * @return node object
     */
    public static InsertInBst.Node predecessorWithParentWay(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        while (root != null) {
            if (root.data == value) {
                break;
            }
            if (root.data > value) {
                root = root.left;
            } else {
                predecessorNode = root;
                root = root.right;
            }
        }
        if(root.left!=null){
            root = root.left;
            while (root != null) {
                predecessorNode = root;
                root = root.right;
            }
        }else{
            while(root!=null && root.parent !=null && root.parent.right!=root){
                root=root.parent;
            }
            if(root!=null){
                predecessorNode = root.parent;
            }else{
                predecessorNode = root;
            }
        }
        return predecessorNode;
    }
}