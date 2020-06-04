/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. 
 * By convention, 1 is included.
 * Given a number n, the task is to find n’th Ugly number.
 * Examples:

    Input  : n = 7
    Output : 8

    Input  : n = 10
    Output : 12

    Input  : n = 15
    Output : 24

    Input  : n = 150    
    Output : 5832
 */
import java.util.ArrayList;
class UglyNumber {
    static int recursive(int n, int count, int p) {
        if (isUgly(p)) {
            if (n == count) {
                return p;
            } else {
                return recursive(n, count + 1, p + 1);
            }
        } else {
            return recursive(n, count, p + 1);
        }
    }
    static int itrative(int n){
        int count=1;
        int prime=2;
        while(n>count){
           if(isUgly(prime)){
             count++;
           }
           if(count==n)
           break;
           prime++;
        }
        return prime;
    }
    static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }

    /* Function to check if a number is ugly or not */
    static boolean isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
        return (no == 1) ? true : false;
    }
    /**
     * Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) 
     multiply 2, 3, 5. Then we use similar merge method as merge sort, to get every ugly number from the three subsequence. 
     Every step we choose the smallest one, and move one step after.
     * 
     */

    static int dp(int n){
     ArrayList<Integer> al=new ArrayList<Integer>();
     al.add(1);
     int count=1;
     int a=2;
     int b=3;
     int c=5;
     int i2=2;
     int i3=3;
     int i5=5;
     int j2=0;
     int j3=0;
     int j5=0;
     while(count<n){
         int min=findMin(i2,i3,i5);
         al.add(min);
         if(i2==min){
             j2++;
             i2=a*al.get(j2);
         }
         if(i3==min){
             j3++;
             i3=b*al.get(j3);

         }
         if(i5==min){
           j5++;
           i5=c*al.get(j5);
         }
         count++;
     }
     return al.get(al.size()-1);
    }
   static  int findMin(int a, int b, int c){
      if(a<b){
          if(a<c){
              return a;
          }else{
              return c;
          }
      }else{
          if(b<c){
              return b;
          }else{
              return c;
          }
      }
    }
    public static void main(String arg[]) {
        int num=150;
       // System.out.println(" recursive result " + recursive(num, 2, 2));
        System.out.println(" itrative result " + itrative(num));
        System.out.println(" DP Result  " + dp(num));
    }
}