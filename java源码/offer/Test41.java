package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer-题41：和为s的两个数字VS和为s的连续正数序列
 * 
 * 题一：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 题二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有2个数），例如输入15，由于1+2+3+4+5=4+5+6=7+8=15。所以结果打印出3个连
 * 续序列1~5，4~6,7~8
 */

public class Test41 {
	// 题一
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> twoNum = new ArrayList<Integer>();
		if (array.length == 0) {
			return twoNum;
		} else {
			int smallIndex = 0;
			int bigIndex = array.length - 1;
			int smallNum = 0;
			int bigNum = 0;
			int multyplyResult = array[bigIndex] * array[bigIndex - 1];

			while (smallIndex < bigIndex) {
				if (array[smallIndex] + array[bigIndex] == sum
						&& array[smallIndex] * array[bigIndex] <= multyplyResult) {
					smallNum = array[smallIndex];
					bigNum = array[bigIndex];
					multyplyResult = smallNum * bigNum;
					bigIndex--;
				} else if (array[smallIndex] + array[bigIndex] > sum) {
					bigIndex--;
				} else {
					smallIndex++;
				}
			}
			if (smallNum + bigNum == sum) {
				twoNum.add(new Integer(smallNum));
				twoNum.add(new Integer(bigNum));
			}
			return twoNum;
		}
	}

	// 题二
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return list;
		} else {
			int small = 1;
			int big = 2;
			int middle = (sum + 1) / 2;
			int curSum = small + big;
			while (small < middle) {
				if (curSum == sum) {
					list.add(getList(small, big));
				}
				while (curSum > sum && small < middle) {
					curSum -= small;
					small++;
					if (curSum == sum) {
						list.add(getList(small, big));
					}
				}
				big++;
				curSum += big;
			}
			return list;
		}
	}

	public ArrayList<Integer> getList(int small, int big) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			arrayList.add(new Integer(i));
		}
		return arrayList;
	}

	public static void main(String[] args) {
		Test41 test41 = new Test41();
		int[] array = { 1, 2, 4, 7, 11, 16 };
		int sum = 15;
		System.out.println("第一题");
		List<Integer> result = test41.FindNumbersWithSum(array, sum);
		for (Integer integer : result) {
			System.out.print(integer + "  ");
		}
		System.out.println();
		System.out.println("第二题");
		ArrayList<ArrayList<Integer>> resultList = test41.FindContinuousSequence(15);
		for (ArrayList<Integer> list : resultList) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}
