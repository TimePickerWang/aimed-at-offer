**题目描述**
--------

请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

java请不要用

```
str.toString().replaceAll("\\s", "%20");
```
太low，哈哈



**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/20180227151555245?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

java:
```
public class Solution {
    public String replaceSpace(StringBuffer str) {
        char[] originStr = str.toString().toCharArray();// 将字符串转为字符数组
		int spaceNum = 0;// 字符串中空格数量
		for (int i = 0; i < originStr.length; i++) {
			if (originStr[i] == ' ') {
				spaceNum++;
			}
		}
		int newStrLength = originStr.length + 2 * spaceNum;
		char[] newStr = new char[newStrLength];
		int originIndex = originStr.length - 1;
		int newStrIndex = newStrLength - 1;
		
		for (; originIndex >= 0; originIndex--) {
			if(originStr[originIndex] != ' '){
				newStr[newStrIndex--] = originStr[originIndex];
			}else {
				newStr[newStrIndex--] = '0';
				newStr[newStrIndex--] = '2';
				newStr[newStrIndex--] = '%';
			}
		}
		return new String(newStr);
   }
}
```


python（个人感觉python用这种方法不是很好）:
```
# -*- coding:utf-8 -*-
class Solution:
    # s 源字符串
    def replaceSpace(self, s):
        # write code here
        str_array = list(s)  # 将字符串转为列表
        origin_str_length = len(str_array)
        origin_index = origin_str_length - 1
        new_str_array = []
        while origin_index >= 0:
            if str_array[origin_index] != ' ':
                new_str_array.insert(0, str_array[origin_index])
            else:
                new_str_array.insert(0, '%20')
            origin_index -= 1
        return "".join(new_str_array)  # 将列表转为字符串
```