package tree._00_introduction;

/**
 * @author Daffupman
 * @date 2018/11/16 15:28
 */
public class BinaryTree implements Tree {

    private Node root;

    //查找节点
    public Node find(int val) {
        Node current = root;
        while(current != null){
            if(current.data > val){
                //当前节点值大于目标节点值,前往左子树
                current = current.leftChild;
            } else if(current.data < val){
                //当前节点值小于目标节点值,前往右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    //插入节点
    public boolean insert(int val) {
        //装配好节点
        Node newNode = new Node(val);
        if(root == null){
            //当前树是空树
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parent = null;
            while(current != null){
                parent = current;
                if(current.data > val){
                    //当前节点值大于目标值，去左子树
                    current = current.leftChild;
                    if(current == null){
                        //左子节点为空，则将val插入
                        parent.leftChild = newNode;
                        return  true;
                    }
                } else {
                    //当前节点值小于目标值，去右子树
                    current = current.rightChild;
                    if(current == null) {
                        //右子节点为空，则将val插入
                        parent.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //中序遍历
    public void infixOrder(Node current) {
        if(current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }

    //先序遍历
    public void preOrder(Node current) {
        if(current != null){
            System.out.println(current.data);
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node current) {
        if(current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.println(current.data);
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node max = current;
        while(current != null) {
            max = current;
            current = current.rightChild;
        }
        return max;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node min = current;
        while(current != null) {
            min = current;
            current = current.leftChild;
        }
        return min;
    }

    @Override
    public boolean delete(int val) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while(current.data != val){
            parent = current;
            if(current.data > val){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }
        //如果当前节点没有子节点
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;

            //当前节点有一个子节点，右子节点
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
        }else if(current.leftChild != null && current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
            return true;
        }else{
            //当前节点存在两个子节点
            Node successor = getSuccessor(current);
            if(current == root){
                successor = root;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public static void main(String[] args){
        Integer[] nums = {1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree();
        for (Integer num : nums) {
            binaryTree.insert(num);
        }
        binaryTree.insert(8);
        System.out.println(binaryTree.find(4).data);
        System.out.println(binaryTree.findMin().data);
        System.out.println(binaryTree.findMax().data);
        binaryTree.infixOrder(binaryTree.root);
        System.out.println();
        binaryTree.delete(3);
        binaryTree.infixOrder(binaryTree.root);
    }
}
