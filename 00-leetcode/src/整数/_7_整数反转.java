package 整数;

public class _7_整数反转 {
    public int reverse(int x) {
    	// int 最大值2147483647 最小值-2147483648
    	int result = 0;
    	while (x != 0) {
    		int tmp = x % 10;
    		x = x/10;
    		if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && tmp >7)) return 0;
    		if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && tmp <8)) return 0; 
    		result = result*10 + tmp;
		}
    	return result;
    }

}
