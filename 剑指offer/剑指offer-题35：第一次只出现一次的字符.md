**题目描述**
--------

在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
该题书上是通过ASCLL码定义了一个长度为256的数组来实现的一个简易的哈希表。由于java和python3有自带的哈希表数据结构，所以我直接拿来用了。要找到第一次只出现一次的字符，需要遍历字符串2次，第一次遍历用来记录每个字符出现的次数；第二次用来查找第一次出现，且只出现一次的字符位置，具体代码如下



java:
```
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
			return -1;
		} else {
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (!charMap.containsKey(charArray[i])) {
					charMap.put(charArray[i], 1);
				} else {
					charMap.put(charArray[i], charMap.get(charArray[i]) + 1);
				}
			}
			for (int i = 0; i < charArray.length; i++) {
				if (charMap.get(charArray[i]) == 1) {
					return i;
				}
			}
			return 0;
		}
    }
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        if s is None or len(s) == 0:
            return -1
        else:
            char_map = {}
            for char in s:
                if char not in char_map:
                    char_map[char] = 1
                else:
                    char_map[char] += 1
            for char in s:
                if char_map[char] == 1:
                    return s.find(char)
            return 0
```