public class frequencybinary {
        public static int findUniqueElement(int[] arr) {
            int s = 0;
            int e = arr.length - 1;
    
            while (s <= e) {
                int mid = (s + e) / 2;
    
                if (mid % 2 == 0) {
                    if (arr[mid] == arr[mid + 1]) {
                        s = mid + 2;
                    } else {
                        e = mid - 1;
                    }
                } else {
                    if (arr[mid] == arr[mid - 1]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
            }
    
            return arr[s];
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
            int uniqueElement = findUniqueElement(arr);
            System.out.println( uniqueElement);
        }
}
    
