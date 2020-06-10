/**
 * eaxample : If the input is "wxyz"  then the output of the string is
    output: "w wx wxy wxyz wxz wy wyz wz x xy xyz xz y yz z "
 */
/**
 * solution is backtraking
 *      
 */
public class CombinationsOfString {
    static void backtraking(Character arr[], int n, String str, int ite, Character temp[], int temp_var){
        if(temp.length>0){
            for(int i=0;i<temp_var;i++){
                System.out.print(temp[i]);
            }
            System.out.println();
        }
        for(int i=ite;i<n;i++){
            str =str+arr[i];
            temp[temp_var] = arr[i];
            backtraking(arr, n , str, i+1, temp, temp_var+1);
        }
    }
    public static void main(String[] args) {
        Character[] ch=new Character[4];
        ch[0]= 'A';
        ch[1]= 'B';
        ch[2]= 'C';
        ch[3]= 'D';
        ch[3]= 'E';
        ch[3]= 'F';
        int n= ch.length;
        backtraking(ch,n,"",0, new Character[7], 0);
    }
}