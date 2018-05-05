package offer;

import java.util.Stack;

/**
 * 剑指offer-题7：用两个栈实现队列
 * 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Test07 {
	Stack<Integer> stack1 = new Stack<Integer>();  // 进队栈
	Stack<Integer> stack2 = new Stack<Integer>();  // 出队栈

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(!stack2.isEmpty()){
			return stack2.pop();
		}else{
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return pop();
		}
	}
	
	public static void main(String[] args) {
		Test07 test07 = new Test07();
		test07.push(3);
		test07.push(2);
		test07.push(1);
		System.out.println(test07.pop());
		System.out.println(test07.pop());
		test07.push(4);
		System.out.println(test07.pop());
		System.out.println(test07.pop());
		test07.push(5);
		System.out.println(test07.pop());
	}
}
