import java.util.Arrays;

public class bitmanipulation {


    public static int and(int a,int b){
        return (a & b);
    }
    public static int or(int a,int b){
        return (a | b);
    }
    public static int xor(int a,int b){
        return (a ^ b);
    }
    public static int rightshift(int a,int b){
    return (a >> b);
    }
    public static int leftshift(int a,int b){
    return (a << b);
    }
    public static boolean setornot(int a,int b){
     return ((a & (1 >> b)) > 0);
    }
    public static int toggle(int a,int b){
     return ((a ^ (1 << b)) );
    }


    /*Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.*/
    public static int[] single_elements_in_array_using_xor(int A[]){
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans ^= A[i];
        }

        int right = 1;
        while ((right & ans) == 0) {
            right <<= 1;
        }
        int[] result = new int[2];

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & right) == 0) {
                result[0] ^= A[i];
            } else {
                result[1] ^= A[i];
            }
        }
    Arrays.sort(result);
        return result;
    }
    /*
     google:given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.
     */
   public static int single_in_thrice_array(int[]A){
        //  int ones=0,twos=0;
        //  for(int i=0;i<A.length;i++){
        //       ones=(ones^A[i])&(~twos);
        //       twos=(twos^A[i])&(~ones);
        //  }
        //  return ones;
        int ans=0;
        for(int i =0;i<32;i++){
            int count=0;
            for(int j=0;j<A.length;j++){
                if((A[j]&(1<<i))!=0){
                    count++;
                }
            }
            if(count%3!=0){
                ans|= (1<<i);
            }
        }
        return ans;

   }
   /* famous question: given an array of positive integers ,find the pairwith minimum xor value in given array.
   */
   //(n^2)
    public static int minxorpair_N(int[]A){
        int minxor=Integer.MAX_VALUE;
        int x = 0;
        for(int i =0;i<A.length;i++){
            for(int j = i+1;j<A.length;j++){
                x = A[i]^A[j];
                minxor = Math.min(minxor,x);
            }
        }
        return minxor;
    }
    public static int minxorpair(int[] A) {
        Arrays.sort(A);
        int minxor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            minxor = Math.min(minxor, A[i] ^ A[i + 1]);
           
        }
        return minxor;
       
    }
  /* google :given an array  of the number return the max & value of any pair i.e, return (A[i]&A[j])(i!=j) */
        public static int maxandpair(int[]A){
        int maxor=0;
        int x = 0;
        for(int i =0;i<A.length;i++){
            for(int j = 0;j<A.length;j++){
                if(i!=j)
                x = A[i]&A[j];
                maxor = Math.max(maxor,x);
            }
        }
        return maxor;
    }
    public static int maxandpair_N(int [] A){
          
        int ans = 0;
        for(int i = 31 ; i >= 0 ; i --){
            int  count = 0;
            ans<<=1;
            for(int j =0;j<A.length;j++){
                if((A[j]&(1<<i))!=0){
                    count++;
                }
            }
            
            if(count>=2){
                ans |=1;
            for(int j =0;j<A.length;j++){
                if((A[j]&(1<<i))==0){
                    A[j]=0;
                }
            }
            }
            
        }
        return ans;
    }


   /*
  google: given an array for every pair of elements in the array.return the sum of different bits between bits of every pair of elements.
   */
    // public static int sumofdifferentbits(int[]A){
    //     int ans=0;
       
    // }



    /*given an array print all subsequence of the array */
    public static void printsubsequence_N(int[]A){
    
    }
    // public static void printsubsequence(int[]A){
    //     for(int i =0;i<A.length;i++){
    //         for(int j =i;j<A.length;j++){
    //             for(int k = i;k<=j;k++){
    //                 System.out.print(A[k]+" ");
    //             }
    //             System.out.println();
    //         }
    //     }
    // }
    public static void main(String[] args) {
        // int n =5;
        // int pos =2;
        // int bitmask =1<<pos;
        // int notbitmask=~(bitmask);
        // int newnumber = notbitmask & n;
        // System.out.println(newnumber);
        // if((bitmask & n) == 0) {
        //     System.out.println("bit was zero");
        // }
        // else {
        //     System.out.println("bit was 1");
        // }   
        // int newnum = bitmask| n;
        // // System.out.println(newnum);

        //     System.out.println(and(4, 3));
        //     System.out.println(or(3, 4));
        //     System.out.println(xor(10, 13)); ));
        //     System.out.println(leftshift(10, 1
        //     System.out.println(rightshift(1,2 ));
            // System.out.println(setornot(21, 2));
            //  System.out.println(toggle(10, 1));
             int[]A={2,3,1};
            // System.out.println(single_elements_in_array_using_xor(A));
            // System.out.println(single_in_thrice_array(A));
            // printsubsequence(A);
    }
}
