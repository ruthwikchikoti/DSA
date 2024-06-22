import java.util.Arrays;

public class binary {
    public static long squarebinaryofnumber(int A) {
        long s = 0;
        long e = A;
        long ans = -1;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (mid * mid <= A) {
                ans = mid;
                s = mid + 1;
            }
            if (mid * mid > A) {
                e = mid - 1;
            }

        }
        return ans;
    }
    /*--------------------------------------------------------------------------------------------------------------------------------------- */

    public static long amazonupstairs(int A) {
        long s = 0;
        long e = A;
        long ans = 0;
        if (A == 1) {
            return 1;
        }
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * (mid + 1) / 2 >= A) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
    /*--------------------------------------------------------------------------------------------------------------------------------------- */

    // public static long googleamazon_Nth_Magicalnumber(int A) {

    // return -1;
    // }
    /*------------------------------------------------------------------------------------------------------------------------------------------------ */
    public static int magicindex(int A[]) {
        int s = 0;
        int e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == mid) {
                return mid;
            }
            if (A[mid] < mid) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        return -1;

    }
    /*--------------------------------------------------------------------------------------------------------------------------------------- */

    public static int minimum_index_i_in_range_l_r(int[] a, int s, int e) {
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (digitsum(mid) < 15) {
                ans = mid;
                e = mid - 1;

            } else {
                s = mid + 1;

            }
        }
        return ans;
    }

    public static int digitsum(int a) {
        int sum = 0;
        while (a != 0) {
            int digit = a % 10;
            sum += digit;
            a /= 10;
        }
        return sum;
    }

    /*------------------------------------------------------------------------------------------------------------*/

    /*
     * Given a sorted array of numbers, find if a given number ‘key’ is present in
     * the array we don’t know if it’s
     * sorted in ascending or descending order. .
     */

    public static int search_insorted_array(int[] A, int target) {
        int s = 0;
        int e = A.length - 1;

        boolean isascending = A[s] < A[e];
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (isascending) {
                if (A[mid] < target) {
                    s = mid + 1;
                } else
                    e = mid - 1;
            } else {
                if (A[mid] > target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /*
     * FIND FIRST AND LAST POSITIONS OF AN ELEMENT IN A SORTED ARRAY:
     * 
     * // public static int binary_search_with_high_index_of_repeating_elemnts(int[]
     * A, int k) {
     * // int s = 0;
     * // int e = A.length - 1;
     * // int answer = -1;
     * // while (s <= e) {
     * // int mid = s + (e - s) / 2;
     * 
     * // if (A[mid] == k) {
     * // answer = mid;
     * // s = mid + 1;
     * // }
     * 
     * // if (A[mid] > k) {
     * // e = mid - 1;
     * // } else {
     * // s = mid + 1;
     * // }
     * // }
     * // if (answer == -1) {
     * // return -1;
     * // }
     * // {
     * // return answer;
     * // }
     * // }
     * 
     * // public static int binarysearch_with_low_index_of_repeating_elemnts(int[]
     * A, int k) {
     * // int s = 0;
     * // int e = A.length - 1;
     * // int answer = -1;
     * // while (s <= e) {
     * // int mid = s + (e - s) / 2;
     * 
     * // if (A[mid] == k) {
     * // answer = mid;
     * // e = mid - 1;
     * // }
     * 
     * // if (A[mid] > k) {
     * // e = mid - 1;
     * // } else {
     * // s = mid + 1;
     * // }
     * // }
     * // if (answer == -1) {
     * // return -1;
     * // }
     * // {
     * // return answer;
     * // }
     * // }
     * /*
     */
    public static int lowindex(int[] A, int k) {
        int s = 0;
        int e = A.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == k) {
                ans = mid;
                e = mid - 1;
            }
            if (A[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    /* */
    public static int highindex(int A[], int k) {
        int s = 0;
        int e = A.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == k) {
                ans = mid;
                s = mid + 1;
            }
            if (A[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*
     * Find the Rotation Count in Rotated Sorted array
     * Consider an array of distinct numbers sorted in increasing order. The array
     * has been rotated (clockwise) k number of times. Given such an array, find the
     * value of k.
     */
    public static int no_of_times_rotated(int[] A) {
        int s = 0;
        int e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid < e && A[mid] > A[mid + 1])
                return mid;
            if (mid > s && A[mid] < A[mid - 1])
                return mid;
            if (A[s] >= A[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return 0;

    }

    public static int countRotations(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                return mid;
            else if (arr[mid] <= arr[high])
                high = mid - 1;
            else if (arr[mid] >= arr[low])
                low = mid + 1;
        }
        return 0;
    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    // Search Element in a Rotated Sorted Array without duplicates

    public static int search_without_duplicates(int A[], int n, int k) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == k) {
                return mid;
            }
            if (A[s] <= A[mid]) {
                if (A[s] <= k && k < A[mid]) {
                    e = mid - 1;
                } else {
                    e = mid + 1;
                }

            } else {
                if (A[mid] <= k && k < A[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    // Search Element in Rotated Sorted Array with duplicates

    public static int search(int[] A, int n, int k) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == k) {
                return mid;
            }
            if (A[s] == A[mid] && A[mid] == A[e]) {
                s++;
                e--;
            } else if (A[s] <= A[mid]) {
                if (A[s] <= k && k < A[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (A[mid] < k && k <= A[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /*---------------------Minimum in Rotated Sorted Array------------------*/

    public static int min_element_in_rotated(int[] A) {
        int s = 0;
        int e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[s] <= A[e]) {
                return A[s];
            }
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                return A[mid];
            }
            if (A[mid] > A[s]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    /*-------------------------------------------------Single Element in Sorted Array---------------------------------------------------------------------------------------------------*/

    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])

            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1])
                    || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
    // Find Peak Element

    public static int findPeakElement(int[] arr) {

        int n = arr.length;
        int s = 1;
        int e = n - 2;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;

            }
            if (arr[mid] > arr[mid - 1])
                s = mid + 1;
            else
                e = mid - 1;

        }
        return -1;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // square root of a number

    public static int floorSqrt(int n) {
        int low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long) (n)) {
                low = (int) (mid + 1);
            } else {
                high = (int) (mid - 1);
            }
        }
        return high;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
    // Find the Nth root of an integer (use binary search)

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {

        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    /*
     * Koko Eating Bananas
     * Problem Statement: A monkey is given ‘n’ piles of bananas, whereas the ‘ith’
     * pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time
     * (in hours) for all the bananas to be eaten.
     * 
     * Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can
     * eat all the bananas within ‘h’ hours.
     */

    public static int mineatingspeed(int[] A, int h) {
        int s = 1;
        int e = 0;
        for (int i = 0; i < A.length; i++) {
            e = Math.max(e, A[i]);

        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int total_H = calculate_total_hours(A, mid);
            if (total_H <= h) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static int calculate_total_hours(int[] A, int k) {
        int total_H = 0;
        for (int i = 0; i < A.length; i++) {
            total_H += Math.ceil((double) (A[i]) / (double) (k));
        }
        return total_H;

    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
    // Minimum days to make M bouquets
    // Find the minimum number of days required to make at least ‘m’ bouquets each
    // containing ‘k’ roses. Return -1 if it is not possible.

    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int cnt = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length;
        if (val > n)
            return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // Find the Smallest Divisor Given a Threshold
    public static int sumbyD(int[] A, int div) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.ceil((double) (A[i]) / (double) (div));
        }
        return sum;
    }

    public static int smallestDivisor(int[] A, int limit) {
        int n = A.length;
        if (n > limit)
            return -1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, A[i]);
        }
        int s = 0;
        int e = maxi;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int sum = sumbyD(A, mid);
            if (sum <= limit) {
                e = mid - 1;

            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
    // Capacity to Ship Packages within D Days
    // Problem Statement: You are the owner of a Shipment company. You use conveyor
    // belts to ship packages from one port to another. The packages must be shipped
    // within ‘d’ days.
    // Find out the least-weight capacity so that you can ship all the packages
    // within ‘d’ days.
    public static int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    /// K th missing element in sorted array

    public static int missingElement(int[] nums, int k) {
        int s = 0;
        int e = nums.length - 1;
        ;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int missing = nums[mid] - (mid + 1);
            if (missing < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return k + e + 1;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // Aggressive cows

    public static boolean canweplace(int[] A, int dis, int cow) {
        int count = 1;
        int last = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - last >= dis) {
                count++;
                last = A[i];
            }
            if (count >= cow) {
                return true;
            }

        }
        return false;
    }

    public static int Aggressivecows(int[] A, int k) {
        Arrays.sort(A);
        int s = 0;
        int e = A[A.length - 1] - A[0];
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (canweplace(A, mid, k) == true) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        return e;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // Allocate minimum number of pages
    public static int findPages(int[] arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = 1;
            int pagesStudent = 0;

            for (int numPages : arr) {
                if (pagesStudent + numPages > mid) {
                    students++;
                    pagesStudent = 0;
                }
                pagesStudent += numPages;
            }

            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // Search in a row-column sorted Matrix

    public static int searchElement(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == target)
                return 1;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return 0;
    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    // painter partition problem
    public static boolean isPossible(int[] boards, int painters, long mid) {
        int count = 1;
        long currentSum = 0;

        for (int board : boards) {
            currentSum += board;

            if (currentSum > mid) {
                count++;
                currentSum = board;

                if (count > painters) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int findMinTime(int[] boards, int painters) {
        long low = 0;
        long high = 0;

        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (isPossible(boards, painters, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }
    // divide 2 numbers without /,*and % and we have to give quotient using bit
    // manipulation

    // public static int quotient(int A, int B) {

    // }

    // given a array find the OR of all possible subarrays

    public static int ORofsubarrays(int[] A) {
        int n = A.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans |= A[i];
        }
        return ans;
    }
//Q3. XOR-ing the Subarrays!
    public static int XORofsubarrays(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            int freq = (i + 1) * (arr.length - i);
            if (freq % 2 == 1) {
                xor ^= arr[i];
            }
        }
        return xor;
    }

    }       
    public static void main(String[] args) {

        // int[] A = { 3, 1, 99, 178, 973, 16, 387, 192 };
        // int[] Aa = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int[] B = { -1, 0, 1, 2, 4, 10 };
        // int[] C = { -1, 10, 12, 13 };
        // int[] D = { 1, 2, 3, 3, 4, 4, 2 };
        // int[] rotated = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        // int[] minrotated = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        // int[] stalls = { 0, 3, 4, 7, 10, 9 };
        // System.out.println(Aggressivecows(stalls, 4));
        // System.out.println(singleNonDuplicate(D));
        // int pilesofbananas[] = { 3, 6, 7, 11 };
        // System.out.println(mineatingspeed(pilesofbananas, 8));
        // int[] a = { 10, 20, 30, 40 };
        // System.out.println(findMinTime(a, 2));
        // System.out.println(quotient(43, 5));
        System.out.println(ORofsubarrays(new int[] { 1, 2, 3 }));
    }
}
