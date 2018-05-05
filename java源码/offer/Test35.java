package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer-题35：第一次只出现一次的字符
 * 
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */

public class Test35 {
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

	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.println(new Test35().FirstNotRepeatingChar(str));
	}
}
