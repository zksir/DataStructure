package 滑动窗口;

import java.util.HashMap;

/**
 * 滑动窗口算法框架
 * @Describe TODO
 */
public class SlidingWindow {
    public void slidingWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        char[] tArr = t.toCharArray();
        int i = 0;
        for (char c: tArr) {
            need.put(c,i++);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            ...

            /*** debug 输出的位置 ***/
            System.out.println(left);
            System.out.println(right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (window needs shrink) {
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                ...
            }
        }

    }
}
