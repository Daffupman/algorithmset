package tree._01_binarytreeconstruct;

import tree.TreeNode;

/**
 * @author Daffupman
 * @date 2018/11/19 19:31
 */
public class _01_BinaryTreefromPreorderandInorderTraversal {

    /**
     * 思路：通过先序和中序推算出树的结构
     * 对于先序，第一个元素必定是根元素，然后在中序中找到当前root值的下标，
     * 再确定子树的范围，以此类推。。。
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
