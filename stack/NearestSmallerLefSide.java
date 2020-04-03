// find the nearset smaller number on lefyt side an array

/**
 * e.g arr[]={1,6,4,10,2,5}
 * result : {-1, 1,1,4,1,2}
 * 
 * e.g 2 arr[]={1,3,0,2,5}
 * result: { -1,1,-10,2}
 */

public class NearestSmallerLefSide{
    
    public void leftSideSmaller(int arr[]){
        Stack st=new Stack();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
             st.pop();
            }
            if(st.isEmpty()){
                System.out.print("\t -1");
            }else{
                System.out.print("\t" + st.peek()); 
            }
            st.push(arr[i]);
       }
       System.out.println(" ");
    }
}