package leetcode;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	      val = x;
	      next = null;
	      }
	  }

public class ReorderList {
	
	 public static void reorderList(ListNode head) {
		 ListNode cur = head;
		 ListNode tmp;
       while(head!=null && head.next!=null){
    	   while(cur.next.next!=null){
    		   cur=cur.next;
    	   }
    	   tmp = cur.next;
    	   cur.next=null;
    	   tmp.next = head.next;
    	   head.next = tmp;
    	   head = tmp.next;
    	   cur = head;   	   
       } 
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		reorderList(node);
		ListNode cur = node;
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.next;
		}
	}

}
