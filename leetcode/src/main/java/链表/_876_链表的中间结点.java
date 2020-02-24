package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 */
public class _876_链表的中间结点 {
    /**
     * 空间换时间的思想
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
            int length=0;
        Map<Integer,ListNode> nodeMap=new HashMap<Integer, ListNode>();
        while (head!=null)
        {
            length=length+1;
            nodeMap.put(length,head);
            head=head.next;
        }
        int middle=length/2+1;
        ListNode node = nodeMap.get(middle);
        return node;
    }
    public ListNode middleNode2(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast==null&& fast.next==null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
