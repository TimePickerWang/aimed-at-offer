**题目描述**
--------

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180401174037998?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/2018040117404611?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


**注**：java中有一个数据结构是PriorityQueue，即优先队列。优先队列的元素默认按照其自然顺序进行排序，即默认为最小堆，若果需要实现最大堆，需要定义一个比较器，定义方式如下（其中k是优先队列的初始容量，若不定义，默认为11）：

```
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
```



java:
```
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length == 0 || k > input.length || k == 0) {
			return list;
		} else {
			// 默认是通过自然顺序排序的最小堆，这里需要定义一个比较器来实现最大堆
			PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			for (int i = 0; i < input.length; i++) {
				if (maxHeap.size() < k) {
					maxHeap.offer(new Integer(input[i]));
				} else if (maxHeap.peek() > input[i]) {
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
			Iterator<Integer> iterator = maxHeap.iterator();
			while (iterator.hasNext()) {
				list.add((Integer) iterator.next());
			}
			return list;
		}
    }
}
```


python:
```
略
```