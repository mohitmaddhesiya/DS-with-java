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
    public static void main(String args[]) {
        String s="abcd";
        System.out.println("\n -------  brute force approach ---------------");
        Set<String> subString=bruteForce(s);
        for (String str : subString)
                System.out.println(str);
        System.out.println(" ------- end  brute forceapproach ---------------");
    }
}