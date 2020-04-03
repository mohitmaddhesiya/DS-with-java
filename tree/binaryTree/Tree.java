public class Tree {
  public static void main(String args[]) {
    BinaryTree bt = new BinaryTree();

    for (int i = 1; i <= 10; i++) {
      bt.insert(10 * i);
    }

    LevelOrder lo = new LevelOrder();
    lo.Itrator(bt.root);

    System.out.println(" ===== Size of tree ===== ");
    SizeOfBinaryTree ts = new SizeOfBinaryTree();
    int treeSize = ts.SizeWithLevelOrder(bt.root);
    System.out.println("  with level order " + treeSize);
    System.out.println("with simple recursive " + ts.sizeWithRecursive(bt.root));
    System.out.println(" ");

    System.out.println(" ");

    System.out.println(" ===== PreOrder Travesal ===== ");
    PreOrder po = new PreOrder();
    po.recursive(bt.root);
    System.out.println(" ");
    po.anotherLogic(bt.root);
    System.out.println(" ");

    System.out.println(" ");

    System.out.println(" ===== InOrder Travesal ===== ");
    InOrder in = new InOrder();
    in.recursive(bt.root);
    System.out.println(" ");
    in.itertive(bt.root);
    System.out.println(" ");

    System.out.println(" ");

    System.out.println(" ===== PostOrder Travesal ===== ");
    PostOrder poo = new PostOrder();
    poo.recursive(bt.root);
    System.out.println(" ");
    poo.itervative(bt.root);
    System.out.println(" ");
    poo.anotherLogic(bt.root);
    System.out.println(" ");

    System.out.println(" ");

    System.out.println(" ===== Heigth Of Tree Logic ===== ");
    HeigthOfTree ht = new HeigthOfTree();
    System.out.println(" higth of tree with level order " + ht.levelOrderHeigth(bt.root));
    System.out.println(" higth of tree with another prise " + ht.levelOrderHeigth(bt.root));
    System.out.println(" higth of tree with recursive  method left under rigth  " + ht.recursive1(bt.root));
    System.out.println(" higth of tree with recursive  left beside rigth  " + ht.recursive2(bt.root));
    // ht.tryWithOtherLogic(bt.root);
    System.out.println(" ");

    System.out.println(" ===== Depth Of Node Logic ===== ");
    DepthOfTree dt = new DepthOfTree();
    int num = 100;
    System.out.println(" Depth of node " + num + " is " + dt.levelOrderDepth(bt.root, num));
    System.out.println(" with another order Depth of node " + num + " is " + dt.tryWithOtherLogic(bt.root, num));
    dt.recursive1(bt.root, num, 0, 0);

    System.out.println(" ");

    System.out.println(" ===== Display of Other view ===== ");
    Display ds = new Display();
    ds.sprialOrder(bt.root);
    System.out.println(" ");

    System.out.println(" ===== Tree 1 ===== ");
    BinaryTree bt1 = new BinaryTree();

    for (int i = 1; i <= 10; i++) {
      bt1.insert(10 * i);
    }
    lo.Itrator(bt1.root);
    System.out.println(" ");

    System.out.println(" ===== Tree 2 ===== ");
    BinaryTree bt2 = new BinaryTree();

    for (int i = 1; i <= 10; i++) {
      bt2.insert(100 * i);
    }
    lo.Itrator(bt2.root);
  }
}