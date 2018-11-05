package linearlist.singlelinkedlist;

import java.util.Arrays;

/**
 * @author Daffupman
 * @date 2018/11/5 14:11
 */
public class PartitionList {

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater
     * than or equal to x.
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
     *
     */

    /**
     * 思路：
     * 准备两个链表，第一条用于存放小于x的数，第二条用于存放原先顺序的数
     * 最后把第二条连接在第一条之后
     */

    public static ListNode partition(ListNode head, int x) {
        //准备两条链表，第一条用于存储小于x的，第二条用于存储剩下次序不变的

        //两链表的头节点
        ListNode dummy1 = new ListNode(0),
                dummy2 = new ListNode(0);
        //两链表的指针
        ListNode lessX = dummy1,
                remained = dummy2;

        while(head != null){
            if(head.val < x){
                //head指针指向的节点的值小于x，放入lessX链表
                lessX.next = head;
                lessX = head;
            } else {
                //否则，放入remained链表
                remained.next = head;
                remained = head;
            }
            //head指针后移
            head = head.next;
        }

        //把remained链表拼接在lessX链表后
        lessX.next = dummy2.next;
        remained.next = null;

        return dummy1.next;
    }
    
    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{2,5,2,3,4,1});
        head = partition(head,3);
        ListNode.display(head);
    }


}
