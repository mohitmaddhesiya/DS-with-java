/**
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. 
 * The task is to remove/delete and insert minimum number of characters from/in str1 
 * so as to transform it into str2. 
 * It could be possible that the same character needs to be removed/deleted from one point of str1 
 * and inserted to some another point.
 * 
 *  Input : str1 = "heap", str2 = "pea" 
    Output : Minimum Deletion = 2 and
            Minimum Insertion = 1

    p and h deleted from heap
    Then, p is inserted at the beginning
    One thing to note, though p was required yet
    it was removed/deleted first from its position and
    then it is inserted to some other position.
    Thus, p contributes one to the deletion_count
    and one to the insertion_count.

    Input : str1 = "geeksforgeeks", str2 = "geeks"
    Output : Minimum Deletion = 8
            Minimum Insertion = 0
 */
/**
 * Best Solution Is use to logest common sequence
 * Get LCS from two string and substract from first string tht will deleltion and subtract from second string that will be insertion
 * e.g Input : str1 = "heap", str2 = "pea" 
 *     LCS : ea (2)
 *     Deletion : str1-LCS = 4 (heap) - 2 (ea) = 2
 *     Insertion:  str1-LCS = 3 (pea) - 2 (ea) = 1
 */
public class MinNoinsertAndDelOneStringIntoAnother {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[41m";
    
    /**
     * using Longest common subsequence
     
     */
    static void LCSApproach(char str1[], char str2[], int n, int m){
        LongestCommonSubsequence lcs=new LongestCommonSubsequence();
        int lcsLen = lcs.recursive(str1, str2,n,m);
        System.out.println("\n -------  Using longest common subsequence approach ---------------");
        System.out.println("\t Minimum number of deletions = " + ANSI_RED + (n-lcsLen) + ANSI_RESET);       
        System.out.println("\t Minimum number of insertions = " + ANSI_RED + (m-lcsLen) +  ANSI_RESET); 
        System.out.println(" ------- end Using longest common subsequence approach ---------------");

    }

    /**
     * using Longest common subsequence
     */
    static void LCSApproachPrint(char str1[], char str2[], int n, int m){
        PrintLCS lcs=new PrintLCS();
        String lcsString = lcs.recursive(str1, str2,n,m, "");
        StringBuffer stringMemoBuffer=new StringBuffer(lcsString);
        lcsString = stringMemoBuffer.reverse().toString();
        String deletion="";
        String insertion="";
        int k=0;
        for(int i=0;i<n;i++){
            if(k<lcsString.length() && str1[i]!=lcsString.charAt(k)){
                deletion = deletion + str1[i];
            }else{
                if(k>=lcsString.length()){
                    deletion = deletion + str1[i];
                }
                k++;
            }
        }
        k=0;
        for(int i=0;i<m;i++){
            if(k>=lcsString.length()){
                break;
            }
            if(k<lcsString.length() && str2[i]!=lcsString.charAt(k)){
                insertion = insertion + str2[i];
            }else{
                if(k>=lcsString.length()){
                    insertion = insertion + str2[i];
                }
                k++;
            }
        }
        System.out.println("\n -------  Using longest common subsequence approach to print ---------------");
        System.out.println("\t Minimum number of deletions = " + ANSI_RED + (deletion) + ANSI_RESET);       
        System.out.println("\t Minimum number of insertions = " + ANSI_RED + (insertion) +  ANSI_RESET); 
        System.out.println(" ------- end Using longest common subsequence approach to print ---------------");

    }

    public static void main(String args[]) {
        String s="heap";
        String s1="pea";
        char str1[] = s.toCharArray();;
        char str2[] = s1.toCharArray();
        int n =str1.length;
        int m =str2.length;
        System.out.println(" String 1 = " + ANSI_RED + s +  ANSI_RESET);
        System.out.println(" String 2 = " + ANSI_RED + s1 + ANSI_RESET);
        LCSApproach(str1, str2, n, m);
        System.out.println("\n");
        LCSApproachPrint(str1, str2, n, m);
    }
}