package offer;

/**
 * 剑指offer-题55：字符流中第一个不重复的字符
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次
 * 的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

public class Test55 {
	int[] occurrence = new int[256];
	int index = 1;

	// Insert one char from stringstream
	public void Insert(char ch) {
		if (occurrence[ch] == 0) {
			occurrence[ch] = index;
		} else {
			occurrence[ch] = -1;
		}
		index++;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int maxIndex = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < occurrence.length; i++) {
			if (occurrence[i] > 0 && occurrence[i] < maxIndex) {
				maxIndex = occurrence[i];
				ch = (char) i;
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		Test55 test55 = new Test55();
		test55.Insert('g');
		test55.Insert('o');
		test55.Insert('o');
		test55.Insert('g');
		test55.Insert('l');
		test55.Insert('e');
		System.out.println(test55.FirstAppearingOnce());
	}
}
