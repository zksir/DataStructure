package 字符串;

public class _剑指_Offer_58_I_翻转单词顺序 {
	/**
	 * 思路：
	 * 		1.分割字符串，得到字符串数组
	 * 		2.倒序拼接字符串
	 * @param s
	 * @return
	 */
    public String reverseWords(String s) {
    	String strs[] = s.trim().split(" ");
    	StringBuilder res = new StringBuilder();
    	for (int i = strs.length - 1; i >= 0; i--) {
			if (strs[i].equals("")) continue;
			res.append(strs[i] + " ");
		}
    	return res.toString().trim();
    }
}
