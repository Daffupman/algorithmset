package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/4 15:36
 */
public class _01_AddTwoNumbers {

    /*
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain
     * a single digit. Add the two numbers and return it as a linked list.
     */
    
    public static void main(String[] args){
        int[] nums1 = {1,8};
        ListNode l1 = ListNode.load(nums1);
        int[] nums2 = {0};
        ListNode l2 = ListNode.load(nums2);

        ListNode result = addTwoNumbers(l1,l2);
        ListNode.display(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //生成结果链表的头节点，初始值为0
        ListNode result = new ListNode(0);
        //生成两个分别指向l1，l2的指针
        ListNode p1 = l1,
                p2 = l2;
        //结果链表的指针
        ListNode currResNode = result;
        //进位值，加法运算的时候，需要连通该变量一起运算
        int carry = 0;
        //只要p1,p2中有一个不为空，继续循环
        while(p1 != null || p2 != null){
            //获取节点值
            int num1 = (p1 != null) ? p1.val : 0;
            int num2 = (p2 != null) ? p2.val : 0;
            //通过sum值可以得知，是否进位和当前节点的值
            int sum = num1 + num2 +carry;
            //重新计算进位值
            carry = sum / 10;
            //结果指针的下一位指向新节点
            currResNode.next = new ListNode(sum % 10);
            //指针后移
            currResNode = currResNode.next;
            //当前节点不为空的，指针后移
            if(p1 != null)   p1 = p1.next;
            if(p2 != null)   p2 = p2.next;
        }
        //最后的进位也是需要考虑的
        if(carry != 0){
            currResNode.next = new ListNode(1);
            currResNode = currResNode.next;
        }
        //由于头节点的值为0的原因，返回的是首节点
        return result.next;
    }

}
