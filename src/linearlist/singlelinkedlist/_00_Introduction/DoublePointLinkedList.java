package linearlist.singlelinkedlist._00_Introduction;

/**
 * 双端链表的实现
 * @author Daffupman
 * @date 2018/11/1 19:22
 */
public class DoublePointLinkedList {

    private Node head;      //头指针
    private Node tail;      //尾指针
    private int size;       //表内元素个数

    public DoublePointLinkedList(){
        //初始化双端链表
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 在表头新增节点,需要考虑空表的情况
     */
    public void addHead(Object value){
        Node newNode = new Node(value);

        if(size == 0){
            //空表
            head = newNode;
            tail = newNode;
        } else {
            //非空表
            newNode.next = head;
            head = newNode;
        }
        size ++;

    }

    /**
     * 从表尾添加节点
     * @param value 要添加节点的数据域的值
     */
    public void addTail(Object value){
        Node newNode = new Node(value);

        if(size == 0){
            //空表
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size ++;

    }

    /**
     * @return 返回是否删除头节点成功
     */
    public boolean deleteHead(){
        if(size == 0){
            //空表
            return false;
        }
        if(head == null){
            //表长为1
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size --;
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        Node currNode = head;
        if(size == 0){
            //空表
            System.out.println("[]");
        } else if(size == 1){
            //表内中有一个节点
            System.out.println("[head->"+currNode.data+"->tail]");
        } else {
            int tempSize = size;
            while(tempSize > 0){
                if(currNode.equals(head)){
                    //头节点
                    System.out.print("[ (head)"+currNode.data+" -> ");
                } else if(currNode.next == null){
                    //遍历结束
                    System.out.print(currNode.data+"(tail) -> null]");
                } else {
                    System.out.print(currNode.data+" -> ");
                }
                currNode = currNode.next;
                tempSize --;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        DoublePointLinkedList dpll = new DoublePointLinkedList();
        dpll.display();
        dpll.addHead("one");
        dpll.addHead("two");
        dpll.addTail("three");
        dpll.display();
    }

}
