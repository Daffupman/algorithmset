package tree._00_introduction;

/**
 * define the Tree interface
 * @author Daffupman
 * @date 2018/11/16 15:23
 */
public interface Tree {

    //查找节点
    Node find(int val);

    //插入新节点
    boolean insert(int val);

    //中序遍历
    void infixOrder(Node current);

    //前序遍历
    void preOrder(Node current);

    //后序遍历
    void postOrder(Node current);

    //找到最大值
    Node findMax();

    //找到最小值
    Node findMin();

    //删除节点
    boolean delete(int val);

}
