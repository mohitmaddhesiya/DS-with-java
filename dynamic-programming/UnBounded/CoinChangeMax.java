/**
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
   For example, for 
                    N = 4 and S = {1,2,3}, 
   there are four solutions: 
                    {1,1,1,1},
                    {1,1,2},
                    {2,2},
                    {1,3}. 
   So output should be 4.

*  For N = 10 and S = {2, 5, 3, 6}, 
   there are five solutions: 
                    {2,2,2,2,2}, 
                    {2,2,3,3}, 
                    {2,2,6}, 
                    {2,3,5} 
                    {5,5}. 
   So the output should be 5.
 */
import java.util.ArrayList;
import java.util.Arrays; 

public class CoinChangeMax {
    static int memoizationMatrix[][] = new int[1000][1000];

    /**
     * This appraoch same as count subset problem unbound way
     * matching:
     *      subset array is given here also array is given
     *      subset sum is given here coin is given
     *      same code nothing to change
     * @param arr
     * @param coin
     * @param n
     * @return
     */
    static int recursive(int arr[], int coin, int n) {
        if(coin==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(coin>=arr[n-1]){
            int item1=recursive(arr, coin, n-1);
            int item2= recursive(arr, coin-arr[n-1], n);
            return item1+item2;
        }else{
           return recursive(arr, coin, n-1); 
        }
    }
    static int memoization(int arr[], int coin, int n) {
        if(coin==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(memoizationMatrix[n][coin]==0){
            if(coin>=arr[n-1]){
                int item1=memoization(arr, coin, n-1);
                int item2= memoization(arr, coin-arr[n-1], n);
                return memoizationMatrix[n][coin]=item1+item2;
            }else{
                return memoizationMatrix[n][coin]=memoization(arr, coin, n-1); 
            }
        }else{
            return memoizationMatrix[n][coin];
        }
    }

    static int tabular(int arr[], int coin, int n){
        int tabularArray[][]= new int[n+1][coin + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=coin;j++){
                if(j==0){
                    tabularArray[i][j]=1;  
                }else{
                    if(i==0){
                        tabularArray[i][j]=0;
                    }else{
                        if(j>=arr[i-1]){
                            tabularArray[i][j] = tabularArray[i-1][j] + tabularArray[i][j-arr[i-1]];  
                        }else{
                            tabularArray[i][j] = tabularArray[i-1][j];  
                        }
                    }
                }
            }   
        }
        prinMatrix(n, coin, tabularArray);
        printSubsetsOfTabular(arr, n, coin,new int[n+1], 0, tabularArray);
        return tabularArray[n][coin];
    }

    static int tabularReduceSpaceComplexicty(int arr[], int coin, int n){
        int tabularArray[]= new int[coin + 1];
        tabularArray[0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=coin;j++){
            if(j>=arr[i]){
                tabularArray[j]=tabularArray[j] + tabularArray[j-arr[i]];
                }
            }
        }
        for(int i=0;i<coin;i++){
            System.out.print("  " + tabularArray[i]);
        }
        System.out.println("    ");
        return tabularArray[coin];
    }
    /**
     * print all count path values
     * @param arr
     * @param n
     * @param sum
     * @param p
     * @param dp
     */
    static void printSubsetsOfTabular(int arr[], int n, int coin, int printArray[], int pos, int dp[][]) {
        if(coin==0){
            for(int i=0;i<pos;i++)
                System.out.print("  " + printArray[i]);
            System.out.println("    ");
            return;
        }
        if(n==0){
            return;
        }
        // excluding
        if(dp[n][coin]>0){
            printSubsetsOfTabular(arr, n-1,coin,printArray, pos ,dp);
        }
        // including
        if(coin>=arr[n-1] && dp[n][coin]>0){
            printArray[pos] = arr[n-1];
            pos++;
            printSubsetsOfTabular(arr,n,coin-arr[n-1],printArray, pos,dp);
        }
    }

    private static void prinMatrix(int n, int m, int tabularArray[][]) {
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
    
    static long countWays(int S[], int m, int n) 
    { 
        //Time complexity of this function: O(mn) 
        //Space Complexity of this function: O(n) 
  
        // table[i] will be storing the number of solutions 
        // for value i. We need n+1 rows as the table is 
        // constructed in bottom up manner using the base 
        // case (n = 0) 
        long[] table = new long[n+1]; 
  
        // Initialize all table values as 0 
        Arrays.fill(table, 0);   //O(n) 
  
        // Base case (If given value is 0) 
        table[0] = 1; 
  
        // Pick all coins one by one and update the table[] 
        // values after the index greater than or equal to 
        // the value of the picked coin 
        for (int i=0; i<m; i++) 
            for (int j=S[i]; j<=n; j++) 
                table[j] += table[j-S[i]]; 
  
        return table[n]; 
    } 


    public static void main(String[] args) {
        int arr[] = new int[] {2, 5, 3, 6};
        int coin = 6;
        int n = arr.length;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println(" recursive approach  " + recursive(arr, coin, n ));
        System.out.println(" memoization approach  " + memoization(arr, coin, n));
        System.out.println(" tabular approach " + tabular(arr, coin, n));
        System.out.println(" another arroach  approach " + countWays(arr, n,coin));
        System.out.println(" another tabluar reduce space complexity arroach  approach " + tabularReduceSpaceComplexicty(arr, coin,n));
    }
}