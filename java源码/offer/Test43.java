package offer;


import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 剑指offer-题43：n个骰子的点数
 * 
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */

public class Test43 {
	int maxValue = 6;

	public HashMap<Integer, Integer> appearCount(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (n > 1) {
			int[][] array = new int[2][maxValue * n + 1];
			int flag = 0;
			// 设置只有一个骰子时的情况,1~6每个数只会出现一次
			for (int i = 1; i <= maxValue; i++) {
				array[flag][i] = 1;
			}
			for (int k = 2; k <= n; k++) {
				for (int i = 0; i < k; i++) {
					array[1 - flag][i] = 0;
				}
				for (int i = k; i <= k * maxValue; i++) {
					array[1 - flag][i] = 0;
					for (int j = 1; j <= i && j <= maxValue; j++) {
						array[1 - flag][i] += array[flag][i - j];
					}
				}
				flag = 1 - flag;
			}
			for (int i = n; i <= n * maxValue; i++) {
				map.put(i, array[flag][i]);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> resultMap = new Test43().appearCount(3);
		for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
			System.out.println("骰子和：" + entry.getKey() + ",出现次数：" + entry.getValue());
		}
	}
}
