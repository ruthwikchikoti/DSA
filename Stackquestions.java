import java.util.Stack;

public class Stackquestions {
    //given an array of positive integres for every index i,find the nearest smaller number to the left of i[0,i-1]
    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = arr[st.peek()];
            }
                st.push(i);
        }
        return ans;
    }

    //given an array of positive integres for every index i,find the index of nearest smaller number  to the left of i[0,i-1]
    public static int[] index_nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] >= arr[i])
            st.pop();
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
 

    //given an array of positive integres for every index i,find the nearest greater number to the right of i[i+1,n-1]
    public static int[] nearestGreaterToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] <= arr[i])
                st.pop();
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = arr[st.peek()];
            }
                st.push(i);
        }
        return ans;
    }
    //given an array of positive integres for every index i,find the index of nearest greater number to the right of i[i+1,n-1]
    public static int[] index_nearestGreaterToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] <= arr[i])
                st.pop();
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
                st.push(i);
        }
        return ans;
    }
    //given an arrray of positive integers for every index i,find  nearest greater number to the left of i[0,i-1]
    public static int[] greatertoright(int[] A){
        int n = A.length;
        int []ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(st.size()!=0 && A[st.peek()]<=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = A[st.peek()];
            }
            st.push(i);

        }
        return ans;
    }
    //given an array of positive integers for every index i,find the index of nearest greater number to the left of i[0,i-1]
    public static int[] index_greatertoright(int[] A){
        int n = A.length;
        int []ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(st.size()!=0 && A[st.peek()]<=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);

        }
        return ans;
    }
    //given an array of positive integers for every index i,find the nearest smaller number to the right of i[i+1,n-1]
    public static int[] nearestsmallernumbertoright(int[] A){
        int n = A.length;
        int ans [] = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = A[st.peek()];
            }
            st.push(i);

        }
        return ans;
    }
    //given an array of positive integers for every index i,find the index of nearest smaller number to the right of i[i+1,n-1]
    public static int[] index_nearestsmallernumbertoright(int[] A){
        int n = A.length;
        int ans [] = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);

        }
        return ans;
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.*/
    public static int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(st.size()!=0 && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek();
            }
            st.push(i);

        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && A[st.peek()]>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek();
            }
            st.push(i);

        }
        int max = 0;
        for(int i =0;i<n;i++){
            int width = right[i]-left[i]-1;
            int area = width*A[i];
            if(area>max){
                max = area;
            }
        }
        return max;
    }


    // public static void main(String[] args) {
    //     int[] arr = { 4, 5, 2, 10, 8};
    //     int[] ans = index_greatertoright(arr);
    //     for (int ele : ans)
    //         System.out.print(ele + " ");
    // }
    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 2, 10, 8};
        System.out.println("Max area for arr1: " + largestRectangleArea(arr1));
    
        int[] arr2 = { 1, 2, 3, 4, 5};
        System.out.println("Max area for arr2: " + largestRectangleArea(arr2));
    
        int[] arr3 = { 5, 4, 3, 2, 1};
        System.out.println("Max area for arr3: " + largestRectangleArea(arr3));
    
        int[] arr4 = { 1, 1, 1, 1, 1};
        System.out.println("Max area for arr4: " + largestRectangleArea(arr4));
    
    }
}
