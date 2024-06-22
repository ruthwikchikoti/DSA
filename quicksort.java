public class quicksort {
    public static int partition(int[] A, int s, int e) {
        int pivot = A[s];
        int i = s;
        int j = e;

        while (i < j) {
            while (i <= e - 1 && A[i] <= pivot) {
                i++;
            }

            while (j >= s + 1 && A[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(A, i, j);
            }
        }

        swap(A, s, j);
        return j;
    }

    public static void quickSort(int[] A, int s, int e) {
        if (s < e) {
            int pIndex = partition(A, s, e);
            quickSort(A, s, pIndex - 1);
            quickSort(A, pIndex + 1, e);
        }
    }

    public static int[] sort(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = { 7, 2, 1, 6, 8, 5, 3,3,4,3,5,3,5,3,5,3,3,4,5,5,3,5,4,3,54,4,4,5,4,5,4,5,5,6,7,8,7,8,6,34,234,234,234,234,654,65,3,6,4,2,1,8,98,7987,6,54,654,4,4,6,7,87,65,7658,76548,7654,87658,765,8765,9876,98765,9876,98763456,78,4567,45677,7,6,7,7,6,7,7,7,7,7,7,7,7,7,6,5,4,3,3,4,5,5,5,55,5,6,66,66,6,66, 4 };
        int[] B = sort(A);
        
        System.out.println("After Quick Sort:");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
    }
}
