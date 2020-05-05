
public class DeleteInBst {

    public void removeNodeWithParent(InsertInBst.Node root, int value) {
        InsertInBst.Node predecessorNode = null;
        InsertInBst.Node temp = root;
        while (temp != null) {
            if (temp.data == value) {
                break;
            }
            if (temp.data > value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if(temp==null){
            System.out.println("NO node exist in BST for delete ");
            return;
        }
        if (temp.left == null && temp.right == null) {
            System.out.println(" Found  with no child and deleteing node " +  temp.data);
            deleteLeaf(temp);
        } else {
            if (temp.left != null && temp.right != null) {
                Inorder in = new Inorder();
                InsertInBst.Node sucessorResult = in.sucessorItrativeWay(root, temp.data);
                System.out.println(" Found  with two child Node repalcing with sucessor " + sucessorResult.data + " and deleting node " + temp.data);
                temp.data = sucessorResult.data;
                // delete if leaf found
                if (sucessorResult.left == null && sucessorResult.right == null) {
                    deleteLeaf(sucessorResult);
                }else{
                    // other wise delete single child found
                    deleteSingleChildNode(sucessorResult);
                }
                
            } else {
                System.out.println(" Found  with one child and deleteing node " +  temp.data);
                deleteSingleChildNode(temp);
            }
        }

    }

    // delete leaf node
    private void deleteLeaf(InsertInBst.Node node) {
        if (node.left != null) {
            node.parent.left = null;
        } else {
            node.parent.right = null;
        }
    }

    // delete if have single node
    private void deleteSingleChildNode(InsertInBst.Node node) {

        if (node.parent.left == node) {
            if (node.left != null) {
                node.parent.left = node.left;
            } else {
                node.parent.left = node.right;
            }
        } else {
            if (node.right != null) {
                node.parent.right = node.left;
            } else {
                node.parent.right = node.right;
            }
        }
    }

}