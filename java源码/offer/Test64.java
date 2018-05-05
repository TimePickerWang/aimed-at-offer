package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指offer-题64：数据流中的中位数
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从
 * 数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Test64 {
	PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // 最小堆
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {// 最大堆
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public void Insert(Integer num) {
		// 数据的总数目是偶数时，把新数据插入到最小堆中
		if (((min.size() + max.size()) & 1) == 0) {
			if (max.size() > 0 && num < max.peek()) {
				max.offer(num);
				num = max.poll();
			}
			min.offer(num);
		} else {
			if (min.size() > 0 && num > min.peek()) {
				min.offer(num);
				num = min.poll();
			}
			max.offer(num);
		}
	}

	public Double GetMedian() {
		int size = min.size() + max.size();
		if ((size & 1) == 0) {
			return ((double) (min.peek() + max.peek()) / 2);
		} else {
			return (double) min.peek();
		}
	}

	public static void main(String[] args) {
		Test64 test64 = new Test64();
		test64.Insert(5);
		test64.Insert(8);
		test64.Insert(1);
		test64.Insert(4);
		test64.Insert(3);
		System.out.println(test64.GetMedian());
		test64.Insert(7);
		System.out.println(test64.GetMedian());
	}
}
