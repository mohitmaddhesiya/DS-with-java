/**
 * Given two strings str1 and str2, 
 * find the shortest string that has both str1 and str2 as subsequences.
 * If you want only length then go ShortestCommonSupersequence.java in this folder
 * 
 *  Input:   str1 = "geek",  str2 = "eke"
    Output:  "geeke"

    Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
    Output:  "AGXGTXAYB"

 * Best Approach Find Longest common sequence from two string and insert only on time 
 * e.g Input:   str1 = "geek",  str2 = "eke"
 *    LCS: ek (ek insert only on time ) 
 *        first insert geeke
 *   output: geeke
 * 
 * 
 * 1) Find Longest Common Subsequence (lcs) of two given strings. For example, 
      lcs of “geek” and “eke” is “ek”.

   2) Insert non-lcs characters (in their original order in strings) to the lcs found above, 
       and return the result. So “ek” becomes “geeke” which is shortest common supersequence.

    Let us consider another example, str1 = “AGGTAB” and str2 = “GXTXAYB”. 
    LCS of str1 and str2 is “GTAB”. Once we find LCS, 
    we insert characters of both strings in order and we get “AGXGTXAYB”
                 
 */
import java.util.*; 
public class PrintSCS {
    static String memoizationMatrix[][] = new String[1000][1000];

    /**
     * using Longest common subsequence
     */
    static String PrintLCS(char str1[], char str2[], int n, int m){
        String result="";
        PrintLCS lcs=new PrintLCS();
        String lcsLen = lcs.recursive(str1, str2,n,m, "");
        StringBuffer stringMemoBuffer=new StringBuffer(lcsLen);
        lcsLen = stringMemoBuffer.reverse().toString();
        int i=0;
        int j=0;
        int k=0;
        while(i<n&& j<m){
            if(k==lcsLen.length()){
                break;
            }
            if(str1[i]==lcsLen.charAt(k) && str2[j]==lcsLen.charAt(k)){
                result = result + str1[i];
                i++;
                j++;
                k++;
            }else{
                if(str1[i]==lcsLen.charAt(k)){
                    result = result + str2[j];
                    j++;
                }else{
                    result = result + str1[i];
                    i++;
                }
            }
        }
         // If Y reaches its end, put remaining characters  
        // of X in the result string  
        while (i < n)  
        { 
            result = result + str1[i - 1];
            i++; 
        } 
  
        // If X reaches its end, put remaining characters  
        // of Y in the result string  
        while (j<m) 
        { 
            result =  result + str2[j - 1];
            j++; 
        } 
        return result;
    }

