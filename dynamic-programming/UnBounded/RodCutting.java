/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * For example, if length of the rod is 8 and the values of different pieces are given as following, 
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8  
    --------------------------------------------
    price    | 1   5   8   9  10  17  17  20
    
    And if the prices are as following, 
    then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

    length   | 1   2   3   4   5   6   7   8  
    --------------------------------------------
    price    | 3   5   8   9  10  17  17  20


 */

public class RodCutting {
    static int memoizationMatrix[][] = new int[1000][1000];

    /**
     * It is same as unbound knaspack problem
     * compare with knaspack
     * given wieght is Rod lenght ( W == rodLen)
     * length array is wieght array ( wieght[] == lenght[])
     * value array is prise array ( value[] == prise[])
    */
    static int recursive(int length[], int prise[], int rodLen, int n) {
        if(rodLen==0 || n==0){
            return 0;
        }
        if(rodLen>=length[n-1]){
            int item2 = prise[n-1] + recursive(length,prise,rodLen-length[n-1],n);
            int item1 = recursive(length,prise,rodLen,n-1);
            return max(item1, item2);
        }else{
            return recursive(length,prise,rodLen,n-1);
        }
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int memoization(int length[], int prise[], int rodLen, int n) {
        if(rodLen==0 || n==0){
            return 0;
        }
        if(memoizationMatrix[n][rodLen]==0){
            if(rodLen>=length[n-1]){
                int item2 = prise[n-1] + memoization(length,prise,rodLen-length[n-1],n);
                int item1 = memoization(length,prise,rodLen,n-1);
                memoizationMatrix[n][rodLen]=max(item1, item2);
                return memoizationMatrix[n][rodLen];
            }else{
                memoizationMatrix[n][rodLen]=memoization(length,prise,rodLen,n-1);
                return memoizationMatrix[n-1][rodLen];
            }
        }else{
           return memoizationMatrix[n][rodLen];
        }   
    }

    static int tabular(int length[], int prise[], int rodLen, int n) {
        int tabularArray[][]= new int[n+1][rodLen+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=rodLen;j++){
                if(i==0||j==0){
                    tabularArray[i][j]=0;
                }else{
                    if(j>=length[i-1]){
                        tabularArray[i][j] = max(tabularArray[i-1][j], ( prise[i-1] + tabularArray[i][j-length[i-1]]));
                    }else{
                        tabularArray[i][j] = tabularArray[i-1][j];
                    }
                }
            }
        }
        return tabularArray[n][rodLen];
    }
    /* Returns the best obtainable price for a rod of length 
       n and price[] as prices of different pieces */
       static int cutRod(int price[], int n) 
       { 
           if (n <= 0) 
               return 0; 
           int max_val = Integer.MIN_VALUE; 
     
           // Recursively cut the rod in different pieces and 
           // compare different configurations 
           for (int i = 0; i<n; i++) 
               max_val = Math.max(max_val, 
                                 price[i] + cutRod(price, n-i-1)); 
     
           return max_val; 
       } 
    public static void main(String[] args) {
        int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int length[] = new int[]{1,2,3,4,5,6 ,7,8}  ;
        int rodLen = 8;
        int n = price.length;
        System.out.println(" recursive approach  " + recursive(length, price, rodLen, n - 1));
        System.out.println(" memoization approach  " + memoization(length, price, rodLen, n));
        System.out.println(" tabular approach " + tabular(length, price, rodLen, n));
        System.out.println(" another arroach  approach " + cutRod(price, n));

    }
}