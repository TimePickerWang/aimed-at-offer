package offer;

import java.util.Stack;

/**
 * 剑指offer-题21：包含min函数的栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

public class Test21 {
	Stack<Integer> minStack = new Stack<>();
	Stack<Integer> dataStack = new Stack<>();

	public void push(int node) {
		this.dataStack.push(node);
		if (minStack.isEmpty() || node < minStack.peek()) {
			minStack.push(node);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		if (!dataStack.isEmpty()) {
			dataStack.pop();
			minStack.pop();
		}
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		Test21 test21 = new Test21();
		test21.push(3);
		test21.push(4);
		System.out.println(test21.min());
		test21.push(2);
		System.out.println(test21.min());
		test21.push(1);
		System.out.println(test21.min()); 
		test21.pop();
		System.out.println(test21.min());
		System.out.println(test21.top());
	}
}
