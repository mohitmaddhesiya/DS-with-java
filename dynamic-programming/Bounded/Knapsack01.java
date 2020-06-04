/**
 * Given weights and values of n items, 
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] 
 * which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] 
 * such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
import java.util.ArrayList;

public class Knapsack01 {
    static  int memoizationMatrix[][]=new int[1000][1000];
    /**
     * Let the given weights be->{a1,a2,a3}
      Let the maximum capacity be: W

                        (W,3)
                  +(a1)  /   \  -(a1)
                        /     \
                  (W-a1,2)    (W,2)
            +(a2)  /    \-(a2)
                  /      \ 
            (W-a1-a2,1) (W-a1,1)

      Here +(ai) denotes (ai) being included and -(ai) denotes 
      it is not included.

      Now let the values returned by cases marked (1) and (2) 
      be val1 , val2 respectively so we take max(a2+val1,val2) 
      and return this to it's ancestor ,likewise for other levels. 
     * @param weigth
     * @param prise
     * @param w
     * @param n
     * @return
     */
    static int recursive(int weigth[],int prise[], int w, int n){
     if(n==0||w==0){
        return 0;
     }
     if(w>=weigth[n-1]){
          int item1=recursive(weigth, prise, w, n-1);
          int item2=prise[n-1] + recursive(weigth, prise, (w-weigth[n-1]), n-1);
        return max(item1, item2);
     }else{
        return recursive(weigth, prise, w, n-1);
     }
    }
    static int memoization(int weigth[],int prise[], int w, int n){
        if(n==0||w==0){
            return 0;
         }
         if(memoizationMatrix[n][w]==0){
            int we=weigth[n-1];
            if(w>=we){
               int pr=prise[n-1];
               int item2=pr + memoization(weigth, prise, (w-we), n-1);
               int item1= memoization(weigth, prise, w, n-1);
               memoizationMatrix[n][w]=max(item1,item2);
               return memoizationMatrix[n][w];
            }else{
               int value= memoization(weigth, prise, w, n-1);
               memoizationMatrix[n][w]= value;
               return value;
            }
         }else{
            return memoizationMatrix[n][w];
         }

    }
    static int tabular(int W, int wt[], int val[], int n){
        int tabularArray[][] = new int[n+1][W+1]; 
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
               if(i==0||j==0){
                tabularArray[i][j]=0;
               }else{
                   if(j>=wt[i-1]){
                       int item1=tabularArray[i-1][j];
                       int item2=val[i-1] + tabularArray[i-1][j-wt[i-1]];
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
    static int max(int a, int b){
      return (a>b)?a:b;
    }
    public static void main(String[] args) {
        int val[] = new int[]{60,300,120}; 
        int wt[] = new int[]{10,20,30}; 
        int w=50;
        int n = val.length; 
        System.out.println(" recursive approach  " + recursive(wt, val, w, n));
        System.out.println(" memoizationMatrix DP Approach " + memoization(wt, val, w, n));
        System.out.println(" Tabular DP wit matrix Approach " + tabular(w, wt, val, n));
    }
}