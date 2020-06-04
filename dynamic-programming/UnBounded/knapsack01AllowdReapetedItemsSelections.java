/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wte,
 * we need to calculate minimum amount that could make up this quantity exactly. 
 * This is different from classical Knapsack problem, 
 * here we are allowed to use unlimited number of instances of an item.
 * Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
    Output : 100
    There are many ways to fill knapsack.
    1) 2 instances of 50 unit weight item.
    2) 100 instances of 1 unit weight item.
    3) 1 instance of 50 unit weight item and 50
    instances of 1 unit weight items.
    We get maximum value with option 2.

    Input : W = 8
        val[] = {10, 40, 50, 70}
        wt[]  = {1, 3, 4, 5}       
    Output : 110 
    We get maximum value with one unit of
    weight 5 and one unit of weight 3.
 */
public class knapsack01AllowdReapetedItemsSelections {
    /**
     *
     * @param weigth
     * @param prise
     * @param w
     * @param n
     * @return
     */
    static int recursive(int weigth[],int prise[], int w, int n){
        if(n<0 || w<  0)
        return 0;

        if(weigth[n]<=w){
            int item1 = recursive(weigth,prise,w,n-1);
            int item2 =  prise[n] + recursive(weigth,prise,(w-weigth[n]),n);
            return max(item1, item2);
        }else{
            return recursive(weigth,prise,w,n-1);
        }
    
    }
    static int  max(int x, int y){
        return x>y?x:y;
    }
    public static void main(String[] args) {
        int val[] = new int[]{10, 40, 50, 70}; 
        int wt[] = new int[]{1, 3, 4, 5}; 
        int w=8;
        int n = val.length; 
        System.out.println(" recursive approach  " + recursive(wt, val, w, n-1));
    }
}