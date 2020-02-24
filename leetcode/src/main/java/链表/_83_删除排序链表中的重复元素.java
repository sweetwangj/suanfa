package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    /**
     * 临时指针法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode cur=head;//临时指针
        while(cur.next!=null)
        {
            if(cur.val==cur.next.val)
            {
                cur.next=cur.next.next;
            }else
            {
                cur=cur.next;
            }
        }
        return head;
    }

    /**
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
     * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) return head;
        head.next=deleteDuplicates2(head.next);
        if(head.val == head.next.val)
        {
            return head.next;
        }else
        {
            return head;
        }
    }
}
