**题目描述**
--------

输入一个链表，从尾到头打印链表每个节点的值。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------



java:

1.用递归

```
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> valueList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       if(listNode != null){
			printListFromTailToHead(listNode.next);
			valueList.add(listNode.val);
		}
		return valueList;
    }
}
```

2.利用栈


```
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    ArrayList<Integer> valueList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       Stack<Integer> valueStack = new Stack<Integer>();  // 利用栈
		ListNode node = listNode;
		while(node != null){
			valueStack.push(node.val);
			node = node.next;
		}
		while(valueStack.size() > 0){
			valueList.add(valueStack.peek());
			valueStack.pop();
		}
		return valueList;
    }
}

```


python:

(用栈，这里我在牛客网上用递归会出问题，大家可以试试)
```
# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        # write code here
        stack = []
        value_list = []
        node = listNode
        while node is not None:
            stack.append(node)
            node = node.next
        while len(stack) > 0:
            value_list.append(stack[-1].val)
            stack.pop()
        return value_list

```