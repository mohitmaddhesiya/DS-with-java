public class Display{
    public void display(InsertLink.Node currentTree){
      while(currentTree!=null){
          System.out.print("\t " + currentTree.data);
          currentTree=currentTree.next;
      }
      System.out.println(" ");
    }
}