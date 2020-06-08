/**
 * LCS Problem Statement: Given two sequences, 
 * find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order,
 *  but not necessarily contiguous.
 *  For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * 
 * In order to find out the complexity of brute force approach, 
 * we need to first know the number of possible different subsequences of a string with length n, i.e., 
 * find the number of subsequences with lengths ranging from 1,2,..n-1. 
 * Recall from theory of permutation and combination that number of combinations with 1 element are nC1. 
 * Number of combinations with 2 elements are nC2 and so forth and so on. 
 * We know that nC0 + nC1 + nC2 + … nCn = 2n. 
 * So a string of length n has 2n-1 different possible subsequences since we do not consider the subsequence with length 0. 
 * This implies that the time complexity of the brute force approach will be O(n * 2n).
 *  Note that it takes O(n) time to check if a subsequence is common to both the strings. 
 * This time complexity can be improved using dynamic programming.
 * It is a classic computer science problem, 
 * the basis of diff (a file comparison program that outputs the differences between two files), 
 * and has applications in bioinformatics.
 * 
 * Examples:
        LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
        LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {
    static int memoizationMatrix[][] = new int[1000][1000];

    // 
    static int recursive(char str1[], char str2[], int n, int m) {
        if(n==0 || m==0)
            return 0;

        if(str1[n-1]==str2[m-1]){
            return 1+recursive(str1, str2, n-1, m-1);
        }else{
            return max(recursive(str1, str2, n-1, m), recursive(str1, str2, n, m-1));
        }
    }
    private static int max(int x, int y){
        return x>y?x:y;
    }
    static int memoization(char str1[], char str2[], int n, int m) {
        if(n==0 || m==0)
            return 0;
        if(memoizationMatrix[n][m]==0){
            if(str1[n-1]==str2[m-1]){
                return memoizationMatrix[n][m]=1+memoization(str1, str2, n-1, m-1);
            }else{
                return memoizationMatrix[n][m]=max(memoization(str1, str2, n-1, m), memoization(str1, str2, n, m-1));
            }
        }else{
            return memoizationMatrix[n][m];
        }
    }

    static int tabular(char str1[], char str2[], int n, int m){
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
        String s="AGGTAB";
        String s1="GXTXAYB";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(s);
        System.out.println(s1);
        System.out.println("\n -------  recursive approach ---------------");
        System.out.println(recursive(str1, str2, n, m));
        System.out.println(" ------- end recursive approach ---------------");
        System.out.println("\n");
        System.out.println("\n -------  memoization approach ---------------");
        System.out.println(memoization(str1, str2, n, m));
        prinMatrix(n,m,memoizationMatrix);
        System.out.println(" ------- end memoization approach ---------------");
        System.out.println("\n -------  tabular approach ---------------");
        System.out.println(tabular(str1, str2, n, m));
        System.out.println(" ------- end tabular approach ---------------");
    }
}