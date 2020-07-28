package 数组;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @Describe 11. 盛最多水的容器
 */
public class _11_盛最多水的容器 {
    /**
     * 思路：双指针
     *  定义 i 和 j 两个指针分别指向数组的左右两端，然后两个指针向中间搜索，并且更新面积最大值 res，直到 i == j 时返回 res
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            res = height[l] < height[r]?
                    Math.max(res, (r - l) * height[l++]):
                    Math.max(res, (r - l) * height[r--]);
        }
        return res;
    }
}
