public class targetbinary {
    //given an array which is rotated,find  the target (all elements are distinct)

    public static int search(int[] A, int target) {
        int s = 0;
        int e = A.length - 1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (A[mid] == target) {
                return mid;
            }
            
            if (A[s] <= A[mid]) {
                if (A[s] <= target && target < A[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        int A[]={10,20,30,-1,2,3,4,5,6,7,8,9};
        System.out.println(search(A, 20));
    }
    
}
