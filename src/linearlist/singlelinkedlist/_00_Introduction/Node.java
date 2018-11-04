package linearlist.singlelinkedlist._00_Introduction;

/**
 * 定义节点类
 * @author Daffupman
 * @date 2018/11/1 19:23
 */
public class Node {

    Node next;      //指针域
    Object data;    //数据域

    public Node(Object data){
        this.data = data;
        this.next = null;
    }

}