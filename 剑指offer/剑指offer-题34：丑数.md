**题目描述**
--------

把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180408111702334?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180408111708811?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
public class Solution {
    public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		} else {
			int[] uglyNumarray = new int[index];
			uglyNumarray[0] = 1;
			int uglyNumIndex = 1;
			int multiply2Index = 0;
			int multiply3Index = 0;
			int multiply5Index = 0;

			while (uglyNumIndex < index) {
				int min = min(uglyNumarray[multiply2Index] * 2, uglyNumarray[multiply3Index] * 3, uglyNumarray[multiply5Index] * 5);
				uglyNumarray[uglyNumIndex] = min;

				while (uglyNumarray[multiply2Index] * 2 <= uglyNumarray[uglyNumIndex]) {
					multiply2Index++;
				}
				while (uglyNumarray[multiply3Index] * 3 <= uglyNumarray[uglyNumIndex]) {
					multiply3Index++;
				}
				while (uglyNumarray[multiply5Index] * 5 <= uglyNumarray[uglyNumIndex]) {
					multiply5Index++;
				}
				uglyNumIndex++;
			}
			return uglyNumarray[uglyNumIndex - 1];
		}
    }
    
    public int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def GetUglyNumber_Solution(self, index):
        # write code here
        if index <= 0:
            return 0
        else:
            ugly_num_list = [1]
            ugly_num_index = 1
            multiply2index = 0
            multiply3index = 0
            multiply5index = 0
            while ugly_num_index < index:
                min = self.min(ugly_num_list[multiply2index] * 2, ugly_num_list[multiply3index] * 3, ugly_num_list[multiply5index] * 5)
                ugly_num_list.append(min)
                while ugly_num_list[multiply2index] * 2 <= ugly_num_list[ugly_num_index]:
                    multiply2index += 1
                while ugly_num_list[multiply3index] * 3 <= ugly_num_list[ugly_num_index]:
                    multiply3index += 1
                while ugly_num_list[multiply5index] * 5 <= ugly_num_list[ugly_num_index]:
                    multiply5index += 1
                ugly_num_index += 1
            return ugly_num_list[ugly_num_index - 1]
        
    def min(self, a, b, c):
        min = (a if a < b else b)
        return min if min < c else c
```