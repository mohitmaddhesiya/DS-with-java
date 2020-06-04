/**
 * Input:  set[] = {2, 3, 5, 5, 8, 10}, sum = 10
    Output: 5 (return count of subset is equal to sum)
    explain: [5, 3, 2]
            [5, 3, 2]
            [5, 5]
            [8, 2]
            [10]

    Same probem as subset problem but different is we need to count

**/

import java.util.ArrayList;

public class CountSubsetSumProblem {
    static int memoizationMatrix[][] = new int[1000][1000];

    static void initZero() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                memoizationMatrix[i][j] = 0;
            }
        }
    }

    static int memoization(int arr[], int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0 && sum != 0) {
            return 0;
        }
        if (memoizationMatrix[n][sum] == 0) {
            if (sum >= arr[n - 1]) {
                int item1 = recursive(arr, n - 1, sum);
                int item2 = recursive(arr, n - 1, sum - arr[n - 1]);
                int value = item1 + item2;
                memoizationMatrix[n][sum] = value;
                return memoizationMatrix[n][sum];
            } else {
                memoizationMatrix[n][sum] = recursive(arr, n - 1, sum);
                return memoizationMatrix[n][sum];
            }
        } else {
            return memoizationMatrix[n][sum];
        }
    }

    // recursive approach only check if subset is present or not
    static int recursive(int arr[], int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0 && sum != 0) {
            return 0;
        }
        if (sum >= arr[n - 1]) {
            int item1 = recursive(arr, n - 1, sum);
            int item2 = recursive(arr, n - 1, sum - arr[n - 1]);
            int value = item1 + item2;
            return value;
        } else {
            return recursive(arr, n - 1, sum);
        }
    }

    // tabular DP approach to only check if subset is present or not
    static int tabular(int arr[], int n, int sum) {
        int tabularArray[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    tabularArray[i][j] = 1;
                } else {
                    if (i == 0) {
                        tabularArray[i][j] = 0;
                    } else {
                        if (j >= arr[i - 1]) {
                            int item1 = tabularArray[i - 1][j];
                            int item2 = tabularArray[i - 1][j - arr[i - 1]];
                            tabularArray[i][j] = item1 + item2;
                        } else {

                            tabularArray[i][j] = tabularArray[i - 1][j];
                        }
                    }
                }
            }

        }
        prinMatrix(n, sum, tabularArray, arr);
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsOfTabular(arr, n, sum, p, tabularArray);
        return tabularArray[n][sum];
    }

    static void printSubsetsOfTabular(int arr[], int n, int sum, ArrayList<Integer> p, int dp[][]) {
        if (n == 0 && sum == 0) {
            // print
            System.out.println(p);
            p.clear();
            return;
        }

        // not incldue
        if (dp[n - 1][sum] > 0) {
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.addAll(p);
            printSubsetsOfTabular(arr, n - 1, sum, b, dp);
        }
        // including
        if (sum >= arr[n - 1] && dp[n - 1][sum - arr[n - 1]] > 0) {
            p.add(arr[n - 1]);
            printSubsetsOfTabular(arr, n - 1, sum - arr[n - 1], p, dp);
        }
    }

    private static void prinMatrix(int n, int m, int tabularArray[][], int arr[]) {
        System.out.println();
        for (int i = 0; i <= m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print(" " + i);
            } else {
                System.out.print(" " + arr[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = { 2, 3, 5, 5, 8, 10 };
        int n = arr.length;
        int sum = 10;
        for (int i = 0; i < n; i++)
            System.out.print(" \t " + arr[i]);
        System.out.println("");
        System.out.println(" ###### Recursive Approach #################");
        System.out.println("recursive approach " + recursive(arr, n, sum));
        System.out.println(" ###### Tabular Approach #################");
        System.out.println("tabular DP approach for count = " + tabular(arr, n, sum));
        // before call meoiztion approach we have to set zero in matrix array
        // that the reason we are calling initZero function
        initZero();
        System.out.println("memoization DP approach " + memoization(arr, n, sum));
    }
}