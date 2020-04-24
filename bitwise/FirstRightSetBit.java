
public class FirstRightSetBit {
         public static int bruteForce(int num){
            int result=-1;
            int count=0;
            while(num!=0){
              int mod=num%2;
              count++;
              if(mod==1){
                  result=count;
                  break;
              }
              num=num/2;
            }
            return result;
         }
         public static int countByAndOpertor(int num){
             int result =-1;
             int count=0;
             while(num!=0){
                int mod=num&1;
                count++;
                if(mod==1){
                    result=count;
                    break;
                }
                num=num>>1;
             }
             return result;
         }
         /**
         * table lookup approach
         * we will store 0 t0 15 nibble first right set bit count
         * e.g- >  0 is 0 , 1 have 1 set bit, 2 have 1 set bit, 3 have 2 set bit and so on 
         * -----------------------------------------------------------
         * | 0000: 0 (0) | 0100: 3 (4) | 1000: 4 (8) | 1100: 3 (12)   |
         * -----------------------------------------------------------
         * | 0001: 1 (1) | 0101: 1 (5) | 1001: 1 (9) | 1101: 1 (13)   |
         * -----------------------------------------------------------
         * | 0011: 1 (2) | 011 : 1 (6) | 1010: 2 (10)| 1110: 2 (14)   |
         * ------------------------------------------------------------
         * | 0011: 1 (3) | 0111: 1 (7) | 1011: 1 (11)| 1111: 1 (15)   |
         * ------------------------------------------------------------
         * */
         static int lookupTable(int num){
            int result = -1;
            // we are storing only first right set  bit postion in arry
            //e.g 1 -> 0001 is 1  first right bit ,  2 -> 0010 is 2  first right bit, 3 -> 0110 is 1  first right bit
            // see table value count  that is present in comment  
            int lookupTable[] = {0,1,1,1,3,1,1,1,4,1,2,1,3,1,2,1};
            // Find last nibble
            int  lastNibble= (num & 0xf);
            result=lookupTable[lastNibble];
            if(result!=0){
                   return result;
            }else{
                int  swappiedLastNibble =((num>>4) & 0xf);
                result=lookupTable[swappiedLastNibble];
                return result+4;
            }
        }
         public static void main(String[] args) {
             int num=128;
             System.out.println(" brute force algorithm " + bruteForce(num));
             System.out.println(" and opertor " + countByAndOpertor(num));
             System.out.println(" lock table approach " + lookupTable(num));
         }
}