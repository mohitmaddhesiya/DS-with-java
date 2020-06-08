import java.util.HashMap;

/**
 * Given an unsorted array of integers, 
 * find a subarray which adds to a given number. 
 * If there are more than one subarrays with the sum as the given number, print any of them.
 *  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
                    Output: Sum found between indexes 2 and 4
                    Explantion: Sum of elements between indices
                    2 and 4 is 20 + 3 + 10 = 33

    Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
                    Output: Sum found between indexes 0 to 3
                    Explantion: Sum of elements between indices
                    0 and 3 is 10 + 2 - 2 - 20 = -10

    Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
                    Output: No subarray with given sum exists
                    Explantion: There is no subarray with the given sum
*/
public class SubArraySumWithNegative {
    // brute force Approach
    static void bruteForce(int arr[], int n, int sum) {
        int result=0;
        int posI=0;
        int posJ=0;
        for(int i=0;i<n;i++){
            int j=i;
            posI = i;
            result = 0;
            for(;j<n;j++){
                result = result + arr[j];
                 // break for inner loop if result found
                if(sum == result){
                    break;
                }
            }
            // break for outer loop if result found
            if(sum == result){
                posJ= j;
                break;
            }
        }
        if(result!=sum){
            System.out.println(" No subarray found ! There is no subarray with " + sum + " sum");
        }else{
            System.out.println(" Sum found between indexes "+ posI+ " and " + posJ);
        }
    }
    /**
     * Using Hash Map find sum
     * The idea is to store the sum of elements of every prefix of the array in a hashmap, 
     * i.e for every index store the sum of elements upto that index hashmap.
     *  So to check if there is a subarray with sum equal to s, check for every index i, 
     * and sum upto that index as x. If there is a prefix with sum equal to x – s, 
     * then the subarray with given sum is found. 
     * 
     * create a Hashmap (hm) to store key value pair, 
     * i.e, key = prefix sum and value = its index and a variable to store the current sum (sum = 0) and the sum of subarray as s
        Traverse through the array from start to end.
        For every element update the sum, i.e sum = sum + array[i]
        If sum is equal to s then print that the subarray with given sum is from 0 to i
        If there is any key in the HashMap which is equal to sum – s then print that the subarray with given sum is from hm[sum – s] to i
        Put the sum and index in the hashmap as key-value pair.
     */
    static void usingHasMap(int arr[], int n, int sum) {
        HashMap<Integer,Integer> hashMap= new HashMap<Integer, Integer>();
        int startPoint=0;
        int endPoint=0;
        int result=0;
        int total= 0;
        for(int i=0;i<n;i++){
            result = result + arr[i];
            if(result == sum){
                startPoint = 0;
                endPoint = i;
                break;
            }
            total = result-sum;
            if(hashMap.get(total)==null){
                hashMap.put(result, i);
            }else{
                startPoint = hashMap.get(total)+1;
                endPoint = i;
                break;
            }
        }
        if(endPoint<n){
            System.out.println(" Sum found between indexes "+ startPoint+ " and " + endPoint);
        }else{
            System.out.println(" No subarray found ! There is no subarray with " + sum + " sum");
        }
    }
    private static void bestApproach(int arr[], int n, int sum){
        int minEle = Integer.MAX_VALUE;  
      
        // Find minimum element in the array  
        for (int i = 0; i < n; i++)  
            minEle = Math.min(arr[i], minEle);  
      
        // Initialize curr_sum as value of  
        // first element and starting point as 0  
        int curr_sum = arr[0] + Math.abs(minEle); 
        int start = 0, i;  
      
        // Starting window length will be 1,  
        // For generating new target sum,  
        // add abs(minEle) to sum only 1 time  
        int targetSum = sum;  
      
        // Add elements one by one to curr_sum  
        // and if the curr_sum exceeds the  
        // updated sum, then remove starting element  
        for (i = 1; i <= n; i++)  
        {  
      
            // If curr_sum exceeds the sum,  
            // then remove the starting elements  
            while (curr_sum - (i - start) *  
                   Math.abs(minEle) > targetSum &&  
                                      start < i - 1) 
            {  
                curr_sum = curr_sum - arr[start] -  
                           Math.abs(minEle);  
                start++;  
            }  
      
            // If curr_sum becomes equal to sum, 
            // then return true  
            if (curr_sum - (i - start) *  
                Math.abs(minEle) == targetSum)  
            {  
                System.out.println("Sum found between indexes " + 
                                      start + " and " + (i - 1));  
                return;  
            }  
      
            // Add this element to curr_sum  
            if (i < n) 
            {  
                curr_sum = curr_sum + arr[i] +  
                             Math.abs(minEle);  
            }  
        }  
        // If we reach here, then no subarray  
        System.out.println("No subarray found"); 
    }

    public static void main(String args[]) {
        int arr[] ={10, 2, -2, -20, 10};
        int n =arr.length;
        int sum=-10;
        for(int i=0;i<n;i++)
            System.out.print(" \t " +arr[i]);
        System.out.println("\n");
        System.out.println(" -------  brute force approach ---------------");
        System.out.println();
        bruteForce(arr, n , sum);
        System.out.println();
        System.out.println(" ------- end brute force approach ---------------");
        System.out.println("\n");
        System.out.println(" -------  best approach with hasMap---------------");
        System.out.println();
        usingHasMap(arr, n , sum);
        System.out.println();
        System.out.println(" ------- end best approach  with hasMap---------------");
        System.out.println();
        bestApproach(arr, n , sum);
    }
}