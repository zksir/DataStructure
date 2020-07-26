package 数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Describe TODO
 */
public class _26_删除排序数组中的重复项 {
    /**
     * 思路快慢指针：
     *  当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0, cur = 0, n =  nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur]){ //如果两个指针指的数字相同，则快指针向前走一步
                cur++;
            } else{ // 如果不同，则两个指针都向前走一步
                ++pre;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        return pre + 1;
    }
}
