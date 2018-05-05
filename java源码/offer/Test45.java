package offer;

import java.util.ArrayList;

/**
 * 剑指offer-题45：圆圈中最后剩下的数字
 * 
 * 0,1,……,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */

public class Test45 {
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		} else {
			ArrayList<Integer> numList = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				numList.add(new Integer(i));
			}
			int index = 0;
			while (numList.size() > 1) {
				for (int i = 1; i < m; i++) {
					index++;
					if (index == numList.size()) {
						index = 0;
					}
				}
				if (index == numList.size() - 1) {
					numList.remove(numList.size() - 1);
					index = 0;
				} else {
					numList.remove(index);
				}
			}
			return numList.get(0);
		}
	}

	public int LastRemaining_Solution2(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		} else {
			int last = 0;
			for (int i = 2; i <= n; i++) {
				last = (last + m) % i;
			}
			return last;
		}
	}

	public static void main(String[] args) {
		Test45 test45 = new Test45();
		System.out.println(test45.LastRemaining_Solution(5, 3));
		System.out.println(test45.LastRemaining_Solution2(5, 3));
	}
}
