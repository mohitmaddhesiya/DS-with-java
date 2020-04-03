// sort a linklist of 0s, 1s ans 2s,

/**
 * input: 1->1->2->0->2->0->1->null;
 * output: 0->0->1->1->1->2->2->null;
 * sourse : microsoft inerview set 1
 */
/**
 * Approvach 1 : traverse the list and count the number of 0s, 1s and 2s let the
 * counts be n1, n2, n3 respectively Approach 2: take tree pointer and store
 * node in that vlaue
 */

public class SortBY012 {
    // Approvach 1
    public void sortByZeroOneTwo(InsertLink.Node currentNode) {
        int zero = 0;
        int one = 0;
        int two = 0;
        InsertLink.Node temp = currentNode;
        while (temp != null) {
            if (temp.data == 0) {
                zero++;
            }
            if (temp.data == 1) {
                one++;
            }
            if (temp.data == 0) {
                two++;
            }
            temp = temp.next;
        }
        temp = currentNode;
        while (temp != null) {
            if (zero > 0) {
                temp.data = 0;
                temp = temp.next;
                zero--;
                continue;
            }
            if (one > 0) {
                temp.data = 1;
                temp = temp.next;
                one--;
                continue;
            }
            if (two > 0) {
                temp.data = 2;
                temp = temp.next;
                two--;
                continue;
            }
        }
    }

    // Approvach 1
    public void sortByZeroOneTwo2(InsertLink.Node currentNode) {
        InsertLink.Node zero = null;
        InsertLink.Node two = null;
        InsertLink.Node one = null;
        InsertLink.Node temp = currentNode;
        InsertLink.Node ptr1 = null;
        InsertLink.Node ptr2 = null;
        InsertLink.Node ptr3 = null;
        while (temp != null) {
            // System.out.print("\t " + temp.data);
            if (temp.data == 0) {
                if (zero == null) {
                    zero = temp;
                    ptr1 = temp;
                } else {
                    ptr1.next = temp;
                    ptr1 = temp;
                }
            }
            if (temp.data == 1) {
                if (one == null) {
                    one = temp;
                    ptr2 = temp;
                } else {
                    ptr2.next = temp;
                    ptr2 = temp;
                }
            }
            if (temp.data == 2) {
                if (two == null) {
                    two = temp;
                    ptr3 = temp;
                } else {
                    ptr3.next = temp;
                    ptr3 = temp;
                }
            }
            temp = temp.next;
        }
        if (ptr1 != null) {
            ptr1.next = one;
        }
        if (ptr2 != null) {
            ptr2.next = two;
        }
        if (ptr3 != null) {
            ptr3.next = null;
        }
    }
}