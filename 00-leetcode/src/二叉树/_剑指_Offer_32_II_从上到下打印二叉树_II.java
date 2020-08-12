package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @Describe 剑指 Offer 32 - II. 从上到下打印二叉树 II
 */
public class _剑指_Offer_32_II_从上到下打印二叉树_II {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (root == null ) return list;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Integer> oneLevel = new ArrayList<>();// 记录一层数据
//            // 每次都取出一层的所有数据
//            int count = queue.size();
//            for (int i = 0; i < count; i++) {
//                TreeNode node = queue.poll();
//                oneLevel.add(node.val);
//                if (node.left != null){
//                    queue.offer(node.left);
//                }
//                if (node.right != null){
//                    queue.offer(node.right);
//                }
//            }
//            list.add(oneLevel);
//        }
//
//        return list;
//    }
}
