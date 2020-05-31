/**
 * problem: Given two strings str1 and str2, write a function that prints all interleavings of the given two strings. 
 *          You may assume that all characters in both strings are different. But postion of string should not change
 *           in below string st1 awalys B should comes after A and str2 D should comes after C
 * Example: Input: str1 = "AB",  str2 = "CD"
            Output:
                ABCD
                ACBD
                ACDB
                CABD
                CADB
                CDAB

            Input: str1 = "AB",  str2 = "C"
            Output:
                ABC
                ACB
                CAB
 */
class InterLeavingChar{
   static  void recursive(String char1, String char2, int n, int m, char s[], int i){
        if(char1.length()==0 && char2.length()==0){
            for(int j=0;j<i;j++)
                System.out.print(s[j]);
             System.out.println();
        }
        if(n!=0){
             s[i] = char1.charAt(0);;
            recursive(removeCharAt(char1,0), char2, n-1,m,s, i+1);
        }
        if(m!=0){
            s[i] = char2.charAt(0);
            recursive(char1, removeCharAt(char2,0), n,m-1 ,s, i+1);
        }
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
     }
    public static void main(String[] args) {
    String s1="AB";
    String s2="CD";
    int n=s1.length();
    int m=s2.length();
        recursive(s1, s2, n, m, new char[5], 0);
    }
}