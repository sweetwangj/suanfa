package 链表;

/**
 *
 * 快慢指针  想象操场上跑步，只要是环形的，跑的快的人和跑的慢的人总会相遇
 * 如果跑的快的人，跑完了，还没有相遇，那就说明没有环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head==null|| head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;

    }
}
