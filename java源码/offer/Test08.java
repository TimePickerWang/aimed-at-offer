package offer;

/**
 * 剑指offer-题8：旋转数组的最小数字
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一 个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数 组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class Test08 {

	public int minNumberInRotateArray(int[] array) {
		int index1 = 0;
		int index2 = array.length - 1;
		// 赋值为index1的原因：当把数组前0个元素进行旋转时，数组的第一个元素就是最小元素，可以不用循环，直接返回
		int indexMin = index1; 
		while (array[index1] >= array[index2]) {
			if (index2 - index1 == 1) {
				indexMin = index2;
				break;
			}
			indexMin = (index1 + index2) / 2;
			if (array[index1] == array[index2] && array[index1] == array[indexMin]) {
				for (int i = index1; i <= index2; i++) {
					if (array[i] <= array[indexMin]) {
						indexMin = i;
					}
				}
				return array[indexMin];
			}else if (array[index1] <= array[indexMin]) {
				index1 = indexMin;
			}else if (array[indexMin] <= array[index2]) {
				index2 = indexMin;
			}
		}
		return array[indexMin];
	}
	
	
	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 7, 8, 1, 2, 3 };
		int[] b = { 9, 10, 11, 12, 13 };
		int[] c = { 1, 0, 1, 1, 1 };
		int[] d = {0};
		Test08 test08 = new Test08();
		System.out.println(test08.minNumberInRotateArray(a));
		System.out.println(test08.minNumberInRotateArray(b));
		System.out.println(test08.minNumberInRotateArray(c));
		System.out.println(test08.minNumberInRotateArray(d));
	}

}
