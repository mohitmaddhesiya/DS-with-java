/**
 * Given two variables, x and y, swap two variables without using a third
 * variable.
 */

public class SwapWithoutTemp {
    // Method 1 (Using Arithmetic Operators)
    // Both Arithmetic solutions may cause arithmetic overflow. If x and y are too large, addition and multiplication may go out of integer range.
    static void MathOpertor(int a, int b) {
        System.out.println("  ===== Math  Plus Opertor ====== ");
        System.out.println(" Before value of a = " + a + " and b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(" After value of a = " + a + " and b = " + b);
        System.out.println();
    }

    // Method 2 (Using Bitwise XOR)
    //When we use pointers to variable and make a function swap, all of the above methods fail when both pointers point to the same variable. Let’s take a look what will happen in this case if both are pointing to the same variable.
    static void XOROpertor(int a, int b) {
        System.out.println("  ===== XOR Opertor ====== ");
        System.out.println(" Before value of a = " + a + " and b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(" After value of a = " + a + " and b = " + b);
        System.out.println();
    }

    // Method 3 (Using Arithmetic divide Operators)
    // bu it will not work if any number get zero
    static void MathDivideOpertor(int a, int b) {
        System.out.println("  ===== Math  divide Opertor ====== ");
        System.out.println(" Before value of a = " + a + " and b = " + b);
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println(" After value of a = " + a + " and b = " + b);
        System.out.println();
    }

    public static void main(String args[]) {
        int a = 10;
        int b = 20;
        MathOpertor(a, b);
        XOROpertor(a, b);
        MathDivideOpertor(a, b);
    }
}