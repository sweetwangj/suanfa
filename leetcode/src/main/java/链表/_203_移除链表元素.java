package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    /**
     *  增加虚拟 前节点
     *
     *  思路：此题删除链表中元素是很简单的，只需要让待删节点之前一个节点指向待删节点之后一个节点即可。
     *  此题最大的问题就是，题目要求我们要返回新链表中的头结点，
     *  如果我们就采用仅仅复制头结点的方式(用H=head)然后用H进行操作，最后返回head。
     *  这样就会导致如果头结点也是我们需要删除的节点就会导致错误。
     *  当然我们可以采用循环操作判断第一个不是我们要删除的节点，但是这样有些麻烦。
     *  最好的方式就是我们创建一个新节点来作为整个链表的头结点，该节点中的值没有意义，
     *  只是用该节点来方便我们的操作。如果用H->next=head;
     *  此时 我们操作H的话就把原先的头结点当做了一个普通节点来操作，此时原先的头结点就可以被删除了。
     *  最后返回H->next就满足条件了。正是由于有个无意义节点作为头结点会统一操作
     *  （把头结点当做普通节点）所以实际链表设计过程中都是有个无意义头结点的，
     *  遇到头结点不好解决的问题，大家可以设一个节点试试
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode header=new ListNode(-1);
        header.next=head;
        ListNode tmp=header;
        while(tmp.next!=null)
        {
            if(tmp.next.val==val)
            {
                tmp.next=tmp.next.next;
            }else{
                tmp=tmp.next;
            }
        }
        return header.next;
    }

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
            if(head==null) return null;
        head.next = removeElements2(head.next, val);
        return head.val==val?head.next:head;
    }
}
