package offer;

/**
 * 剑指offer-题47：不用加减乘除做加法
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Test47 {
	public int Add(int num1, int num2) {
		int jin;
		int sum;
		do {
			sum = num1 ^ num2;
			jin = (num1 & num2) << 1;
			num1 = sum;
			num2 = jin;
		} while (jin != 0);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Test47().Add(3, 9));
	}
}
