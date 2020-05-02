
public class Postorder {
    public void recursiveDisplay(InsertInBst.Node root){
        if(root==null){
            return;
        }
        recursiveDisplay(root.left);
        recursiveDisplay(root.right);
        System.out.print("  \t " + root.data);
    }
    /**
     * case 1: If given node is root then postorder successor is NULL, 
     *          since root is the last node print in a postorder traversal.
     * case 2: If given node is right child of parent or right child of parent is NULL, 
     *          then parent is postorder successor.
     * case 3: If given node is left child of parent and right child of parent is not NULL,
     *           then postorder successor is the leftmost node of parent’s right subtree
     * 
     * Examples: Consider the following binary tree
              20            
           /      \         
          10       26       
         /  \     /   \     
       4     18  24    27   
            /  \
           14   19
          /  \
         13  15

        Postorder traversal of given tree is 4, 13, 15, 14, 19, 18, 10, 24, 27, 26, 20.

        Input :  24
        Output : 27

        Input : 4
        Output : 13
     * @param root
     * @param value
     * @return
     */
    public InsertInBst.Node sucessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node sucessorNode = null;
        InsertInBst.Node ptr =null;
        InsertInBst.Node temp = root;
        int rightFlag=0;
        int leftFlag=0;
        while(temp!=null){
            if(temp.data == value){
                sucessorNode = ptr;
                break;
            }
            ptr=temp;
            if (temp.data > value) {
                rightFlag = 0;
                leftFlag=1;
                temp = temp.left;
            } else {
                rightFlag = 1;
                leftFlag =0 ;
                temp = temp.right;
            }
        }
        if(rightFlag!=1){
            if(leftFlag==1){
                if(ptr.right!=null){
                    temp=ptr.right;
                    while(temp!=null){
                        ptr=temp;
                        temp=temp.left;
                        if(temp==null){
                            temp=ptr.right;
                        }
                    }
                    sucessorNode=ptr;
                }
            }
        }
        return sucessorNode;
    }
    /**
     * case 1: If right child of given node exists, then the right child is postorder predecessor.
     * case 2: If right child does not exist and given node is left child of its parent, then its sibling is its postorder predecessor.
     * case 3: If none of above conditions are satisfied (left child does not exist and given node is not right child of its parent), 
     *          then we move up using parent pointers until one of the following happens.
     *          a) We reach root. In this case, postorder predecessor does not exiss
     *          b) Current node (one of the ancestors of given node) is right child of its parent, 
     *              in this case postorder predecessor is sibling of current node.
     * 
     * Consider the following binary tree
              20            
           /      \         
          10       26       
         /  \     /   \     
       4     18  24    27   
            /  \
           14   19
          /  \
         13  15

        Input :  4
        Output : 10

        Postorder traversal of given tree is 4, 13, 15, 14, 19, 18, 10, 24, 27, 26, 20.

        Input :  24
        Output : 10

     * @param root
     * @param value
     * @return
     */
    public static InsertInBst.Node predecessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        InsertInBst.Node temp = root;
        InsertInBst.Node ptr = null;
        InsertInBst.Node parent = null;
        int leafFlag=0;
        while(temp!=null){
            if(temp.data == value){
                if(temp.right!=null){
                    predecessorNode = temp.right;
                }else{
                    if(temp.left!=null){
                        predecessorNode = temp.left;
                    }else{
                        leafFlag=1;
                    }
                }
                break;
            }
            parent=temp;
            if (temp.data > value) {
                temp = temp.left;
            } else {
                if(temp.left!=null){
                    ptr=temp;
                }
                temp = temp.right;
            }
        }
        if(leafFlag==1){
            if(parent!=null){
                if(parent.left!=null && parent.left.data!=value){
                    predecessorNode=parent.left;
                }else{
                    if(ptr!=null){
                        predecessorNode=ptr.left;
                    }
                }
            }
        }
       
        return predecessorNode;
    }
}