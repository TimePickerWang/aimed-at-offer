package offer;

/**
 * 剑指offer-题32：从1到n整数中1出现的次数
 * 
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12,1一共出现了5次。
 */

public class Test32 {
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n < 1) {
			return 0;
		} else {
			int count = 0;
			int base = 1;
			int round = n;
			int weight;
			while (round > 0) {
				weight = round % 10;
				round /= 10;
				count += round * base;
				if (weight > 1) {
					count += base;
				} else if (weight == 1) {
					count += (n % base) + 1;

				}
				base *= 10;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		int n = 534;
		System.out.println(new Test32().NumberOf1Between1AndN_Solution(n));
	}
}