    public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
    }  

    private static int min(int x, int y){
        return x>y?y:x;
    }
    
    static String superSeq(char str1[], char str2[],  int n, int m) { 
        if (n == 0){
            String temp="";
            for(int i=0;i<m;i++){
                temp=str2[i]+temp;
            }
            return temp;
        } 
        if (m == 0){
            String temp="";
            for(int i=0;i<n;i++){
                temp=str1[i]+temp;
            }
            return temp;
        } 

        if (str1[n - 1] == str2[m - 1]) 
            return str1[n-1]+superSeq(str1, str2, n - 1, m - 1); 
        else{
            String len1 = superSeq(str1, str2, n - 1, m);
            String len2 = superSeq(str1, str2, n, m - 1);
            if(len1.length()>len2.length()){
                return str2[m-1] + len2 ;
            }else{
                return str1[n-1] + len1;
            }
           // return result;
        }
    } 

    static String memoization(char str1[], char str2[],  int n, int m) { 
        if (n == 0){
            String temp="";
            for(int i=0;i<m;i++){
                temp=str2[i]+temp;
            }
            return temp;
        } 
        if (m == 0){
            String temp="";
            for(int i=0;i<n;i++){
                temp=str1[i]+temp;
            }
            return temp;
        } 
        if(memoizationMatrix[n][m]==null){
            if (str1[n - 1] == str2[m - 1]) 
                return  memoizationMatrix[n][m]=str1[n-1]+memoization(str1, str2, n - 1, m - 1); 
            else{
                String len1 = memoization(str1, str2, n - 1, m);
                String len2 = memoization(str1, str2, n, m - 1);
                if(len1.length()>len2.length()){
                    memoizationMatrix[n][m] = str2[m-1]  + len2;
                }else{
                    memoizationMatrix[n][m] = str1[n-1]  + len1;
                }
                return  memoizationMatrix[n][m];
            }
        }else{
            return memoizationMatrix[n][m]; 
        }
        
    } 

    private static void prinMatrix(int n, int m, int tabularArray[][]) {
        System.out.println();
        for (int i = 0; i <=m; i++)
            System.out.print("__\t__" + i + "__");
        System.out.println("__");
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                System.out.print("|\t" + tabularArray[i][j]);
            }
            System.out.println("  ");
        }
        System.out.println();
    }
    static String tabularWithLCS(char str1[], char str2[], int n, int m){
        int tabularArray[][]= new int[n+1][m + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    tabularArray[i][j]=0;
                }else{
                    if(str1[i-1] == str2[j-1]){
                        tabularArray[i][j] = 1 + tabularArray[i-1][j-1];
                    }else{
                        tabularArray[i][j] = max(tabularArray[i-1][j-1], tabularArray[i][j-1]);
                    }
                }
            }
        }
        return printTabularWithLCS(tabularArray, n,m,str2, str1);
    }

    static String printTabularWithLCS(int tabularArray[][], int n, int m, char str2[], char str1[]) {
        int i = n;
        int j = m;
        String temp = "";
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                temp =  str2[j - 1] + temp;
                i--;
                j--;
            } else {
                if (tabularArray[i-1][j] > tabularArray[i][j - 1]) {
                    temp =  str1[i - 1] + temp;
                    i--;
                } else {
                    temp = str2[j - 1] + temp;
                    j--;
                }
            }
        }
         // If Y reaches its end, put remaining characters  
        // of X in the result string  
        while (i > 0)  
        { 
            temp = str1[i - 1] + temp;
            i--; 
        } 
  
        // If X reaches its end, put remaining characters  
        // of Y in the result string  
        while (j > 0) 
        { 
            temp =  str2[j - 1]+temp;
            j--; 
        } 
        return temp;

    }
    static String tabular(char str1[], char str2[], int n, int m){
        int tabularArray[][]= new int[n+1][m + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    tabularArray[i][j]=j;
                }else{
                    if(j==0){
                        tabularArray[i][j]=i;
                    }else{
                        if(str1[i-1] == str2[j-1]){
                            tabularArray[i][j] = 1+tabularArray[i-1][j-1];
                        }else{
                            tabularArray[i][j] = 1+min(tabularArray[i-1][j], tabularArray[i][j-1]);
                        }
                    }
                }
            }
        }
        prinMatrix(n,m,tabularArray);
        return printTabular(tabularArray, n, m, str2, str1);
    }

    static String printTabular(int tabularArray[][], int n, int m, char str2[], char str1[]) {
        int i = n;
        int j = m;
        String temp = "";
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                temp =  str2[j - 1] + temp;
                i--;
                j--;
            } else {
                if (tabularArray[i-1][j] >= tabularArray[i][j - 1]) {
                    temp =  str2[j - 1]+temp;
                    j--;
                } else {
                    temp = str1[i - 1] + temp;
                    i--;
                }
            }
        }
         // If Y reaches its end, put remaining characters  
        // of X in the result string  
        while (i > 0)  
        { 
            temp = str1[i - 1] + temp;
            i--; 
        } 
  
        // If X reaches its end, put remaining characters  
        // of Y in the result string  
        while (j > 0) 
        { 
            temp =  str2[j - 1]+temp;
            j--; 
        } 
        return temp;
    }

    private static int max(int x, int y){
        return x>y?x:y;
    }
    
    public static void main(String args[]) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[41m";
        String s="AGGTAB";
        String s1="GXTXAYB";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(" String 1 = " + ANSI_RED + s +  ANSI_RESET);
        System.out.println(" String 2 = " + ANSI_RED + s1 + ANSI_RESET);
        System.out.println("\n -------  Using longest common subsequence approach ---------------");
        System.out.println(" \t " + ANSI_RED + PrintLCS(str1, str2, n, m) + ANSI_RESET);
        System.out.println(" ------- end Using longest common subsequence approach ---------------");
        System.out.println("\n");
        System.out.println(" ------- tabular approach ---------------");
        System.out.println(" \t " + ANSI_RED + tabular(str1, str2, n, m) + ANSI_RESET);
        System.out.println(" ------- end tabular approach ---------------");
        System.out.println(" ------- Recusrsive approach ---------------");
        StringBuffer stringToBuffer=new StringBuffer(superSeq(str1, str2, n, m));
        System.out.println(" \t " + ANSI_RED + stringToBuffer.reverse() +  ANSI_RESET);
        System.out.println(" ------- end Recusrsive approach ---------------");
        System.out.println(" ------- memoization approach ---------------");
        StringBuffer stringMemoBuffer=new StringBuffer(memoization(str1, str2, n, m));
        System.out.println(" \t " + ANSI_RED + stringMemoBuffer.reverse() + ANSI_RESET);
        System.out.println(" ------- end memoization approach ---------------");
        System.out.println(" ------- tabular approach with longest common subsequence---------------");
        System.out.println(" \t " + ANSI_RED + tabularWithLCS(str1, str2, n, m) + ANSI_RESET);
        System.out.println(" ------- end tabular approach longest common subsequence---------------");
    }
 
}