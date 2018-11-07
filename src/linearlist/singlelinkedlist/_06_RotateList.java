package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/7 10:35
 */
public class _06_RotateList {

    /**
     * Given a linked list, rotate the list to
     * the right by k places, where k is non-negative.
     */

    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{5,4,3,2,1});
        ListNode.display(head);
        head = rotateRight(head,2);
        ListNode.display(head);
    }

    /**
     * 思路：
     * 设置头节点和指针，获取链表长度，移动头指针
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }

        //设置头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //设置计数节点，用于统计链表节点个数和连接首尾
        ListNode cntNode = dummy;
        //设置头指针，寻找新链表的第一个元素，实际上定位到的是尾节点
        ListNode currHead = dummy;

        //统计链表节点个数
        int size = 0;
        while(cntNode.next != null){
            cntNode = cntNode.next;
            size ++;
        }
        //首尾连接
        cntNode.next = dummy.next;

        //新链表头指针定位
        for(int i = size - k%size; i > 0; i--){
            currHead = currHead.next;
        }
        //分割头尾
        dummy.next = currHead.next;
        currHead.next = null;

        return dummy.next;
    }

}
