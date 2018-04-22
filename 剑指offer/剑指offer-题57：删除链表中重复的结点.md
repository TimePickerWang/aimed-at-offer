**题目描述**
--------

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180421222918515?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/2018042122292556?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) {
			return null;
		}
		ListNode node = pHead;
		ListNode preNode = null;
		ListNode nextNode = null;
		while (node != null) {
			nextNode = node.next;
			boolean needDelete = false;
			if (nextNode != null && nextNode.val == node.val) {
				needDelete = true;
			}
			if (!needDelete) {
				preNode = node;
				node = nextNode;
			}else{
				int value = node.val;
				ListNode deleteNode = node;
				while (deleteNode != null && deleteNode.val == value) {
					nextNode = deleteNode.next;
					deleteNode = null;
					deleteNode = nextNode;
				}
				if(preNode == null){
					pHead = nextNode;
				}else{
				 	preNode.next = nextNode;
				}
				node = nextNode;
			}
		}
		return pHead;
    }
}
```


python:
```

```