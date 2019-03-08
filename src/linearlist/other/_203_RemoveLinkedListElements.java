package linearlist.other;

/**
 * @program: algorithmset
 * @description:
 * @author: Daffupman
 * @create: 2019-03-08 16:48
 **/
public class _203_RemoveLinkedListElements {

	/**
	 * Remove all elements from a linked list of integers that have value val.
	 */

	//利用头结点的方式
	public ListNode removeElements1(ListNode head, int val) {
		//设置虚拟头结点的方式
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		//列表中的每个结点都有了前驱（包括第一个元素）
		ListNode prev = dummyHead;
		while(prev.next != null) {
			if(prev.next.val == val) {
				prev.next = prev.next.next;
			}else {
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}

	//递归的方式：将问题拆分成许多个更小的问题
	public ListNode removeElements2(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		ListNode res = removeElements2(head.next, val);
		if(head.val == val) {
			return res;
		} else {
			head.next = res;
			return head;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,2,6,3,4,5,6};
		ListNode head = new ListNode(nums);
		System.out.println(head);

		ListNode res = (new _203_RemoveLinkedListElements()).removeElements2(head, 2);
		System.out.println(res);
	}

}
