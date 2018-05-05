package offer;

import java.util.Arrays;

/**
 * 剑指offer-题44：扑克牌的顺子
 * 
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11， Q为12，K为13，而大小王可以看成任意数字。
 */

public class Test44 {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length < 1) {
			return false;
		} else {
			Arrays.sort(numbers);
			int numberOfZeros = 0; // 数组中0的个数
			int gapNum = 0; // 排序后数组中的差值
			for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
				numberOfZeros++;
			}
			int smallIndex = numberOfZeros; // 排序后数组中最小非0值得索引
			int bigIndex = numberOfZeros + 1;
			while (bigIndex < numbers.length) {
				if(numbers[bigIndex] == numbers[smallIndex]){
					return false;
				}
				gapNum += numbers[bigIndex] - numbers[smallIndex] - 1;
				smallIndex = bigIndex;
				bigIndex++;
			}
			return gapNum > numberOfZeros ? false : true;
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 5, 4, 2, 0, 0 };
		System.out.println(new Test44().isContinuous(numbers));
	}
}
