/**
 * Created by xuan on 16-10-23.
 */
public class L2_AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumyHead = new ListNode(0);
        ListNode now = dumyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            now.next = new ListNode(sum % 10);

            //用while的时候注意把循环不变式写到方法最后
            now = now.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            now.next = new ListNode(1);
        }

        return dumyHead.next;
    }

    public ListNode mySolution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode now = result;
        ListNode l = null;
        int sum = 0, carry = 0;
        while (l1 != null && l2 != null) {
            now.next = new ListNode(0);
            now = now.next;
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            now.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            l = l1;
        } else if (l2 != null) {
            l = l2;
        }
        while (l != null) {
            now.next = new ListNode(0);
            now = now.next;
            sum = carry + l.val;
            carry = sum / 10;
            now.val = sum % 10;
            l = l.next;
        }
        if (carry > 0) now.next = new ListNode(1);
        result = result.next;

        return result;
    }
}
