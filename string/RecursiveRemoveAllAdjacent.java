
/**
 * Given a string, recursively remove adjacent duplicate characters from the string. 
 * The output string should not have any adjacent duplicates. See following examples.
 * Input: azxxzy
    Output: ay
    First “azxxzy” is reduced to “azzy”.
    The string “azzy” contains duplicates,
    so it is further reduced to “ay”.
 */

import java.util.Stack;

public class RecursiveRemoveAllAdjacent {
    static String itrativeApproach(String str) {
        String result = "";
        char strArray[] = str.toCharArray();
        int len = strArray.length;
        Stack<Character> st = new Stack<Character>();
        int duplicateFlag = 0;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            char temp = strArray[i];
            if (!st.isEmpty()) {
                char ptr = st.peek();
                if (ptr == temp) {
                    duplicateFlag = 1;
                } else {
                    if (duplicateFlag == 1) {
                        while (!st.isEmpty() && (st.peek() == ptr)) {
                            st.pop();
                        }
                        if (!st.isEmpty() && st.peek() == temp) {
                            duplicateFlag = 1;
                        } else {
                            duplicateFlag = 0;
                        }
                    }
                }
                if ((len - 1) == i) {
                    while (!st.isEmpty() && (st.peek() == temp)) {
                        st.pop();
                        flag = 1;
                    }
                    if (st.isEmpty()) {
                        flag = 1;
                    }
                }
            }
            if (flag == 0) {
                st.push(temp);
            }
        }
        // System.out.println(" st " + st);

        while (!st.isEmpty()) {
            result = st.pop() + result;
        }
        return result;
    }

    static String itrativeApproachBest(String str) {
        // String result = "";
        char strArray[] = str.toCharArray();
        int len = strArray.length;
        char ptr = strArray[0];
        int i = 1;
        int k = 0;
        while (i < len) {
            if (ptr != strArray[i]) {
                k++;
                strArray[k] = strArray[i];
                i++;
                ptr = strArray[k];
            } else {
                while (i < len && ptr == strArray[i]) {
                    i++;
                }
                if (k > 0) {
                    k--;
                    ptr = strArray[k];
                } else {
                    if (i < len) {
                        k=0;
                        strArray[k]=strArray[i];
                        ptr =  strArray[k];
                        i++;
                    }else{
                        k = -1;
                    }
                }
            }
        }
        String sb = "";
        for (int j = 0; j <= k; j++) {
            sb = sb + strArray[j];
        }
        return sb;
    }

    public static void main(String args[]) {
        String str = "acbbcddc";
        System.out.println(" ==== itravite approach remove ========");
        System.out.println(" given string = " + str + "  result of str = " + itrativeApproach(str));
        System.out.println(" ==== itravite best  approach remove ========");
        System.out.println(" given string = " + str + "  result of str = " + itrativeApproachBest(str));

    }
}