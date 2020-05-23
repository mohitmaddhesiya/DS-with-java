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
import java.util.ArrayList;
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
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=sum; j++) {
                if (j == 0) {
                    tabularArray[i][j] = true;
                } else {
                    if (i == 0) {
                        tabularArray[i][j] = false;
                    } else {
                        if (j >= arr[i-1]) {
                            boolean item1 = tabularArray[i - 1][j];
                            boolean item2 = tabularArray[i - 1][j - arr[i-1]];
                            tabularArray[i][j] = item1 || item2;
                        } else {
                            
                            tabularArray[i][j] = tabularArray[i - 1][j];
                        }
                    }
                }
            }

        }
        prinMatrix(n, sum, tabularArray, arr);
        printValues(n, sum, tabularArray, arr);
        ArrayList<Integer> p = new ArrayList<>(); 
        printSubsetsRec(arr, n, sum, p, tabularArray); 

        return tabularArray[n][sum];
    }
    static void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
       
    // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p, boolean dp[][]) 
    { 
      // System.out.println("\t" + i + " sum "+sum + " arr " + arr[i-1] );

        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sun OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) 
        { 
            //p.add(arr[i-1]); 
           // display1(p); 
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0) 
        { 
            display1(p); 
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        //System.out.println("i = " + i  + " sum = " + sum + " dp[i-1][sum] = " + dp[i-1][sum]);
        if (dp[i-1][sum]) 
        { 
           // System.out.println("\t if we are not incuding sum =  " + sum + " i = " + i + " arr = " +arr[i-1] + " dp[i-1][sum] = " +  dp[i-1][sum]);

            // Create a new vector to store path 
           // System.out.println("\t p " + p);
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
           // System.out.println("\t b " + b);

            printSubsetsRec(arr, i-1, sum, b, dp); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
           // 

           // System.out.println("\t dp[i-1][sum-arr[i]] = " + (sum-arr[i-1]));

            if (sum >= arr[i-1] && dp[i-1][sum-arr[i-1]]) 
            { 
               //System.out.println("\t if we are incuding sum =  " + sum + " i = " + i + " arr = " +arr[i-1] + " dp[i-1][sum-arr[i-1]] = " +  dp[i-1][sum-arr[i-1]]);
                p.add(arr[i-1]); 
                printSubsetsRec(arr, i-1, sum-arr[i-1], p,dp); 
            } 
       
    }
    static void display1(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
       
    private static void prinMatrix(int n, int m, boolean tabularArray[][], int arr[]){
        System.out.println();
        for(int i=0;i<=m;i++)
        System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for(int i=0;i<=n;i++){
            if(i==0){
                System.out.print(" " + i);
            }else{
                System.out.print(" " + arr[i-1]);
            }
            for(int j=0;j<=m;j++){
                System.out.print("|\t" + tabularArray[i][j] + "_");
            }
            System.out.println("__");
        }
        System.out.println();
    }
    private static void printValues(int n, int m, boolean tabularArray[][], int arr[]){
            int i=n;
            int j=m;
            System.out.println("##### Print Only one sum  #########");
            while(i>=0 && j>=0){
                if(j==0 || i==0)
                    break;
                if(tabularArray[i][j]){
                    if(tabularArray[i-1][j]){
                        i=i-1;
                    }else{
                        System.out.print("\t " + arr[i-1]);
                        j=j-arr[i-1];
                    }
                }else{
                    break;
                }
            }
            System.out.println();
            System.out.println("##### End Only one sum #########");
    }
    /**
     * Given an array and a number, print all subsets with sum equal to given the sum.
        Input :  arr[] =  {2, 5, 8, 4, 6, 11}, sum = 13
        Output : 
        5 8
        2 11
        2 5 6

        Input : arr[] =  {1, 5, 8, 4, 6, 11}, sum = 9
        Output :
        5 4
        1 8

     * @param arr
     * @param n
     * @param sum
     * @param pos
     * @param pr
     * @return
     */
    public static int printAllSubsetSum(int arr[], int n, int sum, int pos ,int pr[]){
        
        if(sum==0){
            System.out.println("");
            for(int i=0;i<pos;i++)
                System.out.print(" \t " +pr[i]);
                System.out.println("");
            return sum;
        }

        if(sum<0 || n<0){
            return sum;
        }
        if(arr[n]<=sum){
            int sum2=printAllSubsetSum(arr,n-1,sum, pos, pr);
            pr[pos]=arr[n];
            pos++;
            int sum1=printAllSubsetSum(arr,n-1,sum-arr[n], pos, pr);
            if(sum1>sum2){
                pr[n]=arr[n];
                   pos++;
                return sum1;
            }else{
                return sum2;
            }
        }else{
            return printAllSubsetSum(arr,n-1,sum, pos, pr); 
        }

    }
    public static void main(String args[]) {
        int[] arr = {2, 3, 5, 5, 8, 10};
        int pr[] = new int[100];
        int n = arr.length;
        int sum = 10 ;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println("recursive approach " + recursive(arr, n, sum));
        System.out.println("memoization DP approach " + memoization(arr, n, sum));
        System.out.println("tabular DP approach " + tabular(arr, n, sum));
        System.out.println("##### Print All Sub set sum #########");
        printAllSubsetSum(arr, n-1, sum, 0, pr);
        System.out.println("#### End Print All Sub set sum ######");
    }
}