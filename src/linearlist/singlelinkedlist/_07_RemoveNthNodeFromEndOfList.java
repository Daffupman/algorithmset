package linearlist.singlelinkedlist;

import java.util.Arrays;

/**
 * @author Daffupman
 * @date 2018/11/8 17:36
 */
public class _07_RemoveNthNodeFromEndOfList {

    /**
     * Given a linked list, remove the n th node from the end of list and return its head.
     * For example, Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * • Given n will always be valid.
     * • Try to do this in one pass.
     */
    
    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{2,1});
        ListNode.display(head);
        head = removeNthFromEnd(head,2);
        ListNode.display(head);

    }

    /**
     * 思路：使用两个指针，一个指针先走n步，然后两个指针再走一步步的走
     * 直到第一个指针为null,初始化的状态为，慢指针指向头节点，快指针指向头元素
     * 慢指针最终的指向是被删节点的前一个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) return null;

        //设置头节点，以免丢链
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //准备快慢指针，慢指针；
        //慢指针是快指针的上一个节点位置
        ListNode fastPtr = head,
                slowPtr = dummy;
        //令快指针先行n步
        while(n>0){
            fastPtr = fastPtr.next;
            n --;
        }
        //如果此时的fastPtr为null的话，意味着n恰好为链表的长度
        if(fastPtr == null){
            //删除头节点,直接返回head的下一个
            return head.next;
        }
        //快慢指针同时前进，直到快指针为null
        while(fastPtr != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        //删除慢指针的后一个节点
        slowPtr.next = slowPtr.next.next;

        return dummy.next;
    }

}
