package tree._03_binarytreesearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daffupman
 * @date 2018/11/21 10:27
 */
public class _02_UniqueBinarySearchTreesII {

    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees)
     * that store values 1 ... n.
     */

    public List<TreeNode> generateTrees(int n){
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<>();
        if(n == 0)  return result[0];
        result[0].add(null);
        for (int i = 1; i <= n ; i++) {
            result[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (TreeNode left : result[j]) {
                    for (TreeNode right : result[i - j - 1]) {
                        TreeNode root = new TreeNode(j+1);
                        root.left = left;
                        root.right = clone(right,j+1);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

}
