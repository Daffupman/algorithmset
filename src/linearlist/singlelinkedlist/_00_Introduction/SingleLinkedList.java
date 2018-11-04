package linearlist.singlelinkedlist._00_Introduction;

/**
 * 单链表的实现
 * @author Daffupman
 * @date 2018/11/1 17:25
 */
public class SingleLinkedList {

    private int size;       //单链表节点数
    private Node head;      //头指针

    /**
     * 从头部插入节点
     * @param data   要插入节点的数据
     */
    public void addHead(Object data){
        Node newNode = new Node(data);
        if(size == 0){
            //空表添加节点
            head = newNode;
            size ++;
        } else {
            //当前节点指向头节点
            newNode.next = head;
            //头指针指向当前节点
            head = newNode;
            size ++;
        }
    }

    /**
     * 寻找指定数据的节点
     * @param data   目标数据
     * @return  返回目标节点
     */
    public Node find(Object data){
        int tempSize = size;
        Node currNode = head;

        //空表
        if(tempSize == 0) {
            return null;
        }

        while(tempSize > 0) {
            //当前节点的数据与目标数据相等
            if(currNode.data.equals(data)){
                return new Node(data);
            }
            tempSize --;
            currNode = currNode.next;
        }
        return null;
    }

    /**
     * 输出指定数据的节点,删除要注意当前元素是否是头节点
     * @param data   目标数据
     * @return  是否删除成功
     */
    public boolean delete(Object data){
        int tempSize = size;
        Node currNode = head;
        Node prevNode = head;

        if(tempSize == 0){
            return false;
        }

        //指针定位
        while(currNode.data != data){
            //指针遍历到结尾
            if(currNode.next == null){
                return false;
            }
            //指针后移
            prevNode = currNode;
            currNode = currNode.next;
        }

        //如果要删除的节点是头节点,则需要移动head指针
        if(currNode.equals(head)){
            head = currNode.next;
            size --;
        } else {
            //非头结点
            prevNode.next = currNode.next;
            size --;
        }
        return true;
    }

    /**
     * 打印单链表里的数据
     */
    public void display(){
        int tempSize = size;
        Node currNode = head;

        if(tempSize == 0){
            System.out.println("[]");
        }

        if(tempSize == 1){
            System.out.print("[(head)"+currNode.data+" -> null]");
            return;
        }

        while(tempSize > 0){
            if(currNode.equals(head)){
                //头节点打印格式
                System.out.print("[(head)"+currNode.data+" -> ");
            } else if(currNode.next == null){
                //尾指针打印格式
                System.out.print(currNode.data+" -> null]");
            } else {
                System.out.print(currNode.data+" -> ");
            }
            currNode = currNode.next;
            tempSize --;
        }
        System.out.println();
    }

    /**
     * 单链表是否是空
     * @return  是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @return 返回单链表的节点数
     */
    public int getSize(){
        return size;
    }

    /**
     * 删除头节点
     * @return 返回头节点的数据
     */
    public Object deleteHead(){
        if(size == 0){
            return null;
        }
        Object data = head.data;
        head = head.next;
        size --;
        return data;
    }

    public static void main(String[] args){
        SingleLinkedList sll = new SingleLinkedList();
        sll.addHead("one");
        sll.addHead("two");
        sll.addHead("three");
        sll.display();
        sll.deleteHead();
        sll.display();
        sll.delete("one");
        sll.display();
    }

}
