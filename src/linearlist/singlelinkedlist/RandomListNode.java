package linearlist.singlelinkedlist;

/**
 * Definition for singly-linked list with a random pointer
 * @author Daffupman
 * @date 2018/11/9 17:17
 */
public class RandomListNode {

    int label;
    RandomListNode next, random;
    RandomListNode(int label){
        this.label = label;
    }

    /**
     * 链表装配节点,尾插法
     */
    public static RandomListNode load(int[] nums,RandomListNode[] random){
        RandomListNode dummy = new RandomListNode(0),
                       curr = dummy;

        RandomListNode newNode = null;
        for (int i = 0; i < nums.length; i++) {
            newNode = new RandomListNode(nums[i]);
            newNode.random = random[i];
            curr.next = newNode;
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }

    /**
     * 打印链表的节点label和random的label
     */
    public static void display(RandomListNode head){
        while(head != null){
            System.out.print(head.label+"->");
            head = head.next;
        }
        System.out.println("null");
    }

}
