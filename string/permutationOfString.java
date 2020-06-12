/**
 * A permutation, also called an “arrangement number” or “order”, 
 * is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. 
 * A string of length n has n! permutation
 * Input: ABC
 * OutPut: ABC ACB BAC BCA CBA CAB
 */
public class permutationOfString {
    
    static void backtraking(String str,int n, int ite){
        if (ite == n) 
        System.out.println(str); 
        else
        { 
            for (int i = ite; i <= n; i++) 
            { 
                str = swap(str,ite,i); 
                backtraking(str,n,ite+1); 
                str = swap(str,ite,i); 
            } 
        } 
       
    }
    static public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    public static void main(String[] args) {
        String str="abc";
        int n= str.length();
        System.out.println("\n -------  brute Backtraking approach ---------------" + n);
        backtraking(str,n-1,0);
        System.out.println("\n -------  End Backtraking approach ---------------");
    }
    
}