package 链表;
/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _24_反转链表 {
    /**
     * 递归实现方式--主要考虑给定函数翻转链表的作用，然后处理最后一个节点
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead=reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead=null;
        while (head!=null)
        {
            ListNode temp=head.next;
            head.next=newHead;
            newHead=head;
            head=temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;

        ListNode node = reverseList1(node1);
        System.out.println(node.val);

    }

}
