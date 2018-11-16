package tree;

/**
 * @author Daffupman
 * @date 2018/11/16 16:44
 */
public class BinarySearchTree {

    public TreeNode root;

    public boolean insert(int val){
        //装配好节点
        TreeNode newNode = new TreeNode(val);
        if(root == null){
            //当前树是空树
            root = newNode;
            return true;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while(current != null){
                parent = current;
                if(current.val > val){
                    //当前节点值大于目标值，去左子树
                    current = current.left;
                    if(current == null){
                        //左子节点为空，则将val插入
                        parent.left = newNode;
                        return  true;
                    }
                } else {
                    //当前节点值小于目标值，去右子树
                    current = current.right;
                    if(current == null) {
                        //右子节点为空，则将val插入
                        parent.right = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
