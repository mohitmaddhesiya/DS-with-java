/**
 * giveb a singly link list rotate the link listcounter-clocwise by k nodes
 * eg1: 10->20->30->40->50->60-70->null; and K=4
 * output: 50->60->70->10->20->30->40->null;
 */

public class Rotate{
    public void rotate(InsertLink.Node currenNode, int k){
        InsertLink.Node temp=currenNode;
        int count=0;
        while(count<k){
            temp=temp.next;
            count++;
        }
        //System.out.print("count " +count);
        //System.out.print("temp " +temp.data);
        InsertLink.Node ptr=temp;
        while(temp.next!=null){
            temp=temp.next;
        }
       // System.out.print("temp 1 " +temp.data);
        temp.next=currenNode;
        currenNode=ptr.next;
        //System.out.print("currenNode 1 " +currenNode.data);
        ptr.next=null;
        while(currenNode!=null){
            System.out.print("\t " + currenNode.data);
            currenNode=currenNode.next;
        }
        System.out.println(" ");

    }
}