/**
 * Given an array arr[] of length N and an integer X, 
 * the task is to find the number of subsets with diff equal to X.
 * Input: arr[] = {1, 1, 2, 3}, X = 1
    Output: 3
    All the possible subsets are {{1, 1, 2}-{3}=1},
    {{3,1}-{1,2}=1} and {{3, 1}-{2,1}=1} 
    note: 1 is repeating twice 
 */
 public class CounNumberOfSubsetGivenDifference {
      // recursive with brute force algorithm
      static int recursive(int arr[], int n, int sum1, int sum2, int diff, int count){
        if(n==0){
            if(Math.abs(sum1-sum2)==diff){
                count++;
            }
            return count;
        }else{
            count=recursive(arr, n-1, sum1+arr[n-1], sum2, diff, count);
            if(Math.abs(sum1-sum2) != diff){
                count=recursive(arr, n-1, sum1, sum2+arr[n-1], diff, count);
            }
            return count;
        }
    }
    static int min(int item1, int item2){
        return item1>item2?item2:item1;
    }
    /**
     * best approach: 
     *    We know the dirrence and arry is given
     *    s1-s2=diff (which i need to find)
     *    s1+s2=sum of array (which we know )
     *   Add both equation
     *   s1-s2=diff
     *   s1+s2=sumOfArray
     *  --------------------
     *   2s1 = diff + sumOfArray (s2 will cancel because have + and - )
     *               diff + sumOfArray 
     * then s1 =     ------------------ ( Which i need to search)
     *                     2
     * Example: 
     *      arr =[1,1,2,3] and diff=1
     *    then sumOfArray = 7;
     * 
     *              1(diff) + 7(sumOfArray)
     *   then s1=   -----------------------
     *                      2
     *    then s1=8/2=4
     * then s1=4 (We need to find count subset which equal to given sum means 4)
     *  this is similer problem of count number of Subset given sum.
     * 
     *   Go to file  CountSubsetSumProblem.java in this folder
     * @param args
     */

    public static int subsetGivenDiff(int arr[], int n, int diff){
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        int totalSum= diff+sum;
        if(totalSum%2==0){
            int s1=totalSum/2;
            CountSubsetSumProblem countSubsetSum=new CountSubsetSumProblem();
            // calling count number of Subset given sum function
            int result = countSubsetSum.tabular(arr, n, s1);
            return result; 
        }else{
            System.out.println("  no two subset are  parsent which is equal to given difff");
            return 0;
        }
    }
    public static void main(String[] args) {
        int arr[]={1, 1, 2, 3}  ;
        int n=arr.length;
        int diff=1;
        System.out.println("--------- given Values  -------");
        for(int i=0;i<n;i++){
            System.out.print(" \t " +arr[i]);
        }
        System.out.println();
        System.out.println("\n--------- End given Values  -------");
        System.out.println("  ######### brute force with recursive for number of count diff  = " + recursive(arr, n, 0, 0, diff, 0));
        System.out.println("  ######### tabular approach for number of count diff  = " + subsetGivenDiff(arr, n, diff));

    }
}