package 数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @Describe 27. 移除元素
 */
public class _27_移除元素 {
    /**
     * 拷贝覆盖：
     *  1.遍历数组nums，每次取出的数字变量为num，同时设置一个下标ans
     *  2.在遍历过程中如果出现数字与需要移除的值不相同时，则进行拷贝覆盖nums[ans] = num，ans自增1
     *  3.如果相同的时候，则跳过该数字不进行拷贝覆盖，最后ans即为新的数组长度
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}
