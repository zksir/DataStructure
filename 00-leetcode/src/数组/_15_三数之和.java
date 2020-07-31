package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * @Describe 15. 三数之和
 */
public class _15_三数之和 {
    /**
     * 这题最大难度是去重
     * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
     * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
     * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
     * 能保证这些，排序可以做到
     *
     * 思路：排序+双指针
     *  1.固定 3 个指针中最左（最小）数字的指针 k，
     *      双指针 l，r 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，
     *      通过双指针交替向中间移动，
     *      记录对于每个固定指针 k 的所有满足 nums[k] + nums[l] + nums[r] == 0 的 l,r 组合
     *  2.当 nums[k] > 0 时直接break跳出：因为 nums[r] >= nums[l] >= nums[k] > 0，
     *      即 3 个数字都大于 0 ，在此固定指针 k 之后不可能再找到结果了。
     *  3.当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：
     *      因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     *  4.l，r 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，当l < r时循环计算s = nums[k] + nums[l] + nums[r]，
     *      并按照以下规则执行双指针移动：
     *          当s < 0时，l += 1并跳过所有重复的nums[l]；
     *          当s > 0时，r -= 1并跳过所有重复的nums[r]；
     *          当s == 0时，记录组合[k, l, r]至res，执行l += 1和l -= 1并跳过所有重复的nums[l]和nums[r]，防止记录到重复组合。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);// 先排序
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(k > 0 && nums[k] == nums[k - 1]) continue;// 去重
            int l = k + 1, r = nums.length - 1;
            while(l < r){// 双指针解法：
                int sum = nums[k] + nums[l] + nums[r];
                if(sum < 0){
                    while(l < r && nums[l] == nums[++l]);
                } else if (sum > 0) {
                    while(l < r && nums[r] == nums[--r]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[l], nums[r])));
                    while(l < r && nums[l] == nums[++l]);
                    while(l < r && nums[r] == nums[--r]);
                }
            }
        }
        return res;
    }
}
