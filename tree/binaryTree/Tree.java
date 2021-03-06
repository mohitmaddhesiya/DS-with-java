public class Tree {
  static void inOrder(BinaryTree bt){
    System.out.println("       ===== InOrder Travesal ===== ");
    InOrder in = new InOrder();
    in.recursive(bt.root);
    System.out.println(" ");
    in.itertive(bt.root);
    System.out.println(" ");
  }
  static void preOrder(BinaryTree bt){
    System.out.println("       ===== PreOrder Travesal ===== ");
    PreOrder po = new PreOrder();
    po.recursive(bt.root);
    System.out.println(" ");
    po.anotherLogic(bt.root);
    System.out.println(" ");
  }
  static void postOrder(BinaryTree bt){
    System.out.println("       ===== PostOrder Travesal ===== ");
    PostOrder poo = new PostOrder();
    poo.recursive(bt.root);
    System.out.println(" ");
    poo.itervative(bt.root);
    System.out.println(" ");
    poo.anotherLogic(bt.root);
    System.out.println(" ");
  }
  static void levelorder(BinaryTree bt){
    System.out.println("       ===== levelOrder Travesal ===== ");
    LevelOrder lo = new LevelOrder();
    lo.Itrator(bt.root);
    System.out.println(" ");
  }
  static void heigth(BinaryTree bt){
    System.out.println(" ");
    System.out.println("       ===== Heigth Of Tree Logic ===== ");
    HeigthOfTree ht = new HeigthOfTree();
    System.out.println("       higth of tree with level order --> " + ht.levelOrderHeigth(bt.root));
    System.out.println("       higth of tree with another logic --> " + ht.tryWithOtherLogic(bt.root));
    System.out.println("       higth of tree with recursive  method left under rigth  --> " + ht.recursive1(bt.root));
    System.out.println("       higth of tree with recursive  left beside rigth  --> " + ht.recursive2(bt.root));
    System.out.println(" ");
  }
  static void size(BinaryTree bt){
    System.out.println("        ===== Size of tree ===== ");
    SizeOfBinaryTree ts = new SizeOfBinaryTree();
    int treeSize = ts.SizeWithLevelOrder(bt.root);
    System.out.println("       with level order " + treeSize);
    System.out.println("       with simple recursive " + ts.sizeWithRecursive(bt.root));
    System.out.println("       with recusrsive 2 approviach  " + ts.sizeWithRecursive2(bt.root));
    System.out.println(" ");
  }
  static void depth(BinaryTree bt, int num){
    System.out.println("        ===== Depth of Node ===== ");
    DepthOfTree dt = new DepthOfTree();
    System.out.println("       Depth of node " + num + " is " + dt.levelOrderDepth(bt.root, num) + " ( Level order approach )");
    System.out.println("       Depth of node " + num + " is " + dt.tryWithOtherLogic(bt.root, num) + " (Another logic with two stack )");
    System.out.println("       Depth of node " + num + " is "+ dt.recursive2(bt.root, num, 0) + " (recursive approach with return value)");
    dt.depthSumRecusrsive(bt.root, num, 0);
    System.out.println("       Print path of depath Node with recursive  ");
    dt.recursivePrintDepathPath(bt.root, num);
    System.out.println("       Print path of depath Node with itrative map  ");
    dt.depthPathItrativeWithMap(bt.root, num);
    System.out.println("       Print path of depath Node with itrative dequeue  ");
    dt.depthPathItrativeWithDequeue(bt.root, num);
    System.out.println(" ");
  } 
  static void rootToLeaf(BinaryTree bt, int sum){
    System.out.println("        ===== Root to leaf all path  ===== ");
    RootToLeaf rl=new RootToLeaf();
    rl.printAllRootToLeafPath(bt.root);
    System.out.println("            ***  Through Map  *** ");
    rl.rootToLeafMap(bt.root);
    System.out.println("            ***  Through recursive  *** ");
    rl.recursivePrint(bt.root);
    System.out.println("            ***  Given Sum  " + sum + " path with hashmap *** ");
    rl.rootToLeafSum(bt.root, sum);
    System.out.println("            ***  Given Sum  " + sum + " path  with deque *** ");
    rl.rootToLeafSumWithDeque(bt.root, sum);
    System.out.println("            ***  Given Sum  " + sum + " path  with Recursive *** ");
    rl.rootToleafRecursiveSum(bt.root, sum);
    System.out.println("            ***  Given Sum  " + sum + " path  with Recursive *** ");
     System.out.print("\t path exist =" + rl.rootToLeafSumCheck(bt.root, sum));

    System.out.println(" ");
  }
  static void countLeafNode(BinaryTree bt){
    System.out.println("       ===== Count number of leaf ===== ");
    CountLeafNode cl = new CountLeafNode();
    System.out.println("            ***  count through level order *** ");
    cl.levelOrderCountLeaf(bt.root);
    System.out.println("            ***  count through itrative order *** ");
    cl.itrativeOrderWithStack(bt.root);
    System.out.println("            ***  count through recursive order *** ");
    cl.recursiveCheck(bt.root);
    System.out.println(" ");
  }
  static void sprialOrderPrint(BinaryTree bt){
    System.out.println("       ===== Display of Other view ===== ");
    Display ds = new Display();
    ds.sprialOrder(bt.root);
    System.out.println(" ");
    int data=190;
    System.out.println("       =====  Print ancestor path of given node with hasmap approach ===== ");
    ds.printAncetorPathWithMap(bt.root, data);
    System.out.println(" ");
    System.out.println("       =====  Print ancestor path of given node with recursive approach ===== ");
    ds.recursivePrint(bt.root, data);
    System.out.println(" ");
    System.out.println("       =====  Print ancestor path of given node with stack itartive geeks appproach ===== ");
    ds.printAncetorPath(bt.root, data);
    System.out.println(" ");
  } 
  static void identical(BinaryTree bt1, BinaryTree bt2){
    Identical i=new Identical();
    System.out.println(" ---  Itrative order -----");
    if(i.levelOrder(bt1.root, bt2.root)){
      System.out.println("Given Tree are indentical");
    }else{
      System.out.println("Given Tree are not indentical");
    }
    System.out.println(" ---  recursive order -----");
    if(i.recursive(bt1.root, bt2.root)){
      System.out.println("Given Tree are indentical");
    }else{
      System.out.println("Given Tree are not identical");
    }
    System.out.println(" ");
  }
  static void displayOtherWay(BinaryTree bt){
    // dispplay alternat way left to right , and right to left
    EveryTwoLevelsChangeDirection e= new EveryTwoLevelsChangeDirection();
    System.out.println("       ===== Level order traversal with direction change after every two levels ===== ");
    e.modifiedLevelOrder(bt.root);
  }
  public static void main(String args[]) {

    System.out.println(" ===== Binary Tree  ===== ");
    BinaryTree bt = new BinaryTree();
    for (int i = 1; i <= 20; i++) {
      bt.insert(10 * i);
    }
    levelorder(bt);
    inOrder(bt);
    postOrder(bt);
    heigth(bt);
    size(bt);
    depth(bt, 100);
    rootToLeaf(bt, 180);
    sprialOrderPrint(bt);
    countLeafNode(bt);
    displayOtherWay(bt);
    
    System.out.println(" ");

    System.out.println(" ===== Binary Tree 1 ===== ");
    BinaryTree bt1 = new BinaryTree();
    tree1(bt1);
    levelorder(bt1);
    inOrder(bt1);
    postOrder(bt1);
    heigth(bt1);
    size(bt1);
    depth(bt1, 50);
    rootToLeaf(bt1, 40);
    sprialOrderPrint(bt);
    countLeafNode(bt1);
    System.out.println(" ");
  
    System.out.println(" ===== Binary Tree 2 ===== ");
    BinaryTree bt2 = new BinaryTree();
    tree2(bt2);
    levelorder(bt2);
    inOrder(bt2);
    postOrder(bt2);
    heigth(bt2);
    size(bt2);
    depth(bt, 100);
    sprialOrderPrint(bt2);
    rootToLeaf(bt2, 370);
    countLeafNode(bt2);
    System.out.println(" ");

    System.out.println(" ===== Identical Tree ===== ");
    identical(bt1,bt2);

    System.out.println(" ");
  }
  static void tree1(BinaryTree bt){
    bt.insert(10);
    bt.insertRandom(bt.root, 20 ,"left");
    bt.insertRandom(bt.root, 30, "rigth");
    bt.insertRandom(bt.root.left, 40, "rigth");
    bt.insertRandom(bt.root.left.rigth, 50, "left");
    bt.insertRandom(bt.root.left.rigth, 80, "rigth");
    bt.insertRandom(bt.root.left.rigth.left, 90, "left");
  }
  static void tree2(BinaryTree bt2){
    bt2.insert(10);
    bt2.insertRandom(bt2.root, 20 ,"left");
    bt2.insertRandom(bt2.root, 40, "rigth");
    bt2.insertRandom(bt2.root.left, 30, "left");
    bt2.insertRandom(bt2.root.rigth, 50, "left");
    bt2.insertRandom(bt2.root.rigth.left, 60, "left");
    bt2.insertRandom(bt2.root.rigth.left, 80, "rigth");
    bt2.insertRandom(bt2.root.rigth.left.rigth, 90, "left");
    bt2.insertRandom(bt2.root.rigth.left.rigth.left, 100, "rigth");
    bt2.insertRandom(bt2.root.rigth.left.rigth.left, 110, "left");
  }
}