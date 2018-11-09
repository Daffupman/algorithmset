package linearlist.singlelinkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Daffupman
 * @date 2018/11/9 17:16
 */
public class _10_CopyListwithRandomPointer {

    /**
     * A linked list is given such that each node contains an additional random pointer which could point to
     * any node in the list or null.
     * Return a deep copy of the list.
     */

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        RandomListNode rnd1 = new RandomListNode(1);
        RandomListNode rnd2 = new RandomListNode(2);
        RandomListNode rnd3 = new RandomListNode(3);
        RandomListNode rnd4 = new RandomListNode(4);
        RandomListNode rnd5 = new RandomListNode(5);
        RandomListNode[] random = new RandomListNode[]{rnd1,rnd2,rnd3,rnd4,rnd5};
        RandomListNode head = RandomListNode.load(nums,random);
        RandomListNode.display(head);
        head = copyRandomList(head);
        RandomListNode.display(head);
    }

    /**
     * 思路：
     * 使用HashMap边遍历链表边存储，然后添加next，random指针
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode curr = head;
        //一边遍历链表，一边存储进map
        while(curr != null) {
            map.put(curr,new RandomListNode(curr.label));
            curr = curr.next;
        }
        //cur返回到头节点处
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);

    }

}
