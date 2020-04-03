public class InsertLink {
    Node head = null;

    static class Node {
        Node next;
        int data;

        Node(int num) {
            data = num;
            next = null;
        }
    }

    public void insertFornt(int num) {
        Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head=newNode;
    }

    public void insertBack(int num) {
        Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

}