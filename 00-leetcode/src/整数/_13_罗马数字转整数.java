package 整数;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/solution/hua-jie-suan-fa-13-luo-ma-shu-zi-zhuan-zheng-shu-b/
 * @author Scentea
 */
public class _13_罗马数字转整数 {
    /**
     * 思路：
     * 每次循环都多拿一个字符比较，总共两种情况：
     *  1.左边小于右边，就是IV这种情况，-=
     *  2.正常情况，VI +=
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
			if ((i+1) >= s.length() || map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) { //正常情况
				sum += map.get(s.charAt(i));
			} else {
				sum -= map.get(s.charAt(i));
			}
		}
        return sum;
        
    }
}
