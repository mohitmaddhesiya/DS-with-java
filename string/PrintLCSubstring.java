/**
 * Only we are printing longest substring. For count We can go and Check LongestCommonSubtring.java file
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
        Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
        Output : Geeks
        The longest common substring is “Geeks”

        Input : X = “abcdxyz”, y = “xyzabcd”
        Output : abcd
        The longest common substring is “abcd”

        Input : X = “zxabcdezy”, y = “yzabcdezx”
        Output : “abcdez”
        The longest common substring is “abcdez”
 */
import java.util.*; 

public class PrintLCSubstring {
    static String memoizationMatrix[][] = new String[1000][1000];
    static  Set<String> subAllString = new HashSet<>();

    //A simple solution is to one by one consider all substrings of first string and for every substring check if it is a substring in second string. Keep track of the maximum length substring
    static String bruteForce(String str1, String str2, int n, int m){
        String count="";
        int max=0;
        Set<String> allSubString = new HashSet<>();
        SubStringPrint subStrObj= new SubStringPrint();
        Set<String> subString=   subStrObj.bruteForce(str1);
        for (String str : subString){
            if(searchSubString(str2, str)){
                if(count.length()<str.length()){
                    allSubString.clear();
                    count=str;
                }
                if(count.length()==str.length()){
                    allSubString.add(str);
                 }
            }
        }
        System.out.println( " Printing All Sub string found By brute force --  " + allSubString);
        return count;
    }

    // string matchin function
    static boolean searchSubString(String txt, String pat) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) { 
  
            int j; 
  
            /* For current index i, check for pattern  
              match */
            for (j = 0; j < M; j++) 
                if (txt.charAt(i + j) != pat.charAt(j)) 
                    break; 
  
            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
                return true; 
        } 
        return false;
    } 
    // recursive solution 
    static String recursiveOnlyPrintOne(char str1[], char str2[], int n, int m,String result) {
        if(n==0 || m==0)
        {
            subAllString.clear();
            return result;
        }

        if(str1[n-1]==str2[m-1]){
            return recursiveOnlyPrintOne(str1, str2, n-1, m-1, result+str2[m-1]);
            //return result;
        }else{
            String s1 = recursiveOnlyPrintOne(str1, str2, n-1, m, "");
            String s2 = recursiveOnlyPrintOne(str1, str2, n, m-1, "");
            int test=  max(s1.length(), s2.length());
            if(result.length()<test){
                if(s1.length()< s2.length()){
                    subAllString.add(s2);
                    return s2;
                }else{
                    subAllString.add(s1);
                    return s1;
                }
            }else{
                subAllString.add(result);
                return result; 
            }
        }
    }

    static String memoization(char str1[], char str2[], int n, int m, String result) {
        if(n==0 || m==0)
            return result;
        if(memoizationMatrix[n][m]==null){
            if(str1[n-1]==str2[m-1]){
                result = result + str2[m-1];
                // memoizationMatrix[n][m]=result;
                 return memoization(str1, str2, n-1, m-1, result);
            }else{
                String s1 = memoization(str1, str2, n-1, m, "");
                String s2 = memoization(str1, str2, n, m-1, "");
                
                int test = max(s1.length(),s2.length());
                String value=""; 
                
                if(result.length()<test){
                    if(s1.length()< s2.length()){
                        value =  s2;
                    }else{
                        value =  s1;
                    }
                }else{
                    value =result;
                }
                return memoizationMatrix[n][m]=value;
            }
        }else{
            return memoizationMatrix[n][m];
        }
    }
    static String tabular(char str1[], char str2[], int n, int m){
        String tabularArray[][]= new String[n+1][m + 1];
        String max="";
        String result="";
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    tabularArray[i][j]="";
                }else{
                    if(str1[i-1] == str2[j-1]){
                        String test = tabularArray[i-1][j-1] + str1[i-1];
                        tabularArray[i][j] = test;
                        result = test;
                        //System.out.println(" test = " + test + " result = " + result);
                    }else{
                        tabularArray[i][j]="";
                        if(max.length()<result.length()){
                            max=result;
                        }
                        result="";
                    }
                }
            }
        }
        prinMatrix(n,m,tabularArray);
        return max;
    }
    private static int max(int x, int y){
        return x>y?x:y;
    }
    static int tabularPrintAll(char str1[], char str2[], int n, int m){
        int tabularArray[][]= new int[n+1][m + 1];
        int max=-999999;
        int count =0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    tabularArray[i][j]=0;
                }else{
                    if(str1[i-1] == str2[j-1]){
                        count = 1 + tabularArray[i-1][j-1];
                        tabularArray[i][j] = count;
                    }else{
                        tabularArray[i][j]=0;
                        if(max<count){
                            max=count;
                        }
                        count=0;
                    }
                }
            }
        }
        printAll(max, tabularArray, n, m, str1);
        return max;
    }
    private static void printAll(int max, int tabularArray[][], int n, int m, char str1[]){
        int i=n;
        int j=m;
        String s="";
        while(i>0){
            if(j==0){
                i--;
                j=m;
            }
            if(j<0){
                break;
            }
            if(tabularArray[i][j]==max){
                s="";
                int tempI=i;
                while(j>0 && i>0 && tabularArray[i][j]!=0){
                    s=str1[i-1]+s;
                    i--;
                    j--;
                }
                i=tempI-1;
                j=m;
                System.out.println(s);
                s="";
            }else{
                j--;
            }
            
        }

    }
    private static void prinMatrix(int n, int m, String tabularArray[][]) {
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
    public static void main(String args[]) {
        String s="abcdef";
        String s1="abcxyzdeflnmbcd";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(s);
        System.out.println(s1);
        System.out.println("\n -------  recursive approach ---------------");
        System.out.println(" Result of recursion = " + recursiveOnlyPrintOne(str1, str2, n, m, ""));
        System.out.println(" Print all find by recusrsive  " + subAllString);
        System.out.println(" ------- end recursive approach ---------------");
        System.out.println("\n -------  memoization approach ---------------");
        System.out.println("result of memoization = " +  memoization(str1, str2, n, m, ""));
        prinMatrix(n,m,memoizationMatrix);
        System.out.println(" ------- end memoization approach ---------------");
        System.out.println("\n -------  tabular approach ---------------");
        System.out.println(" result of tabular = " + tabular(str1, str2, n, m));
        System.out.println(" ------- end tabular approach ---------------");
        System.out.println("\n -------  tabular approach Wiht print All---------------");
        System.out.println(" result of tabular print All = " + tabularPrintAll(str1, str2, n, m));
        System.out.println(" ------- end tabular approach print All---------------");
        System.out.println( " find result from brute force result  = " +bruteForce(s, s1, n, m));
        System.out.println(" ------- end Brute Force approach ---------------");

    }
    
}