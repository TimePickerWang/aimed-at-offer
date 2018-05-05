package offer;

/**
 * 剑指offer-题29：数组中出现次数超过一半的数字
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数
 * 字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class Test29 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int arrayLen = array.length;
		if (array == null || arrayLen == 0) {
			return 0;
		} else {
			int times = 1;
			int totleTimes = 0; // 某个数字出现的总次数
			int num = array[0];
			for (int i = 1; i < arrayLen; i++) {
				if (times == 0) {
					num = array[i];
					times = 1;
				} else if (array[i] == num) {
					times++;
				} else {
					times--;
				}
			}
			for (int j = 0; j < arrayLen; j++) {
				if (array[j] == num) {
					totleTimes++;
				}
			}
			if (totleTimes > arrayLen / 2) {
				return num;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(new Test29().MoreThanHalfNum_Solution(array));
	}
}
