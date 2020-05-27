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
        ch[0]= 'w';
        ch[1]= 'x';
        ch[2]= 'y';
        ch[3]= 'z';
        int n= ch.length;
        backtraking(ch,n,"",0, new Character[4], 0);
    }
}