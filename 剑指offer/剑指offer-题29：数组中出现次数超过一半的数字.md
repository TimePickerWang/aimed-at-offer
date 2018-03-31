**题目描述**
--------

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180331153552478?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int arrayLen = array.length;
		if (array == null || arrayLen == 0) {
			return 0;
		} else {
			int times = 1;
			int totleTimes = 0; // 某个数字出现的总次数
			int num = array[0];
			for (int i = 1; i < arrayLen; i++) {
				if (times == 0) {
					num = array[i];
					times = 1;
				} else if (array[i] == num) {
					times++;
				} else {
					times--;
				}
			}
			for (int j = 0; j < arrayLen; j++) {
				if (array[j] == num) {
					totleTimes++;
				}
			}
			if (totleTimes > arrayLen / 2) {
				return num;
			} else {
				return 0;
			}
		}
    }
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        list_len = len(numbers)
        if numbers is None or list_len == 0:
            return 0
        else:
            times = 1
            num = numbers[0]
            for i in range(1, list_len):
                if times == 0:
                    num = numbers[i]
                    times = 1
                elif numbers[i] == num:
                    times += 1
                else:
                    times -= 1
            totle_num = numbers.count(num)
            if totle_num > list_len/2:
                return num
            else:
                return 0
```