package leetcode;
/**
 * 二叉树的最小深度
 * @author HJH
 *
 */
public class MinDepthOfBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if(root.left == null && root.right==null){
			return 1;
		}
		if (root.left == null) {
			return run(root.right)+1;
		}
		if (root.right == null) {
			return run(root.left)+1;
		}
		return Math.min(run(root.left), run(root.right)) +1;
    }
	
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	 }

}
