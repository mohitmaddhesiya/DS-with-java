/**
 * Bubble Sort is the simplest sorting algorithm 
 * that works by repeatedly swapping the adjacent elements if they are in wrong order.
    Example:
        First Pass:
        ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
        ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
        ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
        ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

        Second Pass:
        ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
        ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
        Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

        Third Pass:
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        */
public class BubbleSort {
    public static int[] bubbleSortIt(int n, int arr[]){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }   
            }
        } 
        return arr;
    }
    public static int[] bubbleSortRec(int n, int arr[]){
        if(n<=0){
            return arr;
        }
        for(int j=0;j<n-1;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }   
        }
       return bubbleSortRec(n-1, arr);
       //return arr;
    }
    public static void main(String args[]){
        int arr[]={3,5,1,2,9,7,8,5};
        int n=arr.length;
        for(int i=0;i<n;i++)
            System.out.print(" \t " +arr[i]);
        System.out.println("");
        int recResult[] = bubbleSortRec(n, arr);
        System.out.println(" ------ Recursive result --------------");
        for(int i=0;i<recResult.length;i++)
            System.out.print(" \t " + recResult[i]);
        System.out.println("\n ------ End Recursive result --------------");
        System.out.println("");
        int itrativeResult[] = bubbleSortIt(n, arr);
        System.out.println(" ------ Itrative result --------------");
        for(int i=0;i<itrativeResult.length;i++)
            System.out.print(" \t " + itrativeResult[i]);
        System.out.println("\n ------ End Itrative result --------------");
    }
}