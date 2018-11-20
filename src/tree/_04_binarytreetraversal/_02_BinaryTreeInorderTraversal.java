package tree._04_binarytreetraversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Daffupman
 * @date 2018/11/17 10:36
 */
public class _02_BinaryTreeInorderTraversal {

    /**
     * Given a binary tree, return the inorder traversal of its nodes’ values.
     * For example: Given binary tree {1,#,2,3},
     */

    /**
     * 思路：非递归，使用stack存储第一个访问到的节点，若该节点下的左边没有节点或访问完，
     * 便从stack中出栈，加入到list中。
     * 中序遍历：left->right->root,right->left-root
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currNode = root;
        while(currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            list.add(currNode.val);
            currNode = currNode.right;
        }
        return list;
    }

}
