/**
 * Polycarpus has a ribbon, its length is n. He wants to cut the ribbon in a way that fulfils the following two conditions:

   1) After the cutting each ribbon piece should have length a, b or c.
   2) After the cutting the number of ribbon pieces should be maximum.
   3) Help Polycarpus and find the number of ribbon pieces after the required cutting.

    Input
    The first line contains four space-separated integers n, a, b and c (1 ≤ n, a, b, c ≤ 4000) — 
    the length of the original ribbon and the acceptable lengths of the ribbon pieces after the cutting, 
    correspondingly. The numbers a, b and c can coincide e.g arr[a,b,c].

    Output
    Print a single number — the maximum possible number of ribbon pieces. 
    It is guaranteed that at least one correct ribbon cutting exists.

    Examples
    inputCopy
    5 5 3 2
    outputCopy
    2
    inputCopy
    7 5 5 2
    outputCopy
    2
    ------------------------------------------------------------------------
    Note:
        In the first example Polycarpus can cut the ribbon in such way: 
            the first piece has length 2, the second piece has length 3.

        In the second example Polycarpus can cut the ribbon in such way: 
            the first piece has length 5, the second piece has length 2.
 */
public class CutRibbonMax {
    static int INT_MIN=Integer.MIN_VALUE+1;
    static int memoizationMatrix[][] = new int[1000][1000];
    static void fillMatrix(){
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                memoizationMatrix[i][j]=INT_MIN; 
            }
        }
}
    static int recursive(int arr[], int coin, int n) {
        if(coin==0){
            return 0;
        }
        if(n==0){
            return INT_MIN;
        }
        if(coin>=arr[n-1]){
            int item1=recursive(arr, coin, n-1);
            int item2=1+recursive(arr, coin-arr[n-1], n);
            return max(item1, item2);
        }else{
            return recursive(arr, coin, n-1);
        }
    }

    static int recursiveWithVariable(int a, int b, int c, int coin) {
        if(coin==0){
            return 0;
        }
        if(coin<0){
            return INT_MIN;
        }
        int aItem = recursiveWithVariable(a,b,c,coin-a);
        int bItem= recursiveWithVariable(a,b,c,coin-b);
        int min=max(aItem, bItem);
        int cItem= recursiveWithVariable(a,b,c,coin-c);
        return 1+ max(min, cItem);
    }
    
    static int max(int x, int y){
        return x>y?x:y;
    }

    static int memoization(int arr[], int coin, int n) {
        if(coin==0){
            return 0;
        }
        if(n==0){
            return INT_MIN;
        }
        if(memoizationMatrix[n][coin]==INT_MIN){
            if(coin>=arr[n-1]){
                int item1=memoization(arr, coin, n-1);
                int item2=1+memoization(arr, coin-arr[n-1], n);
                memoizationMatrix[n][coin] = max(item1, item2);
                return memoizationMatrix[n][coin];
            }else{
                memoizationMatrix[n][coin] = memoization(arr, coin, n-1);
                return memoizationMatrix[n][coin];
            }
        }else{
            return memoizationMatrix[n][coin];
        }
    }

     static int memoizationWithVariable(int a, int b, int c, int coin, int n) {
        if(coin==0){
            return 0;
        }
        if(n==0){
            return INT_MIN;
        }
        if(memoizationMatrix[n][coin]==INT_MIN){
            int aItem = recursiveWithVariable(a,b,c,coin-a);
            int bItem= recursiveWithVariable(a,b,c,coin-b);
            int min=max(aItem, bItem);
            //memoizationMatrix[n][coin] = min;
            int cItem= recursiveWithVariable(a,b,c,coin-c);
            return  memoizationMatrix[n][coin]= 1+ max(min, cItem);
        }else{
            return memoizationMatrix[n][coin];
        }
    }

    static int tabular(int arr[], int coin, int n) {
        int tabularArray[][]= new int[n+1][coin + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=coin;j++){
                if(i==0){
                    tabularArray[i][j]= INT_MIN;
                }else{
                    if(j==0){
                        tabularArray[i][j] = 0;
                    }else{
                        if(j>=arr[i-1]){
                            tabularArray[i][j] =   max(tabularArray[i-1][j],   1+tabularArray[i][j-arr[i-1]]);
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
    static int tabularWithVariable(int a,int b,int c, int coin) {
        // fill array other wise we have to run one by one loop for a , b, c
        // e.f a we have to run 0 to <=coin , for b we have to run 0 to <=coin , for c we have to run 0 to <=coin;
        // that the reason i have putted in array easy to loop
        int arr[] = {a,b,c};
        int n=arr.length;
        int tabularArray[][]= new int[n+1][coin + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=coin;j++){
                if(i==0){
                    tabularArray[i][j]= INT_MIN;
                }else{
                    if(j==0){
                        tabularArray[i][j] = 0;
                    }else{
                        if(j>=arr[i-1]){
                            tabularArray[i][j] =   max(tabularArray[i-1][j],   1+tabularArray[i][j-arr[i-1]]);
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
    public static void main(String[] args) {
        int arr[] = new int[]{5,3,2};
        int coin = 5;
        int a=5;
        int b=3;
        int c=2 ;
        int n = arr.length;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println(" recursive approach  " + recursive(arr, coin, n ));
        System.out.println(" recursive Variable approach  " + recursiveWithVariable(a,b,c,coin));
        fillMatrix();
        System.out.println(" memoization approach  " + memoization(arr, coin, n));
        prinMatrix(n, coin, memoizationMatrix);
        fillMatrix();
        System.out.println(" memoization  variable approach  " + memoizationWithVariable(a, b, c, coin, n));
        prinMatrix(n, coin, memoizationMatrix);
        System.out.println(" tabular approach " + tabular(arr, coin, n));
        System.out.println(" tabular with variable approach " + tabularWithVariable(a, b, c , coin));
        /*System.out.println(" another tabluar reduce space complexity arroach  approach " + tabularReduceSpaceComplexicty(arr, coin,n));
        System.out.println(" another recursive approach  count min number of coin " + minCoins(arr, n,coin));
        System.out.println(" another tabular  approach  count min number of coin " + anotherTabularWay(arr, n,coin));*/
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
}