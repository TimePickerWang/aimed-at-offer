package offer;

import java.util.Stack;

/**
 * 剑指offer-题22：栈的压入、弹出序列
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序
 * 列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序
 * 列。（注意：这两个序列的长度是相等的）
 */

public class Test22 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean possible = false;
		if (pushA.length > 0 && popA.length > 0) {
			int pushIndex = 0;
			int popIndex = 0;
			Stack<Integer> dataStack = new Stack<Integer>();
			while (popIndex < popA.length) {
				while (dataStack.isEmpty() || dataStack.peek() != popA[popIndex]) {
					// 将压栈序列压入一个栈中直到： 1.栈顶元素和弹出序列的索引位置相同
					// 2.压栈序列遍历结束也没有找到和弹出序列的索引位置相同的值
					if (pushIndex == pushA.length) {
						break;
					}
					dataStack.push(new Integer(pushA[pushIndex]));
					pushIndex++;
				}
				if (dataStack.peek() != popA[popIndex]) {
					break;
				}
				dataStack.pop();
				popIndex++;
			}
			if (dataStack.isEmpty() && popIndex == popA.length) {
				possible = true;
			}
		}
		return possible;
	}

	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop1 = { 4, 5, 3, 2, 1 };
		int[] pop2 = { 4, 3, 5, 1, 2 };
		Test22 test22 = new Test22();
		System.out.println(test22.IsPopOrder(push, pop1));
		System.out.println(test22.IsPopOrder(push, pop2));
	}
}
