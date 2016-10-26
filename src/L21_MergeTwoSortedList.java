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
                now = now.next;
                l1 = l1.next;
            } else {
                now.next = l2;
                now = now.next;
                l2 = l2.next;
            }
        }
        l1 = (l1 != null ? l1 : l2);
        while (l1 != null) {
            now.next = l1;
            l1 = null;
        }

        return l.next;
    }
}
