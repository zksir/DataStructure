package 字符串;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author Scentea
 */
public class _3_无重复字符的最长子串 {
	/**
	 * 思路：滑动窗口
	 * 	1.建立一个256位大小的整型数组 freg ，用来建立字符和其出现位置之间的映射。
	 * 	2.如果当前遍历到的字符从未出现过，那么直接扩大右边界
	 * 	3.如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符
	 * 	4.重复（1）（2），直到左边索引无法再移动
	 *  5.维护一个结果res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int[] freq = new int[256]; //hash array
        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;
        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.length(); r == s.length()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while(l < s.length()){
            if(r + 1 < s.length() && freq[sArr[r+1]] == 0){//如果字符没出现过，移动右边界扩大窗口
                r++;
                freq[sArr[r]]++;
            }else {   //r已经到头
                freq[sArr[l]]--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
