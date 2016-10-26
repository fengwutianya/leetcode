/**
 * Created by xuan on 16-10-26.
 */
public class L21_MergeTwoSortedList {
    public ListNode MyMergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode now = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                now.next = l1;
                l1 = l1.next;
            } else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        now.next = (l1 != null ? l1 : l2);

        return l.next;
    }
    /**
     * recursive solution
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode pHead = null;
        if (l1.val < l2.val) {
            pHead = l1;
            pHead.next = mergeTwoLists(l1.next, l2);
        } else {
            pHead = l2;
            pHead.next = mergeTwoLists(l1, l2.next);
        }

        return pHead;
    }
}
