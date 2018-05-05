package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 剑指offer-题33：把数组排成最小的数
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class Test33 {
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

	public static void main(String[] args) {
		int[] numbers = { 3, 32, 321 };
		System.out.println(new Test33().PrintMinNumber(numbers));
	}
}
