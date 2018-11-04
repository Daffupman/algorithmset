package linearlist.singlelinkedlist._00_Introduction;

/**
 * 单链表实现栈
 * @author Daffupman
 * @date 2018/11/1 19:13
 */
public class StackLinkedList {

    private SingleLinkedList sll = new SingleLinkedList();

    /**
     * 元素入栈
     * @param val   需要入栈的元素
     */
    public void push(Object val){
        sll.addHead(val);
    }

    /**
     * 栈顶元素出栈
     */
    public void pop(){
        sll.deleteHead();
    }

    public void display(){
        sll.display();
    }

    /**
     * @return 返回是否是空栈
     */
    public boolean isEmpty(){
        return sll.isEmpty();
    }

    /**
     * @return 返回栈内的元素个数
     */
    public int getSize(){
        return sll.getSize();
    }

    public static void main(String[] args){
        StackLinkedList stack = new StackLinkedList();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.display();
    }

}
