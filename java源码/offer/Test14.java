package offer;

/**
 * 剑指offer-题14：调整数组顺序使奇数位于偶数前面
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的
 * 前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Test14 {

	// 该方法实现的是调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，不管相对位置
	public void array(int[] array) {
		int firstIndex = 0;
		int lastIndex = array.length - 1;
		while (firstIndex < lastIndex) {
			while (firstIndex < lastIndex && isEven(array[firstIndex])) {
				firstIndex++;
			}
			while (firstIndex < lastIndex && !isEven(array[lastIndex])) {
				lastIndex--;
			}
			if (firstIndex < lastIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[lastIndex];
				array[lastIndex] = temp;
			}
		}
	}

	// 该方法实现的是调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶
	// 数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
	public void newArray(int[] array) {
		int j;
		int i = 1;
		while (i < array.length && !isEven(array[i])) {
			i++;
		}
		while (i < array.length) {
			j = i - 1;
			int temp = array[i];
			while (j >= 0 && !isEven(array[j])) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
			i++;
			while (i < array.length && !isEven(array[i])) {
				i++;
			}
		}
	}

	public boolean isEven(int num) { // 判断是否是奇数，是返回true
		return (num & 0x1) == 1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		// new Test10().array(array);
		new Test14().newArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

}
