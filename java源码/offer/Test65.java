package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer-题65：滑动窗口的最大值
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一
 * 共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class Test65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		if (num.length >= size && size >= 1) {
			LinkedList<Integer> indexQueue = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				while (!indexQueue.isEmpty() && num[i] >= num[indexQueue.getLast()]) {
					indexQueue.pollLast();
				}
				indexQueue.offerLast(i);
			}
			for (int i = size; i < num.length; i++) {
				maxList.add(num[indexQueue.getFirst()]);
				while (!indexQueue.isEmpty() && num[i] >= num[indexQueue.getLast()]) {
					indexQueue.pollLast();
				}
				if (!indexQueue.isEmpty() && indexQueue.getFirst() <= i - size) {
					indexQueue.pollFirst();
				}
				indexQueue.offerLast(i);
			}
			maxList.add(num[indexQueue.getFirst()]);
		}
		return maxList;
	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		ArrayList<Integer> maxList = new Test65().maxInWindows(num, size);
		for (Integer value : maxList) {
			System.out.print(value + " ");
		}
	}
}
