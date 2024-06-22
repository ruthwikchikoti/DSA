import java.util.HashMap;
import java.util.Scanner;

public class LinkedList {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int v) {
            data = v;
        }

        ListNode(int arr[]) {
            if (arr.length == 0) {
                return;
            }
            this.data = arr[0];
            ListNode current = this;
            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }
        }

    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
    }

    public static ListNode insertstart(ListNode head, int data) {
        ListNode insert = new ListNode(data);
        insert.next = head;
        return insert;
    }

    public static ListNode insertEnd(ListNode head, int data) {
        ListNode insert = new ListNode(data);
        if (head == null) {
            return insert;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = insert;
        return head;
    }

    public static ListNode deleteStart(ListNode head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static ListNode deleteEnd(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static ListNode insertKth(ListNode head, int kth, int data) {
        ListNode insert = new ListNode(data);
        if (kth == 0) {
            insert.next = head;
            return head;
        }
        if (head == null) {
            return insert;
        }
        ListNode temp = head;
        int i = 0;
        while (i < kth - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }
        insert.next = temp.next;
        temp.next = insert;
        return head;
    }

    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListNode reverseK(ListNode head, int k) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        if (head != null) {
            head.next = reverseK(current, k);
        }
        return previous;
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || B == C) {
            return A;
        }
        ListNode temp = new ListNode(0);
        temp.next = A;
        ListNode prev = temp;

        for (int i = 0; i < B - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        ListNode next = null;

        for (int i = B; i <= C; i++) {
            ListNode tempNode = cur.next;
            cur.next = next;
            next = cur;
            cur = tempNode;
        }

        prev.next.next = cur;
        prev.next = next;

        return temp.next;
    }

    public static ListNode merge_or_sorListNode(ListNode head, ListNode head2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        while (head != null && head2 != null) {
            if (head.data < head2.data) {
                current.next = head;
                head = head.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
            if (head != null) {
                current.next = head;
            } else {
                current.next = head2;
            }
        }
        return temp.next;
    }

    public static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergesort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode nextofmid = mid.next;
        mid.next = null;
        ListNode left = mergesort(head);
        ListNode right = mergesort(nextofmid);
        ListNode sorListNode = merge_or_sorListNode(left, right);
        return sorListNode;
    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
            if (a != null) {
                current.next = a;
            } else {
                current.next = b;
            }
        }
        return temp.next;
    }

    public static ListNode merge_sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode midtoright = mid.next;
        mid.next = null;
        ListNode right = mergesort(midtoright);
        ListNode left = mergesort(head);
        ListNode sorted = merge(left, right);
        return sorted;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode dum = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            dum.next = temp;
            dum = dum.next;

        }
        if (carry != 0) {
            ListNode x = new ListNode(carry);
            dum.next = x;
        }
        return ans.next;
    }

    public int Pairs_sum(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        int n = A.length;
        long count = 0;
        HashMap<Integer, Integer> nak = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = B - A[i];
            if (nak.containsKey(temp)) {
                count = (count + nak.get(temp)) % mod;
            }
            nak.put(A[i], nak.getOrDefault(A[i], 0) + 1);
        }
        return (int) count;
    }

    // given a LL check if the cycle exists or not
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    public ListNode detectCycle(ListNode a) {
        if (a == null || a.next == null)
            return null;
        ListNode slow = a;
        ListNode fast = a;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;

        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // ListNode a = new ListNode(-1);
        // Scanner sc = new Scanner(System.in);
        // ListNode lastNode = a;

        // for(int i = 0;i<5;i++){

        // int data = sc.nextInt();

        // ListNode b = new ListNode(data);

        // lastNode.next = b;
        // lastNode = b;
        // }
        ListNode a = new ListNode(new int[] { 1, 2, 4, 2, 3, 4, 1, 6, 2, 9, 6, 5, 3 });

        ListNode b = new ListNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        // print(a.next);
        // System.out.println(" ");
        // print(reverseK(a, 3));
        System.out.println(hasCycle(a));
    }
}
