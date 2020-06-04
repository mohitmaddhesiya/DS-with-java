/**
 * arr[] = {1, 5, 11, 5} Output: true The array can be partitioned as {1, 5, 5}
 * and {11}
 * 
 * arr[] = {1, 5, 3} Output: false The array cannot be partitioned into equal
 * sum sets.
 */
public class EqualSumPartition {
    /**
     * we are checking if sum of arry is even or odd 1) if odd then solution is not
     * possible reason (25/2 = 12.5 and number is given in int formt in array) 2) if
     * number id even then divide by 2 and apply logic of subset sum problem e.g 24
     * is result then divide by 2 is 12, then sum=12 and search in array is subset
     * is available sum in array for 12 or not. it is similer to subset problem
     * 
     * @param arr as list of int number
     * @return
     */
    static boolean recursiveApproach(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
        if (sum % 2 == 0) {
            return recursive(arr, n - 1, sum / 2);
        } else {
            return false;
        }
    }

    static boolean recursive(int arr[], int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum >= arr[n]) {
            boolean item1 = recursive(arr, n - 1, sum);
            boolean item2 = recursive(arr, n - 1, sum - arr[n]);
            return item1 || item2;
        } else {
            return recursive(arr, n - 1, sum);
        }
    }

    static void printEqualArrayWithRecursive(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
        if (sum % 2 == 0) {
            boolean result = recursivePrint(arr, n - 1, sum / 2, new int[1000], 0, n);
            System.out.println();
            if (!result) {
                System.out.println(" No equal partition is possible !");
            }
            // return recursive(arr, n - 1, sum / 2);
        } else {
            System.out.println(" No equal partition is possible !");
        }
    }

    static boolean recursivePrint(int arr[], int n, int sum, int dis[], int pos, int arrLen) {
        if (sum == 0) {
            System.out.println("\t---------first partition ------");
            System.out.print("\t");
            for (int i = 0; i < pos; i++)
                System.out.print(" " + dis[i]);
            System.out.println();
            System.out.println("\t---------second partition ------");
            System.out.print("\t");
            for (int i = 0; i < arrLen; i++) {
                int j = 0;
                for (j = 0; j < pos; j++) {
                    if (arr[i] == dis[j]) {
                        break;
                    }
                }
                if (j >= pos) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println();
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum >= arr[n]) {
            boolean item1 = recursivePrint(arr, n - 1, sum, dis, pos, arrLen);
            dis[pos] = arr[n];
            pos++;
            boolean item2 = recursivePrint(arr, n - 1, sum - arr[n], dis, pos, arrLen);
            return item1 || item2;
        } else {
            return recursive(arr, n - 1, sum);
        }
    }
    /**
     * This is different approach from above
     * here we are trying all possiable solution for parttion array
     * 
     * @param arr
     * @param first_sum
     * @param second_sum
     * @param n
     * @param dis
     * @param pos
     * @param arrLen
     */
    static void partionArray(int arr[], int first_sum, int second_sum,int n, int dis[], int pos, int arrLen){
        if(n==0){
            if(first_sum == second_sum){
                System.out.println(" ");
                for (int i = 0; i < pos; i++)
                    System.out.print(" " + dis[i]);
                System.out.println(" ");
            }
            return;
        }
        
        partionArray(arr, arr[n-1]+first_sum, second_sum, n-1, dis, pos, arrLen);
        if(first_sum!=second_sum){
            dis[pos] = arr[n-1];
            pos++;
            partionArray(arr, first_sum, arr[n-1]+second_sum, n-1, dis, pos, arrLen);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,4,6,2,3,1};
        int n=arr.length;
        for(int i=0;i<n;i++)
        System.out.print(" \t " +arr[i]);
        System.out.println("");
        System.out.println("---------  recursive approach , same as subset sum problem ----------------");
        System.out.println(" find sub array in boolean format =  " + recursiveApproach(arr));
        System.out.println("----------  End recursive approach , same as subset sum problem ----------------");

        System.out.println("");
        System.out.println("---------  recursive approach , print all soultion insert into an array ----------------");
        printEqualArrayWithRecursive(arr);
        System.out.println("---------  End recursive approach , print all soultion insert into an array ----------------");
        System.out.println("");
        System.out.println("---------  recursive approach , With same divide by two array ----------------");
        partionArray(arr, 0, 0, n, new int[1000], 0, n);
        System.out.println("---------  End recursive approach , With same divide by two array ----------------");
        System.out.println("");
    }
}