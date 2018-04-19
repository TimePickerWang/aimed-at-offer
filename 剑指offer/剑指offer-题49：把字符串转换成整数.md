**题目描述**
--------

将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题需要抓住以下几个问题：1.传入的字符串是否是null或者空字符串""；2.传入的字符串是否带正负号；3.传入的字符串里是否含有有除了正负号及数字外其他的字符等。针对这些可能出现的问题，我们需要考虑全面，提高代码的鲁棒性。具体代码如下：


java:
```
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.trim().length() == 0) {
			return 0;
		} else {
			char[] charArray = str.toCharArray();
			int num = 0;
			boolean minus = false;
			int i = 0;
			if (charArray[0] == '-') {
				minus = true;
				i = 1;
			} else if (charArray[0] == '+') {
				i = 1;
			}
			for (; i < charArray.length; i++) {
				if(charArray[i] < '0' || charArray[i] > '9'){
					return 0;
				}else {
					num = num * 10 + charArray[i] - '0';
				}
			}
			if(minus){
				return 0 - num;
			}else {
				return num;
			}
		}
    }
}
```


python:
```
略
```