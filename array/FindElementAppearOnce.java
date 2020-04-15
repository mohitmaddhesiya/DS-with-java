 /**
 * Given an array where every element occurs three times, except one element
 * which occurs only once input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
 * Output: 2 In the given array all element appear three times except 2 which
 * appears once.
 * 
 * Input: arr[] = {10, 20, 10, 30, 10, 30, 30} Output: 20 In the given array all
 * element appear three times except 20 which appears once.
 */
package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class FindElementAppearOnce {
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
        System.out.println(" al " + al);
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
    

    public static void main(String args[]) {
        int arr[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3, 2, 2, 10 };
        // System.out.println(" broute force approach " + bruteForce(arr));
        // System.out.println(" HashMap approach " + hashmap(arr));
        System.out.println(" Sorting Approach " + sortingApproach(arr));
    }
}