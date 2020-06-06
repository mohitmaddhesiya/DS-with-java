/**
 * Given an unsorted array of nonnegative integers, 
 * find a continuous subarray which adds to a given number.
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
                Ouptut: Sum found between indexes 2 and 4
                Sum of elements between indices
                2 and 4 is 20 + 3 + 10 = 33

   Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
                Ouptut: Sum found between indexes 1 and 4
                Sum of elements between indices
                1 and 4 is 4 + 0 + 0 + 3 = 7

    Input: arr[] = {1, 4}, sum = 0
                Output: No subarray found
                There is no subarray with 0 sum
*/
public class SubarraySumWithoutNegative {
    // brute force Approach
    static void bruteForce(int arr[], int n, int sum) {
        int result=0;
        int posI=0;
        int posJ=0;
        for(int i=0;i<n;i++){
            posI = i;
            result = 0;
            int j=i;
            for(;j<n;j++){
                result= result + arr[j];
                //System.out.println(" result " + result);
                if(sum == result ||  sum<=result){
                    break;
                }
            }
            if(j<n && sum == result){
                posJ=j;
                break; 
            }
        }

        if(result!=sum){
            System.out.println(" No subarray found ! There is no subarray with " + sum + " sum");
        }else{
            System.out.println(" Sum found between indexes "+ posI+ " and " + posJ);
        }
    }
    // best approach with tow pointer
    static void bestApproach(int arr[], int n, int sum){
        int firstPointer=0;
        int secondPointer=0;
        int result =0 ;
        while(secondPointer<n && firstPointer<n){
            result=result + arr[secondPointer];
            if(result == sum){
                break;
            }
            while(result>sum && firstPointer<secondPointer){
                result = result-arr[firstPointer];
                firstPointer++;
            }
            if(result == sum){
                break;
            }
            secondPointer++;
        }

        if(result!=sum){
            System.out.println(" No subarray found ! There is no subarray with " + sum + " sum");
        }else{
            System.out.println(" Sum found between indexes "+ firstPointer+ " and " + secondPointer);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int n =arr.length;
        int sum=33;
        for(int i=0;i<n;i++)
            System.out.print(" \t " +arr[i]);
        System.out.println("\n");
        System.out.println(" -------  brute force approach ---------------");
        System.out.println();
        bruteForce(arr, n , sum);
        System.out.println();
        System.out.println(" ------- end brute force approach ---------------");
        System.out.println("\n");
        System.out.println(" -------  best approach with two pointer---------------");
        System.out.println();
        bestApproach(arr, n , sum);
        System.out.println();
        System.out.println(" ------- end best with two pointer---------------");
    }
}