package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 剑指offer-题28：字符串的排列
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

public class Test28 {
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

	public static void main(String[] args) {
		String str = "dbca";
		ArrayList<String> stringList = new Test28().Permutation(str);
		for (String string : stringList) {
			System.out.println(string);
		}

	}
}
