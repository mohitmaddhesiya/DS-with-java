/**
 *  This is different from classical subset problem.
 *  In this prolem are allowing calculte same number many time .
 *  Input:  set[] = {6,2,4}, sum = 14
    Output: 8 (return count of subset is equal to sum)
    explain: [2 6 6]  == 14
             [2 2 2 2 6]  == 14
             [2 2 2 2 2 2 2]  == 14
             [4 2 2 6]  == 14
             [4 2 2 2 2 2]  == 14
             [4 4 6]  == 14
             [4 4 2 2 2]  == 14
             [4 4 4 2]  == 14


    Same probem as subset problem but different is we need to count
**/
import java.util.ArrayList;
public class CountSubsetSumProblem {
    static int memoizationMatrix[][] = new int[1000][1000];

    static int recursive(int arr[], int n, int sum) {
        if(sum==0){

            return 1;
        }
        if(n<0 && sum!=0){
            return 0;
        }
        if(sum>=arr[n]){
            int item1=recursive(arr, n-1,sum);
            int item2=0;
            if(sum!=0){
                item2=recursive(arr, n,sum-arr[n]);
            }
            return item1+item2;
        }else{
            return recursive(arr, n-1,sum);
        }
    }

    static int memoization(int arr[], int n, int sum) {
        if(sum==0){

            return 1;
        }
        if(n<0 && sum!=0){
            return 0;
        }
        if(memoizationMatrix[n][sum]==0){
            if(sum>=arr[n]){
                int item1=memoization(arr, n-1,sum);
                int item2=memoization(arr, n,sum-arr[n]);
                return memoizationMatrix[n][sum]= item1+item2;
            }else{
                return memoizationMatrix[n][sum] = memoization(arr, n-1,sum);
            }
        }else{
            return memoizationMatrix[n][sum];
        }    
    }

    static int tabular(int arr[], int n, int sum) {
        int tabularArray[][]= new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    tabularArray[i][j] = 0;
                }else{
                    if(j==0){
                        tabularArray[i][j] = 1;
                    }
                }
            }
        }
        for(int i=0;i<=sum;i++){
            for(int j=0;j<=n;j++){
                if(i!=0 && j!=0){
                    if(i>=arr[j-1]){
                        tabularArray[j][i]= tabularArray[j-1][i] +  tabularArray[j][i-arr[j-1]];
                    }else{
                        tabularArray[j][i] = tabularArray[j-1][i];
                    }
                }
                
            }   
        }
       // prinMatrix(n+1, sum+1, tabularArray);

        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsOfTabular(arr, n-1, sum, p,tabularArray);
        return tabularArray[n][sum];
    }
    static void printSubsetsOfTabular(int arr[], int n, int sum, ArrayList<Integer> p, int dp[][]) {
       if ((n == 0) && (sum != 0) && (dp[0][sum]>0)) 
        { 
            p.add(arr[n]); 
            System.out.println(p); 
            p.clear(); 
            return; 
        } 
        if( sum == 0){
            System.out.println(p);
            p.clear();
            return;
        }
        if (n == -1 && sum == 0) {
            // print
            System.out.println(p);
            p.clear();
            return;
        }
        if(n<0 && sum!=0){
            return;
        }
         
        // not incldue
        if (dp[n+1][sum] > 0) {
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.addAll(p);
            printSubsetsOfTabular(arr, n - 1, sum, b, dp);
        }
        // including
        if (sum >= arr[n] && dp[n+1][sum - arr[n]] > 0) {
            p.add(arr[n]);
            printSubsetsOfTabular(arr, n, sum - arr[n], p, dp);
        }
       
    }
    private static int recursiveValuesOfCount(int arr[], int n, int sum, int array[], int pos) {
        if(sum==0){
            int check =0 ;
            for(int i=0;i<pos;i++){
                check = check + array[i];
                System.out.print(" " + array[i]);
            }
            System.out.print("  == " + check);
            System.out.println();
            return 1;
        }
        if(n<0 && sum!=0){
            return 0;
        }
        if(sum>=arr[n]){
            int item1=recursiveValuesOfCount(arr, n-1,sum, array, pos);
            array[pos] = arr[n];
            pos++;
            int  item2=recursiveValuesOfCount(arr, n,sum-arr[n], array, pos);
            return item1+item2;
        }else{
            return recursiveValuesOfCount(arr, n-1,sum, array, pos);
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

    static int tabularWithPrevious(int arr[], int n, int sum) {
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
                            int item1 = tabularArray[i-1][j];
                            int item2 = tabularArray[i][j - arr[i - 1]];
                            int max =  item1 + item2;
                            tabularArray[i][j] = max;
                        } else {
                            tabularArray[i][j] = tabularArray[i - 1][j];
                        }
                    }
                }
            }
        }
        prinMatrix(n+1, sum+1, tabularArray);

        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsOfTabular(arr, n-1, sum, p,tabularArray);
        return tabularArray[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {6,2,4};
        int n = arr.length;
        int sum = 14;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println("recursive approach  count number of sum = " + recursive(arr, n-1, sum));
        recursiveValuesOfCount(arr, n-1, sum, new int[sum+1], 0);
        System.out.println("memoization  approach  count number of sum = " + memoization(arr, n-1, sum));
        System.out.println("tabular 2 approach count number of sum  = " + tabularWithPrevious(arr, n, sum));

       // prinMatrix(n+1, sum+1, memoizationMatrix);
        System.out.println("tabular approach count number of sum  = " + tabular(arr, n, sum));
    }
}