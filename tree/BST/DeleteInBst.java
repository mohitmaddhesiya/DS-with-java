
public class DeleteInBst {

    public void removeNodeWithParent(InsertInBst.Node root, int value) {
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

    public void removeNodeWithOutParent(InsertInBst.Node root, int value) {
        InsertInBst.Node temp = root;
        InsertInBst.Node parent = null;

        while (temp != null) {
            if (temp.data == value) {
                break;
            }
            parent = temp;
            if (temp.data > value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if(temp==null){
            System.out.println("No node exist in BST for delete parent calulated with loop");
            return;
        }else{
            if (temp.left == null && temp.right == null) {
                System.out.println(" Found  with no child and deleteing node " +  temp.data);
                deleteLeafWithPartent(temp, parent);
            } else {
                if (temp.left != null && temp.right != null) {
                   // System.out.println(" Two child node parent calulated with loop");
                   findInorderSucessorParent(root, value, temp);
                } else {
                    System.out.println(" Found  with one child and deleteing node parent calulated with loop " +  temp.data);
                    deleteSingleChildNodeWithParent(temp, parent);
                }
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
                node.parent.right = node.right;
            } else {
                node.parent.right = node.left;
            }
        }
    }
    // delete leaf node if passing parent node
    private void deleteLeafWithPartent(InsertInBst.Node node, InsertInBst.Node parent) {
        if (node.left != null) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
        // delete if have single node  id passing with paarent node
        private void deleteSingleChildNodeWithParent(InsertInBst.Node node, InsertInBst.Node parent) {

            if (parent.left == node) {
                if (node.left != null) {
                    parent.left = node.left;
                } else {
                    parent.left = node.right;
                }
            } else {
                if (node.right != null) {
                    parent.right = node.right;
                } else {
                    parent.right = node.left;
                }
            }
        }
        private void findInorderSucessorParent(InsertInBst.Node root, int value, InsertInBst.Node node){
            InsertInBst.Node predecessorNode = null;
            InsertInBst.Node predecessorParentNode = null;
            while (root != null) {
                if (root.data == value) {
                    root = root.left;
                    break;
                }
                if (root.data > value) {
                    root = root.left;
                } else {
                    predecessorParentNode = predecessorNode;
                    predecessorNode = root;
                    root = root.right;
                }
            }
            while (root != null) {
                predecessorParentNode = predecessorNode;
                predecessorNode = root;
                root = root.right;
            }
            System.out.println(" Found  with two child Node repalcing with predecessor " + predecessorNode.data + " and deleting node " + node.data);
            node.data = predecessorNode.data;
            if (predecessorParentNode.left == null && predecessorParentNode.right == null) {
                deleteLeafWithPartent(predecessorNode, predecessorParentNode);
            }else{
                // other wise delete single child found
                deleteSingleChildNodeWithParent(predecessorNode, predecessorParentNode);
            }
        }

}