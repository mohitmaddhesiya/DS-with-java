/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
        Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
        Output : 5
        The longest common substring is “Geeks” and is of length 5.

        Input : X = “abcdxyz”, y = “xyzabcd”
        Output : 4
        The longest common substring is “abcd” and is of length 4.

        Input : X = “zxabcdezy”, y = “yzabcdezx”
        Output : 6
        The longest common substring is “abcdez” and is of length 6.
 */
public class LongestCommonSubstring {
    static int memoizationMatrix[][] = new int[1000][1000];
    //A simple solution is to one by one consider all substrings of first string and for every substring check if it is a substring in second string. Keep track of the maximum length substring
    static int bruteForce(char str1[], String str2, int n, int m, int count, int ite, String subString){
        for(int i=ite;i<n;i++){
            subString = subString + str1[i];
            if(searchSubString(str2, subString)){
                if(count<subString.length()){
                    count=subString.length();
                }
            }
            bruteForce(str1,str2, n, m, count,i+1, subString);
        }
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
    static int recursive(char str1[], char str2[], int n, int m, int count) {
        if(n==0 || m==0)
            return 0;

        if(str1[n-1]==str2[m-1]){
            count = recursive(str1, str2, n-1, m-1, count)+1;
            return count;
        }else{
            return max(count,max(recursive(str1, str2, n-1, m, 0), recursive(str1, str2, n, m-1, 0)));
        }
    }
    
    private static int max(int x, int y){
        return x>y?x:y;
    }

    static int memoization(char str1[], char str2[], int n, int m, int count) {
        if(n==0 || m==0)
            return 0;
        if(memoizationMatrix[n][m]==0){
            if(str1[n-1]==str2[m-1]){
                return memoizationMatrix[n][m]=count+memoization(str1, str2, n-1, m-1, count)+1;
            }else{
                return memoizationMatrix[n][m]=max(count,max(memoization(str1, str2, n-1, m, 0), memoization(str1, str2, n, m-1, 0)));
            }
        }else{
            return memoizationMatrix[n][m];
        }
    }

    static int tabular(char str1[], char str2[], int n, int m){
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
        prinMatrix(n,m,tabularArray);
        return max;
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
    public static void main(String args[]) {
        String s="GeeksQuiz";
        String s1="GeeksforGeeks";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(s);
        System.out.println(s1);
        System.out.println("\n -------  recursive approach ---------------");
        System.out.println("Result of recursion" + recursive(str1, str2, n, m, 0));
        System.out.println(" ------- end recursive approach ---------------");
        System.out.println("\n");
        System.out.println("\n -------  memoization approach ---------------");
        System.out.println("result of memoization" +  memoization(str1, str2, n, m, 0));
        prinMatrix(n,m,memoizationMatrix);
        System.out.println(" ------- end memoization approach ---------------");
        System.out.println("\n -------  tabular approach ---------------");
        System.out.println(tabular(str1, str2, n, m));
        System.out.println(" ------- end tabular approach ---------------");
        System.out.println("\n -------  Brute Force approach ---------------");
        System.out.println( " find result from brute force result " +bruteForce(str1, s1, n, m, 0, 0, ""));
        System.out.println(" ------- end Brute Force approach ---------------");
    }
    
}