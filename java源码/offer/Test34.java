package offer;

/**
 * 剑指offer-题34：丑数
 * 
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

public class Test34 {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		} else {
			int[] uglyNumarray = new int[index];
			uglyNumarray[0] = 1;
			int uglyNumIndex = 1;
			int multiply2Index = 0;
			int multiply3Index = 0;
			int multiply5Index = 0;

			while (uglyNumIndex < index) {
				int min = min(uglyNumarray[multiply2Index] * 2, uglyNumarray[multiply3Index] * 3, uglyNumarray[multiply5Index] * 5);
				uglyNumarray[uglyNumIndex] = min;

				while (uglyNumarray[multiply2Index] * 2 <= uglyNumarray[uglyNumIndex]) {
					multiply2Index++;
				}
				while (uglyNumarray[multiply3Index] * 3 <= uglyNumarray[uglyNumIndex]) {
					multiply3Index++;
				}
				while (uglyNumarray[multiply5Index] * 5 <= uglyNumarray[uglyNumIndex]) {
					multiply5Index++;
				}
				uglyNumIndex++;
			}
			return uglyNumarray[uglyNumIndex - 1];
		}
	}

	public int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new Test34().GetUglyNumber_Solution(1500));
	}

}
