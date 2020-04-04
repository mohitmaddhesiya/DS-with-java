public class Tree {
  public static void main(String args[]) {
    BinaryTree bt = new BinaryTree();

    for (int i = 1; i <= 20; i++) {
      bt.insert(10 * i);
    }

    LevelOrder lo = new LevelOrder();
    lo.Itrator(bt.root);

    System.out.println(" ===== Size of tree ===== ");
    SizeOfBinaryTree ts = new SizeOfBinaryTree();
    int treeSize = ts.SizeWithLevelOrder(bt.root);
    System.out.println("  with level order " + treeSize);
    System.out.println("with simple recursive " + ts.sizeWithRecursive(bt.root));
    System.out.print(" with recusrsive 2 approviach  " + ts.sizeWithRecursive2(bt.root));
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
    bt1.insert(10);
    bt1.insertRandom(bt1.root, 20 ,"left");
    bt1.insertRandom(bt1.root, 30, "rigth");
    bt1.insertRandom(bt1.root.left, 40, "rigth");
    bt1.insertRandom(bt1.root.left.rigth, 50, "left");
    po.recursive(bt1.root);
    System.out.println(" ");

    System.out.println(" ===== Tree 2 ===== ");
    BinaryTree bt2 = new BinaryTree();

    bt2.insert(10);
    bt2.insertRandom(bt2.root, 20 ,"left");
    bt2.insertRandom(bt2.root, 30, "rigth");
    bt2.insertRandom(bt2.root.rigth, 40, "rigth");
    bt2.insertRandom(bt2.root.rigth.rigth, 50, "left");
    po.recursive(bt2.root);
    System.out.println(" ");
    System.out.println(" ===== Identical Tee Check  ===== ");
    Identical i=new Identical();
    System.out.println(" ---  Itrative order -----");
    if(i.levelOrder(bt1.root, bt2.root)){
      System.out.println("Given Tree are indentical");
    }else{
      System.out.println("Given Tree are indentical");
    }
    System.out.println(" ---  recrsive order -----");
    if(i.recursive(bt1.root, bt2.root)){
      System.out.println("Given Tree are indentical");
    }else{
      System.out.println("Given Tree are not identical");
    }
    System.out.println(" ");

  }
}