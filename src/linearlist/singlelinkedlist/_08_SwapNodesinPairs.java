package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/8 18:13
 */
public class _08_SwapNodesinPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes
     * itself can be changed.
     */
    
    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{4,3,2,1});
        ListNode.display(head);
        head = swapPairs(head);
        ListNode.display(head);
    }

    /**
     * 思路：
     * 在结对的两个节点的第二个节点设置temp指针，进行指针交换操作
     */

    public static ListNode swapPairs(ListNode head) {
        //设置头节点，连接到链表上
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){
            //指针重新指向元素
            ListNode tmp = curr.next.next;
            curr.next.next = tmp.next;
            tmp.next = curr.next;
            curr.next = tmp;

            //此时，curr的下一个节点解释tmp指向的节点，curr指针后移,
            curr = tmp.next;
        }

        return dummy.next;
    }

}
