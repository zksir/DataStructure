package 整数;

public class _7_整数反转 {
    public int reverse(int x) {
    	// int 最大值2147483647 最小值-2147483648
    	int result = 0;
    	while (x != 0) {
    		int tmp = x % 10;
    		x = x/10;
    		result = result*10 + tmp;
		}
    	return result;
    }

}
