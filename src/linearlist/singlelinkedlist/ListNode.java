package linearlist.singlelinkedlist;

/**
 * define Node class for leetcode
 * @author Daffupman
 * @date 2018/11/4 15:42
 */
public class ListNode {

    int val ;
    ListNode next ;

    ListNode (int val){
        this.val = val;
    }

    public static ListNode load(int[] nums){
        ListNode head = null;
        ListNode newNode = null;
        for (int num : nums) {
            //装配新节点
            newNode = new ListNode(num);
            //新节点的next指向原有指针
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void display(ListNode node){
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println("null");
    }

}
