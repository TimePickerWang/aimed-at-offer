package offer;

/**
 * 剑指offer-题9：斐波那契数列
 * 
 * 题目一：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 
 * 题目二：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Test09 {

	public int Fibonacci(int n) {
		int fibonacci1 = 0;
		int fibonacci2 = 1;
		int fibonacci = 0;
		if (n == 0) {
			return fibonacci1;
		} else if (n == 1) {
			return fibonacci2;
		} else {
			for (int i = 2; i <= n; i++) {
				fibonacci = fibonacci1 + fibonacci2;
				fibonacci1 = fibonacci2;
				fibonacci2 = fibonacci;
			}
			return fibonacci;
		}
	}

	public int Fibonacci2(int n) { // 递归，效率低
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci2(n - 1) + Fibonacci2(n - 2);
		}
	}

	
// -----------------------------题二----------------------------
	public int JumpFloor(int target) {
		int sum1 = 1;
		int sum2 = 2;
		int sum = 0;
		if (target == 1) {
			return sum1;
		} else if (target == 2) {
			return sum2;
		} else {
			for (int i = 2; i < target; i++) {
				sum = sum1 + sum2;
				sum1 = sum2;
				sum2 = sum;
			}
			return sum;
		}
	}
	
	
	
	public static void main(String[] args) {
		Test09 test09 = new Test09();
//		System.out.println(test09.Fibonacci(0));
//		System.out.println(test09.Fibonacci(10));
//		System.out.println(test09.Fibonacci2(0));
//		System.out.println(test09.Fibonacci2(10));
		
		System.out.println(test09.JumpFloor(0));
		System.out.println(test09.JumpFloor(5));
	}

}
