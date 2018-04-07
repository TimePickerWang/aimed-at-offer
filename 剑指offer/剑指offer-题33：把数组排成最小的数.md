**题目描述**
--------

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这道题主要就是要实现一个比较器，即自己定义一个比较的方式，使数组按我们自己定义的方式排序，比较之前首先需要将数组元素转为字符串，比较的方式是这样的：两个字符串s1,s2，如果(s1+s2)<(s2+s1)说明s1"小于"s2，这里的"小于"和实际的'<'不同，举个例子来说吧：123、23，这两个数字都是字符串类型，它们连起来本别是12323和23123,
显然有12323 < 23123,然后根据我们的定义就有123小于23。定义一个比较器虽然可以解题，但书中还有证明的过程，大家可以看看。这题用我java和python3分别定义了一个比较器并可以运行通过，代码如下：




java:
```
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
		List<String> numStrList = new ArrayList<String>();
		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			numStrList.add(numbers[i] + "");
		}
		numStrList.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s1 + s2).compareTo(s2 + s1);
			}
		});
		for (String string : numStrList) {
			result += string;
		}
		return result;
	}
}
```


python:
```
# -*- coding:utf-8 -*-
from functools import cmp_to_key

class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        numbers = map(str, numbers)  # 把numbers里的元素全部转成字符串
        array = sorted(numbers, key=cmp_to_key(lambda s1, s2: int(s1+s2) - int(s2+s1)))
        return "".join(array)
```