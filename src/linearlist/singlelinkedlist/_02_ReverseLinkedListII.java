package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/4 19:20
 */
public class _02_ReverseLinkedListII {

    /*
     * 思路整理：
     * 1.dummy节点作为头节点，是用来做起点的，
     * 2.定位好pre，start，then指针，
     * 3.开始翻转：then一直前移，每移动一步，
     *   start指针就来接替它的指向，then指针只能指向start节点，
     *   同时pre指向then，then前移。
     *
     *   思考：好像一个人(start)插队，被插队的又容忍的故事：
     *        故事是这样的：中午11：30，照例是午饭时间.
     *        在某高校食堂里，同学们都在排队买饭，有个队伍是这样的，
     *        按先来后到的次序这样排，prev->start->then->...->食堂大妈.
     *        队伍前移一位，start同学性急，忍不住插了前面then同学的位置，then
     *        同学脾气好，也忍让了，同时prev就站在start同学后面，但是start同学喜欢看手机。
     *        队伍前移了一位，then看start不走，then就站回原来位子，同时start又反应过来，继续插在
     *        start前面，就这样一直到大妈面前...
     */

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //判断链表非空
        if(head == null)    return null;
        //dummy节点，标记头节点
        ListNode dummy = new ListNode(0);
        //头节点指向头元素
        dummy.next = head;
        //开始节点之前的节点
        ListNode prev = dummy;
        //pre定位到开始翻转的节点之前
        for (int i = 0; i < m-1; i++) prev = prev.next;
        //标记开始节点
        ListNode start = prev.next;
        //标记开始节点的后面一个节点
        ListNode then = start.next;

        //翻转开始
        for (int i = 0; i < n-m; i++) {
            //start指向then的前面
            start.next = then.next;
            //then指向start
            then.next = prev.next;
            //prev指向then
            prev.next = then;
            //then前移
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        int[] nums = {5,4,3,2,1};
        ListNode head = ListNode.load(nums);
        head = reverseBetween(head,2,4);
        ListNode.display(head);
    }

}
