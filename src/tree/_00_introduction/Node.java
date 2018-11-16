package tree._00_introduction;

/**
 * define the Node for Binary Tree
 * @author Daffupman
 * @date 2018/11/16 15:20
 */
public class Node {

    int data;        //节点数据
    Node leftChild;     //左子节点
    Node rightChild;    //右子节点

    public Node(int data) {
        this.data = data;
    }

    //打印节点值
    public void display(){
        System.out.println(data);
    }

}
