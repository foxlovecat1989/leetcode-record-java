package medium.addtwonumbers2;


import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1A = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2A = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode resultA = addTwoNumbers(l1A, l2A);
        print(resultA);

        ListNode l1B = new ListNode(0);
        ListNode l2B = new ListNode(0);
        ListNode resultB = addTwoNumbers(l1B, l2B);
        print(resultB);

        ListNode l1C = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l2C = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode resultC = addTwoNumbers(l1C, l2C);
        print(resultC);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0, null);
        ListNode temp = ans;
        boolean isCarried = false;
        while (l1 != null || l2 != null) {
            int value = (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0)
                    + (isCarried ? 1 : 0);
            isCarried = value >= 10;
            value = value % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            temp.next = new ListNode(value, null);
            temp = temp.next;
        }

        // append when last one node carry happen
        if (isCarried) {
            temp.next = new ListNode(1, null);
        }

        return ans.next;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
