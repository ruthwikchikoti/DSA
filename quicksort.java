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
        int [] A = {7, 2, 1, 6, 8, 5, 3, 4};
        int[] B = sort(A);
        
        System.out.println("After Quick Sort:");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
    }
}
