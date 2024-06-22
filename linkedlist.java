// import org.w3c.dom.Node;

// public class linkedlist {
    
//     //Linked List
//     static class Node{
//         int val;
//         Node next;
        
//         public Node(int v){
//             this.val = v;
//             this.next = null;
//         }
// //-->     // insert at the start of the linked list
//         Node insertAtStart(Node head,int v){
//             Node start = new Node(v);
//             start.next = head;
//             return start;
//         }
// //-->     // insert at the end of the linked list
//         Node insertAtEnd(Node head, int v) {
//             Node start = new Node(v);
//             if (head == null) {
//                 return start;
//             }
//             Node tail = head;
//             while (tail.next != null) {
//               tail = tail.next;
//             }
//            tail.next = start;
//             return head;
//         }

//        public void print(Node A) {
//         Node temp = A;
//         while(temp!=null){
//             System.out.print(temp.val + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }
    
    

// // -->  insert at kth position
// public static Node insertAtKth(Node head, int k, int v) {
//     Node inset = new Node(v);

//     if (k == 0) {
//         inset.next = head;
//         return inset;
//     }

//     if (head == null) {
//         return inset;
//     }

//     Node temp = head;
//     int i = 0;

//     while (i < k - 1 && temp.next != null) {
//         temp = temp.next;
//         i++;
//     }

//     inset.next = temp.next;
//     temp.next = inset;

//     return head;
// }

//     /* given a LL reverse the LL  */
//        public static Node reverse(Node head) { 
//         Node previous = null;
//         Node currrent = head;
//         Node next = null;
//         while(currrent!=null){
//             next=currrent.next;
//             currrent.next=previous;
//             previous=currrent;
//         }
//         return previous;
//     }
//     }

//         public static void main(String[] args) {
    
//           //Create a linked list for 
    
//           // 5 -> 5 -> 6 -> 7..
    
//           Node head = new Node(5);
    
//           head.next = new Node(6);
    
//           head.next.next = new Node(7);
    
//             head.print(head);
//             head.reverse(head);
//             head.print(head);
//         //   // head.insertAtStart(5);
//         //  head.insertAtEnd(head,3);
    
//         //   head.print();        
      
//     }

// }       
public class linkedlist {

    static class Node{
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
            this.next = null;
        }
    

    // insert at the start of the linked list
    Node insertAtStart(Node head, int v) {
        Node start = new Node(v);
        start.next = head;
        return start;
    }

    // insert at the end of the linked list
    Node insertAtEnd(Node head, int v) {
        Node start = new Node(v);
        if (head == null) {
            return start;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = start;
        return head;
    }

    public void print(Node A) {
        Node temp = A;
        while (temp != null) {
            System.out.print(temp.val + " ->");
            temp = temp.next;
        }
        System.out.println();
    }

    // insert at kth position
    public Node insertAtKth(Node head, int k, int v) {
        Node inset = new Node(v);

        if (k == 0) {
            inset.next = head;
            return inset;
        }

        if (head == null) {
            return inset;
        }

        Node temp = head;
        int i = 0;

        while (i < k - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }

        inset.next = temp.next;
        temp.next = inset;

        return head;
    }
    // given a linked list, find the middle node    
    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /* given a LL reverse the LL */
    public Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }       

    // given a ll reverse first k nodes
    public Node reverseK(Node head, int k) {
        Node previous = null;
        Node current = head;
        Node next = null;
        int i = 0;
        while (current != null && i < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }
        if (next != null) {
            head.next = reverseK(next, k);
        }
        return previous;
    }

/*---------------------------------------------------------------------------------------------*/
// given 2 sorted linked list  merge them into one sorted linked list
    public static Node merge(Node A, Node B) {
        Node temp = new Node(0);
        Node tail = temp;
        while (A != null && B != null) {
            if (A.val < B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }
        if (A != null) {
            tail.next = A;
        } else {
            tail.next = B;
        }
        return temp.next;
    }




    // Given a Linked list  sort the Linked List(merge sort)
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = middle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        Node sortedList = merge(left, right);
        return sortedList;
    }

}



public static void main(String[] args) {
    // Create first sorted linked list: 1 -> 3 -> 5
    Node head1 = new Node(1);
    head1.next = new Node(7);
        head1.next.next = new Node(10);
        head1.next.next.next = new Node(12);
        head1.next.next.next.next = new Node(15);


        // Create second sorted linked list: 2 -> 4 -> 6
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(14);

        // Merge the two sorted linked lists
        Node sort = mergeSort(head1);
        // Print the merged linked list
        sort.print(sort);
    }




   
        
    }
