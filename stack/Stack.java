import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> st = new ArrayList<Integer>();
    int top = -1;

    public void push(int num) {
        top++;
        st.add(top, num);
    }

    public int pop() {
        int temp = 0;
        if (top == -1) {
            return temp;
        } else {
            if (top != st.size()) {
                temp = st.get(top);
                st.remove(top);
                top--;
            }
            return temp;

        }
    }

    public int peek() {
        int tempTop = top;
        int temp=0;
        if (tempTop == -1) {
            return temp;
        } else {
            if (tempTop != st.size()) {
                temp = st.get(top);
                tempTop--;
            }
            return temp;
        }
    }

    public Boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

}