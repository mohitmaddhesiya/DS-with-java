/**
 * Given a string as an input. We need to write a program 
 * that will print all non-empty substrings of that given string.
 * Input :  abcd
   Output : a 
            b
            c
            d
            ab
            bc
            cd
            abc
            bcd
            abcd

 */
import java.util.*;
public class SubStringPrint {
    
    static Set<String> bruteForce(String str){
        Set<String> subString = new HashSet<>();
        int n=str.length();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=i;j<n;j++){
                s=s+str.charAt(j);
                subString.add(s);
            }
        }
        return subString;
    }

    static void bitwiseDisplay(String str){
        int n=str.length();
        int i=1;
        int j=i;
        int count=0;
        int pos=0;
        String s="";
        int bitCount = -1;
        while(i<Math.pow(2,n)){
            j=i;
            pos=0;
            s="";
            bitCount=-1;
            while(j>0){
                count = j & 1;
                if(bitCount>=0 && count ==0){
                    bitCount=-1;
                    break;
                }
                if(count ==1){
                  s=s+str.charAt(pos);
                  bitCount++;
                }   
                pos++;
                j=j>>1;
            }
            if(bitCount !=-1){
                System.out.println(s);
            }
            i++;
        }
    }
    public static void main(String args[]) {
        String s="abcd";
        System.out.println("\n -------  brute force approach ---------------");
        Set<String> subString=bruteForce(s);
        for (String str : subString)
                System.out.println(str);
        System.out.println(" ------- end  brute forceapproach ---------------");
        System.out.println("\n -------  Bitwise display force approach ---------------");
        bitwiseDisplay(s);
        System.out.println("\n -------  End Bitwise display approach ---------------");

    }
}