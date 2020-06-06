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

    public static void main(String args[]) {
        int arr[] ={4,2,-5,3,1,8};
        int n =arr.length;
        int sum=-1;
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
    }
}