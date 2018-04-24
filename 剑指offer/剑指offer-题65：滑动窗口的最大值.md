**题目描述**
--------
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。


实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180424222331723?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180424222342894?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180424222351634?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180424222400717?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

流程可以结合表8.4分析。java中ArrayList继承了Deque（即双端队列），可以在队首和队尾进行操作。代码如下


java:
```
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
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
}
```


python:
```
略
```