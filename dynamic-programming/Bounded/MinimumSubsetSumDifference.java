import java.util.ArrayList;

/**
 * Input:  arr[] = {1, 6, 11, 5} 
    Output: 1
    Explanation:
    Subset1 = {1, 5, 6}, sum of Subset1 = 12 
    Subset2 = {11}, sum of Subset2 = 11      
 */
public class MinimumSubsetSumDifference {
    static int memoizationMatrix[][] = new int[1000][1000];

    static void initZero() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                memoizationMatrix[i][j] = 0;
            }
        }
    }

    // recursive with brute force algorithm
    static int recursive(int arr[], int n, int sum1, int sum2){
        if(n==0){
            return Math.abs(sum1-sum2);
        }
        int item1=recursive(arr, n-1, sum1+arr[n-1], sum2);
        int item2=recursive(arr, n-1, sum1, sum2+arr[n-1]);
        return min(item1, item2);
    }
    /**
     * The task is to divide the set into two parts. 
        We will consider the following factors for dividing it. 
        Let 
            dp[n+1][sum+1] = {1 if some subset from 1st to i'th has a sum equal to j
                   0 otherwise}
        i ranges from {1..n}
        j ranges from {0..(sum of all elements)}  

        So      
            dp[n+1][sum+1]  will be 1 if 
            1) The sum j is achieved including i'th item
            2) The sum j is achieved excluding i'th item.

        Let sum of all the elements be S.  

        To find Minimum sum difference, w have to find j such 
        that Min{sum - j*2  : dp[n][j]  == 1 } 
            where j varies from 0 to sum/2

        The idea is, sum of S1 is j and it should be closest
        to sum/2, i.e., 2*j should be closest to sum.
        
     * In this approach we are take total sum of array.
     * we know min sum will 0 and max sum will total sum of array
     * 1) Fill Dp table with max sum of array 
     * 2) take last row true value from DP table
     * 3) take half of array element from selected values
     * 4) subtract with sum and 2*selected values of array
     * 5)take absolute and min value
     * @param arr
     * @param n
     * @return
     */
    static int tabular(int arr[], int n){
        int sum=0;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        boolean result[] = fillTabularMatrix(arr, n, sum);
        for(int j=0;j<=sum;j++){
            if(result[j]){
                arrList.add(j);
            }
        }
        int len=arrList.size();
        int min=9999999;
        for(int j=1;j<len/2;j++){
            int s1=(sum-2*arrList.get(j));
            min = Math.abs(min(min, s1));
        }
        return min;
    }

    static boolean[] fillTabularMatrix(int arr[], int n, int sum) {
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

        return tabularArray[n];
    }

    // 
    static int min(int item1, int item2){
        return item1>item2?item2:item1;
    }
    static int memoization(int arr[], int n, int sum1, int sum2) {
        if(n==0){
            return Math.abs(sum1-sum2);
        }
        int item1;
        if(memoizationMatrix[n][sum1]==0){
            memoizationMatrix[n][sum1] = sum1;
            item1=memoization(arr, n-1, sum1+arr[n-1], sum2);
        }else{
            item1 = memoizationMatrix[n][sum1];
        }
        int item2;
        if(memoizationMatrix[n][sum2]==0){
            memoizationMatrix[n][sum2] = sum2;
            item2=memoization(arr, n-1, sum1, sum2+arr[n-1]);
           
        }else{
            item2 = memoizationMatrix[n][sum2];
        }
        return min(item1, item2);
    
    }

    private static void prinMatrix(int n, int m, int tabularArray[][], int arr[]) {
        System.out.println();
        for (int i = 0; i <= m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print(" " + i);
            } else {
                System.out.print(" " + arr[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }
    /**
     * Another approach to find minium values
     * 1) calculate sum of array, sum=26
     * 2) divide by 2 of sum , sum/2=13
     * 3) find subset of 13 which below to that array using subset sum approach we ar finding
     * 4) after get check last row of matrix from last posistion of row dp[n+1][sum+1]
     * 5) stop if find true and take that postsion that will we s1
     * 6)  for s2 we will subtract from sum , sum-s1=s2;
     * 7) for result subtract s1-s2 and take absulte value .
     * @param 
     */
    static int finMinwihtSubsetProbelm(int arr[], int n, int sum){
        int result=0;
        // take half of sum of array
        int halfSum=sum/2;
        //filling matrix as subset problem 
        boolean tempArray[] = fillTabularMatrix(arr, n, halfSum);
        // taking last row of matrix and take max sum from row, will get result as s1
        for(int i=halfSum;i>=0;i--){
            if(tempArray[i]){
                result=i;
                break;
            }
        }
         // taking s2 as temp variable
        int temp=sum-result;
        return Math.abs(temp-result);
    }
    public static void main(String[] args) {
        int arr[]={1, 6, 11, 5}  ;
        int n=arr.length;
        int sum=0;
        System.out.println("--------- given Values  -------");
        for(int i=0;i<n;i++){
            System.out.print(" \t " +arr[i]);
            sum = sum +arr[i];
        }
        System.out.println();
        System.out.println("\n--------- End given Values  -------");
        System.out.println("  ######### brute force with reciursive = " + recursive(arr, n, 0, 0));
        initZero();
        System.out.println("  ######### brute force with memoization reciursive = " + memoization(arr, n, 0, 0));
        System.out.println("  ######### Tabular approach  = " + tabular(arr,n));
        System.out.println("  ######### Using subset sum problem find min diff value  = " +  finMinwihtSubsetProbelm(arr,n,sum));
        System.out.println();
        prinMatrix(n,sum,memoizationMatrix, arr);
       
    }

}