package leetcode;

/**
 * 复杂链表的复制
 * 
 * @author HJH
 *
 */
public class CopyComplexList {

	// 复杂链表的定义
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head==null) {
			return null;
		}
		RandomListNode cur = head;
		RandomListNode next = null;
		//复制链表结点，并连接在当前结点的后面
		while(cur!=null){
			next = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		next = null;
		//获取复制后链表结点的random结点
		while(cur!=null){
			next = cur.next.next;
			cur.next.random = cur.random!=null ? cur.random.next : null;
			cur = next;
		}
		//拆分链表
		cur = head;
		next = null;
		RandomListNode copyHead = head.next;
		RandomListNode curCopy;
		while(cur!=null){
			next = cur.next.next;
			curCopy =  cur.next;
			cur.next = next;
			curCopy.next = curCopy.next!=null ? curCopy.next.next : null;
			cur = next;
		}
		return copyHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
