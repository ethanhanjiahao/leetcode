package leetcode;
/**
 * ��O��nlogn����ʱ�临�Ӷ�
 * ����Ĺ鲢����
 * @author HJH
 *
 */
public class SortedLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode sortList(ListNode head) {
		if (head==null || head.next == null) {
			return head;
		}
		ListNode mid = getMidNode(head);
		ListNode right = sortList(mid.next);	//�ݹ��Ұ벿������
		mid.next = null;	//�ݹ���벿��
		ListNode left = sortList(head);
		return merge(left, right);
	}
	
	//����ָ�뷵��������м���
	public static ListNode getMidNode(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static ListNode merge(ListNode left,ListNode right){
		if (left==null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		ListNode head = null;
		if (left.val>right.val) {
			head=right;
			right=right.next;
		}else {
			head=left;
			left=left.next;
		}
		ListNode cur = head;
		while(left!=null && right!=null){
			if(left.val>right.val){
				cur.next = right;
				right=right.next;
			}else {
				cur.next = left;
				left = left.next;
			}
			cur=cur.next;
		}
		if (left!=null) {
			cur.next = left;
		}
		if (right!=null) {
			cur.next = right;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
