/**
 * Given a value V, if we want to make change for V cents, 
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, 
 * what is the minimum number of coins to make the change?
 * Input: coins[] = {25, 10, 5}, V = 30
                    Output: Minimum 2 coins required
                    We can use one coin of 25 cents and one of 5 cents 

                    Input: coins[] = {9, 6, 5, 1}, V = 11
                    Output: Minimum 2 coins required
                    We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class CoinChangeMin {
    static int INT_MAX=Integer.MAX_VALUE-1;
    static int memoizationMatrix[][] = new int[1000][1000];
    static void fillMatrix(){
            for(int i=0;i<1000;i++){
                for(int j=0;j<1000;j++){
                    memoizationMatrix[i][j]=INT_MAX; 
                }
            }
    }
    static int recursive(int arr[], int coin, int n) {
        if(coin==0){
            return 0;
        }
        if(n==0){
            return INT_MAX;
        }
        if(coin>=arr[n-1]){
            int item1=recursive(arr, coin, n-1);
            int item2=1+recursive(arr, coin-arr[n-1], n);
            return min(item1, item2);
        }else{
            return recursive(arr, coin, n-1);
        }
    }
    static int min(int x, int y){
        return x>y?y:x;
    }
    static int memoization(int arr[], int coin, int n) {
        if(coin==0){
            return 0;
        }
        if(n==0){
            return INT_MAX;
        }
        if(memoizationMatrix[n][coin]==INT_MAX){
            if(coin>=arr[n-1]){
                int item1=memoization(arr, coin, n-1);
                int item2=1+memoization(arr, coin-arr[n-1], n);
                memoizationMatrix[n][coin] = min(item1, item2);
                return memoizationMatrix[n][coin];
            }else{
                memoizationMatrix[n][coin] = memoization(arr, coin, n-1);
                return memoizationMatrix[n][coin];
            }
        }else{
            return memoizationMatrix[n][coin];
        }
    }
    static int tabular(int arr[], int coin, int n) {
        int tabularArray[][]= new int[n+1][coin + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=coin;j++){
                if(i==0){
                    tabularArray[i][j]= INT_MAX;
                }else{
                    if(j==0){
                        tabularArray[i][j] = 0;
                    }else{
                        if(j>=arr[i-1]){
                            tabularArray[i][j] =   min(tabularArray[i-1][j],   1+tabularArray[i][j-arr[i-1]]);
                        }else{
                            tabularArray[i][j]= tabularArray[i-1][j];
                        }
                    }
                    
                }
            }
        }
        prinMatrix(n, coin, tabularArray);
        return tabularArray[n][coin];
    }
    static int tabularReduceSpaceComplexicty(int arr[], int coin, int n){
        int tabularArray[]= new int[coin + 1];
        tabularArray[0]=0;
        for(int i=1;i<=coin;i++){
            if(i%arr[0]==0){
                tabularArray[i] = i/arr[0];
            }else{
                tabularArray[i] = INT_MAX; 
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=coin;j++){
                if(j>=arr[i]){
                    tabularArray[j] =   min(tabularArray[j],   1+tabularArray[j-arr[i]]);
                   // System.out.println(" \t "+ tabularArray[j]);
                }
            }
        }
        System.out.println(" Last row of matrix with one daimaila array space complexcity ");
        for(int i=0;i<=coin;i++){
            System.out.print(" \t "+ tabularArray[i]);
        }
        System.out.println("\n");
        return tabularArray[coin];
    }       

    private static void prinMatrix(int n, int m, int tabularArray[][]) {
        System.out.println();
        for (int i = 0; i < m; i++)
            System.out.print("__\t\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }

    static int minCoins(int coins[], int n, int coin) 
    { 
       // base case 
       if (coin == 0) return 0; 
       
       // Initialize result 
       int res = INT_MAX; 
       
       // Try every coin that has smaller value than coin 
       for (int i=0; i<n; i++) 
       { 
         if (coins[i] <= coin) 
         { 
             int sub_res = minCoins(coins, n, coin-coins[i]); 
       
             // Check for INT_MAX to avoid overflow and see if 
             // result can minimized 
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
                res = sub_res + 1; 
         } 
       } 
       return res; 
    } 

    // m is size of coins array  
    // (number of different coins) 
    static int anotherTabularWay(int coins[], int n, int coin) 
    { 
        // table[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // table[coin] will have result 
        int table[] = new int[coin + 1]; 
  
        // Base case (If given value coin is 0) 
        table[0] = 0; 
  
        // Initialize all table values as Infinite 
        for (int i = 1; i <= coin; i++) 
        table[i] = Integer.MAX_VALUE; 
  
        // Compute minimum coins required for all 
        // values from 1 to coin 
        for (int i = 1; i <= coin; i++) 
        { 
            // Go through all coins smaller than i 
            for (int j = 0; j < n; j++) 
            if (coins[j] <= i) 
            { 
                int sub_res = table[i - coins[j]]; 
                if (sub_res != Integer.MAX_VALUE  
                       && sub_res + 1 < table[i]) 
                       table[i] = sub_res + 1; 
            } 
        } 
        return table[coin]; 
    } 
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        int coin = 5;
        int n = arr.length;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println(" recursive approach  " + recursive(arr, coin, n ));
        fillMatrix();
        System.out.println(" memoization approach  " + memoization(arr, coin, n));
        prinMatrix(n, coin, memoizationMatrix);
        System.out.println(" tabular approach " + tabular(arr, coin, n));
        System.out.println(" another tabluar reduce space complexity arroach  approach " + tabularReduceSpaceComplexicty(arr, coin,n));
        System.out.println(" another recursive approach  count min number of coin " + minCoins(arr, n,coin));
        System.out.println(" another tabular  approach  count min number of coin " + anotherTabularWay(arr, n,coin));
    }
}