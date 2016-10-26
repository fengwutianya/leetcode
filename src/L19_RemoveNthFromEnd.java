/**
 * Created by xuan on 16-10-26.
 */
public class L19_RemoveNthFromEnd {
    /** my solution
     * 链表问题 注意画图
     * 增加头节点用于循环方便
     */
    public ListNode MyRemoveNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode p = head, q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return head.next;
    }
}
