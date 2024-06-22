public class stack {
    public class STACK {
        int[] A;
        int capacity;
        int top = -1;

        STACK(int capacity) {
            this.capacity = capacity;
            A = new int[capacity];
        }

        public void push(int data) {
            if(top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            A[++top] = data;
        }
        
        public int pop() {
            if(top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            
            return A[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == capacity - 1;
        }
        public int size(){
            return top + 1;
        
        }
        //design a stack with operations on the middle element
        public int findMiddle() {
            if(top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return A[top/2];
        }
        
        public void dltmiddle(){
            if(top == -1){
                System.out.println("underflow");
                return;
            }
            int mid = top/2;
            for(int i = mid;i<top;i++){
                A[i] = A[i+1];
            }
            top--;


        }
        
        public int getmin(){
          
            int min = A[0];
            for(int i = 0;i<=top;i++){
                if(A[i]<min){
                    min = A[i];
                }
            }
            return min;
        }

        public void print() {
            for(int i = 0; i <= top; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        STACK stack = s.new STACK(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4); 
        System.out.println(stack.findMiddle()); 
        stack.dltmiddle();
        stack.print();
        System.out.println(stack.getmin());
    }

}