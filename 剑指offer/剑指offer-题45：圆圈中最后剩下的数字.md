**题目描述**
--------

0,1,……,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题用了2种方法解答：第一种是通过链表实现的，用链表模拟一个环形链表，当到达链表末尾的时候，如果没有到达第m个数字，则又从链表的头开始扫描，这种算法的时间复杂度是O(mn)；第二种方法是通过数学规律解答的，思路如下图：


![这里写图片描述](https://img.blog.csdn.net/20180414232012565?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180414232022304?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180414232031248?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



方法一：

java:
```
import java.util.ArrayList;

public class Solution {
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
}
```

方法二：

java:
```
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
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
}
```