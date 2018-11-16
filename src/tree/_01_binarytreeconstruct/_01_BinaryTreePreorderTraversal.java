package tree._01_binarytreeconstruct;

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

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        Integer[] nums = {2,14,53,3,21};
        for (Integer num : nums) {
            tree.insert(num);
        }
        System.out.println(preorderTraversal(tree.root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> right = new Stack<>();
//        TreeNode treeNode = root;
//        while (treeNode != null){
//            //当前值加入list
//            list.add(treeNode.val);
//            System.out.println(treeNode.val);
//            //当前节点的右子节点存在，就push进right
//            if(treeNode.right != null){
//                right.push(treeNode.right);
//            }
//            treeNode = treeNode.left;
//            if(treeNode == null && !right.isEmpty()){
//                treeNode = right.pop();
//            }
//        }
//        return list;
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while(node != null){
            list.add(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
        return list;
    }
}
