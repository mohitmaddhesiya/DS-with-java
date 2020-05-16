/**
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    Output:  True  //There is a subset (4, 5) with sum 9.
    solution: Let isSubSetSum(int set[], int n, int sum) be the function to find whether there is a subset of set[] with sum equal to sum. n is the number of elements in set[].
            * The isSubsetSum problem can be divided into two subproblems
                a) Include the last element, recur for n = n-1, sum = sum – set[n-1]
                b) Exclude the last element, recur for n = n-1.
            If any of the above the above subproblems return true, then return true.

    explain: isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) ||   isSubsetSum(set, n-1, sum-set[n-1])
                Base Cases:
                isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
                isSubsetSum(set, n, sum) = true, if sum == 0 
 */
public class SubsetSumProblem {
    static boolean memoizationMatrix[][] = new boolean[1000][1000];

    // recursive approach only check if subset is present or not
    static boolean recursive(int arr[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum >= arr[n - 1]) {
            boolean item1 = recursive(arr, n - 1, sum);
            boolean item2 = recursive(arr, n - 1, sum - arr[n - 1]);
            boolean value = item1 || item2;
            return value;
        } else {
            return recursive(arr, n - 1, sum);
        }
    }

    // memoization DP approach to only check if subset is present or not
    static boolean memoization(int arr[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum >= arr[n - 1]) {
            boolean item1 = memoization(arr, n - 1, sum);
            boolean item2 = memoization(arr, n - 1, sum - arr[n - 1]);
            boolean value = item1 || item2;
            memoizationMatrix[n][sum] = value;
            return value;
        } else {
            boolean value = memoization(arr, n - 1, sum);
            memoizationMatrix[n][sum] = value;
            return value;
        }
    }

    // tabular DP approach to only check if subset is present or not
    static boolean tabular(int arr[], int n, int sum) {
        boolean tabularArray[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum; j++) {
                if (j == 0) {
                    tabularArray[i][j] = false;
                } else {
                    if (i == 0) {
                        tabularArray[i][j] = true;
                    } else {
                        if (j >= arr[i]) {
                            boolean item1 = tabularArray[i - 1][j];
                            boolean item2 = tabularArray[i - 1][j - arr[i - 1]];
                            tabularArray[i][j] = item1 || item2;
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
        int[] arr = { 2, 3, 7, 8, 10 };
        int n = arr.length;
        int sum = 11;
        System.out.println("recursive approach " + recursive(arr, n, sum));
        System.out.println("memoization DP approach " + memoization(arr, n, sum));
        System.out.println("tabular DP approach " + memoization(arr, n, sum));
    }
}