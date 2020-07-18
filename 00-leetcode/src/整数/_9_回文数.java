package 整数;

public class _9_回文数 {
	public static void main(String[] args) {
		int x = 121;
		int rev = 0;
    	while (x != 0) {
    		int tmp = x % 10;
    		x /= 10;
    		if (x > Integer.MAX_VALUE || (x == Integer.MAX_VALUE && x > 7)) ;
			rev = rev*10 + tmp;	
		}
		System.out.println(rev);
		System.out.println(x);
	}
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	// 不小于0就反转整数，判断反转后的整数是否相等。
    	int rev = 0;
    	while (x != 0) {
    		int tmp = x % 10;
    		x /= 10;
    		if (x > Integer.MAX_VALUE || (x == Integer.MAX_VALUE && x > 7)) return false;
			rev = rev*10 + tmp;	
		}
		return rev == x;
    }
}
