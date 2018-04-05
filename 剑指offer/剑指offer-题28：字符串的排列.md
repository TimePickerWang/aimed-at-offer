**题目描述**
--------

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

---------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180330192042348?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180330192051448?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<String> Permutation(String str) {
		ArrayList<String> strList = new ArrayList<String>();
		if (str != null && str.trim().length() != 0) {
			char[] strArray = str.toCharArray();
			Permutation(0, strArray, strList);
			Collections.sort(strList);
		}
		return strList;
	}

	public void Permutation(int begin, char[] strArray, ArrayList<String> strList) {
		if (begin == strArray.length) {
			String str = String.valueOf(strArray);
			// System.out.println(str);
			if (!strList.contains(str)) {
				strList.add(str);
			}
		} else {
			for (int i = begin; i < strArray.length; i++) {
				char temp = strArray[i];
				strArray[i] = strArray[begin];
				strArray[begin] = temp;

				Permutation(begin + 1, strArray, strList);

				temp = strArray[i];
				strArray[i] = strArray[begin];
				strArray[begin] = temp;
			}
		}
	}
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def Permutation(self, ss):
        # write code here
        str_list = []
        if ss is not None and len(ss) != 0:
            self.get_list(0, list(ss), str_list)
            str_list.sort()  # 这里用sort()而不用sorted()可以避免不必要的内存开销
        return str_list

    def get_list(self, begin, str_array, str_list):
        if begin == len(str_array):
            str = "".join(str_array)
            if str not in str_list:
                str_list.append(str)
        for i in range(begin, len(str_array)):
            temp = str_array[i]
            str_array[i] = str_array[begin]
            str_array[begin] = temp

            self.get_list(begin+1, str_array, str_list)

            temp = str_array[i]
            str_array[i] = str_array[begin]
            str_array[begin] = temp
```