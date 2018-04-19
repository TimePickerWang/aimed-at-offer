**题目描述**
--------

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180419180238703?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
    public boolean isNumeric(char[] str) {
		int strLenght = str.length;
		if (str == null || strLenght == 0) {
			return false;
		}
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		// 整数0~9部分
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		if (index != strLenght) {
			if (str[index] == '.') {// 含有小数点时
				index++;
				while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
					index++;
				}
				if (index < strLenght && (str[index] == 'e' || str[index] == 'E')) {
					return isExponential(str, strLenght, index);
				}
			} else if (str[index] == 'e' || str[index] == 'E') {
				return isExponential(str, strLenght, index);
			} else {
				return false;
			}
		}
		return index == strLenght;
	}

	// 判断是否是科学计数法
	public boolean isExponential(char[] str, int strLenght, int index) {
		index++;
		if (index < strLenght && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index == strLenght ? true : false;
	}
}
```


python:
```
略
```