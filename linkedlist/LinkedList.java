public class LinkedList{
    public static void main(String args[]){
        InsertLink ln=new InsertLink();
        for(int i=1;i<=10;i++)
        ln.insertBack(i*10);
       /* ln.insertBack(0);
        ln.insertBack(1);
        ln.insertBack(2);
        ln.insertBack(1);
        ln.insertBack(0);
        ln.insertBack(2);
        ln.insertBack(0);
        ln.insertBack(0);
        ln.insertBack(0);
        ln.insertBack(0);
        ln.insertBack(0);
        ln.insertBack(2);
        ln.insertBack(1);
        ln.insertBack(2);
        ln.insertBack(1);*/

        System.out.println(" ====== Normal Display ==========");
        Display ds=new Display();
        ds.display(ln.head);
        System.out.println(" ");

        System.out.println(" ====== Sort By zero one two ==========");

        SortBY012 sort=new SortBY012();
        System.out.println(" ====== approach 1 ==========");

       // sort.sortByZeroOneTwo(ln.head);
       // ds.display(ln.head);
        System.out.println(" ");
        System.out.println(" ====== approach 2 ==========");
       // sort.sortByZeroOneTwo2(ln.head);
        //ds.display(ln.head);
        System.out.println(" ");

        System.out.println(" ====== Rotate Node by K postion ==========");
        Rotate r=new Rotate();
        r.rotate(ln.head,4);
        //ds.display(ln.head);
        System.out.println(" ");
    }
}