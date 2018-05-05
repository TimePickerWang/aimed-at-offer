package offer;

/**
 * 剑指offer-题10：二进制中1的个数
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。例如把9表示成二进制是1001， 有2位是1。因此如果输入9，改函数输出2。
 */

public class Test10 {
	public int NumberOf1_1(int n) { // 除法的效率比位移低的多，不能计算负数
		int num = 0;
		while (n != 0) {
			int yu = n % 2;
			if (yu == 1) {
				num++;
			}
			n = n / 2;
		}
		return num;
	}

	// 正数时可以用右移运算,负数时会陷入死循环。
	// 例如整形的-9，其补码为：11111111 11111111 11111111 11110111，会一直右移，且在其左端一直添加1
	public int NumberOf1_2(int n) {
		int num = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				num++;
			}
			n = n >> 1;
		}
		return num;
	}

	// 为了避免死循环，可以不右移输入的数字n。首先把n和1做“与”运算，判断n的最低位是不是
	// 为1。接着把1左移一位得到2，在和n做“与”运算，就能判断n的次低位是不是1……这样反复左移，每次都能
	// 判断n的其中一位是不是1。
	public int NumberOf1_3(int n) {
		int num = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				num++;
			}
			flag = flag << 1;
		}
		return num;
	}

	public int NumberOf1(int n) {
		int num = 0;
		while (n != 0) {
			n = (n - 1) & n;
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		Test10 test10 = new Test10();
		System.out.println(test10.NumberOf1_1(9));
		System.out.println(test10.NumberOf1_2(9));
		System.out.println(test10.NumberOf1_3(-9));
		System.out.println(test10.NumberOf1(-9));
	}

}
