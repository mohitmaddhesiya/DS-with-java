/**
 * This is different from classical subset problem. In this prolem are allowing
 * calculte same number many time . Input: set[] = {3, 34, 4, 12, 5, 2}, sum =
 * 10 Output: True //There is a subset (5, 5) with sum 10. (we are calculating 5
 * number twice) solution: Let isSubSetSum(int set[], int n, int sum) be the
 * function to find whether there is a subset of set[] with sum equal to sum. n
 * is the number of elements in set[]. The isSubsetSum problem can be divided
 * into two subproblems a) Include the last element, recur for n = n, sum = sum
 * – set[n] b) Exclude the last element, recur for n = n-1. If any of the above
 * the above subproblems return true, then return true.
 * 
 * explain: isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) ||
 * isSubsetSum(set, n, sum-set[n-1]) Base Cases: isSubsetSum(set, n, sum) =
 * false, if sum > 0 and n == 0 isSubsetSum(set, n, sum) = true, if sum == 0
 */
public class SubSetSumProblem {
    static boolean memoizationMatrix[][] = new boolean[1000][1000];

    static void initZero() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                memoizationMatrix[i][j] = false;
            }
        }
    }

    static boolean recursive(int arr[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n < 0 && sum != 0) {
            return false;
        }
        if (sum >= arr[n]) {
            boolean item1 = recursive(arr, n - 1, sum);
            boolean item2 = recursive(arr, n, sum - arr[n]);
            return item1 || item2;
        } else {
            return recursive(arr, n - 1, sum);
        }
    }

    static boolean memoization(int arr[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n < 0 && sum != 0) {
            return false;
        }
        if (!memoizationMatrix[n][sum]) {
            if (sum >= arr[n]) {
                boolean item1 = memoization(arr, n - 1, sum);
                boolean item2 = memoization(arr, n, sum - arr[n]);
                memoizationMatrix[n][sum] = item1 || item2;
                return memoizationMatrix[n][sum];
            } else {
                return memoizationMatrix[n][sum] = memoization(arr, n - 1, sum);
            }
        } else {
            return memoizationMatrix[n][sum];
        }
    }

    static boolean tabular(int arr[], int n, int sum) {
        boolean tabularArray[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    if (i == 0) {
                        tabularArray[j][i] = true;
                    } else {
                        tabularArray[j][i] = false;
                    }
                } else {
                    if (i == 0) {
                        tabularArray[j][i] = true;
                    } else {
                        if (i >= arr[j - 1]) {
                            tabularArray[j][i] = tabularArray[j][i] || (tabularArray[j][i - arr[j - 1]]);
                        } else {
                            tabularArray[j][i] = tabularArray[j - 1][i];
                        }
                    }
                }
            }
        }
        prinMatrix(n + 1, sum + 1, tabularArray);
        return tabularArray[n][sum];
    }

    static boolean tabular2(int arr[], int n, int sum) {
        boolean tabularArray[] = new boolean[sum + 1];
        tabularArray[0] = true;
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j]) {
                    tabularArray[i] = tabularArray[i] || tabularArray[i - arr[j]];
                }
            }
        }

        for (int i = 0; i <= sum; i++) {
            System.out.print(" " + tabularArray[i]);
        }
        System.out.println();
        return tabularArray[sum];
    }

    private static void prinMatrix(int n, int m, boolean tabularArray[][]) {
        System.out.println();
        for (int i = 0; i < m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }

    static boolean tabularWithPrevious(int arr[], int n, int sum) {
        boolean tabularArray[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    tabularArray[i][j] = true;
                } else {
                    if (i == 0) {
                        tabularArray[i][j] = false;
                    } else {
                        if (j >= arr[i - 1]) {
                            boolean item1 = tabularArray[i-1][j];
                            boolean item2 = tabularArray[i][j - arr[i - 1]];
                            boolean max =  item1 || item2;
                            tabularArray[i][j] = max;
                        } else {
                            tabularArray[i][j] = tabularArray[i - 1][j];
                        }
                    }
                }
            }
        }
        return tabularArray[n][sum];
    }

    public static void main(String args[]) {
        int[] arr = { 6, 2, 4 };
        int n = arr.length;
        int sum = 12;
        for (int i = 0; i < n; i++)
            System.out.print(" \t " + arr[i]);
        System.out.println("");
        System.out.println("recursive approach " + recursive(arr, n - 1, sum));
        System.out.println("memoization approach " + memoization(arr, n - 1, sum));
        System.out.println("tabularWithPrevious approach " + tabularWithPrevious(arr, n, sum));
        System.out.println("tabular approach " + tabular(arr, n, sum));
        System.out.println("tabular  second approach approach " + tabular2(arr, n, sum));
    }
}