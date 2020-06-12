/**
 * eaxample : If the input is "wxyz"  then the output of the string is
    output: "w wx wxy wxyz wxz wy wyz wz x xy xyz xz y yz z "
 */
/**
 * solution is backtraking
 *      
 */
public class CombinationsOfString {

    static void backtraking(String str, int n, int ite, Character temp[], int temp_var){
        if(temp.length>0){
            for(int i=0;i<temp_var;i++){
                System.out.print(temp[i]);
            }
            System.out.println();
        }
        for(int i=ite;i<n;i++){
            temp[temp_var] = str.charAt(i);
            backtraking(str, n, i+1, temp, temp_var+1);
        }
    }
    // bit wise operator
    static void bitwiseDisplay(String str){
        int n=str.length();
        int i=1;
        int j=i;
        int count=0;
        int pos=1;
        String s="";
        while(i<Math.pow(2,n)){
            j=i;
            s="";
            pos=0;
            while(j>0){
                count = j & 1;
                if(count==1)
                    s=s+str.charAt(pos);
                pos++;
                j=j>>1;
            }
            System.out.println(s);
            i++;
        }
    }
    // optimise way of bitwise time complexcity of this power of 2,length of string
    public static void main(String[] args) {
        String str="abc";
        int n= str.length();
        System.out.println("\n -------  brute Backtraking approach ---------------");
        backtraking(str,n,0, new Character[n], 0);
        System.out.println("\n -------  End Backtraking approach ---------------");
        System.out.println("\n -------  Bit wise approach ---------------");
        bitwiseDisplay(str);
        System.out.println("\n -------  End Bit wise approach ---------------");
    }
}