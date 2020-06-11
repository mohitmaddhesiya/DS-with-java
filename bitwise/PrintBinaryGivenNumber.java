
/**
 * Given a positive integer number n generate all the binary number from 0 to n.
 *  Input :  5
    Output : 0  1  10  11  100  101    
    Binary numbers are 0(0), 1(1), 2(10), 3(11), 4(100) and 5(101).

    Input : 10
    Output : 0 1  10  11  100   101  110  111  1000  1001  1010

 */
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryGivenNumber {
    
    static void bruteForce(int n){
        int i=0;
        int j=0;
        String s="";
        while(i<=n){
            j=i;
            s="";
            while(j>0){
                s =  (j & 1)+s;
                j=j>>1;
            }
            System.out.println(s);
            i++;
        }
    }
    // ioptimise way to print 
    static void optimiseWay(int n){
        Queue<String> q= new LinkedList<String>();
        q.add("1");
        while(n>0){ 
            String str=q.poll();
            System.out.println(str);
            q.add(str+"0");
            q.add(str+"1");
            n--;
        }
    }

    public static void main(String[] args) {
        int n= 10;
        System.out.println("\n -------  brute  approach ---------------");
        bruteForce(n);
        System.out.println("\n -------  End brute approach ---------------");
        System.out.println("\n -------  Optimise way  approach ---------------");
        optimiseWay(n);
        System.out.println("\n -------  End Optimise way approach ---------------");
    }
}