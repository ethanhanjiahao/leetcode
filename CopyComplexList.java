package leetcode;

/**
 * ��������ĸ���
 * 
 * @author HJH
 *
 */
public class CopyComplexList {

	// ��������Ķ���
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
		//���������㣬�������ڵ�ǰ���ĺ���
		while(cur!=null){
			next = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		next = null;
		//��ȡ���ƺ��������random���
		while(cur!=null){
			next = cur.next.next;
			cur.next.random = cur.random!=null ? cur.random.next : null;
			cur = next;
		}
		//�������
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
