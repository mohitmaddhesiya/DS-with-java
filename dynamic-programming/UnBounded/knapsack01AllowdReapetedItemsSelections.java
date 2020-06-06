/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wte, 
 * we need to calculate minimum amount that could make up this quantity exactly. 
 * This is different from classical Knapsack problem, 
 * here we are allowed to use unlimited number of instances of an item. 
 * Input : W = 100
           val[] = {1, 30} 
           wt[] = {1, 50} 
 *         
 *         Output : 100 
 
   There are many ways to fill knapsack. 
   1) 2 instances of 50 unit weight item. 
   2) 100 instances of 1 unit weight item. 
   3) 1 instance of 50 unit weight item and 50 instances of 1 unit
 * weight items. We get maximum value with option 2.
 * 
 * Input : W = 8 
 *         val[] = {10, 40, 50, 70} 
 *         wt[] = {1, 3, 4, 5} 
 *         
 *         Output : 110 
 * We get maximum value with one unit of weight 5 and one unit of weight 3.
 */
public class knapsack01AllowdReapetedItemsSelections {
    static int memoizationMatrix[][] = new int[1000][1000];

    /**
     *
     * @param weigth
     * @param prise
     * @param w
     * @param n
     * @return
     */
    static int recursive(int weigth[], int prise[], int w, int n) {
        if (n < 0 || w < 0)
            return 0;

        if (weigth[n] <= w) {
            int item1 = recursive(weigth, prise, w, n - 1);
            int item2 = prise[n] + recursive(weigth, prise, (w - weigth[n]), n);
            return max(item1, item2);
        } else {
            return recursive(weigth, prise, w, n - 1);
        }

    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int memoization(int weigth[], int prise[], int w, int n) {
        if (n < 0 || w < 0)
            return 0;
        if (memoizationMatrix[n][w] == 0) {
            if (weigth[n] <= w) {
                int item1 = memoization(weigth, prise, w, n - 1);
                int item2 = prise[n] + memoization(weigth, prise, (w - weigth[n]), n);
                memoizationMatrix[n][w] = max(item1, item2);
                return memoizationMatrix[n][w];
            } else {
                memoizationMatrix[n][w] = recursive(weigth, prise, w, n - 1);
                return memoizationMatrix[n][w];
            }
        } else {
            return memoizationMatrix[n][w];
        }
    }

    static int tabular(int wt[], int val[], int W, int n) {
        int tabularArray[]= new int[W + 1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<n;j++){
                if(i>=wt[j]){
                    tabularArray[i] = max(tabularArray[i], val[j]+ tabularArray[i-wt[j]]);
                }
            }
        }

        for(int i=0;i<=W;i++){
            System.out.print(" " + tabularArray[i]);
        }
        System.out.println();
        return tabularArray[W];
    }

    static int tabularWithPrevious(int wt[], int val[], int W, int n) {
        int tabularArray[][] = new int[n+1][W+1]; 
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
               if(i==0||j==0){
                tabularArray[i][j]=0;
               }else{
                   if(j>=wt[i-1]){
                       int item1=tabularArray[i-1][j];
                       int item2=val[i-1] + tabularArray[i][j-wt[i-1]];
                       int max=max(item1, item2);
                       tabularArray[i][j]=max;
                   }else{
                    tabularArray[i][j]=tabularArray[i-1][j]; 
                   }
               }
            }
        }      
         return tabularArray[n][W];
    }

    static int tabular2(int wt[], int val[], int W, int n) {
        int tabularArray[][]= new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    tabularArray[j][i]=0;
                }else{
                    if(i>=wt[j-1]){
                        tabularArray[j][i] = max(tabularArray[j][i], val[j-1]+ tabularArray[j][i-wt[j-1]]);
                    }else{
                        tabularArray[j][i] = tabularArray[j-1][i];
                    }
                }
            }
        }
        prinMatrix(n+1,W+1,tabularArray);
        return tabularArray[n][W];
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


    public static void main(String[] args) {
        int val[] = new int[] {10, 40, 50, 70};
        int wt[] = new int[]{1, 3, 4, 5}  ;
        int w = 7;
        int n = val.length;
        System.out.println(" recursive approach  " + recursive(wt, val, w, n - 1));
        System.out.println(" memoization approach  " + memoization(wt, val, w, n - 1));
        System.out.println(" tabular approach similier approach " + tabularWithPrevious(wt, val, w, n));
        System.out.println(" tabular approach  " + tabular(wt, val, w, n));
        System.out.println(" tabular2 approach  " + tabular2(wt, val, w, n));
    }
}