package tree._01_binarytreeconstruct;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Daffupman
 * @date 2018/11/17 14:36
 */
public class _03_BinaryTreeLevelOrderTraversal {

    /**
     * 层序遍历二叉树是典型的广度优先搜索BFS的应用，但是这里稍微复杂一点的是，
     * 我们要把各个层的数分开，存到一个二维向量里面，大体思路还是基本相同的，
     * 建立一个queue，然后先把根节点放进去，这时候找根节点的左右两个子节点，
     * 这时候去掉根节点，此时queue里的元素就是下一层的所有节点，用一个for循环遍历它们，
     * 然后存到一个一维向量里，遍历完之后再把这个一维向量存到二维向量里，以此类推，可以完成层序遍历。
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        //存放每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //存放结果
        List<List<Integer>> wrapList = new LinkedList<>();

        //如果是空树，则直接返回
        if(root == null)    return wrapList;

        //把根节点放入queue
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                //如果queue要被移除的节点有左右孩子，那么全部插入queue
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                //移除queue中队头，并加入subList中
                subList.add(queue.poll().val);
            }
            //添加进wrapList
            wrapList.add(subList);
        }

        return wrapList;

    }

}
