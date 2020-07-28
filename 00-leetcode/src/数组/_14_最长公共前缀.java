package 数组;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @Describe 14. 最长公共前缀
 */
public class _14_最长公共前缀 {
//    public static void main(String[] args) {
//        String[] strs = new String[]{"dog","racecar","car"};
//        String common = longestCommonPrefix(strs);
//        System.out.println(common);
//    }
    /**
     * 二分查找解题思路：定义两个指针(green red)，用于限定字符串,通过不断的截取一半一半,来判断是否是前缀
     * flagcabd
     *  假使green指向f,red指向d,
     *  第一次二分(g)前缀情况：flag，
     *  第二次二分(a)前缀情况：flagca
     *  ps:假使第一次二分(g)前缀情况flag不是前缀，第二次二分(f)前缀情况就变成(fl)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {// 获取字符串长度最小值
            minLength = Math.min(minLength, str.length());
        }
        // 2. 维护头尾指针用于程序指路
        int green = 0;
        int red = minLength;
        // 3.二分查找模板
        while (green < red) {
            int mid = ((red - green + 1) >>> 1) + green;
            if (isPrefix(strs, mid)) {// 是前缀
                green = mid;
            } else {
                red = mid - 1;
            }
        }
        return strs[0].substring(0, green);
//        int low = 0, high = minLength;
//        while (low < high) {
//            int mid = ((high - low + 1) >>> 1) + low;
//            if (isPrefix(strs, mid)) {
//                low = mid;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return strs[0].substring(0, low);
    }

    // 获取（0， len + 1）长度的字符串是不是数组前缀
    public boolean isPrefix(String[] strs, int len) {
        String base = strs[0].substring(0, len + 1);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(base))
                return false;
        }
        return true;
    }
}
