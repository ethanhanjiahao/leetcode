package leetcode;

import java.util.ArrayList;

/**
 * �������������,�������ĺ������
 * 
 * @author HJH
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class PostOrderTree {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root==null) {
			return list;
		}
		if(root.left!=null){
			list.addAll(postorderTraversal(root.left));
		}
		if (root.right!=null) {
			list.addAll(postorderTraversal(root.right));
		}
		list.add(root.val);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
