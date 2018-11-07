package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/6 17:56
 */
public class _04_RemoveDuplicatesFromSortedList {

    /**
     * Given a sorted linked list,
     * delete all duplicates such that each element appear only once.
     */

    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{5,4,4,3,3,2,1});
        ListNode.display(head);
        deleteDuplicates2(head);
        ListNode.display(head);
    }

    /**
     * 思路：遍历链表，找到当前节点的值与前面的节点一样
     *      舍弃当前的节点
     */
    public static ListNode deleteDuplicates1(ListNode head) {

        if(head == null)    return null;

        //头节点
        ListNode dummy = head;
        ListNode prevNode = head;
        ListNode currNode = prevNode.next;
        while(currNode != null){
            if(currNode.val == prevNode.val){
                //当前节点值与前一个节点值相等，修改指针，丢弃当前节点
                prevNode.next = currNode.next;
                currNode = currNode.next;
            } else {
                //两指针后移
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return dummy;
    }

    /**
     * 递归
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
