package offer;

/**
 * 剑指offer-题40：数组中只出现一次的数字
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n),空间复杂度是O(1)
 */

public class Test40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length < 2) {
			return;
		}
		int resultXOR = 0;
		for (int i = 0; i < array.length; i++) {
			resultXOR ^= array[i];
		}
		int index = getFirstBitIndex(resultXOR);
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	// 返回进行异或之后二进制中第一个为1的位置
	public int getFirstBitIndex(int num) {
		int index = 0;
		while ((num & 1) != 1 && index < 32) {
			num = num >> 1;
			index++;
		}
		return index;
	}

	// 判断某个数的二进制从右往左数的指定位是否是1
	public boolean isBit1(int num, int index) {
		return (num >> index & 1) == 1;
	}

	public static void main(String[] args) {
		Test40 test40 = new Test40();
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		test40.FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + "--" + num2[0]);
	}
}
