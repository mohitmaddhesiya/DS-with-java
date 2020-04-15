public class CountSetBits {
      // approach 1 devide by 2
      static int bitCountBy2(int value){
          int result=0;
          while(value!=0){
             int mod=value%2;
             if(mod==1){
                result++;
             }
             value=value/2;
          }
          return result;
      }
      // with and opertor
      static int bitCountByAndOpertor(int value){
        int result=0;
        while(value!=0){
           int mod=value&1;
           if(mod==1){
            result++;
           }
           value=value>>1;
        }
        return result;
      }
      /**
       * Brian Kernighan’s Algorithm
       * Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
            for example :
            10 in binary is 00001010
            9 in binary is 00001001
            8 in binary is 00001000
            7 in binary is 00000111
So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit. If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer.
       * @param value
    */
    static int brianKernighansAlgorithm(int value){
        int result=0;
        while(value!=0){
           value=value&(value-1);
           result++;
        }
        return result;
      }
      /**
     * table lookup approach
     * we will store 0 t0 15 nibble set bit count
     * e.g- >  0 is 0 , 1 have 1 set bit, 2 have 1 set bit, 3 have 2 set bit and so on 
     * -----------------------------------------------------------
     * | 0000: 0 (1) | 0100: 1 (4) | 1000: 1 (8) | 1100: 2 (12)   |
     * -----------------------------------------------------------
     * | 0001: 1 (2) | 0101: 2 (5) | 1001: 2 (9) | 1101: 2 (13)   |
     * -----------------------------------------------------------
     * | 0011: 2 (3) | 011 : 2 (6) | 1010: 2 (10)| 1110: 3 (14)   |
     * ------------------------------------------------------------
     * | 0011: 2 (4) | 0111: 3 (7) | 1011: 3 (11)| 1111: 4 (15)   |
     * ------------------------------------------------------------
     * */
    static int lookupTable(int num){
        int result = -1;
        // we are stoering nly count
        //e.g 1 -> 0001 is 1 count ,  2 -> 0010 is 2 count, 3 -> 0110 is 2 count
        // see table value count  that is present in comment  
        int lookupTable[] = {0,1,2,2,1,2,2,3,1,2,2,3,2,2,3,4};
        // Find last nibble
        int  lastNibble= (num & 0xf);
        int  swappiedLastNibble =((num>>4) & 0xf);
        result = lookupTable[lastNibble] + lookupTable[swappiedLastNibble];;
        return result;
    }
      public static int bitCount(int i)
      {
          // HD, Figure 5-2
          i = i - ((i >>> 1) & 0x55555555);
          i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
          i = (i + (i >>> 4)) & 0x0f0f0f0f;
          i = i + (i >>> 8);
          i = i + (i >>> 16);
          return i & 0x3f;
      }
    public static void main(String args[]){
      int value = 119; 
      System.out.println(" bit count devide by two " + bitCountBy2(value));
      System.out.println(" bit count with '&' opertor " + bitCountByAndOpertor(value));
      System.out.println(" bit count with brian Kernighan's Algorithm " + brianKernighansAlgorithm(value));
      System.out.println(" Java Implemenation " + bitCount(value));
      System.out.println(" lookup Table approach  " + lookupTable(value));

    }
}