
public class Preorder {
    public void recursiveDisplay(InsertInBst.Node root){
        if(root==null){
            return;
        }
        System.out.print("  \t " + root.data);
        recursiveDisplay(root.left);
        recursiveDisplay(root.right);
    }
    /**
     * case 1: If left child of given node exists, then the left child is preorder successor.
     * case 2: If left child does not exist and given node is left child of its parent, 
     *          then its sibling is its preorder successor.
     * case 3: If none of above conditions are satisfied (left child does not exist and given node is not left child of its parent), 
     *   then we move up using parent pointers until one of the following happens.
     *    a) We reach root. In this case, preorder successor does not exist.
     *    b) Current node (one of the ancestors of given node) is left child of its parent, 
     *       in this case preorder successor is sibling of current node.
     
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
        Output : 18

        Preorder traversal of given tree is 20, 10, 4, 18, 14, 13, 15, 19, 26, 24, 27.

        Input :  19
        Output : 26
     * @param root
     * @param value
     * @return
     */
    public InsertInBst.Node sucessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node sucessorNode = null;
        InsertInBst.Node ptr =null;
        int minValue=999999;
        InsertInBst.Node temp = root;
        while(temp!=null){
            if(temp.data==value){
                if(temp.left!=null){
                    sucessorNode=temp.left;
                }else{
                    if(temp.right!=null){
                        sucessorNode=temp.right;
                    }else{
                        if(ptr!=null){
                            System.out.println(" ptr found " +  ptr.data);
                            sucessorNode=ptr.right;
                        }
                    }
                }
                break;
            }
            if (temp.data > value) {
                if(temp.right!=null){
                    ptr=temp;
                }
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return sucessorNode;
    }
    /**
     * case 1: If the given node is root, then return NULL as preorder predecessor.
     * case 2: If node is the left child of its parent or left child of parent is NULL, 
     *         then return parent as its preorder predecessor.
     * case 3: If node is the right child of its parent and left child of parent exists, 
     *         then predecessor would be the rightmost node (max value) of the left subtree of parent
     * case 4: If node is the right child of its parent and the parent has no left child, 
     *         then predecessor would be the parent node (max value).
     * 
     * consider the following binary tree
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

        Preorder traversal of given tree is 20, 10, 4, 18, 14, 13, 15, 19, 26, 24, 27.

        Input :  19
        Output : 15
     * @param root
     * @param value
     * @return
     */
    public static InsertInBst.Node predecessorItrativeWay(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        InsertInBst.Node temp = root;
        InsertInBst.Node ptr = null;
        int rightFlag=0;
        int leftFlag=0;
        while(temp!=null){
            if(temp.data == value){
                predecessorNode = ptr;
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
        if(leftFlag!=1){
            if(rightFlag==1){
                if(ptr.left!=null){
                    temp=ptr.left;
                    while(temp!=null){
                        ptr=temp;
                        temp=temp.right;
                        if(temp==null){
                            if(ptr.left!=null){
                                temp=ptr.left;
                            }
                        }
                    }
                    predecessorNode =ptr;   
                }
            }
        }
        return predecessorNode;
    }
}