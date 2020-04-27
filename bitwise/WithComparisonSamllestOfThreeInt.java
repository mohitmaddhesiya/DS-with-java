
public class WithComparisonSamllestOfThreeInt {
   /**
    * Take a counter variable k and initialize it with 0. In a loop, 
    * repeatedly subtract a, b and c by 1 and increment k. 
    * The number which becomes 0 first is the smallest. After the loop terminates, 
      k will hold the minimum of 3.
    * @param a
    * @param b
    * @param c
    * @return
    */
     static int method1(int a, int b, int c){
         int k=0;
         while((a!=0) && (b!=0) && (c!=0)){
           k++;
           a--;
           b--;
           c--;
         }
         return k;
     }
     static void method2(int a, int b, int c){
        System.out.println(" a " + a + " b " + b +" c " + c);
         System.out.println(" a/b " + a/b);
         System.out.println(" a%b of mod " + a%b);
         System.out.println(" b/c " + b/c);
         System.out.println(" b%c of mod " + b%c);
         System.out.println(" c/a " + c/a);
         System.out.println(" c%a of mod " + c%a);
     }
    public static void main(String args[]){
         int a=5;
         int b=6;
         int c=2;
         System.out.println(" Frist Approach " + method1(a,b,c));
         method2(a,b,c);
    }
}