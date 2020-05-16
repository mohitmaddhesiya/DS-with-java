
public class EqualSumPartition {
    
    static boolean recursiveApproach(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum=sum+arr[i];
        if(sum%2==0){
            return recursive(arr, n-1, sum/2);
        }else{
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
        if(sum<=arr[n]){
            boolean item1=recursive(arr, n-1, sum-arr[n]);
            boolean item2=recursive(arr, n-1, sum-arr[n]);
            return item1 || item2;
        }
           
        return false;
    }
    public static void main(String[] args) {
        int arr[]={5,5,11,1};
        System.out.println(" result " + recursiveApproach(arr));
    }
}