package linearlist.singlelinkedlist;

/**
 * @author Daffupman
 * @date 2018/11/6 18:19
 */
public class _05_RemoveDuplicatesfromSortedListII {

    public static void main(String[] args){
        ListNode head = ListNode.load(new int[]{3,2,1,1});
        ListNode.display(head);
        head = deleteDuplicates(head);
        ListNode.display(head);
    }

    /**
     * 思路：
     * 只要两个指针，前驱指针和当前指针，
     * 1.当前指针向后遍历，直到和其后继节点值不等，
     * 2.前驱指针接替位置，当前指针后移一步，在向后遍历，直到当前节点为null，返回头指针；
     */
    public static ListNode deleteDuplicates(ListNode head){
        //设置头节点：important
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //前驱指针
        ListNode prevNode = dummy;
        //当前指针
        ListNode currNode = head;

        while(currNode != null){
            //当前元素和当前元素的后继节点相等，指针后移，直到两值不等
            while(currNode.next != null && currNode.val == currNode.next.val){
                currNode = currNode.next;
            }
            //前驱指针移动到currNode处：有两种情况
            //1.两指针紧邻
            if(prevNode.next == currNode){
                //指针后移
                prevNode = prevNode.next;
            } else {
                //2.指针不紧邻
                prevNode.next = currNode.next;
            }
            //currNode指针一往无前
            currNode = currNode.next;
        }
        return dummy.next;
    }


//    /**
//     * 思路：
//     * 三个指针prevNode，currNode，nextNode
//     */
//
//    //被遗弃的代码，漏洞太多
//    public static ListNode deleteDuplicates(ListNode head) {
//
//        if(head == null) return null;
//
//        ListNode dummy = head;
//        ListNode prevNode = head;
//        ListNode currNode = prevNode.next;
//        if(currNode == null){
//            //只有一个节点
//            return head;
//        }
//        ListNode nextNode = currNode.next;
//        if(nextNode == null){
//            //只有两个节点,且两个点不等
//            if(prevNode.val == currNode.val)    return null;
//            return head;
//        }
//
//        //只有三个节点
//        if(nextNode.next == null){
//            if(prevNode.val == currNode.val && currNode.val == nextNode.val){
//                return null;
//            } else if(prevNode.val == currNode.val){
//                //把返回的节点指向null
//                nextNode.next = null;
//                return nextNode;
//            } else if(currNode.val == nextNode.val){
//                //把返回的节点指向null
//                prevNode.next = null;
//                return prevNode;
//            }
//        }
//
//        while(nextNode != null){
//
//            //前两个指针对应的值相等
//            if(prevNode.val == currNode.val && currNode.val != nextNode.val){
//                prevNode = nextNode;
//                currNode = prevNode.next;
//                nextNode = currNode.next;
//                if(nextNode == null){
//                    return prevNode;
//                }
//            }
//
//            if(currNode.val == nextNode.val){
//                //currNode的值与nextNode的值一致，移动这两个指针，直到两值不等
//                while( nextNode.next != null && currNode.val == nextNode.val){
//                    currNode = nextNode;
//                    nextNode = nextNode.next;
//                }
//                //针对前两个指针指向的节点值也相等的情况，此时应是三个指针指向的节点值都相等
//                if(prevNode.val == currNode.val){
//                    prevNode = nextNode;
//                    currNode = prevNode.next;
//                    if(currNode == null){
//                        return prevNode;
//                    }
//                    nextNode = currNode.next;
//                    if(nextNode == null) {
//                        return prevNode;
//                    }
//                }
//                //针对最后两个节点值相等的情况
//                if(nextNode.next == null && currNode.val == nextNode.val){
//                    prevNode.next = null;
//                    return dummy;
//                }
//                //修改指针，丢弃所有是重复的元素
//                prevNode.next = currNode.next;
//                currNode = nextNode;
//                nextNode = nextNode.next;
//            } else {
//                //指针正常后移
//                prevNode = currNode;
//                currNode = nextNode;
//                nextNode = nextNode.next;
//            }
//        }
//        return dummy;
//    }

}
