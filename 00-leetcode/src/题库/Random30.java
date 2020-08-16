package 题库;

import java.util.HashMap;
import java.util.Random;

/**
 * @Describe TODO
 */
public class Random30 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        //链表
        map.put(2, "https://leetcode-cn.com/problems/add-two-numbers/");
        map.put(21, "https://leetcode-cn.com/problems/merge-two-sorted-lists/");
        map.put(83, "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/");
        map.put(203, "https://leetcode-cn.com/problems/remove-linked-list-elements/");
        map.put(237, "https://leetcode-cn.com/problems/delete-node-in-a-linked-list/");
        map.put(141, "https://leetcode-cn.com/problems/linked-list-cycle/");
        map.put(206, "https://leetcode-cn.com/problems/reverse-linked-list/");

        //栈
        map.put(20, "https://leetcode-cn.com/problems/valid-parentheses/");
        map.put(232, "https://leetcode-cn.com/problems/implement-queue-using-stacks/");
        map.put(856, "https://leetcode-cn.com/problems/score-of-parentheses/");

        //二叉树
        map.put(101, "https://leetcode-cn.com/problems/symmetric-tree/");
        map.put(102, "https://leetcode-cn.com/problems/binary-tree-level-order-traversal/");
        map.put(104, "https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/");
        map.put(107, "https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/");
        map.put(108, "https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/");
        map.put(110, "https://leetcode-cn.com/problems/balanced-binary-tree/");
        map.put(226, "https://leetcode-cn.com/problems/invert-binary-tree/");
        map.put(700, "https://leetcode-cn.com/problems/search-in-a-binary-search-tree/");
        map.put(1382, "https://leetcode-cn.com/problems/balance-a-binary-search-tree/");
        map.put(32, "https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/");
        map.put(5501, "https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/");
        map.put(5502, "https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/");
        map.put(58901, "https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/");
        //滑动窗口
        map.put(3, "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/");
        map.put(11, "https://leetcode-cn.com/problems/container-with-most-water/");
        //双指针
        map.put(26, "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/");
        map.put(14, "https://leetcode-cn.com/problems/longest-common-prefix/");
        map.put(15, "https://leetcode-cn.com/problems/3sum/");
        //数组
        map.put(27, "https://leetcode-cn.com/problems/remove-element/");
        //整数
        map.put(7, "https://leetcode-cn.com/problems/reverse-integer/");
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Random random = new Random();
        String[] randomValue = new String[5];
        for (int i = 0; i < 5; i++) {
            Integer randomKey = keys[random.nextInt(keys.length)];
            randomValue[i] = map.get(randomKey);
        }
        System.out.println(map.size());
        for (int i = 0; i < randomValue.length; i++) {
            System.out.println(randomValue[i]);
        }
    }
}
