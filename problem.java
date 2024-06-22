    public class problem {
   public static int[] arrngelastele(int []A){
        int n = A.length;
        int last = A[n-1];
        int j =0;
        for(int i =0;i<n-1;i++){
            if(A[i]<last){
                int temp = A[i];
                A[i]=A[j];
                A[j]=temp;
            }

        }
        j++;
        return A;
        

    }

    public static void main(String[] args) {
        int A[]={9,8,1,6,5,11,4,7};
        int C [] = arrngelastele(A);
        for(int i = 0;i<C.length;i++){
        System.out.print(C[i]+ " ");}
    }
}
