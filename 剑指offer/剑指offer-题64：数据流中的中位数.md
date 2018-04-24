**题目描述**
--------

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180424220651853?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180424220658830?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180424220705642?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

这题用到了推，在我的另一篇博客[剑指offer-题30：最小的k个数](https://blog.csdn.net/wang454592297/article/details/79780024)也用到了，可以结合看下。由于该题在数据总数是偶数时，会把新的数据插入到最小堆中，插入后数据总数为奇数，且最小堆中的数比最大堆多一个。所以，如果数据总数如果是奇数，则数据流中的中位数在最小堆中找。代码如下：


java:
```
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
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
}
```


python:
```
略
```