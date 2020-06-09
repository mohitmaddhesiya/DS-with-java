/**
 * Print Longest common subsequence Please go to longest comomon subsequnce file
 * and check how to find
 */
import java.util.*; 

public class PrintLCS {
    static String memoizationMatrix[][] = new String[1000][1000];

    static String recursive(char str1[], char str2[], int n, int m, String temp) {
        if (n == 0 || m == 0) {
            return "";
        }

        if (str1[n - 1] == str2[m - 1]) {
            return str2[m - 1] + temp + recursive(str1, str2, n - 1, m - 1, temp);
        } else {
            String s = recursive(str1, str2, n - 1, m, temp);
            int len1 = s.length();
            String s2 = recursive(str1, str2, n, m - 1, temp);
            int len2 = s2.length();
            if (len1 > len2) {
                temp = s;
            } else {
                temp = s2;
            }
            return temp;
        }
    }

    static String memoization(char str1[], char str2[], int n, int m) {
        if (n == 0 || m == 0)
            return "";
        if (memoizationMatrix[n][m] == null) {
            if (str1[n - 1] == str2[m - 1]) {
                return memoizationMatrix[n][m] = str1[n - 1] + memoization(str1, str2, n - 1, m - 1);
            } else {
                String s = memoization(str1, str2, n - 1, m);
                String s1 = memoization(str1, str2, n, m - 1);
                if (s.length() > s1.length())
                    return memoizationMatrix[n][m] = s;
                else
                    return memoizationMatrix[n][m] = s1;
            }
        } else {
            return memoizationMatrix[n][m];
        }
    }

    /**
     * we are calculating first number of count then printing string
     * 
     * @param str1
     * @param str2
     * @param n
     * @param m
     * @return
     */
    static String tabular(char str1[], char str2[], int n, int m) {
        int tabularArray[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    tabularArray[i][j] = 0;
                } else {
                    if (str1[i - 1] == str2[j - 1]) {
                        tabularArray[i][j] = 1 + tabularArray[i - 1][j - 1];
                    } else {
                        tabularArray[i][j] = max(tabularArray[i - 1][j - 1], tabularArray[i][j - 1]);
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i <= m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println(" tabularArray " + tabularArray[n][m]);
        
        Set<String> s = printAllLCS(str1, str2, n, m, tabularArray);
        System.out.println(" printing ALl Sub sequnce" );
        for (String str : s) 
          System.out.println(str);
          System.out.println(" End printing ALl Sub sequnce");

        System.out.println();

        return printTabular(tabularArray, n, m, str2, str1);
    }

    // print all subsequnce list
    static Set<String> printAllLCS(char str1[], char str2[], int m, int n, int L[][]) {
        // construct a set to store possible LCS
        Set<String> s = new HashSet<>();

        // If we reaches end of either String,
        // return a empty set
        if (m == 0 || n == 0) {
            s.add("");
            return s;
        }

        // If the last characters of str1 and str2 are same
        if (str1[m - 1] ==str2[n - 1]) {
            // recurse for str1[0..m-2] and str2[0..n-2]
            // in the matrix
            Set<String> tmp = printAllLCS(str1, str2, m - 1, n - 1, L);
            System.out.println(" tmp "  + tmp);

            // append current character to all possible LCS
            // of subString str1[0..m-2] and Y[0..n-2].
            for (String str : tmp)
                s.add(str + str1[m - 1]);
        }

        // If the last characters of str1 and str2 are not same
        else {
            // If LCS can be constructed from top side of
            // the matrix, recurse for str1[0..m-2] and Y[0..n-1]
            if (L[m - 1][n] >= L[m][n - 1])
                s = printAllLCS(str1, str2, m - 1, n,L);

            // If LCS can be constructed from left side of
            // the matrix, recurse for str1[0..m-1] and str2[0..n-2]
            if (L[m][n - 1] >= L[m - 1][n]) {
                Set<String> tmp = printAllLCS(str1, str2, m, n - 1, L);

                // merge two sets if L[m-1][n] == L[m][n-1]
                // Note s will be empty if L[m-1][n] != L[m][n-1]
                s.addAll(tmp);
            }
        }
        return s;
    }

    static String printTabular(int tabularArray[][], int n, int m, char str2[], char str1[]) {
        int i = n;
        int j = m;
        String temp = "";
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                temp = temp + str2[j - 1];
                i--;
                j--;
            } else {
                if (tabularArray[i - 1][j] > tabularArray[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return temp;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    private static void prinMatrix(int n, int m, String tabularArray[][]) {
        System.out.println();
        for (int i = 0; i <= m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String s = "AGTGATG";
        String s1 = "GTTAG";
        char str1[] = s.toCharArray();
        char str2[] = s1.toCharArray();
        int n = str1.length;
        int m = str2.length;
        System.out.println(s + " n " + n);
        System.out.println(s1 + " m " + m);
        System.out.println("\n -------  recursive approach ---------------");
        System.out.println(recursive(str1, str2, n, m, ""));
        System.out.println(" ------- end recursive approach ---------------");
        System.out.println("\n");
        System.out.println("\n -------  memoization approach ---------------");
        System.out.println(memoization(str1, str2, n, m));
        prinMatrix(n, m, memoizationMatrix);
        System.out.println(" ------- end memoization approach ---------------");
        System.out.println("\n -------  tabular approach ---------------");
        System.out.println(tabular(str1, str2, n, m));
        System.out.println(" ------- end tabular approach ---------------");

    }
}