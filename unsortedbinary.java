public class unsortedbinary {
    public static int localminumum(int[] A) {
        int s = 0;
        int e = A.length-1;
        while (s<=e) {
            int mid = (s+e)/2;
            if(A[mid] < A[mid-1] && A[mid]<A[mid+1])
            return A[mid];
        
        if(A[mid]>A[mid-1]){
            e=mid-1;
        }
        else s= mid+1;
        }
        return -1;
    }
    
    
    
    public static int localMinimum(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > 0 && mid < A.length - 1) {
                if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                    return A[mid];
                } else if (A[mid] > A[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (A[0] < A[1]) {
                    return A[0];
                } else {
                    start = mid + 1;
                }
            } else if (mid == A.length - 1) {
                if (A[A.length - 1] < A[A.length - 2]) {
                    return A[A.length - 1];
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int A[] = {7,2,4,6,9,8};
        System.out.println(localminumum(A));
    }
}
    