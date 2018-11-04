package linearlist.singlelinkedlist._00_Introduction;

/**
 * 使用双端链表实现队列
 * @author Daffupman
 * @date 2018/11/1 20:18
 */
public class QueueLinkedList {

    private DoublePointLinkedList dpll = new DoublePointLinkedList();

    public void insert(Object data){
        dpll.addTail(data);
    }

    public void delete(){
        dpll.deleteHead();
    }

    public boolean isEmpty(){
        return dpll.isEmpty();
    }

    public int getSize(){
        return dpll.getSize();
    }

    public void display(){
        dpll.display();
    }

    public static void main(String[] args){
        QueueLinkedList queue = new QueueLinkedList();
        queue.insert("one");
        queue.insert("two");
        queue.insert("three");
        queue.display();
        queue.delete();
        queue.display();
    }

}
