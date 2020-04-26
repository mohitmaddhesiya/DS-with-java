import java.util.ArrayList;

public class Fibonacci {
       static  int memoizationarray[]=new int[1000];
       static  int tabularArray[]=new int[1000];
       static void setMemoiztionDefault(){
        for(int i=0;i<memoizationarray.length;i++){
            memoizationarray[i]=-1;
        }
       }
       static void setTabularDefault(){
        for(int i=0;i<tabularArray.length;i++){
            tabularArray[i]=-1;
        }
       }
       static int recursive(int n){
           if(n==0 || n==1 || n==2){
               return 1;
           }
           return recursive(n-1) + recursive(n-2);
       }
       // DP with memoization approach
       static int memoization(int n){
        if(n==0 || n==1 || n==2){
            return 1;
        }
       // System.out.println(" vlaue n " +n + " memoizationarray[n] " +memoizationarray[n]);
        if(memoizationarray[n]==-1){
           int result=memoization(n-1) + memoization(n-2);
         //  System.out.println("result " + result);
           memoizationarray[n]=result;
           return result;
        }else{
            //System.out.print(" vlaue " + n);
            return memoizationarray[n];
        }
       } 
       // DP with tabular Approach
       static int tabular(int n){
        tabularArray[0]=1;
        tabularArray[1]=1;
        for(int i=2;i<n;i++){
            tabularArray[i]=tabularArray[i-1]+tabularArray[i-2];
        }
        return tabularArray[n-1];
       }
       public static void main(String args[]){
        int num=8;    
        System.out.println(" recursive of  Fibonacci "+ recursive(num));
        // set deault value in array
        setMemoiztionDefault();
        System.out.println(" bottom-up or memoization approach of  Fibonacci "+ memoization(num));
         // set deault value in array
        setTabularDefault();
        System.out.println(" top down or tabular approach of  Fibonacci "+ tabular(num));

       }
}