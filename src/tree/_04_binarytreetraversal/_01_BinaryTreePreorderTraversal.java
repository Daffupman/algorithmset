package tree._04_binarytreetraversal;

import tree.BinarySearchTree;
import tree.TreeNode;
import tree._00_introduction.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Daffupman
 * @date 2018/11/16 14:40
 */
public class _01_BinaryTreePreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes’ values.
     */

    /**
     * 先序遍历：root->left->right,root->right->left
     * 对于首次访问到的节点直接加入list中，
     * 再使用stack存储当前节点的右子节点（存在的话）
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null){
            //当前值加入list
            list.add(treeNode.val);
            //当前节点的右子节点存在，就push进right
            if(treeNode.right != null){
                right.push(treeNode.right);
            }
            treeNode = treeNode.left;
            if(treeNode == null && !right.isEmpty()){
                treeNode = right.pop();
            }
        }
        return list;
    }
}
