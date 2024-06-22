public class Twopointers {
    // given a sorted array, find a pair of numbers that sum to a target

    public static boolean  twosum(int[] A,int k){
        int i = 0;
        int j = A.length - 1;
    
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
}

// given a sorted array, find a pair of numbers that differnce to a target usin two pointers (k>=0) check if there exists a pair of numbers in the array that differ by k A[i] - A[j] = k i!=j

  public static boolean twodifference(int[] A,int k){
    int i = 0;
    int j = i+1;
    while(i < A.length && j < A.length){
        if( A[j] - A[i] == k){
            return true;
        }else if(A[j] - A[i] < k){
            j++;
        }else{
            i++;
        }
    }
    return false;
  }

  // given a sorted array, find a pair of numbers that differnce to a target usin two pointers  check if there exists a pair of numbers in the array that differ by k A[i] - A[j] = k i!=j && k is not sure it will be positive or negative
  // k is not sure it will be positive or negative
    public static boolean twodifference_negative(int[] A,int k){
    int i = 0;
    int j = i+1;
    while(i < A.length && j < A.length){
        if( A[j] - A[i] == k || A[j] - A[i] == -k){
            return true;
        }else if(A[j] - A[i] < k){
            j++;
        }else{
            i++;
        }
    }
    return false;
  }

  //given  3 sorted arrays, A, B , C find max(A[i],B[j],C[k]) - min(A[i],B[j],C[k]) i!=j!=k value is minized

  public static boolean smallestdifference(int[]A,int[]B,int[]C){
    int i =0;
    int j =0;
    int k =0;
    int min = Integer.MAX_VALUE;
    int max  = Integer.MIN_VALUE;
    while( i < A.length && j < B.length && k < C.length){
        min = Math.min(A[i],Math.min(B[j],C[k]));
        max  = Math.max(A[i],Math.max(B[j],C[k]));
        // i need to find the min difference
        if(max - min < min){
            return true;}
        if(A[i] == min){    
            i++;            
        }else if(B[j] == min){
            j++;        
        }else{
            k++;
        }
        
    }
        return false;
    }

    // given an array containing the heights of the walls, find the maximum area of water that can be trapped between the walls
    public static int maximumarea(int[]A){
        int i = 0;
        int j = A.length - 1;
       int maxa = 0;
        while (i < j) {
            int area = Math.min(A[i],A[j]) * (j-i);
            maxa = Math.max(maxa,area);
            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxa;
    }
public static void main(String[] args) {
    // int[] A={3,14,16,23};
    // int[] B = {-6,23,24,30};
    // int[] C={-15,15,26,31};
    int[]A = {1,2,3};
    int k = 0;
System.out.println(twodifference(A, k));}
}