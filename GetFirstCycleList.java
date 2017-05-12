package leetcode;
/**
 * 
 * @author HJH
 * 返回循环链表第一个开始循环的结点
 *
 */

public class GetFirstCycleList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		if (fast == null || fast.next == null) {
			return null;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (slow != fast) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
