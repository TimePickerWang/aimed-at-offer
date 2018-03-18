**题目描述**
--------

定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/20180318155822157?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180318155850551?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180318155858415?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
import java.util.Stack;

public class Solution {
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
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    data_stack = []
    min_stack = []
    
    def push(self, node):
        self.data_stack.append(node)
        if len(self.min_stack) == 0 or node < self.min_stack[-1]:
            self.min_stack.append(node)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self):
        if len(self.data_stack) > 0:
            self.data_stack.pop()
            self.min_stack.pop()

    def top(self):
        return self.data_stack[-1]

    def min(self):
        return self.min_stack[-1]
```