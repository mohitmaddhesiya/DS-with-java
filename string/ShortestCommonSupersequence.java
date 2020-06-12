/**
 *  Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 *  Input:   str1 = "geek",  str2 = "eke"
    Output: "geeke"

    Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
    Output:  "AGXGTXAYB"
 */

 /**
  * Best Approach Find Longest common sequence from two string and subtract total string length
    e.g  input:  str1 = "geek",  str2 = "eke"
         Output: LCS: 2 (ek)
                 totalLength: 7 (geekeke)
                 result = 7-2 
                 result = 5 (geeke)
                 
    1) Find Longest Common Subsequence (lcs) of two given strings. 
       For example, lcs of “geek” and “eke” is “ek”.

  */
  /**
   * Another approach to caculate to calculate all string and take both if does not match and take if one match
   * 
   */
public class ShortestCommonSupersequence {
    static int memoizationMatrix[][] = new int[1000][1000];

    /**
     * using Longest common subsequence
     */
     
     static int LCSApproach(char str1[], char str2[], int n, int m){
       int length=0;
       LongestCommonSubsequence lcs=new LongestCommonSubsequence();
       int lcsLen = lcs.recursive(str1, str2,n,m);
       length = (str1.length+str2.length) - lcsLen;
       return length;
     }

    static int superSeq(char str1[], char str2[],  int n, int m) { 
        if (n == 0) return m; 
        if (m == 0) return n; 

        if (str1[n - 1] == str2[m - 1]) 
            return 1 + superSeq(str1, str2, n - 1, m - 1); 
        else{
            return 1 + min(superSeq(str1, str2, n - 1, m),superSeq(str1, str2, n, m - 1)); 
        }
    } 

    static int memoization(char str1[], char str2[], int n, int m) {
        if (n == 0) return m; 
        if (m == 0) return n; 

        if(memoizationMatrix[n][m]==0){
            if(str1[n-1]==str2[m-1]){
                return memoizationMatrix[n][m]=1+memoization(str1, str2, n-1, m-1);
            }else{
                return memoizationMatrix[n][m]=1+min(memoization(str1, str2, n-1, m), memoization(str1, str2, n, m-1));
            }
        }else{
            return memoizationMatrix[n][m];
        }
    }
    private static int min(int x, int y){
        return x>y?y:x;
    }
    static int tabular(char str1[], char str2[], int n, int m){
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
        return tabularArray[n][m];
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
        String s="geek";
        String s1="eke";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(s);
        System.out.println(s1);
        System.out.println("\n -------  Using longest common subsequence approach ---------------");
        System.out.println(LCSApproach(str1, str2, n, m));
        System.out.println(" ------- end Using longest common subsequence approach ---------------");
        System.out.println("\n");
        System.out.println("\n -------  recursive approach ---------------");
        System.out.println(superSeq(str1, str2, n, m));
        System.out.println(" ------- end recursive approach ---------------");
        System.out.println("\n -------  memoization approach ---------------");
        System.out.println(memoization(str1, str2, n, m));
        prinMatrix(n,m,memoizationMatrix);
        System.out.println(" ------- end tabular approach ---------------");
        System.out.println(tabular(str1, str2, n, m));
        System.out.println(" ------- end tabular approach ---------------");
    }
}