package offer;

/**
 * 剑指offer-题46：剑指offer-题46：求1+2+...+n
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Test46 {
	public int Sum_Solution(int n) {
        int sum = n;
		boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
    }
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println(new Test46().Sum_Solution(n));
	}
}
