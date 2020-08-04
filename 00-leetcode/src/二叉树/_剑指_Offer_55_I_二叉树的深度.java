package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * @Describe 剑指 Offer 55 - I. 二叉树的深度
 */
public class _剑指_Offer_55_I_二叉树的深度 {
    /**
     * 思路：层序遍历
     * 层序遍历模板：队列
     * 1.将根节点入队
     * 2.循环以下操作：
     * 将队头节点A节点出队，进行访问
     * 将A的左子节点入队
     * 将A的右子节点入队
     * 关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
     * <p>
     * 怎么知道是遍历了一层？
     * 思路：
     * 用count来记录从队列取出的个数，达到层上限时，重设为0
     *
     * @param root
     * @return
     */
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int res = 0, count = 0, cur_size = queue.size();
//        while (!queue.isEmpty()) {
//            count++;
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//            //上一层的个数，达到了，res用来记录是第几层
//            if (count == cur_size) {
//                cur_size = queue.size();
//                res++;
//                count = 0;
//            }
//        }
//        return res;
//    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 树的高度
        int height = 0;
        // 存储着每一层元素的数量
        int levelSize = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {// 意味着即将要访问
                levelSize = queue.size();// 每当有一层最后一个元素遍历完，队列里的size就是下一层的元素个数。
                height++;
            }
        }
        return height;
    }
}
