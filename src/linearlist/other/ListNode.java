package linearlist.other;

/**
 * @program: algorithmset
 * @description:
 * @author: Daffupman
 * @create: 2019-03-08 16:50
 **/
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     ListNode(int[] arr) {
     	if(arr == null || arr.length == 0) {
     		throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
     	ListNode curr = this;
	     for (int i = 1; i < arr.length; i++) {
		     curr.next = new ListNode(arr[i]);
		     curr = curr.next;
	     }
     }

     @Override
     public String toString() {
     	StringBuilder res = new StringBuilder();
     	ListNode curr = this;
     	while(curr != null) {
     		res.append(curr.val + "->");
     		curr = curr.next;
        }
        res.append("NULL");
     	return res.toString();
     }
 }
