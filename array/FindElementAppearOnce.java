 /**
 * Given an array where every element occurs three times, except one element
 * which occurs only once input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
 * Output: 2 In the given array all element appear three times except 2 which
 * appears once.
 * 
 * Input: arr[] = {10, 20, 10, 30, 10, 30, 30} Output: 20 In the given array all
 * element appear three times except 20 which appears once.
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class FindElementAppearOnce {
    static final int INT_SIZE = 32; 
    // brute force Approach
    // set negtive with find
    static int bruteForce(int arr[]) {
        int result = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(arr[i]) == arr[j]) {
                        arr[j] = -arr[j];
                        if (arr[i] > 0) {
                            arr[i] = -arr[i];
                        }
                    }
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result = arr[i];
                break;
            }
        }
        return result;
    }

    // using hashmap
    public static int hashmap(int arr[]) {
        int result = -1;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            if (!hmap.containsKey(arr[i])) {
                hmap.put(arr[i], 1);
            } else {
                int value = hmap.get(arr[i]);
                value++;
                hmap.put(arr[i], value);
            }
        }
        for (int i = 0; i < n; i++) {
            if (hmap.get(arr[i]) == 1) {
                result = arr[i];
                break;
            }
        }
        return result;
    }

    // sorting approch
    public static int sortingApproach(int arr[]) {
        int result = -1;
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            al.add(arr[i]);
        }
        Collections.sort(al);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (al.get(i - 1) == al.get(i)) {
                count++;
            } else {
                if (count > 0) {
                    count = 0;
                } else {
                    result = al.get(i - 1);
                    break;
                }
            }

        }
        return result;
    }
    /**
     * We can sum the bits in same positions for all the numbers and take modulo with 3. 
     * The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
        Let us consider the example array 
                        {5, 5, 5, 8}. 
                    The 101, 101, 101, 1000

        Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0;
        Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
        Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0;
        Sum of fourth bits%3 = (1)%3 = 1;
        Hence number which appears once is 1000
     * @param arr
     * @param n
     * @return
     */
    // Method to find the element that occur only once 
    static int getSingle(int arr[], int n) 
    { 
        int result = 0; 
        int x, sum; 
          
        // Iterate through every bit 
        for(int i=0; i<INT_SIZE; i++) 
        { 
            // Find sum of set bits at ith position in all  
            // array elements 
            sum = 0; 
            x = (1 << i); 
            for(int j=0; j<n; j++) 
            { 
                // arr[j] & x result will be x
                // e.g x=2 and arr[j] then 
                // arr[j] & x= 2 & 2 = 11 & 11 (bit wise caculation) = 11 (bitwise result ) = 2(convert in int)  
                if((arr[j] & x) == x) 
                    sum++; 
            } 
            // The bits with sum not multiple of 3, are the 
            // bits of element with single occurrence. 
            if ((sum % 3) != 0) 
                result |= x; 
        } 
        return result; 
    }
    public static void main(String args[]) {
        int arr[] = {10, 20, 10, 30, 10, 30, 30};
        int n =arr.length;
        int copy[]={10, 20, 10, 30, 10, 30, 30};
        for(int i=0;i<n;i++)
            System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println(" broute force approach " + bruteForce(arr));
        arr=copy;
        System.out.println(" HashMap approach " + hashmap(arr));
        System.out.println(" Sorting Approach " + sortingApproach(arr));
        System.out.println(" Best Approach using Bit Count " + getSingle(arr, n));
    }
}